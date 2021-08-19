<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<h1>New Product</h1>
<p></p>

</body>

<form:form action="/products/new" method="post" modelAttribute="product">
    <p>
        <form:label path="name">Name :</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
       <p>
        <form:label path="description">Description :</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>
       <p>
        <form:label path="price">Price :</form:label>
        <form:errors path="price"/>
        <form:input path="price"/>
    </p>
  
  
    
    <input type="submit" value="Create"/>
</form:form>


   
</html>