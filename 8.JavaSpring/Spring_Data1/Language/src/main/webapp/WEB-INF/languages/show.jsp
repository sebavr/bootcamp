<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h5 style="text-align: right;"><a href ="/languages">Dashboard</a></h5>  
<h1><c:out value="${lista.name}"/></h1>
<p><c:out value="${lista.creator}"/></p>
<p><c:out value="${lista.version}"/></p>

<a href="/languages/edit/${lista.id}">Edit </a>
<form action="/languages/${lista.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>