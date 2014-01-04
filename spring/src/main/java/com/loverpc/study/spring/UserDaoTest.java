package com.loverpc.study.spring;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{

		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao",UserDao.class);

		User user = new User();
		user.setId("loverpc");
		user.setName("전근수");
		user.setPassword("test1234");
		
		dao.add(user);
		
		System.out.println(user.getId() + " 등록완료");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId()+ " 조회완료");
	}
}
