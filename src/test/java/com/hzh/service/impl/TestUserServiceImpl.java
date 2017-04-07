package com.hzh.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzh.entity.User;
import com.hzh.service.UserService;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class TestUserServiceImpl {
	@Autowired
	private UserService userService;
	
	//测试注册用户
//	@Test
//	public void testInsertUser() throws Exception{
//		User user=new User("jzh", "123",13534886987L);
//		System.out.println(userService.insertUser(user));
//	}
	
	//测试显示全部用户信息
//	@Test
//	public void querytUser() throws Exception{
//		System.out.println(userService.QueryAllUser());
//	}
	//测试判断用户名是否存在
	@Test
	public void testUsername() throws Exception{
		//User user=new User("jzh", "123",13534886987L);
		System.out.println(userService.selectUsernameCount("hzh"));
	}
}
