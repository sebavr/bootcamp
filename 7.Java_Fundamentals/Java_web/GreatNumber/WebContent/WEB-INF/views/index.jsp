<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>El Gran N�mero</title>
</head>
<body>

<h1>Bienvenido al juego del gran n�mero!</h1>
<h2>Estoy pensando en un n�mero entre 1 el 10</h2>
<h2>�Ingresa un n�mero!</h2>

<% String laRespuesta=(String) session.getAttribute("respuesta");
	if(laRespuesta=="Correcto"){ %>
		<h3>Excelente, es CORRECTO</h3>
		<a href="reset"><button>�Jugar de nuevo?</button></a>
	<% }else if(laRespuesta=="Demasiado chico" ){%>
	<h3>el n�mero es muy chico</h3>
	<% }else if(laRespuesta=="Demasiado grande" ){%>
	<h3>el n�mero es muy grande</h3>
	<%} %>
	
	

<form method="post" action="/GreatNumber/GranNumero">
 <input type="number" name="adivinar" ><br>
  <input   value="Ingresar" type="submit"></input>
</form> 

<% //<h4>el numero secreto es  <c:out value="${a}"/></h4>%>


</body>
</html>