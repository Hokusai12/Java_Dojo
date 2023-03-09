<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Form</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/create" method="POST" modelAttribute="ninja">
		<form:label path="dojo">Dojo</form:label>
		<form:errors path="dojo"/>
		<form:select path="dojo">
			<c:forEach items="${dojos}" var="oneDojo">
				<form:option value="${oneDojo.id}"><c:out value="${oneDojo.name}"/></form:option>
			</c:forEach>
		</form:select>
		<form:label path="firstName">First Name</form:label>
		<form:input path="firstName" type="text" />
		<form:errors path="firstName"/>
		<form:label path="lastName">Last Name</form:label>
		<form:input path="lastName" type="text" />
		<form:errors path="lastName"/>
		<form:label path="age">Age</form:label>
		<form:input path="age" type="number"/>
		<form:errors path="age"/>
		<input type="submit" value="Create"/>
	</form:form>
</body>
</html>