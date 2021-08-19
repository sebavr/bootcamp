<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!doctype html>
<html lang="es">
<head>
	<!-- Required meta tags -->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	<link rel="stylesheet" href="/css/style.css">
	<title>WaterBnB</title>
</head>
<body>

	<div class="container my-4">
	
		<ul class="nav justify-content-end">
  			<c:if test = "${user != null}">
			<li class="nav-item">
    			<form class="d-inline-block" id="logoutForm" method="POST" action="/logout">
        			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        			<button type="submit" class="btn btn-link mb-1">Logout</button>
    			</form>	
  			</li>
  			<li class="nav-item">
				<a class="nav-link disabled"><i class="bi bi-person-fill"></i> ${user.firstName}</a>
			</li>
  			</c:if>
		</ul>
  		
  		<p>Current Listings</p>
		
		<div class="row my-3">
			<div class="col-lg">
				<table class="table table-sm table-borderless border border-red">
					<thead class="bg-primary text-white">
						<tr>
							<th scope="col">Address</th>
							<th scope="col">Pool size</th>
							<th scope="col">Cost per night (USD)</th>
							<th scope="col">Details</th>
						</tr>
					</thead>
					<tbody class="bg-white">
						<c:forEach var="pool" items="${user.poolList}">
						<tr>
							<td>${pool.address}</td>
							<td>${pool.size}</td>
							<td><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${pool.cost}" /></td>
							<td><a href="/host/pools/${pool.id}"><fmt:formatNumber type = "number" maxFractionDigits = "1" value = "${pool.ratingAvg}" />/5 - Edit</a></td>
						</tr>
						</c:forEach>		
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-6">
				<div class="text-white bg-mybg border border-dark border-bottom-0">
					<p class="my-0 mx-3 p-2">New Listing</p>
				</div>
				<form:form action="/host/addPool" method="POST" modelAttribute="pool" class="border border-dark p-4 bg-white">
				
					<div class="form-group row">
						<form:label for="address" class="col-lg-4 col-form-label" path="address">Address</form:label>
						<div class="col-lg">
							<form:errors path="address"/>
       						<form:input type="text" id="address" class="form-control" path="address" required="true"/>
						</div>
					</div>
					<div class="form-group row">
						<form:label for="description" class="col-lg-4 col-form-label" path="description">Description</form:label>
						<div class="col-lg">
							<form:errors path="description"/>
       						<form:textarea id="description" rows="3" class="form-control" path="description" required="true"/>
						</div>
					</div>
					<div class="form-group row">
						<form:label for="cost" class="col-lg-4 col-form-label" path="cost">Cost per night (USD)</form:label>
						<div class="col-lg">
							<form:errors path="cost"/>
       						<form:input type="number" id="cost" class="form-control" step="0.01" path="cost" min="0" required="true"/>
						</div>
					</div>
					<div class="form-group row">
						<label for="size" class="col-lg-4 col-form-label">Pool size</label>
						<div class="col-lg">
								<select id="size" class="form-control" name="size">
       							<option value="Small" label="Small"/>
       							<option value="Medium" label="Medium"/>
       							<option value="Large" label="Large"/>    
       						</select> 
						</div>
					</div>
					<button type="submit" class="offset-lg-9 col-lg-3 btn btn-block btn-outline-dark">Submit</button>
					<c:if test = "${errorPool != null}">
   						 <p class="text-danger">${errorPool}</p>				
					</c:if>
				</form:form>
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
