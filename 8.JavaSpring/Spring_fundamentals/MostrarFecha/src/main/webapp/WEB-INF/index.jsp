<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Fecha</title>
<style>

div.a{
 display: inline-block;
  width: 200px;
  height: 100px;
  padding: 5px;
  border: 1px solid blue;    
  background-color: yellow; 
  margin: 20px;
}

div.b{
 display: inline-block;
  width: 200px;
  height: 100px;
  padding: 5px;
  border: 1px solid blue;    
  background-color: cerulean; 
}

</style>
</head>
<body>
<h1>¿Como quiere ver la fecha?</h1>

<div class="a"><a href="date">Plantilla de fecha</a></div>
<div class="b"><a href="time">Plantilla de hora</a></div>




</body>
</html>