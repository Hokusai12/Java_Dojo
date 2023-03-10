<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body class="bg-dark">
	<div class="container col-5 mt-4 d-flex flex-column">
		<h1 class="text-info">Here's your Omikuji!</h1>
		<div class="bg-info text-dark rounded border border-white border-2 col-6 align-self-center">
			<p class="fs-4">In <span><c:out value="${number}"/></span> years, you will live in <span><c:out value="${city}"/></span> with <span><c:out value="${person}"/></span> as your roomate, selling <span><c:out value="${hobby}"/></span> for a living. The next time you see a <span><c:out value="${livingThing}"/></span>, you will have good luck. Also, <span><c:out value="${note}"/></span></p>
		</div>
		<a href="/omikuji/" class="align-self-end text-warning">Go Back</a>
	</div>
</body>
</html>