<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>Num Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td><c:out value="${book.id}"/></td>
					<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.language}"/></td>
					<td><c:out value="${book.numberOfPages}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>