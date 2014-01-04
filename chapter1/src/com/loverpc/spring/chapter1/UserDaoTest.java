package com.loverpc.spring.chapter1;

import java.sql.SQLException;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		UserDao dao = new UserDao();
		
		User user = new User();
		user.setId("loverpc");
		user.setName("전근수");
		user.setPassword("test1234");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId()+ " 조회성공");
	}
}
