package com.hzh.service;

import java.util.List;

import com.hzh.entity.User;

public interface UserService {
	//增加用户
	int insertUser(User user);
	
	//判断登录
	User login(String username,String password);
	
	//完善用户个人信息
	boolean updateUser(User user);
	
	//显示全部用户信息
	List<User> QueryAllUser();
	
	//判断用户名是否存在
	int selectUsernameCount(String username);
	
	//根据用户名查询全部信息
	User selectUserByName(String username);
}
