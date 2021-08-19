
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
<h1>What is your Question?</h1>
<c:out value="${error}" escapeXml="false"/>
<form:form action="/questions/new" method="post" modelAttribute="sumar_question" >
				<form:label  path="question">Question</form:label>
        		<form:textarea row="4" path="question"/>
        		
        		<label >Tags</label>
				<input type="text" name="tagcito">
        		<button  type="submit"  style="color: orange; background:purple; border: solid 2px orange;">Submit</button>
        	</form:form>




   

</body>
</html>