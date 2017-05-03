package com.hzh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzh.entity.User;

public interface UserDao {
	//增加用户,注册
	int insertUser(User user);
	
	//判断登录
	User login(@Param("username")String username,@Param("password")String password);
	
	//完善用户个人信息
	boolean updateUser(User user);
	
	//显示全部用户信息
	List<User> QueryAllUser();
	
	//判断用户名是否存在
	int selectUsernameCount(String username);
	
	//根据用户名查询全部信息
	User selectUserByName(String username);
	
	//修改用户密码
	boolean updatePassword(@Param("username")String username,@Param("password")String password);
}
