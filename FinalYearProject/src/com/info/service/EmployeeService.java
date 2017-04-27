package com.info.service;

import com.info.model.Employee;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeService
{
	static Connection con;
	
	
	public static int getUserId(String  email)
	{
		int empid=0;
		
		try{
		con=ConnectionProvider.getconnection();
		PreparedStatement pr =con.prepareStatement("select empid from employeeDetail where email = ? ");
		pr.setString(1,email);
	
		ResultSet rs  = pr.executeQuery();
		
		while (rs.next()) {
		   empid= rs.getInt("empid");
		}
		
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return empid;
	}
	
	public static int getStatus(String  email)
	{
		int status=0;
		try{
		con=ConnectionProvider.getconnection();
		PreparedStatement pr =con.prepareStatement("select status from employeedetail where email = ? ");
		pr.setString(1,email);
			
		ResultSet rs  = pr.executeQuery();
		
		while (rs.next()) {
			status= rs.getInt("status");
		}
		
		
		}catch (Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	
	public static ArrayList <Employee> searchEmpl(String name)
	{
		      ArrayList<Employee> Arremp = new ArrayList<>();
		      
		try {
			con=ConnectionProvider.getconnection();
			PreparedStatement pr =con.prepareStatement("select * from employeeDetail where empName like ? ");
			pr.setString(1,name+"%");
			
			ResultSet rs =pr.executeQuery();
			
				while(rs.next())
				{
					Employee emp=new Employee();
					
					emp.setName(rs.getString("empName"));
					emp.setEmail(rs.getString("email"));
					emp.setPassword(rs.getString("password"));
					emp.setAge(rs.getString("age"));
					emp.setBiographie(rs.getString("biographie"));
					emp.setJobroles(rs.getString("jobRoles"));
					emp.setInterest(rs.getString("interest"));
					
					Arremp.add(emp);
				}
		}
		catch (Exception e) {
			
		}
		return Arremp;
		
	}
	
	public static boolean validateEmployee(Employee emp)
	{
		boolean signal = false;
		
		String email = emp.getEmail();
		String password=emp.getPassword();
		
		try{
			con=ConnectionProvider.getconnection();
			Statement stmt=con.createStatement();
			String query = "select * from employeeDetail where email='"+email+"' and password ='"+password+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()==true)
			{
				signal=true;
			}
			stmt.close();
			con.close();
		}
		catch(Exception e){}
		
		return signal;
	}
	
	
	public static boolean registerEmployee(Employee emp)
	{
		boolean signal = false;
		int result=0;
		try{
			Connection con = ConnectionProvider.getconnection();
			PreparedStatement pstmt=con.prepareStatement("insert into employeeDetail(empName,email,password,age,biographie,jobroles,interest,status) values (?,?,?,?,?,?,?,?)");
			pstmt.setString(1,emp.getName());
			pstmt.setString(2,emp.getEmail());
			pstmt.setString(3,emp.getPassword());
			pstmt.setString(4,emp.getAge());
			pstmt.setString(5,emp.getBiographie());
			pstmt.setString(6,emp.getJobroles());
			pstmt.setString(7,emp.getInterest());
			pstmt.setInt(8,0);
			
			result = pstmt.executeUpdate();
			
			con.close();
			pstmt.close();
		}
		catch(Exception e){System.out.println(e);}
		
		if(result>0)
		{
			signal=true;
		}
		
		return signal;
	}
	
	public static ArrayList<Employee> selectAllEmployee()
	{
		ArrayList<Employee> array= new ArrayList<>();
		try{
			Connection con=ConnectionProvider.getconnection();
			Statement stmt=con.createStatement();
			String query="select * from employeeDetail ";
			ResultSet rs =stmt.executeQuery(query);
			while(rs.next())
			{
				Employee emp=new Employee();
				
				emp.setName(rs.getString("empName"));
				emp.setEmail(rs.getString("email"));
				emp.setPassword(rs.getString("password"));
				emp.setAge(rs.getString("age"));
				emp.setBiographie(rs.getString("biographie"));
				emp.setJobroles(rs.getString("jobRoles"));
				emp.setInterest(rs.getString("interest"));
				
				array.add(emp);
			}
		}
		catch(Exception e){}
		
		return array;
	}
	
	public static ArrayList <Employee> selectEmployee(Employee emp)
	{
		ArrayList<Employee> array=new ArrayList<>();
		
		try{
			Connection con=ConnectionProvider.getconnection();
			PreparedStatement pr=con.prepareStatement("select * from employeeDetail where email=? and password=? ");
			pr.setString(1, emp.getEmail());
			pr.setString(2,emp.getPassword());
			ResultSet rs =pr.executeQuery();
			while(rs.next())
			{				
				emp.setName(rs.getString("empName"));
				emp.setEmail(rs.getString("email"));
				emp.setPassword(rs.getString("password"));
				emp.setAge(rs.getString("age"));
				emp.setBiographie(rs.getString("biographie"));
				emp.setJobroles(rs.getString("jobRoles"));
				emp.setInterest(rs.getString("interest"));
				array.add(emp);
				
			}
		}
		catch(Exception e){}
		
		return array;
	}
	
	public static boolean deleteEmployee(String name)
	{
		boolean signal = false;
		try{
		con=ConnectionProvider.getconnection();
		Statement stmt =con.createStatement();
		String query = "delete from employeeDetail where empName='"+name+"'";
		int result = stmt.executeUpdate(query);
		
		if (result>0)
		{
			signal =true;
		}
		}catch (Exception e){}
		
		return signal;
	}
	
	public static boolean updateEmployee(Employee emp)
	{
		boolean signal = false;
		try{
		con=ConnectionProvider.getconnection();
		PreparedStatement pr =con.prepareStatement("update employeeDetail set  email=? , password=? ,  age=? , biographie=? , jobRoles=? , interest=? where empName=?  ");
		pr.setString(1,emp.getEmail());
		pr.setString(2,emp.getPassword());
		pr.setString(3,emp.getAge());
		pr.setString(4,emp.getBiographie());
		pr.setString(5,emp.getJobroles());
		pr.setString(6,emp.getInterest());
		pr.setString(7,emp.getName());
			
		int result = pr.executeUpdate();
			
		if (result>0)
		{
			signal =true;
		}
		}catch (Exception e){}
		
		return signal;
	}
	
	public static boolean updateEmpStatus(int empid)
	{
		boolean signal = false;
		try{
		con=ConnectionProvider.getconnection();
		PreparedStatement pr =con.prepareStatement("update employeeDetail set status=1  where EmpId=? ");
		pr.setInt(1,empid);
			
		int result = pr.executeUpdate();
			
		if (result>0)
		{
			signal =true;
		}
		}catch (Exception e){}
		
		return signal;
	}
	
	

}
