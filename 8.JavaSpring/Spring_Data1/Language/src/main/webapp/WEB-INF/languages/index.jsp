
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<style>
<!-- CSS Code: Place this code in the document's head (between the 'head' tags) -->
<style>
table.GeneratedTable {
  width: 100%;
  background-color: #fafafa;
  border-collapse: collapse;
  border-width: 2px;
  border-color: #000000;
  border-style: solid;
  color: #000000;
}

table.GeneratedTable td, table.GeneratedTable th {
  border-width: 2px;
  border-color: #000000;
  border-style: solid;
  padding: 3px;
}

table.GeneratedTable thead {
  background-color: #e1d6ad;
}
</style>


 



</head>
<body>
<table class="GeneratedTable">
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Creador</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
   
        <c:forEach items="${lista}" var="languages">
        <tr>
            <td><a href ="/languages/<c:out value="${languages.id}"/>"><c:out value="${languages.name}"/></a></td>
            <td><c:out value="${languages.creator}"/></td>
            <td><c:out value="${languages.version}"/></td>
            <td><a href = "/languages/edit/<c:out value="${languages.id}"/>">Details</a>
				<form action="/languages/<c:out value="${languages.id}"/>" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
			
				
				</td>
           
           
        </tr>
       
        </c:forEach>
    </tbody>
</table>

<form:form action="/languages" method="post" modelAttribute="lang_nuevo">
    <p>
        <form:label path="name">Nombre</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creador</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>
    
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>