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

<body onload="hidedisplay()" >

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
               <%if(session.getAttribute("type").toString().contains("student")){ %>
                <li>
                     <a href="ViewProfandTA.jsp">View Professor and TA info</a>
                </li>
                <%} %>
                <%if(session.getAttribute("type").toString().contains("student")){ %>
                <li>
                     <a href="ViewProgramRequiremntServlet">View Program Requirement</a>
                </li>
                <%} %>
                 <%if(session.getAttribute("type").toString().contains("student")){ %>
                <li>
                     <a href="CoursesSuggested.jsp">Field Concentrations</a>
                </li>
                <%} %>
                <li>
                    <a href="ResourceReservation.jsp" >Resource Reservation</a>
                </li>
                <li>
                    <a href="Cancellation.jsp">Resource Cancellation</a>
                </li>
                 <%if(session.getAttribute("type").toString().contains("faculty")){ %>
                <li>
                    <a href="Announcement.jsp">Announcements</a>
                </li>
                <%}	 %>
                <%if(session.getAttribute("type").toString().contains("student")){ %>
                <li>
                     <a href="ViewCoursesStudent.jsp">View Courses</a>
                </li>
                <%} %>
                 <%if(session.getAttribute("type").toString().contains("student")){ %>
                <li>
                    <a href="ViewAnnouncements.jsp">View Announcements</a>
                </li>
                <%} %>
                 <%if(session.getAttribute("type").toString().contains("student")){ %>
                <li>
                    <a href="CheckRegistrationjsp.jsp">Register For exam</a>
                </li>
                <%} %>
                
                <%if(session.getAttribute("type").toString().contains("staff")){ %>
                <li>
                    <a href="AddNewResource.jsp">Add New Resources</a>
                </li>
                <%} %>
                
                  <%if(session.getAttribute("type").toString().contains("staff")||session.getAttribute("type").toString().contains("faculty")){ %> 
                <li>
                    <a href="ViewPhDStudent.jsp">View PhD Student Status</a>
                </li>
                
                <li>
                    <a href="PostExamInfo.jsp">Create Examination </a>
                </li>
                <%} %>
                <%if(session.getAttribute("type").toString().contains("student")){ %>
                <li>
                    <a href="EditProfileServlet">Edit Profile</a>
                </li>
                <%} %>
                 <%if(session.getAttribute("type").toString().contains("student")){ %>
                <li>
                    <a href="ViewJobOffers.jsp">Job opportunity	</a>
                </li>
                <%} %>
                <li>
                    <a href="DiscussionBoard.jsp">Discussion Board</a>
                </li>
                
                <li>
                    <a href="PostAlumni.jsp">Alumni Information</a>
                </li>
                <%if(session.getAttribute("type").toString().contains("faculty")||session.getAttribute("type").toString().contains("staff")){ %>
                <li>
                    <a href="TeamJobPortal.jsp">Post a job</a>
                </li>
                <%} %>
               
                
                
                 <%if(session.getAttribute("type").toString().contains("faculty")){ %>
                 <li>
                    <a href="PostResult.jsp">Examination</a>
                </li>
                <%} %>
                <li>
                    <a input type="button" value="Click Here"  onclick="includefile(T2)">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->
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
        <h2>Professor information</h2>
          <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/termproject" user="root" password="" />

<c:set var="empId" value="103"/>



<sql:query dataSource="${snapshot}" var="result">
   SELECT * from registration where type="faculty";
</sql:query>
 
<table border="1" width="100%">
<tr>
<th>Professor Names</th>
<th>Email Address</th>

</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.name}"/></td>
<td><a href="https://login.microsoftonline.com/login.srf?wa=wsignin1.0&rpsnv=4&ct=1463002747&rver=6.6.6556.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.office.com%2fowa%2f%3frealm%3dalbany.edu%26authRedirect%3dtrue&id=260563&whr=albany.edu&CBCXT=out&msafed=0">Send Email</a> </td>

</tr>
</c:forEach>
</table>   
        <h2>TA information</h2>
          <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/termproject" user="root" password="" />

<c:set var="empId" value="103"/>



<sql:query dataSource="${snapshot}" var="result">
   SELECT * from courselist where Semester="fall";
</sql:query>
 
<table border="1" width="100%">
<tr>
<th>Course ID</th>
<th>Course Name</th>
<th>TA Information</th>

</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.CourseID}"/></td>
<td><c:out value="${row.CourseName}"/></td>
<td><c:out value="${row.TAInfo}"/><br><a href="https://login.microsoftonline.com/login.srf?wa=wsignin1.0&rpsnv=4&ct=1463002747&rver=6.6.6556.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.office.com%2fowa%2f%3frealm%3dalbany.edu%26authRedirect%3dtrue&id=260563&whr=albany.edu&CBCXT=out&msafed=0">(Send Email)</a> </td>


</tr>
</c:forEach>
</table>   
             
             
             
                
        </div>
        <div>
        
        
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
