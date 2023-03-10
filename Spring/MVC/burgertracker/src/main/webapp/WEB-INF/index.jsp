<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<title>Burgerator</title>
</head>
<body>
	<div class="container mt-4 d-flex justify-content-around">
		<div class="container col-6">
			<h1>Burger Tracker</h1>
			<table class="table border">
				<thead>
					<tr>
						<th>Burger Name</th>
						<th>Restaurant</th>
						<th>Rating</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${burgers}" var="burger">
						<tr>
							<td>${burger.name}</td>
							<td>${burger.restaurant}</td>
							<td>${burger.rating}</td>
							<td><a href="/burgers/edit/${burger.id}">Edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container d-flex flex-column align-items-center justify-content-center">
			<h3>Add a burger</h3>
			<form:form class="d-flex flex-column gap-2 col-7 " action="/burgers/"
				method="POST" modelAttribute="burger">
				<div class="d-flex justify-content-between">
					<form:label path="name">Burger Name</form:label>
					<form:input type="text" path="name" />
				</div>
				<form:errors class="text-danger" path="name" />
				<div class="d-flex justify-content-between">
					<form:label path="restaurant">Restaurant Name</form:label>
					<form:input type="text" path="restaurant" />
				</div>
				<form:errors class="text-danger" path="restaurant" />
				<div class="d-flex justify-content-between">
					<form:label path="rating">Rating</form:label>
					<form:input type="number" path="rating" step="0.1" />
				</div>
				<form:errors class="text-danger" path="rating" />
				<div class="d-flex justify-content-between">
					<form:label path="notes">Notes</form:label>
					<form:textarea path="notes" id="notes" cols="20" rows="3"></form:textarea>
				</div>
				<form:errors class="text-danger" path="notes" />
				<input
					class="col-3 btn bg-info text-white align-self-end"
					type="submit" value="Submit" />
			</form:form>
		</div>
	</div>
</body>
</html>