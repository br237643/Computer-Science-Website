<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
  
<link href="css/login.css"rel="stylesheet">
<link href="css/name.css" rel="stylesheet">

</head>
<style>
div{
background-color: white;
}
div1{
background-color: white;
}
h1{
background-color: white;
}
</style>
<h1>  <img src="img/Logo.jpg" alt="" width="800" height="100" border="0"/ align="center"></h1>
<body background=#FFE5CC>
<div class="login_form" align="right">
<%
String ErrorMessage=(String)request.getAttribute("Error");%>


<form  action="LoginServlet" method="post">
    <ul style="list-style:none">
      <tr>
		<table>		
				
  				<input type="radio" name="type" value="faculty" id="ft" checked="checked"> Faculty
  				<input type="radio" name="type" value="staff" > Staff
  				<input type="radio" name="type" value="student"> Student
				
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="usermail" id="usermail" required/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="password" required/></td>
				</tr>
				<tr><p style="Color:red"><%if(ErrorMessage!=null){%>
				<red><%=ErrorMessage %></red>
				<%} %></p></tr>
					
				
		</table>
		<input type="submit" value="Login" /><br>	
        <a href="Registration1.jsp">Register AS a Student</a> <br>
        OR<br>
         <a href="Registration.jsp">Register AS a Faculty/Staff</a>
        
    </ul>
</form>

</div>
<div1 class="footer">
<%@include file="footer.jsp" %>
</div1> 
</body>
</html>