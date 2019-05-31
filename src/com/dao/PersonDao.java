package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.PersonModel;

public class PersonDao {
	
	  public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    } 
	  
	  public void  Authenticate(PersonModel person) 
	  {
		  try {
		  Connection con= PersonDao.getConnection();
			PreparedStatement statement=null;
			System.out.println("Succesfull");
			statement = con.prepareStatement("select username,password from personA");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
			String u=resultSet.getString(1);
			String p=resultSet.getString(2);
			System.out.println(u+p);
			}
			resultSet.close();
			con.close();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		
			  
		  
}
	  
	public boolean save(PersonModel person)
	{
		try {
			//Connection con= PersonDao.getConnection();
			Class.forName("oracle.jdbc.driver.OracleDriver");  
           Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); 
			PreparedStatement statement=null;
			//DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("Succesfull");
			statement = con.prepareStatement("insert into person values(?,?,?,?)");
			String username=person.getUsername();
			String pass=person.getPassword();
			String sub=person.getSubject();
			String gen=person.getGender();
			System.out.println(username);
			System.out.println(pass);
			statement.setString(1,username);
			statement.setString(2,pass );
			statement.setString(3,sub );
			statement.setString(4,gen);
			int i=statement.executeUpdate();
			con.setAutoCommit(true);
			System.out.println(i+" records inserted");  
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	System.out.println(person);
	return true;
	}
	
	
	public  void Update(PersonModel person) throws SQLException, ClassNotFoundException
	{
		Connection con= PersonDao.getConnection();
		PreparedStatement statement=null;
		System.out.println("Succesfull");
		statement = con.prepareStatement("update person set gender=? where username=?");
		String username=person.getUsername();
		String gen=person.getGender();
		statement.setString(1,username);
		statement.setString(4,gen);
		int i=statement.executeUpdate();  
		System.out.println(i+" records updated");  
		con.close();
	}
	public void delete(PersonModel person) throws SQLException, ClassNotFoundException
	{
		Connection con= PersonDao.getConnection();
		PreparedStatement statement=null;		//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		System.out.println("Succesfull");
		statement = con.prepareStatement("delete from emp where usernmae=?  ");
		String username=person.getUsername();
		statement.setString(1,username);
		int i=statement.executeUpdate();  
		System.out.println(i+" records deleted");  
		con.close();
	}
	public void Retrive(PersonModel person) throws SQLException, ClassNotFoundException
	{
		Connection con= PersonDao.getConnection();
		PreparedStatement statement=null;
		System.out.println("Succesfull");
		statement = con.prepareStatement("select * from person");
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next())
		{
			System.out.println(resultSet.getString(1)+resultSet.getString(2)+resultSet.getString(3)+resultSet.getString(4));
		}
		con.close();
	}
	
}
