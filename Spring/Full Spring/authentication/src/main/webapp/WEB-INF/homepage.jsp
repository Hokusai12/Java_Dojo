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
	<div class="container mt-5 d-flex flex-column">
		<div class="d-flex justify-content-between">		
			<h1>Welcome <c:out value="${user.userName}"/></h1>
			<a href="logout">Logout</a>
		</div>
		<div class="d-flex justify-content-between">
			<h3>Everyone's Books!</h3>
			<a href="/books/new">Add a book to my shelf</a>
		</div>
		<div class="col-6 d-flex align-self-center">
			<table class="table table-striped table-bordered border-primary align-self-center">
				<thead>
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${unborrowedBooks}">
						<tr>
							<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
							<td><c:out value="${book.author}"/></td>
							<td><c:out value="${book.poster.userName}"/></td>
							<td>
								<c:choose>
									<c:when test="${book.poster.id == user.id}">
										<a href="/books/${book.id}/edit">Edit</a>
										<form action="/books/${book.id}/delete" method="POST">
											<input type="hidden" name="_method" value="DELETE"/>
											<a href="/books/${book.id}/delete"><button>Delete</button></a>
										</form>
									</c:when>
									<c:otherwise>
										<a href="/books/${book.id}/borrow">Borrow</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>				
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-6 d-flex align-self-center">
			<table class="table table-striped table-bordered border-primary align-self-center">
				<thead>
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${borrowedBooks}">
						<tr>
							<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
							<td><c:out value="${book.author}"/></td>
							<td><c:out value="${book.poster.userName}"/></td>
							<td><a href="/books/${book.id}/return">Return</a></td>
						</tr>				
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>