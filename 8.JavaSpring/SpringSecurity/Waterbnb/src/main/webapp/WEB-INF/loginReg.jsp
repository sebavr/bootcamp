<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="es">
<head>
	<!-- Required meta tags -->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
	<title>WaterBnB</title>
</head>
<body>

	<div class="container my-4">
	
		
		<div class="row">
			<div class="my-2 col-lg-6">
				<div class="text-white bg-primary border border-red border-bottom-0">
					<p class="my-0 mx-3 p-2">Register</p>
				</div>
				<form:form action="/registration" method="POST" modelAttribute="user" class="border border-red p-4 bg-white">
					<div class="form-group row">
						<form:label for="firstName" class="col-lg-4 col-form-label" path="firstName">First Name</form:label>
						<div class="col-lg">
							<form:errors path="firstName"/>
       						<form:input type="text" id="firstName" class="form-control" path="firstName" required="true"/>
						</div>
					</div>
					<div class="form-group row">
						<form:label for="lastName" class="col-lg-4 col-form-label" path="lastName">Last Name</form:label>
						<div class="col-lg">
							<form:errors path="lastName"/>
       						<form:input type="text" id="lastName" class="form-control" path="lastName" required="true"/>
						</div>
					</div>

					<div class="form-group row">
						<form:label for="email" class="col-lg-4 col-form-label" path="email">Email</form:label>
						<div class="col-lg">
							<form:errors path="email"/>
       						<form:input type="email" id="email" class="form-control" path="email" required="true"/>
						</div>
					</div>
					
					<div class="form-group row">
						<form:label for="password" class="col-lg-4 col-form-label" path="password">Password</form:label>
						<div class="col-lg">
							<form:errors path="password"/>
       						<form:input type="password" id="password" class="form-control" path="password" required="true"/>
						</div>
					</div>
					<div class="form-group row">
						<form:label for="passwordConfirmation" class="col-lg-4 col-form-label" path="passwordConfirmation">password Conf.</form:label>
						<div class="col-lg">
							<form:errors path="passwordConfirmation"/>
       						<form:input type="password" id="passwordConfirmation" class="form-control" path="passwordConfirmation"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="offset-lg-4 col-lg">
							<select class="form-control" id="role" name="role" required>
								<option value="">Select type of user</option>
								<option value="GUEST">Guest</option>
								<option value="HOST">Host</option>
							</select>
						</div>
					</div>

					<button type="submit" class="offset-lg-9 col-lg-3 btn btn-block btn-outline-dark">Submit</button>
					<c:if test = "${errorReg != null}">
    					<p class="text-danger">${errorReg}</p>				
					</c:if>
				</form:form>
			</div>

			<div class="my-2 col-lg-6">
				<div class="text-white bg-danger border border-dark border-bottom-0">
					<p class="my-0 mx-3 p-2">Login</p>
				</div>
				<form class="border border-dark p-4 bg-white" method="POST" action="/guest/signin">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="form-group row">
						<label for="email" class="col-lg-4 col-form-label">Email</label>
						<div class="col-lg">
							<input type="email" id="email" class="form-control" name="username" required>
						</div>
					</div>
					
					<div class="form-group row">
						<label for="password" class="col-lg-4 col-form-label">Password</label>
						<div class="col-lg">
							<input type="password" id="password" class="form-control" name="password" required>
						</div>
					</div>
			
					<button type="submit" class="offset-lg-9 col-lg-3 btn btn-block btn-outline-dark">Submit</button>
					<c:if test = "${errorLog != null}">
    					<p class="text-danger">${errorLog}</p>				
					</c:if>
				</form>
			</div>
		</div>
		
	</div>
			
		
	
	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	<script src="/js/myscript.js"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
	-->
</body>
</html>
