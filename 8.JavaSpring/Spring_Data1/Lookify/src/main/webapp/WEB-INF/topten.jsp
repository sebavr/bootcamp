<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top10</title>
</head>
<body>
<h5 style="text-align: right;"><a href ="/dashboard">Dashboard</a></h5> 


	<table class="table table-bordered">
			<tbody>
				<c:forEach items="${top10}" var="song">
					<tr>
						<td><c:out value="${song.rate}" /></td>
						<td><a href="/songs/${song.id}"><c:out
									value="${song.name}" /></a></td>
						<td><c:out value="${song.artist}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>