<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
 	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
<style>
#borde{
border: 14px solid rgba(28,110,164,0.53);
border-radius: 40px;
padding-left:30px;
}
</style>
</head>
<body>

<div class="container col-md-6" style="padding-right: 0px;padding-left: 0px;">
<div id="borde">
<table class="aa">
  <tr>
    <td>Nombre</td>
    <th><c:out value="${nombre}"/></th> 
   
  </tr>
  <tr>
    <td>Ubicación</td>
    <th><c:out value="${ubicacion}"/></th> 
 
  </tr>
  <tr>
    <td>Lenguaje Favorito</td>
    <th><c:out value="${lenguaje}"/></th> 
    
  </tr>
  <tr>
    <td>comentario</td>
    <th><c:out value="${comentario}"/></th> 
  </tr>
	</table>
	
	<button style="background-color: #900C3F; margin-top: 20px;text-align: center;" type="submit " class="btn btn-primary "><a href="/">Atrás</a></button>
</div>
</div>
</body>
</html>