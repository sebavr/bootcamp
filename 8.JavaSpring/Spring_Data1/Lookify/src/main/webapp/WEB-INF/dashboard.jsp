
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify!</title>
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
<form:form action="/search" method="post" modelAttribute="songName" cssClass=" formBox d-inline-block float-right ">
        		<form:input type="text" path="name" cssClass="form-control d-inline-block col-7"/>
        		<button class="btn btn-outline-dark " type="submit"  style="color: orange; background:purple; border: solid 2px orange;">Search Artist</button>
        	</form:form>

<h5 style="text-align: left; display:inline;"><a href ="/new">Add new</a></h5> 
<h5 style="display:inline;"><a href ="/search/topTen">Top Songs</a></h5>

<table class="GeneratedTable">
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
   
        <c:forEach items="${songs}" var="songs">
        <tr>
            <td><a href ="/songs/<c:out value="${songs.id}"/>"><c:out value="${songs.name}"/></a></td>
            <td><c:out value="${songs.rate}"/></td>
            
            <td><form action="/songs/<c:out value="${songs.id}"/>" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
			
				
				</td>
           
           
        </tr>
       
        </c:forEach>
    </tbody>
</table>
</body>


   
</html>