<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<title>Save Travels</title>
</head>
<body>
	<div class="container d-flex flex-column col-8 mt-5">
		<div class="d-flex justify-content-between">
			<h1>Edit Expense</h1>
			<a href="/expenses/">Go Back</a>
		</div>
		<form:form class="d-flex flex-column gap-2 ms-5 col-5" action="/expenses/update/${expense.id}" method="POST" modelAttribute="expense">
			<input type="hidden" name="_method" value="PUT"/>
			<div class="d-flex justify-content-between">
				<form:label path="name">Expense</form:label>
				<form:input type="text" path="name"/>
			</div>
			<form:errors class="text-danger" path="name"/>
			<div class="d-flex justify-content-between">
				<form:label path="vendorName">Vendor Name</form:label>
				<form:input path="vendorName" type="text"/>
			</div>
			<form:errors class="text-danger" path="vendorName"/>
			<div class="d-flex justify-content-between">
				<form:label path="amount">Amount</form:label>
				<form:input path="amount" type="number" step="0.01"/>
			</div>
			<form:errors class="text-danger" path="amount"/>
			<div class="d-flex justify-content-between">
				<form:label path="description">Description</form:label>
				<form:textarea path="description" id="description" cols="20" rows="2"></form:textarea>
			</div>
			<form:errors class="text-danger" path="description"/>
			<input class="btn bg-info col-4 align-self-end" type="submit" value="Update"/>
		</form:form>
	</div>
</body>
</html>