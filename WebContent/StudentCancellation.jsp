<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body onload="slots()" >

 	<script type="text/javascript">
        function includefile(a) 
        {
        	document.getElementById("a").style.display="block";
        	}
        	
        function hidedisplay()
        {
        	document.getElementById("T1").style.display="none";
        	}
        </script>
    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                   
                </li>
               
                <li>
                    <a href="ResourceReservation.jsp" >Resource Reservation</a>
                </li>
                <li>
                    <a href="StudentCancellation.jsp">Resource Cancellation</a>
                </li>
                <li>
                    <a href="ViewAnnouncement.jsp">Announcements</a>
                </li>
                <li>
                    <a href="ViewCoursesStudent.jsp">View Courses</a>
                </li>
                
                
                <li>
                    <a href="EditProfileServlet">Edit Profile</a>
                </li>
                <li>
                    <a href="StudentDiscussionBoard.jsp">Discussion Board</a>
                </li>
                <li>
                    <a input type="button" value="Click Here"  onclick="includefile(T2)">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->
        <div align="right">
                 Welcome,
<%HttpSession session3 = request.getSession(); 
  String sri = (String) session.getAttribute("name");%>
  <%=sri %> 
  <br>
  
  <a href="Logout.jsp">Logout</a>
        </div>

        <!-- Page Content -->
        <div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                       <img src="img/Logo.jpg" alt="" width="somewidthhere" height="someheighthere" border="0"/ >
                        
                        <br>
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
                    </div>
                    <script type="text/javascript">
					
					</script>
                </div>
            </div>
        </div>
        <div>
        <div align="right">
                 
<%HttpSession session2 = request.getSession(); 
  String srin = (String) session.getAttribute("username");%>
  
  </div>
  <div>
<h2> The Resources you have reserved are:</h2>
  
        
 <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/termproject" user="root" password="" />

<c:set var="empId" value="<%=srin%>"/>

<sql:query dataSource="${snapshot}" var="result">
   SELECT * from resource where username=?;
   <sql:param value="${empId}" />
  
</sql:query>
<form action="CancellationServlet" method="post">
<table border="1" width="100%" >
<tr>
<th>userID</th>
<th>Date</th>
<th>Type Of Resource</th>
<th>Time Slot</th>
<th>Action</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.username}"/></td>
<td><c:out value="${row.date}"/></td>
<td><c:out value="${row.type}"/></td>
<td><input type="text" id="timeslot1${row.value}"  value="">

<td><input type ="submit" name="Cancel" value="Cancel Reservation" onclick="cancel(${row.ID})" /></td>
<td><input type="hidden" name="timeslot" id="timeslot${row.value}" value="${row.value}"	>
</tr>
</c:forEach>
</table>

<input type="hidden" name="cancelID" id="cancelID"  >
<%for (int i=1;i<9;i++) {%>
<input type="hidden" name="timeslot" id="timeslot<%=i%>" value=""	>
<%} %>
</form> 
<script>
function cancel(ID){
document.getElementById("cancelID").value = ID; 
alert("You sure to cancel Reservation");
}
</script> 



<script>
function slots()
{
	var b;
	for (b=1;b<=8;b++) {
		
		var c = "timeslot" + b;
		
		var a = document.getElementById(c).value;
		
		var d = "timeslot1" + b;
		if(a==1)
		{
		  document.getElementById(d).value="10AM-11AM";
		}
		if(a==2)
		{
		  document.getElementById(d).value="11AM-12PM";
		}
		if(a==3)
		{
		  document.getElementById(d).value="12PM-1PM";
		}
		if(a==4)
		{
		  document.getElementById(d).value="1PM-2PM";
		}
		if(a==5)
		{
		  document.getElementById(d).value="2PM-3PM";
		}
		if(a==6)
		{
		  document.getElementById(d).value="3PM-4PM";
		}
		if(a==7)
		{
			  document.getElementById(d).value="4PM-5PM";
		}
		
		if(a==8)
		{
		  document.getElementById(d).value="5PM-6PM";
		}
		
	}
	
}
</script>      
        
        
        
        
        
        
</div>
             
             
                
        </div>
        
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>
