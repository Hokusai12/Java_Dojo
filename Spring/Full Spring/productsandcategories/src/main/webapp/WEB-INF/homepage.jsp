<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
</head>
<body>
	<h1>Homepage</h1>
	<h3><a href="/products/new">New Product</a></h3>
	<h3><a href="/categories/new">New Category</a></h3>
	<hr />
	<table>
		<thead>
			<tr>
				<th>Products</th>
				<th>Categories</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<ul>
						<c:forEach items="${productList}" var="product">
							<li><a href="/products/${product.id}"><c:out value="${product.name}"/></a></li>
						</c:forEach>
					</ul>
				</td>
				<td>
					<ul>
						<c:forEach items="${categoryList}" var="category">
							<li><a href="categories/${category.id}"><c:out value="${category.name}"/></a></li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>