<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
	String name=(String)session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../resource/css/style.css">
</head>
<body>
	<form action="../LogoutServlet">
	<button>logout</button>
	</form>
	
	<h1>Welcome <%= name %> you have successfully logged in</h1>
	<a href="details.jsp">click for details</a>
</body>
</html>