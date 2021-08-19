<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clicker</title>
</head>
<body>

<form method="get" action="Counter">
 
  <input   value="Clikeame!" type="submit"></input>
</form> 

 <h1>Tú haz clickeado el botón </h1>
    <h1><c:out value="${counter}"/></h1>



</body>
</html>