<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://bootswatch.com/4/sandstone/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="js/script.js"></script>
</head>

<body>
	<header class="bg-dark p-2 mb-5">
		<h1>Employees &amp; Mangagers</h1>
		<a href="/employees/new" class="btn btn-primary">Add Employee</a>
	</header>
	<main class="text-center w-75 m-auto">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Manager</th>
					<th>Employees</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ employees }" var="employee">
				<tr data-href="/employees/${ employee.id }">
					<td>${ employee.firstName } ${ employee.lastName }</td>
					<td>${ employee.manager.firstName } ${ employee.manager.lastName }</td>
					<td><c:if test="${ employee.employees.size() > 0}">${ employee.employees.size() }</c:if></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>