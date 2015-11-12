<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Local Admin Rights Home</title>

<script type="text/javascript">
	
</script>

</head>
<body>
	<p>${greetings}</p>
	<h4>Local Admin Home page</h4>
	<div><label>${message}</label></div> </br>
	<form action="/app/ladmin/submitreq" name="home-form" method="GET">
		<div><label>UserName : </label></div>
		<div><label><c:out value="${user.userName}" /></label></div> </br>
		<div><label>userId : </label></div>
		<div><input type="text" name = "userId" /></div> </br>
		<div align="left"><input type="submit" name = "create" value="Create"/></div> </br>
	</form>
</body>
</html>