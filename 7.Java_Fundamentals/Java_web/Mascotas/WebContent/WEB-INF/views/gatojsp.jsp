<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página del Gato</title>
</head>
<body>



<h1>Has creado un <c:out value="${gato.getRaza()}"/></h1>

<h3>Tu gato <c:out value="${gato.getRaza()}"/>, <c:out value="${gato.getNombre()}"/>, te mira con mucho afecto</h3>
</body>
</html>