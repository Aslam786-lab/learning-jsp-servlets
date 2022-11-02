<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="resource/css/style.css">
</head>
<body>
		<div class="container">
			<h1>Please register here</h1>
			<form  action="register" method="post">
				<label>Username</label>
				<input name="user_name" type="text">
				<br>
				
				<label>Email</label>
				<input name="user_email" type="email">
				<br>
				
				<label>City</label>
				<input name="user_city" type="text">
				<br>
				
				<label>Age</label>
				<input name="user_age" type="text">
				<br>
				
				<label>Gender</label>
				<input name="user_gender" type="text">
				<br>
				
				<label>Password</label>
				<input name="user_password" type="password">
				<br>
				<button>register</button>
			</form>
		</div>
</body>
</html>