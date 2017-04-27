<%@page import="java.util.ArrayList"%>
<%@page import="com.info.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td ,th {
    border: 1px solid #dddddd;
    text-align: center;
    padding: 8px;
}
input {
    border: 1px solid #dddddd;
    text-align: center;
    padding: 8px; 
    }

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>

</head>
<body>
          <table align="center">
               <tr>
			       <th> NAME </th>
			       <th>EMAIL </th>
			       <th>PASSWORD </th>
			       <th>AGE </th>
			       <th>BIOGRAPHIE </th>
			       <th>JOB_ROLE </th>
			       <th>INTEREST</th>
			       <th>ACTION</th>
			    </tr>

 <font style="atalic" align="center" color="green" ><h1>List of Employee </h1></font>
       <%
          ArrayList<Employee> AllEmp =(ArrayList<Employee>)session.getAttribute("listOfEmpl");
          String id =request.getParameter("id");
    
          if (AllEmp != null)
          {	  
		       for(Employee emp : AllEmp)
		       {
		    	   
		   %>
		     
			    <tr>
			    <form action ="UpdateEmployeeServelet?id=<%=id %>" method ="post">
			       <td><input type="text" name ="name" value="<%= emp.getName() %>" ></td>
			       <%
			       if(id.equals("update"))
			       {
			    	   %>
			    	    <td><input readonly="readonly" type="text" name ="email" value="<%= emp.getEmail() %>" ></td>
			    	   <% 
			       }
			       else
			       {
			    	   %>
			    	     <td><input type="text" name ="email" value="<%= emp.getEmail() %>" ></td>
			    	   <%
			       }
 			       
			       %>
			     
			       <td><input type="password" name ="password" value="<%= emp.getPassword() %>" ></td>
			       <td><input type="text" name ="age" value="<%= emp.getAge() %>" ></td>
			       <td><input type="text" name ="biographie" value="<%= emp.getBiographie() %>" ></td>
			       <td><input type="text" name ="jobroles" value="<%= emp.getJobroles() %>" ></td>
			       <td><input type="text" name ="interest" value="<%= emp.getInterest() %>"></td>
			       		       
			       <td> <a href="deleteEmployee?name=<%= emp.getName()%>"><button type="button"><font color="red" >delEmp!</font></button></a></td>
			       <td><font color="green" > <input type="submit" value="updEmp"></font></td>
			     </form>
			    </tr>
		  
			 
		      
		   <% 
		   
		       }
          }
          else
          {
          %>
              <font style="atalic" align="center" color="red" ><h2> List is empty </h2></font>
          <%
        	 
          }
        session.setAttribute("listOfEmpl",null);
       %>
        </table>	
</body>
</html>