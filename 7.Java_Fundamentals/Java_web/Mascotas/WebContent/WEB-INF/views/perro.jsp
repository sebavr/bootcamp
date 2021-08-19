<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página del Perro</title>
</head>
<body>



<h1>Has creado un <c:out value="${perro.getRaza()}"/></h1>

<c:choose>
<c:when test="${perro.getpeso()>=30}"> 
<h2><c:out value="${perro.mostrarAfecto()}"/> Haz que <c:out value="${perro.getNombre()}"/> se acurruque a tu lado</h2>
</c:when>
<c:otherwise>
<h2><c:out value="${perro.mostrarAfecto()}"/> Haz que <c:out value="${perro.getNombre()}"/> salte a tu regazo</h2>
</c:otherwise>
</c:choose>
</body>
</html>