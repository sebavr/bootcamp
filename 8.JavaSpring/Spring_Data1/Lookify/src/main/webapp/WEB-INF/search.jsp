
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
<h5 style="text-align: right;"><a href ="/dashboard">Dashboard</a></h5> 
<h2 class="d-inline-block">Songs by artist: <c:out value="${search}"/></h2>

<div class="col-sm">
				<form:form action="/search" method="post" modelAttribute="songName" cssClass=" formBox d-inline-block float-right ">
					<form:input type="text" path="name" cssClass="form-control d-inline-block col-7"/>
					<input type="submit"  value="New Search" />
				</form:form>
				
			</div>

<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Rating</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${results}" var="song">
					<tr>
						<td><a href="/songs/${song.id}">
						<c:out value="${song.name}" /></a></td>
									
						<td><c:out value="${song.rate}" /></td>
						<td><a href="/delete/${song.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>