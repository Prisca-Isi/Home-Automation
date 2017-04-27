package com.info.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider
{
  
	public static Connection getconnection()throws SQLException, ClassNotFoundException
	{
		Connection con=null;
		if (con==null)
		{
		  Class.forName("com.mysql.jdbc.Driver");
		  con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","1234");	
		  System.out.println("connection establish ");
		  
		}	

		return con;
		
	}
	
}
