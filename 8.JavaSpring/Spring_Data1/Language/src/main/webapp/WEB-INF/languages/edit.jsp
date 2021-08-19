<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<h1>Edit Language</h1>
<h5 style="text-align: right;"><a href ="/languages">Dashboard</a></h5> 
<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Nombre :</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creador :</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="version">Version :</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>
     
    <input type="submit" value="Submit"/>
</form:form>

<form action="/languages/<c:out value="${language.id}"/>" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>