<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.Console"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<h1>ADD COURSE DETAILS</h1>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <meta name="description" content="">
    <meta name="author" content="">

    <title>UALABNY COMPUTER SCIENCE WEBSITE</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/simple-sidebar.css" rel="stylesheet">


<div id="header"> 

<div id="logo">
 
 </div> 
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body style = "border:1px solid black;>
         Welcome,
<%HttpSession session1 = request.getSession(); 
  String srinivas = (String) session.getAttribute("username");%>
  <%=srinivas %>              
                        
                       <form action="PostOfficeServlet" method="post" >
                       
                        Course Code       : <input type="text" name="CourseID"><br>
   						Add Office Hours  : <input type="text" name="OfficeHours"><br>
   						Add TA information:<input tyep="text" name="TAinfo"><br>
   						Syllabus: <br><textarea   name="Syllabus" col="100" rows="40" style="width:595px; height:842  px;" "></textarea><br>
   						<input type="submit" value="Submit">
   						
   						
						</form> 
</body>

</html>
