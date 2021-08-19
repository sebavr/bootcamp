  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Add a New Player</title>
	<style>
		#main {
			padding-left: 30px;
		}
	</style>
</head>
<body>
	<div id = "main">
		<% int index = Integer.parseInt(request.getParameter("id")); %>
		<h2>Add a new player to: <c:out value = "${team.getTeam_name()}"/> </h2>
		<br/>
		<form name = "guess" method = "post" action = "/TeamRoster/players?id=<%= index %>">
			First Name: <input type = "text" name = "first_name"/>
			<br/><br/>
			Last Name: <input type = "text" name = "last_name"/>
			<br/><br/>
			Age: <input type = "text" name = "age"/>
			<br/><br/>
			<input type = "submit" value = "Add!"/>
		</form>
	</div>
</body>
</html>