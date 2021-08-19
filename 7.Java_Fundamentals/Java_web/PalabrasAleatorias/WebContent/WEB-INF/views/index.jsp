<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generador Aleatorio de Palabras</title>
</head>
<body>

<h3>Tu has generado una palabra aleatoria <c:out value="${counter}"/> veces</h3>


<h3><c:out value="${generador}"/></h3>

<form method="get" action="Home">
 
  <input   value="Generar!" type="submit"></input>
</form> 

<h2>La última vez que generaste una palabra fue el: </h2>
<h2> <c:out value="${fecha}"/> </h2>


</body>
</html>