<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
	<h1>Make a New Dojo</h1>
	<form:form action="/dojos/create" method="POST" modelAttribute="dojo">
		<form:label path="name">Name: </form:label>
		<form:input type="text" path="name"/>
		<form:errors path="name"/>
		<input type="submit" value="Create"/>
	</form:form>
</body>
</html>