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
		
		<div class="row mt-2">
		
			<div class="col-lg-6 py-2">
				<p class="mb-0 py-2 bg-mybg text-white px-3">Pool info</p>
				<div class="border border-dark bg-white p-3">
					<p class="my-0">Address:</p>
					<p>${pool.address }</p>
					<p class="my-0">Description:</p>
					<p>${pool.description }</p>
					<p class="my-0">Cost per Night:</p>
					<p><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${pool.cost}" /></p>
					<p class="my-0">Pool size:</p>
					<p>${pool.size }</p>
					<p class="my-0">Pool Rating:</p>
					<p><fmt:formatNumber type = "number" maxFractionDigits = "1" value = "${pool.ratingAvg}" />/5</p>
				</div>
			</div>
			
			<div class="col-lg-6 py-2">
				<div class="text-white bg-mybg border border-dark border-bottom-0">
					<p class="my-0 mx-3 p-2">Add Review</p>
				</div>
				<form:form action="/pools/${pool.id}/review" method="POST" modelAttribute="review" class="border border-dark p-4 bg-white">
				
					<div class="form-group mx-1 row">
						<form:label for="comment"  path="comment">Comment</form:label>
						<form:errors path="comment"/>
       					<form:textarea id="comment" rows="4" class="form-control" path="comment" required="true"/>
					</div>
					<form:label for="rating" class="mx-1" path="rating">Rating</form:label>
					<div class="form-group row">
						<div class="col-lg-4">
       						<form:select class="form-control" id="rating" path="rating" required="true">
								<form:option value="">Select Option</form:option>
								<form:option value="1">1</form:option>
								<form:option value="2">2</form:option>
								<form:option value="3">3</form:option>
								<form:option value="4">4</form:option>
								<form:option value="5">5</form:option>
							</form:select>
						</div>
					</div>
					<button type="submit" class="offset-lg-9 col-lg-3 btn btn-outline-dark">Submit</button>
					<c:if test = "${errorRev != null}">
    					<p class="text-danger">${errorRev}</p>				
					</c:if>
				</form:form>
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
