<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"  %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>¡Crea una mascota!</title>
</head>
<body>
<h1>Crea un Perro</h1>
<form method="post" action="Perros">
  <label >Nombre: </label><input type="text" name="name" value="cachupin"  ><br><br>
  <label >Raza: </label><input type="text" name="breed" value="pastor belga"><br><br>
  <label >Peso(lb): </label><input type="number" name="weight" value="30" ><br><br>
  <input type="submit" value="Crea un perro">
</form> 


<h1>Crea un Gato</h1>
<form method="post" action="Gatos">
  <label >Nombre: </label><input type="text" name="name"  value="cucho"><br><br>
  <label >Raza: </label><input type="text" name="breed" value="siames"><br><br>
  <label >Edad: </label><input type="text" name="weight"  value="3"><br><br>
  <input type="submit" value="Crea un gato">
</form> 

</body>
</html>