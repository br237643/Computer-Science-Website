<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <form action="LogoutServlet" method="post">
  <input type="submit" name="logout" value="Logout">
  </form>
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
                    <div>
                     <li>
                    <a href="index.jsp">HOME</a>
                </li>
                    
                    </div>
                  
                    <div align="right">
                   <li>
                    <a href="ChangePassword.jsp">Change Password</a>
                </li>
                    </div>
                    <script type="text/javascript">
					
					</script>
                </div>
            </div>
        </div>
    <div>
    <form action="TeamJobPortalServlet" method="post">
																<div class="panel-heading panel-heading-gray ">

																	Please fill out the form:</div>
																<div class="panel-body">
																	<label class="radio-inline">Select Location : 
																		<input type="radio" name="location" value="oncampus">On Campus
																	</label> <label class="radio-inline"><input
																		type="radio" name="location" value="offcampus">Off Campus</label>
																	<br><label><div class="dropdown">
																	  Select The Category:
																	   <br>
																	 <select name="category" id="type1" required>
																	   <option value="Default">Choose a Category</option>
																	   <option value="Computer Science">Computer Science</option>
																	   <option value="Management">Management</option>
																	   <option value="Finance">Finance</option>
																	   <option value="Economics">Economics </option>
																	</select> 
																	  </div></label>
																	 <br> Job description <br>
																	<textarea name="description" id="description"
																		class="form-control" rows="3"
																		placeholder="Description of Job..." required></textarea>
																	<br> <label for="requirement">Requirement :</label> <input
																		type="text" class="form-control" id="add"
																		name="requirement" /> <br> <label for="requirement" required>Deadline Date:</label>
																	<input type="date"  id="date"
																		name="date" /><br>
																		<label >Apply at :</label>
																	<input type="text" id="url"
																		name="url"  /><br>
																		<label >Contact Email:</label>
																	<input type="email" class="form-control" id="contact"
																		name="email"  required>
																		<input type="hidden" name="pid" value="0">
																</div>
																<div class="panel-footer share-buttons">
																	<input type="submit"
																		class="btn btn-primary btn-xs pull-right "
																		name="action" class="btn btn-primary" value="Post" />
																</div>
															</form>
    
    
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
