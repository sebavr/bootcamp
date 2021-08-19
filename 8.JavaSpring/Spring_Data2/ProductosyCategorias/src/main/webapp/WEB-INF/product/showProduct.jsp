<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page!</title>
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
<h1><c:out value="${product.name}"/></h1>
<h2>Categories:</h2>

<c:forEach items="${product.categories}" var="category">
				<h3>-<c:out value="${category.name}"/></h3>
			</c:forEach>


</body>
<form:form action="/products/${product.id}" method="POST" modelAttribute="productCategory">
   
        <form:label path="category">Add Category : </form:label>
        <form:select  path="category">
				<c:forEach items="${categories}" var="category" >
					<form:option value="${category.id}"><c:out value="${category.name}"/> </form:option>
				</c:forEach>
			</form:select>
    <button type="submit">ADD</button>
</form:form>

   
</html>