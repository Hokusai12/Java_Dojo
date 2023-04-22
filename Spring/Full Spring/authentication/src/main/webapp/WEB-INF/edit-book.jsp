<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Book Club</title>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1>Update your Entry</h1>
			<a href="/books">Back to the shelves</a>
		</div>
		<form:form class="col-6 ms-5 mt-5 d-flex flex-column gap-2" action="/books/${book.id}/update" method="POST" modelAttribute="book">
			<input type="hidden" name="_method" value="PUT"/>
			<form:input type="hidden" path="poster" value="${book.poster.id}"/>
			<form:input type="hidden" path="borrower" value="${book.borrower.id}"/>
			<form:errors class="text-danger" path="title"/>
			<div class="d-flex justify-content-between">
				<form:label path="title">Title</form:label>
				<form:input class="w-75" path="title" type="text"/>
			</div>
			<form:errors class="text-danger" path="author"/>
			<div class="d-flex justify-content-between">
				<form:label path="author">Author</form:label>
				<form:input class="w-75" path="author" type="text"/>
			</div>
			<form:errors class="text-danger" path="thoughts"/>
			<div class="d-flex justify-content-between">
				<form:label path="thoughts">Thoughts</form:label>
				<form:textarea class="w-75" path="thoughts" cols="20" rows="3"></form:textarea>
			</div>
			<input class="btn bg-info col-4 align-self-end" type="submit" value="Update"/>
		</form:form>
		<form action="/books/${book.id}/delete" method="POST">
			<input type="hidden" name="_method" value="DELETE"/>
			<input type="submit" value="DELETE"/>
		</form>
	</div>
</body>
</html>