<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String name=(String)session.getAttribute("name");
	%>
	<h1>Name is <%=name %>. he is 33 year old lives in LA.</h1>
</body>
</html>