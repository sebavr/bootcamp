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
		<a href="/employees" class="btn btn-primary">Employee Dashboard</a>
	</header>
	<main class="text-center">
		<h2><c:out value="${ employee.firstName } ${ employee.lastName }"/></h2>
		<c:if test="${ employee.manager != null }">
		<h4>Manager:  <c:out value="${ employee.manager.firstName } ${employee.manager.lastName }"/></h4>
		</c:if>
		<c:if test="${ employee.employees.size() > 0 }">
		<ul>
			<c:forEach items="${ employee.employees }" var="employs">
			<li>${ employs.firstName } ${ employs.lastName }</li>
			</c:forEach>
		</ul>
		</c:if>
		
		<c:if test="${ employee.manager == null && employee.employees.size() == 0 }">
		<form action="/addManager" method="POST">
			<input type="hidden" name="employeeId" value="${ employee.id }">
			<select name="managerId">
				<c:forEach items="${ employees }" var="manager" >
				<c:if test="${ employee.id != manager.id }">
				<option value="${ manager.id }">${ manager.firstName } ${ manager.lastName }</option>
				</c:if>
				</c:forEach>
			</select>
			<input type="submit" class="btn btn-success" value="Add Manager">
		</form>
		</c:if>
	</main>
</body>
</html>l>