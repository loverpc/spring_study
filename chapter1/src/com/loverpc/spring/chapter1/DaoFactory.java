package com.loverpc.spring.chapter1;

public class DaoFactory {
	public UserDao userDao()
	{
		ConnectionMaker connMaker = new SimpleConnectionMaker();
		UserDao userDao = new UserDao(connMaker);
		
		return userDao;
	}
}
