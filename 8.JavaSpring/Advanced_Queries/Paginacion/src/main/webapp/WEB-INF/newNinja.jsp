<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
 
<!doctype html>
<html lang="es">
<head>
	<!-- Required meta tags -->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
	<title>New Ninja</title>
</head>
<body>
	<nav>
		<div class="container">
  			<ol class="breadcrumb">
    			<li class="breadcrumb-item"><a href="/dojos/new">New Dojo</a></li>
    			<li class="breadcrumb-item active">New Ninja</a></li>
  			</ol>
  		</div>
	</nav>
	<div class="container my-4">
		<h2>New Ninja</h2>
		
		<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
				<div class="form-group row">
					<label for="student" class="col-sm-2 col-form-label">Student</label>
					<div class="col-sm-3">
						<select class="form-control" id="dojoId" name="dojoId">
							<c:forEach var="dojo" items="${dojos}">
							<option value="${dojo.getId()}">${dojo.getName()}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row my-3">
					<div class="col-2"><form:label path="firstName">First Name</form:label></div>
					<div class="col-3">
						<form:errors path="firstName"/>
       					<form:input path="firstName" class="form-control"/>
					</div>
				</div>
				<div class="row my-3">
					<div class="col-2"><form:label path="lastName">Last Name</form:label></div>
					<div class="col-3">
						<form:errors path="lastName"/>
       					<form:input path="lastName" class="form-control"/>
					</div>
				</div>
				<div class="row my-3">
					<div class="col-2"><form:label path="age">Age</form:label></div>
					<div class="col-3">
						<form:errors path="age"/>
       					<form:input path="age" class="form-control"/>
					</div>
				</div>

				<button type="submit" class="btn btn-outline-secondary">Create</button>
				
			</form:form>   
		
		
	</div>
	
	
	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	<script src="js/myscript.js"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
	-->
</body>
</html>
