package com.info.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.model.Employee;
import com.info.service.EmployeeService;

@WebServlet("/UpdateEmployeeServelet")
public class UpdateEmployeeServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String id = request.getParameter("id");
		System.out.println("this is the id value :"+id);
		String name = request.getParameter("name");
		String email = request.getParameter("email"); 
		String passoword = request.getParameter("password"); 
		String age = request.getParameter("age"); 
		String biographie = request.getParameter("biographie"); 
		String jobrole = request.getParameter("jobroles"); 
		String interest = request.getParameter("interest"); 
				
		Employee emp = new Employee(name, email, passoword, age, biographie, jobrole, interest);
		
		EmployeeService.updateEmployee(emp);
		
		RequestDispatcher rd =request.getRequestDispatcher("ShowEmployeeDetail");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
