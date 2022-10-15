<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String name=(String)session.getAttribute("username");
	String email=(String)session.getAttribute("email");
	String city=(String)session.getAttribute("city");
	int age=(int)session.getAttribute("age");
	String gender=(String)session.getAttribute("gender");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>

<body>
	<h1>Name: <%= name %>.</h1>
	<h1>Email: <%= email %></h1>
	<h1>City: <%= city %>.</h1>
	<h1>Age: <%= age %>.</h1>
	<h1>Gender: <%= gender %>.</h1>
</body>

</html>