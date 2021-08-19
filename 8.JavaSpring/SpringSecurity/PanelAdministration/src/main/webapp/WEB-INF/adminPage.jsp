<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Admin Page</title>

	<style>
		#wrapper {
			background-color: rgb(211, 127, 226);
		}
		h1 {
			display: inline-block;
		}
		#top {
			padding: 20px;
			padding-left: 70px;
		}
		#topright {
			display: inline-block;
			padding-left: 200px;
		}
		#blackline {
			background-color: black;
			height: 3px;
		}
		#main {
			padding: 20px;
			padding-left: 150px;
			height: 550px;
			background-color: rgb(227, 175, 237);
		}
		table {
			border: 1px solid black;
			border-collapse: collapse;
			margin-top: 30px;
			margin-left: 120px;
		}
		th {
			text-align: center;
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px;
			padding-left: 20px;
			padding-right: 180px;
			background-color: rgb(249, 209, 144);
			font-size: 18px;
		}
		tr td {
			border: 1px solid black;
			border-collapse: collapse;
			padding: 10px;
			background-color: rgb(247, 228, 197);
			font-size: 18px;
		}
	</style>
</head>
<body>
	<div id = "wrapper">
		<div id = "top">
			<h1>Welcome to the Admin Page, <c:out value="${user.username}"></c:out>!</h1>
			
			<div id = "topright">
				<form id = "logoutForm" method="POST" action="/logout">
			        <input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token}"/>
			        <input type = "submit" value = "Logout!" />
			    </form>
			</div>
		</div>
		<div id = "blackline"></div>
		<div id = "main">
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Email</th>
			            <th>Action</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items = "${everyone}" var = "e">
			        <tr>
			            <td>${e.username}</td>
			            <td>${e.email}</td>
			            <td>
			            <c:choose>
			            	<c:when test = "${e.roles.get(0).name.equals('ROLE_ADMIN')}">
				            	Admin
				            </c:when>
				            <c:otherwise>
				            	<a href = "/admin/${e.id}/delete">Delete</a> /
				            	<a href = "/admin/${e.id}/makeAdmin">Make Admin</a>
				            </c:otherwise>
			            </c:choose>
			            
						</td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
	</div>
</body>
</html>