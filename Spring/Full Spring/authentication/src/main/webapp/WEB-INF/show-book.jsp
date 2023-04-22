<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Book Club</title>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between mb-3 align-items-center">
			<h1><c:out value="${book.title}"/></h1>
			<a href="/books">Back to the shelves</a>
		</div>
		<h3>
			<span class="text-primary">
				<c:choose>
					<c:when test="${book.user.id == userId}">
						You
					</c:when>
					<c:otherwise>
						<c:out value="${book.user.userName}"/>
					</c:otherwise>
				</c:choose>
			</span>
			read <span class="text-warning"><c:out value="${book.title}"/></span> by <span class="text-warning"><c:out value="${book.author}"/></span>
		</h3>
		<div class="d-flex flex-column">
			<h4 class="mt-5">
				<c:choose>
					<c:when test="${book.user.id == userId}">
						Your
					</c:when>
					<c:otherwise>
						<c:out value="${book.user.userName}'s"/>
					</c:otherwise>
				</c:choose>
				thoughts
			</h4>
			<hr />
			<q class="text-info text-center"><c:out value="${book.thoughts}"/></q>
			<hr />
		</div>
		<c:if test="${book.user.id == userId}">
			<div class="d-flex justify-content-end gap-2">
				<a class="btn bg-warning col-1" href="/books/${book.id}/edit">Edit</a>
				<form class="col-3" action="/books/${book.id}/delete" method="POST">
					<input type="hidden" name="_method" value="DELETE"/>
					<button class="btn bg-danger col-4">Delete</button>
				</form>
			</div>
		</c:if>
	</div>
</body>
</html>