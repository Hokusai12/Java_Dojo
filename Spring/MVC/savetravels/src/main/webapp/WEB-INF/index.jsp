<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Save Travels</title>
</head>
<body>
	<div class="container d-flex mt-5">
		<div class="container col-6 d-flex flex-column align-items-center">
			<h1>Save Travels</h1>
			<table class="table table-bordered">
				<thead class="text-center">
					<tr>
						<th>Expense</th>
						<th>Vendor</th>
						<th>Amount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${expenses}" var="expense">
						<tr>
							<td><a href="/expenses/${expense.id}">${expense.name}</a></td>
							<td><c:out value="${expense.vendorName}"></c:out></td>
							<td><fmt:formatNumber value="${expense.amount}" type="currency"/></td>
							<td class="d-flex align-items-center">
								<a class="btn link-primary" href="/expenses/edit/${expense.id}">Edit</a>|
								<form class="d-inline" action="/expenses/delete/${expense.id}" method="POST">
									<input type="hidden" name="_method" value="DELETE"/>
									<input class="bg-transparent text-danger btn" type="submit" value="Delete"/>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container d-flex flex-column align-items-center align-self-center">
			<h2>Add an Expense</h2>
			<form:form class="col-8 d-flex flex-column gap-2" action="/expenses/" method="POST" modelAttribute="expense">
				<div class="d-flex justify-content-between">
					<form:label path="name">Expense Name</form:label>
					<form:input type="text" path="name" />
				</div>
				<form:errors class="text-danger" path="name"/>
				<div class="d-flex justify-content-between">
					<form:label path="vendorName">Vendor Name</form:label>
					<form:input type="text" path="vendorName" />
				</div>
				<form:errors class="text-danger" path="vendorName"/>
				<div class="d-flex justify-content-between">
					<form:label path="amount">Amount</form:label> 
					<form:input type="number" path="amount" step="0.01" />
				</div>
				<form:errors class="text-danger" path="amount"/>
				<div class="d-flex justify-content-between">
					<form:label path="description">Description</form:label>
					<form:textarea path="description" id="description" cols="20" rows="3"></form:textarea>
				</div>
				<form:errors class="text-danger" path="description"/>
				<input class="btn bg-info col-3 align-self-end" type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>