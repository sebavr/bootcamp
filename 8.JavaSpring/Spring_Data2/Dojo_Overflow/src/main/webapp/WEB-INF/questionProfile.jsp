<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Profile!</title>
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
<h1>${question.question}</h1>

	<h4>Tags: 
				<c:forEach items="${question.tags}" var="t">
			      	<button class="btn btn-success">${t.subject}</button>
			    </c:forEach>
</h4>

<table class="table">
					  <thead class="thead-dark">
						    <tr>
						      <th scope="col">Answers</th>
						    </tr>
						  </thead>
						  <tbody>
						    <tr>
						      <c:forEach items="${question.answers }" var="a">
						      	<td class="text-info">  ${a.answer}</td>
						      </c:forEach>
						    
						    </tr>
						 </tbody>
					</table>
					
					
					<form:form action="/questions/${question.id}" method="POST" modelAttribute="sumar_answer">
					
						<form:errors path="answer" cssClass="alert alert-danger" element="p"/>
					
					
					<p>
						<form:label cssClass="font-weight-normal" path="answer">Add your Answer</form:label>
						<form:textarea cssClass="form-control" rows="3" path="answer"/>
					</p>
					
					<p class="text-right">
						<br>
						<button type="submit" class="btn btn-info">Add Answer</button>
					</p>
					
				</form:form>





</body>


   
</html>