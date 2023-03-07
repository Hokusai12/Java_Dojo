<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<div class="container d-flex flex-column align-items-center mt-5 col-8">
		<div class="d-flex justify-content-between col-12">
			<h1>Expense Details</h1>
			<a href="/expenses/">Go Back</a>
		</div>
		<div class="align-self-start ms-5 mt-5 col-8 d-flex justify-content-evenly">
			<div class="d-flex flex-column gap-3">
				<h5>Expense Name: </h5>
				<h5>Expense Amount: </h5>
				<h5>Vendor: </h5>
				<h5>Description: </h5>
			</div>
			<div class="d-flex flex-column gap-3">
				<h5>${expense.name}</h5>
				<h5><fmt:formatNumber type="currency" value="${expense.amount}"/></h5>
				<h5>${expense.vendorName}</h5>
				<h5>${expense.description}</h5>
			</div>
		</div>
	</div>
</body>
</html>