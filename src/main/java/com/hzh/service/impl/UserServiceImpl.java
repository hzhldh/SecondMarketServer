package com.hzh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzh.dao.UserDao;
import com.hzh.entity.User;
import com.hzh.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	// 注入Service依赖
    @Autowired
    private UserDao userDao;

	//增加用户
	@Transactional
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	//验证登录
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

	//完善用户个人信息
	@Transactional
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	//获取全部用户信息
	public List<User> QueryAllUser() {
		return userDao.QueryAllUser();
	}

	//判断用户名是否存在
	public int selectUsernameCount(String username) {
		return userDao.selectUsernameCount(username);
	}

	//根据用户名查询全部信息
	public User selectUserByName(String username) {
		return userDao.selectUserByName(username);
	}

}
