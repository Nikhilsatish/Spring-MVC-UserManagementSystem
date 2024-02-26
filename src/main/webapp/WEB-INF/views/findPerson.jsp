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
	<form:form action="displayPerson" method="get" modelAttribute="person">
		<form:label path="personId">Person Id: </form:label>
		<form:input path="personId" name="personId" type="number" />
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>