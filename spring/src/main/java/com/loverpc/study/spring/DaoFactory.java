package com.loverpc.study.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao()
	{
		ConnectionMaker connMaker = new SimpleConnectionMaker();
		UserDao userDao = new UserDao(connMaker);
		
		return userDao;
	}
	@Bean
	public ConnectionMaker connectionMaker()
	{
		return new SimpleConnectionMaker();
	}
}
