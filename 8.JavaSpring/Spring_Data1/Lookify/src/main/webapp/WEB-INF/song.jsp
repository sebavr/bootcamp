<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h5 style="text-align: right;"><a href ="/dashboard">Dashboard</a></h5>  
<p>Title: <c:out value="${song.name}"/></p>
<p>Artist: <c:out value="${song.artist}"/></p>
<p>Rating(1-10)<c:out value="${song.rate}"/></p>


<form action="/songs/${song.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>