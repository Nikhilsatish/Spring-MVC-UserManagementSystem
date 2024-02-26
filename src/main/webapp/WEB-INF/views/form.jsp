<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<base href="http://localhost:8080/com.nikhil.personmanagement/">
<meta charset="ISO-8859-1">
<title>Add Person</title>
<style>
.button{
  cursor: pointer;
}
</style>
</head>
<body>
<h3>${msg }</h3><br>

	<form:form class="form" action="savePerson" method="post" modelAttribute="person">
		<form:label path="personId">ID:</form:label>
		<form:input path="personId" type="number" name="personId" />
		<br >
		<form:label path="name">Name:</form:label>
		<form:input path="name" type="text" name="name" />
		<br />
		<form:label path="location">Location:</form:label>
		<form:input path="location" type="text" name="location" />
		<br />
		<form:label path="email">Email Address:</form:label>
		<form:input path="email" type="text" name="email" />
		<br />
		<form:label path="phNo">Phone Number:</form:label>
		<form:input path="phNo" type="number" name="phNo" />
		<br />
		<form:label path="gender">Gender:</form:label>
		<form:select path="gender">
			<form:option value="male">Male</form:option>
			<form:option value="female">Female</form:option>
			<form:option value="others">Others</form:option>
		</form:select>
		<br/><br/>
		<form:button class="button" type="submit">Submit</form:button>
	</form:form>
	<button><a href="">Back</a></button>
</body>
</html>