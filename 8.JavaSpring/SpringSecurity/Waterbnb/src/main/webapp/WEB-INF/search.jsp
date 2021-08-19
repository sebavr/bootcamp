<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<li class="nav-item">
    			<a class="nav-link" href="/">Home</a>
  			</li>
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
  		
		<p class="mb-0">Find your pool!</p>
		
		<div class="row">
			<div class="col-lg-6">
				<form class="" method="GET" action="/search">
					<div class="form-group row">
						<div class="col-lg-9 my-2">
							<input type="text" id="location" class="form-control" name="location" placeholder="Location" required>
						</div>
						<div class="col-lg my-2">
							<button type="submit" class="btn btn-block btn-outline-dark">Search</button>
						</div>
					</div>
			
				</form>
			</div>
		</div>
		<c:if test = "${errorSearch != null}">
    		<p class="text-danger">${errorSearch}</>				
			</c:if>
		<div class="row my-3">
			<div class="col-lg">
				<table class="table table-sm table-borderless border border-dark">
					<thead class="bg-mybg text-white">
						<tr>
							<th scope="col">Address</th>
							<th scope="col">Pool size</th>
							<th scope="col">Cost per night (USD)</th>
							<th scope="col">Details</th>
						</tr>
					</thead>
					<tbody class="bg-white">
						<c:forEach var="pool" items="${pools}">
						<tr>
							<td>${pool.address}</td> 
							<td>${pool.size}</td>
							<td><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${pool.cost}" /></td>
							<td><a href="/pools/${pool.id}"><fmt:formatNumber type = "number" maxFractionDigits = "1" value = "${pool.ratingAvg}" />/5 - See More</a></td>
						</tr>
						</c:forEach>		
					</tbody>
				</table>
			</div>
		</div>
		
	
	</div>
			
		
	
	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	<!-- <script src="/js/myscript.js"></script> -->

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
	-->
</body>
</html>
