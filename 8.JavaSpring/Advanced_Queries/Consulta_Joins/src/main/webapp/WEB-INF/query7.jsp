<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table class="table">
    <thead>
       <th>Pais</th>
       <th>Ciudad</th>
       <th>Distrito</th>
       <th>Poblacion</th>
       
       
    </thead>
    <tbody>
        <c:forEach var="row" items="${lista7}">                
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
            <td>${row[3]}</td>
          
           
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>