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
               
                <li>
                    <a href="ResourceReservation.jsp" >Resource Reservation</a>
                </li>
                <li>
                    <a href="Cancellation.jsp">Resource Cancellation</a>
                </li>
                <li>
                    <a href="Announcement.jsp">Announcements</a>
                </li>
                <%if(session.getAttribute("type").toString().contains("faculty")){ %>
                <li>
                     <a href="ViewCourses.jsp">View Courses</a>
                </li>
                <%} %>
                <%if(session.getAttribute("type").toString().contains("staff")){ %>
                <li>
                    <a href="AddNewResource.jsp">Add New Resources</a>
                </li>
                <%} %>
                <li>
                    <a href="FSEditProfileServlet">Edit Profile</a>
                </li>
                <li>
                    <a href="ViewPhDStudent.jsp">View PhD Student Status</a>
                </li>
                <li>
                    <a href="PostExamInfo.jsp">Create Examination </a>
                </li>
                <%if(session.getAttribute("type").toString().contains("student")){ %>
                <li>
                    <a href="EditProfileServlet">Edit Profile</a>
                </li>
                <%} %>
                <li>
                    <a href="DiscussionBoard.jsp">Discussion Board</a>
                </li>
                <li>
                    <a href="PostAlumni.jsp">Alumni Information</a>
                </li>
                <li>
                    <a href="TeamJobPortal.jsp">Post a job</a>
                </li>
               
                
                
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
        <div align="justify" border="1">
        <%

String title = (String) request.getAttribute("title");
String postedby = (String) request.getAttribute("postedBy");
String postID=(String) request.getAttribute("postID");
%>
         <h1>Title:<%=title %></h1>
          <h3>Posted By:<%=postedby %></h3>
          <h4 align="right">POST ID:<%=postID %>     </h4>
          <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/termproject" user="root" password="" />

<c:set var="empId" value="<%=postID %>"/>



<sql:query dataSource="${snapshot}" var="result">
   SELECT * from discussioncomment where Pid=? ORDER BY time ASC;
   <sql:param value="${empId}" />
</sql:query>
 <form name="myform" action="DeleteCommentServlet" method="post">



</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
Replied By:
<b>
<td><c:out value="${row.postedby}"/></td> :
<td><c:out value="${row.comment}"/></td><br> </b> (
<td><c:out value="${row.time}"/></td>  )
<%if ((session.getAttribute("type").toString().contains("faculty"))||(session.getAttribute("type").toString().contains("staff")) ){ %>
<td><input type="submit" name="delete"  value="Delete inappropriate content" id="${row.Id}" onclick="comment2(this.id)"></td>
<%} %>
<br>
</tr>
</c:forEach>


<input type="hidden" name="comment" id="comment" >
<input type="hidden" name="postID" value="<%=postID %>"  >
<input type="hidden" name="title" value="<%=title %>"  >
<input type="hidden" name="postedby" value="<%=postedby %>"  >
</form>
<script>
function comment2(Id){
	"use strict";
	
	document.forms["myform"]["comment"].value=Id;
	
	
	
}
</script>
<form action="NewReplyServlet" method="post">

<input type="hidden" name="postID" value="<%=postID %>"  >
<input type="hidden" name="title" value="<%=title %>"  >
<input type="hidden" name="postedby" value="<%=postedby %>"  >




          
<textarea   name="newreply" Placeholder="Reply" col="50" rows="2" style="width:595px; height:842  px;" "></textarea><br>
  			<input type="submit" name="reply" value="Send Reply">
  			</form>	

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
