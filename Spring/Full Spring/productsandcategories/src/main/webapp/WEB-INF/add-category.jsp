<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
</head>
<body>
	<h1>New Category</h1>
	<h3><a href="/">Home</a></h3>
	<hr />
	<form:form action="/categories/new" method="POST" modelAttribute="newCategory">
		<form:errors path="name"/>
		<form:label path="name">Name</form:label>
		<form:input path="name" type="text"/>
		<input type="submit" value="Add Category"/>
	</form:form>
</body>
</html>