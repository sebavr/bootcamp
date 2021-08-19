
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<title>People and Licenses</title>
</head>
<body>

<h5 style="text-align: left; display:inline;"><a href ="persons/new">New person</a></h5> 
<h5 style="display:inline;"><a href ="licenses/new">New license</a></h5>
	<h1>Information</h1>
	<table>
		<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>License #</th>
			<th>State</th>
			<th>Expiration Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="persons" items="${persons}">
			<tr>
				<td>${persons.firstName}</td>
				<td>${persons.lastName}</td>
				<td>${persons.license.number}</td>
				<td>${persons.license.state}</td>
				<td>${persons.license.expirationDate}</td>	
						
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>