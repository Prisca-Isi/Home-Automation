<%@page import="java.util.ArrayList"%>
<%@page import="com.info.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="jquery.js"></script>
		
		<script>
			$(document).ready(function(){
				$("#update").click(function(){
					alert(" your are going to update your informations ");
				});
				
			});
		</script>
</head>
<body>

      <%
          Employee emp = (Employee)session.getAttribute("msg");
          session.setAttribute("msg",emp);
      %>
      <font style="atalic" align="center" color="green" ><h1>welcome  <%=emp.getEmail() %></h1></font>
      <font style="atalic" align="center" color="green" ><h2><a name="id" id="show" href="ShowEmployeeDetail?id=show"> show employee detail </a> </h2></font>
      <font style="atalic" align="center" color="green" ><h3><a name="id" id="update" href="ShowEmployeeDetail?id=update"> update your informations </a> </h3></font>



      curent temperature :  29.30 degree <%--  <%= %> --%>
      
      <br> <br> <br>
      
      <input type="button" name="ON_Fan" value="ON_FAN">
      
      <br> <br> <br>
      
      <input type="button" name="ON_Fan" value="OFF_FAN"> 
      



</body>
</html>
</body>
</html>