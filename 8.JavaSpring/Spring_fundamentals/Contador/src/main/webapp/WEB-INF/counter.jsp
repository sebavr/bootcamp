<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contador de visitas</title>
<style>
.a{
background-image: linear-gradient(90deg, rgba(157, 186, 216, 1) 0%, rgba(255, 255, 255, 1) 96%);
color: #333333;
line-height: 1.2
letter-spacing: 0px
word-spacing: 0px
text-align: left
text-decoration: none
text-transform: none

}
</style>
</head>
<body>


<div class="a">Tu has visitado  http://localhost:8080/  <c:out value="${counter}"/> veces </div>
<div><a href="/">¿Testear otra visita?</a></div>
</body>
</html>