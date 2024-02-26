<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="http://localhost:8080/com.nikhil.personmanagement/">
<meta charset="UTF-8">
<title>User Table</title>
</head>
<body>
	<c:if test="${not empty message}">
		<div>${message}</div>
	</c:if>
	<h2>User Table</h2>

	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Phone number</th>
				<th>Gender</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.phNo}</td>
					<td>${user.gender}</td>
					<td><a
						href="<c:url value='getPerson?personId=${user.personId}'/>">update</a></td>
					<td><a
						href="<c:url value='deletingperson?personId=${user.personId}'/>">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<button>
		<a href="">Back</a>
	</button>
</body>
</html>
