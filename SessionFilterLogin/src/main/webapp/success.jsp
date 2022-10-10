<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
<link rel="stylesheet" href="resource/css/style.css">
</head>
<body>
	<form action="logout">
	<button>logout</button>
	</form>
	<%
	String name=(String)session.getAttribute("name");
	%>
	<h1>Welcome <%= name %> you have successfully logged in</h1>
	<a href="details.jsp">click for details</a>
</body>
</html>