package com.hzh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzh.dao.UserDao;
import com.hzh.entity.User;
import com.hzh.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	// 注入Service依赖
    @Autowired
    private UserDao userDao;

	//增加用户
	public boolean insertUser(User user) {
		return userDao.insertUser(user);
	}

}
