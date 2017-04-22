package com.hzh.controller;

import java.util.List;









import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;		

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.hzh.entity.User;
import com.hzh.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//注册用户
	@ResponseBody 
    @RequestMapping(value="/addUser",produces = {"text/javascript;charset=UTF-8"})  
	public String addUser(String username,String password,long phone) {
		//先判断用户名是否重复
		if (userService.selectUsernameCount(username)>0) {
			return "100";
		}else {
			User user=new User(username, password, phone);
			if (userService.insertUser(user)>0) {
			    return "0";	
			}else {
				return "1";
			}			
		}
	}
	
	//验证登录
	@ResponseBody 
    @RequestMapping(value="/login",produces = {"text/javascript;charset=UTF-8"})  
 	public String login(String username,String password,HttpSession session) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper(); 
		//先判断用户名密码是否正确
		User user=userService.login(username, password);
		if (user!=null) {
			//将已登录个人信息以json格式返回
			String json=mapper.writeValueAsString(user);
			return json;
		}else {
			return "1";
		}
	}	
	
	//完善个人信息
	@ResponseBody 
    @RequestMapping(value="/updateUser",produces = {"text/javascript;charset=UTF-8"})  
	public String updateUser(String username,int short_num,String wechat,String head_img) {
		//先根据用户名获取该对象
		User user=userService.selectUserByName(username);
		user.setShort_num(short_num);
		user.setWechat(wechat);
		user.setHead_img(head_img);
		if (userService.updateUser(user)) {
			return "修改个人信息成功";
		}else {
			return "修改失败";
		}
		
	}
	
/*	//获取已登录用户个人信息
	@ResponseBody 
    @RequestMapping(value="/getLoginUser",produces = {"text/javascript;charset=UTF-8"})  
	public String getLoginUser(HttpSession session) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();  
		User user= (User) session.getAttribute("loginUser");
		System.out.println(user);
		if (user!=null) {
			//将已登录个人信息以json格式返回
			String json=mapper.writeValueAsString(user);
			return json;
		}else {
			return "1";
		} 
	}*/
	
	//后台管理-获取全部用户信息
	@ResponseBody  
    @RequestMapping(value="/userList")  
	public List<User> list() {  
		List<User> list=userService.QueryAllUser();
	    return list;
	}
}
