<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "t" uri = "/WEB-INF/mylib.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello world</h1>
	<t:mytag></t:mytag>
	<hr>
	<t:printTable number ="23"></t:printTable>
	<t:printTable number ="100"></t:printTable>
</body>
</html>