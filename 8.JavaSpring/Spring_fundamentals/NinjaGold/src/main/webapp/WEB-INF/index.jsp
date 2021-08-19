  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
 import="java.util.Collections,java.util.ArrayList"    
 %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<meta charset="ISO-8859-1">
<title>Neenja gold</title>
<style>
.route{ margin-top: 50px; width: 200px; height: 200px;}
.green{color:green;}
.red{color:red;}
</style>
</head>
<body>
	<h1> This is index</h1>
	<form action="reset">
	<button class="btn btn-danger" type = "submit"> Reset</button>
	</form>
<div class="container"> 
	<h2>Your Gold: <input type="text" value ="${gold}"> </h2>
</div>

<div class="container">
	<div class="row">
		<div class="route col-xs-2 offset-xs-1">
		<p>+10-20 Gold</p>
			<form class="form-inline" action="farm" method="post" >
			  <button type="submit" class="btn btn-primary mb-2">Farm</button>
			</form>
		</div>
		<div class="route col-xs-2 offset-xs-1">
		<p>+5-10 Gold</p>
			<form action="cave" method="post" >
			  <button type="submit" class="btn btn-primary mb-2">Cave</button>
			</form>
		</div>
		<div class="route col-xs-2 offset-xs-1">
		<p>+2-5 Gold</p>
			<form class="form-inline" action="house" method="post" >
			  <button type="submit" class="btn btn-primary mb-2">House</button>
			</form>
		</div>
		<div class="route col-xs-2 offset-xs-1">
		<p>< (+/-)50 Gold /p>
			<form action="casino" method="post" >
			  <button type="submit" class="btn btn-primary mb-2">Casino</button>
			</form>
		</div>
	</div>
</div>

<div class="container">
	<h2> Activities: </h2>
	<p> 
		<c:forEach var="item" items="${log}">
	    ${item}
		</c:forEach>
	<p>
</div>
</body>
</html>