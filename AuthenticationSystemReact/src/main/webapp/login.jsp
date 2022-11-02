<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%
String invalidUser = "";
String registerUser = "";

if(session.getAttribute("msg") != null){
	invalidUser = session.getAttribute("msg").toString(); 
	session.removeAttribute("msg");
	 
}else if(session.getAttribute("registered") != null) {
	registerUser = session.getAttribute("registered").toString();
	session.removeAttribute("registered");
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="resource/css/style.css">
<link rel="stylesheet" href="dist/static/css/main.css">
</head>
<body >
	<div id="root"></div>
	<div class= "container">
		<form action="/user-register">
			<button class= "register-btn">register</button>
		</form>
		<h1>Login Please</h1>
		
		
		<h3 style="color: red;"><%= invalidUser %></h3>
		<h3 style="color: green;"><%= registerUser %></h3>
		
		<form  action="login" method="post">
			<label>Email</label>
			<input name="user_email" type="email">
			<br>
			
			<label>Password</label>
			<input name="user_password" type="password">
			<button>login</button>
		</form>

	</div>


<script src="dist/static/js/main.js" type="text/javascript"></script>
<script src="dist/static/js/chunk.js" type="text/javascript"></script>
</body>
</html>