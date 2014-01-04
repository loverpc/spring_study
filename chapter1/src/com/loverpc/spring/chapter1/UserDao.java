package com.loverpc.spring.chapter1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/spring_test","root","canine99");
		
		return c;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException 
	{
		Connection c = getConnection();
		
		PreparedStatement ps = c.prepareStatement("INSERT INTO USERS(id,name,password) VALUES (?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException
	{
		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("SELECT * FROM USERS WHERE id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
	
	
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
