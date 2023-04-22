<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>TVDB</title>
</head>
<body>
	<div class="container mt-5 d-flex flex-column">
		<h1>Add a new show</h1>
		<div class="d-flex flex-column col-4 gap-2">
			<form:form class="d-flex flex-column gap-2" action="/shows/new" method="POST" modelAttribute="newShow">
				<form:input type="hidden" path="poster" value="${userId}"/>
				<div class="d-flex justify-content-between">
					<form:label path="title">Title</form:label>
					<form:input type="text" path="title"/>
				</div>
				<form:errors class="text-danger" path="title"/>
				<div class="d-flex justify-content-between">
					<form:label path="description">Description</form:label>
					<form:input type="text" path="description"/>
				</div>
				<form:errors class="text-danger" path="description"/>
				<div class="d-flex justify-content-between">
					<form:label path="network">Network</form:label>
					<form:input type="text" path="network"/>
				</div>
				<form:errors class="text-danger" path="network"/>
				<input class="btn bg-info col-3 align-self-end" type="submit" value="Add show"/>
			</form:form>
			<a class="btn bg-info align-self-end col-3" href="/shows">Cancel</a>
		</div>
	</div>
</body>
</html>