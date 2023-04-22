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
	<h1>New Product</h1>
	<h3><a href="/">Home</a></h3>
	<hr />
	<form:form action="/products/new" method="POST" modelAttribute="newProduct">
		<form:errors path="name"/>
		<form:label path="name">Name</form:label>
		<form:input path="name" type="text"/>
		<form:errors path="description"/>
		<form:label path="description">Description</form:label>
		<form:input path="description" type="text"/>
		<form:errors path="price"/>
		<form:label path="price">Price</form:label>
		<form:input path="price" type="number" step="0.1"/>
		<input type="submit" value="Add Product"/>
	</form:form>
</body>
</html>