<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Add a new team</title>
</head>
<body>
	<div id = "main">
		<h2>Create a new team!</h2>
		<br/>
		<form name = "guess" method = "post" action = "/TeamRoster/teams">
			Team name: <input type = "text" name = "team"/>
			<br/>
			<br/>
			<input type = "submit" value = "Create!"/>
		</form>
	</div>
</body>
</html>