package com.info.controller;

import java.io.IOException;
import java.io.PrintWriter;
import com.info.model.Employee;
import com.info.model.JavaMail;
import com.info.service.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServelet
 */
@WebServlet("/RegistrationServelet")
public class RegistrationServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		ServletConfig config = getServletConfig();
		
		/*String nam=config.getInitParameter("name");
		System.out.println("name in servlet config  is :"+nam);*/
		
		String name =request.getParameter("user_name");
		String email =request.getParameter("user_email");
		String password =request.getParameter("user_password");
		String age =request.getParameter("user_age");
		String biographie =request.getParameter("user_bio");
		String job_role =request.getParameter("user_job");
		String interest[] =request.getParameterValues("user_interest");
		String interestList="";
		
		try
		{
			for(String s:interest)
			{
				interestList+=s+" ;";
			}
		}catch(Exception e){}
		
		
		Employee emp = new Employee(name,email,password,age,biographie,job_role,interestList);
		
		RequestDispatcher rd ;
		HttpSession session = request.getSession();
		
			if ((name!="")&& (password.length()>=8) && EmployeeService.registerEmployee(emp)==true)
			{
				int EmpId= EmployeeService.getUserId(email);  //getting the empid of the new user register 
				
				System.out.println(email + " :: "+ EmpId );
			
				try{
					JavaMail.sendMail(email,EmpId);
				}
				catch(Exception e){System.out.println(e);}
				
				rd= request.getRequestDispatcher("loginPage.jsp");
				rd.forward(request, response);
				
			}
			else if(password.length()<8)
			{
				rd=request.getRequestDispatcher("registration.jsp");
				session.setAttribute("msg1",emp);
				session.setAttribute("error"," password must be more than 8 characters ");
				rd.forward(request, response);
			}
			
			else if(name=="")
			{
				rd=request.getRequestDispatcher("registration.jsp");
				session.setAttribute("msg1",emp);
				session.setAttribute("error","please  fill all mandetory space ");
				rd.forward(request, response);
			}
		else if(EmployeeService.registerEmployee(emp)==false)
		{
			rd=request.getRequestDispatcher("registration.jsp");
			session.setAttribute("msg1",emp);
			session.setAttribute("error","user not register  ");
			rd.forward(request, response);
		}
			
		else
		{
			rd=request.getRequestDispatcher("registration.jsp");
			session.setAttribute("msg1",emp);
			session.setAttribute("error"," registration error ");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
