<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido</title>
<style>
.menu-bar {
  background-color: #1988f7;
  display: flex;
  justify-content: flex-start;
  box-sizing: border-box;
}

.item {
  color: white;
  background-color: transparent;
  font-size: 18px;
  display: inline-block;
  box-sizing: border-box;
  padding: 14px 20px;
}

.item.title {
  font-weight: 600;
}

.item:hover {
  background-color: rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>

<h3>¡¡¡Bienvenido otra vez!!!</h3>
<nav class="menu-bar">
<h3 class="item"><a href="/counter">Volver al contador<a></a></h3>


<h3 class="item"><a href="/counter2">Volver al contadorx2<a></a></h3>


<h3 class="item"><a href="/reset">Volver a 0 el contador<a></a></h3>
</nav>
</body>
</html>