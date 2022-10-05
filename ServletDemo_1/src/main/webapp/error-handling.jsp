<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
	int a = 20;
	int b = 0;
	%>
	
	<%
	int division = a/b;
	%>
	
	<h1><%= division %></h1>
</body>
</html>