<%@page import="com.auth.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
User user=(User)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>

<body>
	<h1>Name: <%= user.getName() %>.</h1>
	<h1>Email: <%= user.getEmail() %></h1>
	<h1>City: <%= user.getCity() %>.</h1>
	<h1>Age: <%= user.getAge() %>.</h1>
	<h1>Gender: <%= user.getGender() %>.</h1>
</body>

</html>