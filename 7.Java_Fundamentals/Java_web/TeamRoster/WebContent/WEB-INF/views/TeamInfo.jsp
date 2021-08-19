<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Team Info</title>
	<style>
		#top {
			padding-left: 35px;
			display: inline-block;
		}
		#topright {
			padding-left: 350px;
			display: inline-block;
		}
		table {
			border: 1px solid black;
			border-collapse: collapse;
			margin: 10px;
			margin-left: 30px; 
			margin-bottom: 30px;
		}
		th {
			text-align: left;
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px;
			padding-left: 10px;
			padding-right: 100px;
			background-color: lightgrey;
			font-size: 18px;
		}
		tr td {
			border: 1px solid black;
			border-collapse: collapse;
			padding: 10px;
			background-color: rgb(237, 241, 248);
			font-size: 18px;
		}
	</style>
</head>
<body>
	<% int index = (int) session.getAttribute("id"); %>
	<div id = "wrapper">
		<div id = "top">
			<h2><c:out value = "${team.getTeam_name()}"/></h2>
		</div>
		<div id = "topright">
			<h3><a href = "/TeamRoster/players?id=<%= index%>">Add New Player</a></h3>
		</div>
		<div id = "main">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Action</th>
				</tr>

			<% int i = 0; %>
				<c:forEach var = "player" items = "${team.getPlayers()}">
				<tr>
					<td><c:out value = "${player.getFirst_name()}"/></td>
					<td><c:out value = "${player.getLast_name()}"/></td>
					<td><c:out value = "${player.getAge()}"/></td>
					<td>
					<a href = "/TeamRoster/deleteplayer?teamid=<%= index %>&playerid=<%= i %>">Delete</a></td>
					<% i++; %>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>