<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h1>Welcome, <c:out value="${user.userName}"/></h1>
			<a href="/logout">Logout</a>
		</div>
		<hr/>
		<div class="col-8 m-auto">
			<h3>TV Shows</h3>
			<table class="table table-striped text-center">
				<thead>
					<tr>
						<th>Show</th>
						<th>Network</th>
						<th>Average Rating</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="show" items="${showList}">
						<tr>
							<td><a href="/shows/${show.id}">${show.title}</a></td>
							<td>${show.network}</td>
							<td><c:out value="${String.format('%.1f', show.avgRating)}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a class="btn bg-info border-rounded" href="/shows/new">Add a show</a>
		</div>
	</div>
</body>
</html>