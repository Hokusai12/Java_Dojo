<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Omikuji</title>
</head>
<body class="bg-dark">
	<div class="container col-5 mt-4">
		<h1 class="text-info">Send an Omikuji!</h1>
		<form class="text-white bg-secondary rounded p-4 d-flex flex-column" action="/omikuji/process-form" method="POST">
			<div class="d-flex justify-content-between">
				<label for="num">Pick any number between 5 and 25</label>
				<input type="number" name="num" id="num"/>
			</div>
			<div class="d-flex justify-content-between">
				<label for="city">Enter the name of any city</label>
				<input type="text" name="city" id="city"/>
			</div>
			<div class="d-flex justify-content-between">
				<label for="person">Enter the name of any real person</label>
				<input type="text" name="person" id="person"/>
			</div>
			<div class="d-flex justify-content-between">
				<label for="hobby">Enter professional endeavor or hobby</label>
				<input type="text" name="hobby" id="hobby"/>
			</div>
			<div class="d-flex justify-content-between">
				<label for="living-thing">Enter any type of living thing</label>
				<input type="text" name="living-thing" id="living-thing"/>
			</div>
			<div class="d-flex justify-content-between">
				<label for="note">Say something nice to someone</label>
				<textarea name="note" id="note" cols="20" rows="3"></textarea>
			</div>
			<p class="text-info"><em>Send and show a friend</em></p>
			<input class="btn bg-warning col-3 align-self-end" type="submit" value="Send"/>
		</form>
	</div>
</body>
</html>