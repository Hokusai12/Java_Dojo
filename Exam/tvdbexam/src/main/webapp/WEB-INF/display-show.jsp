<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>TVDB</title>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1><c:out value="${show.title}"/></h1>
			<a href="/shows">Back to Homepage</a>
		</div>
		
		<hr />
		
		<div class="col-8 m-auto">
			<h3>Posted By: <span class="text-info"><c:out value="${show.poster.userName}"/></span></h3>
			<h3>Network: <span class="text-info"><c:out value="${show.network}"/></span></h3>
			<h3>Description: <span class="text-info"><c:out value="${show.description}"/></span></h3>
		</div>
		
		<hr />
		

		<c:if test="${show.poster.id == userId}">
			<div class="d-flex justify-content-end">
				<a class="btn bg-warning col-2" href="/shows/${show.id}/edit">Edit</a>
			</div>
		</c:if>

		
		<div class="col-6">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>User</th>
						<th>Rating</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneRating" items="${show.ratings}">
						<tr>
							<td>${oneRating.user.userName}</td>
							<td>${oneRating.rating}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<form:form class="d-flex flex-column" action="/ratings/new" method="POST" modelAttribute="newRating">
				<form:input type="hidden" path="user" value="${userId}"/>
				<form:input type="hidden" path="show" value="${show.id}"/>
				<div>
					<form:errors class="text-danger" path="user"/>
					<form:errors class="text-danger" path="show"/>
					<form:errors class="text-danger" path="rating"/>
				</div>
				<div>
					<form:label path="rating">Leave a rating</form:label>
					<form:input path="rating" type="number" step="0.1"/>
					<input type="submit" value="Rate"/>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>