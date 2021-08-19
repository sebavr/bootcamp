<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="/style.css">
	<title><c:out value="${event.name}"/></title>
</head>

<body>
	<div id="container">
		<h1><c:out value="${event.name}"/></h1>
		<h2><a class="fltright" href="/logout">Logout</a></h2>
		<div id="lftpnl">
			<h3>Edit Event</h3>
			<form:form method="post" action="/events/${id}/edit" modelAttribute="event">
				<input type="hidden" name="_method" value="put">
				<h4 class="avoid">
					<form:label path="name">Name:</form:label>
					<form:input cssClass="fields" type="text" path="name"/>
				</h4>
				<h4 class="avoid">
					<form:label path="date">Date:</form:label>
					<form:input cssClass="fields" type="date" path="date"/>
				</h4>
				<h4 class="avoid">
					<form:label path="location">Location:</form:label>
					<form:select cssClass="state" path="state">
						<c:forEach items="${states}" var="state">
							<form:option value="${state}"><c:out value="${state}"/></form:option>
						</c:forEach>
					</form:select>
					<form:input cssClass="smfields" type="text" path="location"/>
				</h4>
				<form:hidden path="user" value="${user.id}"/>
				<input class="btn" type="submit" value="Save"/>
			</form:form>
			<form:errors cssClass="red" path="event.*"/>
		</div>
		<div id="rghtpnl">
		</div>
	</div>
</body>
</html>