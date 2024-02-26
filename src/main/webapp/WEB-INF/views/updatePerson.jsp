<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Person</title>
</head>
<body>
	<form action="getPerson">
		Enter the Id : <input type="number" name="personId" placeholder="Enter the Id ">
		<button type="submit">Submit</button>
	</form>
</body>
</html>