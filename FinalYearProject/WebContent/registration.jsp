<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.info.model.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
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
      <h1 style="color:black">Header Part!!!</h1>
      <hr>
      <form action="RegistrationServelet" method="post">
      
        <h1>Sign Up</h1>
				
    <!--     <select id="color" >
            <option > select your form color </option>
            <option value="gray"> GRAY </option>
        	<option value="red"> RED </option>
        	<option value="blue"> BLUE </option>
        	<option value="yellow">YELLOW </option>
       	
        </select> -->
        
        <%
        Employee emp = new Employee();
        emp.setName("");
        emp.setEmail("");
        emp.setBiographie("");
        
        if(session.getAttribute("msg1")!= null)
        {
        	 emp=(Employee)session.getAttribute("msg1");
        }
       
        String error = (String) session.getAttribute("error");
           if(error !=null)
           {
        %>
          <font align="center" color="red"><h2><%=error %></h2></font>
                  
        <%	 
           }
        %>
          
          <script>
                  function check()
                  {
                	  var Id_radio = <%= emp.getAge()%>
                	            	 
                	     $("#name").val("<%=emp.getName()%>");
                	     $("#email").val("<%=emp.getEmail()%>");
                	     $("#bio").val("<%=emp.getBiographie()%>");
                	     //pending
                	     $("user_age[value=$(Id_radio)]").attr('checked','checked');	     
                  }
                            
          </script>
          
          
          
        
        <fieldset>
          <legend><span class="number">1</span>Your basic info</legend>
          <label for="name">Name:</label>
          <input type="text" id="name" name="user_name" >
          
          <label for="mail">Email:</label>
          <input type="email" id="email" name="user_email"  >
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="user_password" > 
        
          <label>Age:</label>
          <input type="radio" id="under_13" value="under_13" name="user_age"><label for="under_13" class="light">Under 13</label><br>
          <input type="radio" id="over_13" value="over_13" name="user_age"><label for="over_13" class="light">13 or older</label>
        </fieldset>
        
        <fieldset>
          <legend><span class="number">2</span>Your profile</legend>
          <label for="bio">Biography:</label>
          <textarea id="bio" name="user_bio" value="<%=emp.getBiographie() %>"></textarea>
        </fieldset>
        
        <fieldset>
        <label for="job">Job Role:</label>
        <select id="job" name="user_job">
          <optgroup label="Web">
            <option value="frontend_developer">Front-End Developer</option>
            <option value="php_developor">PHP Developer</option>
            <option value="python_developer">Python Developer</option>
            <option value="rails_developer"> Rails Developer</option>
            <option value="web_designer">Web Designer</option>
            <option value="WordPress_developer">WordPress Developer</option>
          </optgroup>
          <optgroup label="Mobile">
            <option value="Android_developer">Androild Developer</option>
            <option value="iOS_developer">iOS Developer</option>
            <option value="mobile_designer">Mobile Designer</option>
          </optgroup>
          <optgroup label="Business">
            <option value="business_owner">Business Owner</option>
            <option value="freelancer">Freelancer</option>
          </optgroup>
          <optgroup label="Other">
            <option value="secretary">Secretary</option>
            <option value="maintenance">Maintenance</option>
          </optgroup>
        </select>
        
          <label>Interests:</label>
          <input type="checkbox" id="development" value="interest_development" name="user_interest"><label class="light" for="development">Development</label><br>
            <input type="checkbox" id="design" value="interest_design" name="user_interest"><label class="light" for="design">Design</label><br>
          <input type="checkbox" id="business" value="interest_business" name="user_interest"><label class="light" for="business">Business</label>
        
        </fieldset>
        <input id="button" type="submit" value="Sign Up">
        
        <script>
                 check();
        </script>
        
      </form>
      
       <%	 
           session.setAttribute("msg1",null);
           session.setAttribute("error",null);
        %>
      
      <hr>

      <h1 style="color:black">Footer Part!!!</h1>
    </body>
</html>