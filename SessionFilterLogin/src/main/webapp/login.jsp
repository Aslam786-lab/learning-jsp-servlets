<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resource/css/style.css">
</head>
<body >
	<div class= "container">
		<h1>Login Please</h1>
		
		<h3 style="color: red;">${message }</h3>
		<form  action="success" method="post">
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