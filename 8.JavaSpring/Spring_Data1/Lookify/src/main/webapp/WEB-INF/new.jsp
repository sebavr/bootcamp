<%@ page isErrorPage="true" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/dashboard" method="post" modelAttribute="nuevo">
    <p>
        <form:label path="name">Título</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="artist">Artista</form:label>
        <form:errors path="artist"/>
        <form:textarea path="artist"/>
    </p>
    <p>
        <form:label path="rate">Rating(1-10)</form:label>
        <form:errors path="rate"/>
        <form:input path="rate"/>
    </p>
    
    <input type="submit" value="Add Song"/>
</form:form>
</body>
</html>