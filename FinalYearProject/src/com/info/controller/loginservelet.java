package com.info.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.info.model.Employee;
import com.info.service.EmployeeService;

@WebServlet("/loginservelet")
public class loginservelet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String email =request.getParameter("user_email");
		String password = request.getParameter("user_password");
		
		Employee emp = new Employee();
		emp.setEmail(email);
		emp.setPassword(password);
		
		RequestDispatcher rd;
		HttpSession session =request.getSession();
		
		
		if(EmployeeService.validateEmployee(emp) == true)
		{
			if (EmployeeService.getStatus(email)==1) // means user has already activate his account
			{
				//out.println("welcome");
				session.setAttribute("msg",emp);
			    rd= request.getRequestDispatcher("homePage.jsp");
				rd.include(request, response);
			}
			else 
			{
				session.setAttribute("msg2","please activate your account by clicking \n on the link sent to your email address ; \n it is a one time task ....");
				rd= request.getRequestDispatcher("loginPage.jsp");
				rd.include(request, response);
			}
		}
		else 
		{
			session.setAttribute("msg", " login error check your data ");
			rd=request.getRequestDispatcher("loginPage.jsp");
			rd.include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
