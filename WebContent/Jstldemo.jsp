<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.Console"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Slot Date    Time <br>
<td><c:out value="${stud.date}" /></td>
<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"

        url="jdbc:mysql://localhost:3306/termproject" user="root" password="" />

 <sql:query var="listMenu" dataSource="${myDS}">

                    select *from resource where username='sri'
             <%--         <sql:param value="${'ID'}" />                
 --%>
            </sql:query>
               <c:forEach var="stud" items="${listMenu.rows}">

                 <tr>

                  <td><c:out value="${stud.date}" /></td> 
                  <td><c:out value="${stud.value}" /></td>
                  
                  <br>
                  </tr>

                  <tr>

                  <td><%-- <img src="${stud.preimagepath}" alt="${stud.preimagename}" width="700px">
 --%>
                  </td>                    

                  </tr>

                  <tr>

                  

                  <td><c:out value="${stud.Officehours}" /></td> 

                  </tr>

                </c:forEach>




</body>
</html>












