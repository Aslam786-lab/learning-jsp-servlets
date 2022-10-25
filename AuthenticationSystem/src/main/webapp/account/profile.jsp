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
<title>profile</title>
<link rel="stylesheet" href="../resource/css/style.css">
</head>
<body>
	<div class="container">
		<form action="../logout">
		<button>logout</button>
		</form>
		
		<form action="/user-details">
				<button class= "register-btn">details</button>
		</form>
		
		<h1>Welcome <%= name %> you have successfully logged in</h1>
		
		<form action="/todo?action=add" method="post">
			<input type="text" name="todo_add">
			<button>add</button>
		</form>
		
	</div>
</body>
</html>

