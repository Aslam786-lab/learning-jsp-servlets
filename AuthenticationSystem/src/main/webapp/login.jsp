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

</head>
<body >
	<div class= "container">
		<form action="registration.html">
			<button class= "register-btn">register</button>
		</form>
		<h1>Login Please</h1>
		
		
		<h3 style="color: red;"><%= invalidUser %></h3>
		<h3 style="color: green;"><%= registerUser %></h3>
		
		<form  action="LoginServlet" method="post">
			<label>Username</label>
			<input name="user_name" type="text">
			<br>
			
			<label>Password</label>
			<input name="user_password" type="password">
			<br>
			<button>login</button>
		</form>
		
	</div>
	

</body>
</html>