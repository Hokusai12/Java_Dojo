<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Book Club</title>
</head>
<body>	
	<div class="container mt-3">
		<div>
			<h1>Welcome to Book Club!</h1>
			<h4>A place where friends can share thoughts on books.</h4>
		</div>
		<div class="d-flex mt-5">
			<div class="d-flex flex-column col-6">
				<h3>Register New User</h3>
				<form:form action="/register" method="POST" modelAttribute="newUser" class="d-flex flex-column col-8 gap-2">
					<form:errors class="text-danger" path="userName"/>
					<div class="d-flex justify-content-between">
						<form:label path="userName">User Name</form:label>
						<form:input path="userName" type="text"/>
					</div>
					<form:errors class="text-danger" path="email"/>
					<div class="d-flex justify-content-between">
						<form:label path="email">Email</form:label>
						<form:input path="email" type="email"/>
					</div>
					<form:errors class="text-danger" path="password"/>
					<div class="d-flex justify-content-between">				
						<form:label path="password">Password</form:label>
						<form:input path="password" type="password"/>
					</div>
					<form:errors class="text-danger" path="confirm"/>
					<div class="d-flex justify-content-between">				
						<form:label path="confirm">Confirm Password</form:label>
						<form:input path="confirm" type="password"/>
					</div>
	
					<input class="btn bg-info col-3 align-self-end" type="submit" value="Register"/>
				</form:form>
			</div>
			<div class="d-flex flex-column col-6">
				<h3>Login User</h3>
				<form:form action="/login" method="POST" modelAttribute="newLogin" class="d-flex flex-column col-8 gap-2">
					<form:errors class="text-danger" path="email"/>
					<div class="d-flex justify-content-between">
						<form:label path="email">Email</form:label>
						<form:input path="email" type="email"/>
					</div>
					<div class="d-flex justify-content-between">
						<form:label path="password">Password</form:label>
						<form:input path="password" type="password"/>
					</div>
					<input class="btn bg-info col-3 align-self-end" type="submit" value="Login"/>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>