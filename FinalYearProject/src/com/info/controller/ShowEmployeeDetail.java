package com.info.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.info.model.Employee;
import com.info.service.EmployeeService;


@WebServlet("/ShowEmployeeDetail")
public class ShowEmployeeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		
		HttpSession session=request.getSession();
		Employee emp= (Employee)session.getAttribute("msg");
		
		String id=request.getParameter("id");
		if(id.equals("update"))
		{
		
			ArrayList<Employee> AllEmp=EmployeeService.selectEmployee(emp);
			session.setAttribute("listOfEmpl",AllEmp);
			
		}
		else{
			
		ArrayList<Employee> AllEmp=EmployeeService.selectAllEmployee();
		session.setAttribute("listOfEmpl",AllEmp);
		}
		
		
		RequestDispatcher rd =request.getRequestDispatcher("showEmplPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
