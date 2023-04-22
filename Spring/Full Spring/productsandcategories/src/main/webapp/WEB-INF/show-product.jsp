<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
</head>
<body>
	<h1><c:out value="${product.name}"/></h1>
	<h3><a href="/">Home</a></h3>
	<hr />
	<h3>Categories</h3>
	<ul>
		<c:forEach items="${product.categories}" var="category">
			<li><c:out value="${category.name}"/></li>
		</c:forEach>
	</ul>
	<hr />
	<c:if test="${categoryList.size() != 0}">
		<form action="/products/add-category" method="POST">
			<input type="hidden" name="product-id" value="${product.id}"/>
			<label for="categories">Add Category</label>
			<select name="categories">
				<c:forEach items="${categoryList}" var="category">
					<option value="${category.id}"><c:out value="${category.name}"/></option>
				</c:forEach>
			</select>
			<input type="submit" value="Add Category"/>
		</form>
	</c:if>
</body>
</html>