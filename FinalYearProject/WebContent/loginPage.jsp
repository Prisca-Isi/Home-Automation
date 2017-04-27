<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="style.css">
        
          <script src="jquery.js"></script>
        
        <script>
			$(function(){
				 $("#color").click(function(){
					 
					 var str = $.trim($('#color').val());
					      
					 if(str=='red'){
							$("form").css("background-color", "red");
							$("body").css("color", "white");
				     	}
						
						else if(str=='blue')
						{
							$('form').css("background-color", "blue");
							$("body").css("color", "red");
				     	}
					 
						else if(str=='gray')
						{
							$('form').css("background-color", "gray");
				     	} 
					 
						else if(str=='yellow')
						{
							$('form').css("background-color", "yellow");
							$("body").css("color", "blue");
				     	} 
					 
				 });
				
			});
			
		</script>
        
        
    </head>
    <body>
         <%
           String msg2 =(String)session.getAttribute("msg2");
         %>
         <% 
          int count =(int)application.getAttribute("counter");
          count++;       
         %>
     <script>
			$(document).ready(function(){
				
			})
	 </script>
<%-- 	 
    <h1 style="color:black">Header Part!!!</h1>  
    <h2 style="color:black">number of refrech: <%=count %></h2> 
     --%>
     
    <hr>
      <form action="loginservelet" method="post">
      
        <h1>Login</h1>
    <!--     
        <select id="color">
            <option > select your form color </option>
            <option value="gray"> GRAY </option>
        	<option value="red"> RED </option>
        	<option value="blue"> BLUE </option>
        	<option value="yellow">YELLOW </option>
       	
        </select>
         -->
         
        <%
        if(msg2!=null)
        {
        	%>
        	  <font color='red'><h3> <%=msg2 %> </h3></font>
        	<%
        }
        %>
        
        <fieldset>
          <label for="mail">Email:</label>
          <input type="email" id="mail" name="user_email">
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="user_password">
        </fieldset>

        <input id="button" type="submit" value="Sign In">
        
        <a style="color:white" href="registration.jsp">Not already Registered...Click here!</a> 
        <br>
        <a style="color:white" href="search.jsp">go for search index</a>
      </form> 

      <hr>
<!-- 
      <h1 style="color:black">Footer Part!!!</h1> -->
      
      <%
      application.setAttribute("counter", count);
      session.setAttribute("msg2",null);
      %>
      
    </body>
</html>