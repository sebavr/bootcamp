
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Dashboard!</title>
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
<h1>Question Dashboard</h1>

<table class="GeneratedTable">
    <thead>
        <tr>
            <th>Question</th>
            <th>Tags</th>
          
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${questions}" var="quest">
    	<tr>
    	<td><a  href="questions/${quest.id}">${quest.question}</a></td>
    	<td>
    	<c:forEach items="${quest.tags}" var="t">
    	<button class="btn btn-success">${t.subject}</button>
    	</c:forEach>
    	</td>
    	</tr>
    	</c:forEach>
   
    </tbody>
</table>


<p><a href="/questions/new">New Question</a></p>




</body>


   
</html>