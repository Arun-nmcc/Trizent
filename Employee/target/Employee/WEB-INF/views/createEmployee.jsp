<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form  action="/create">
		<form:label path="name">Name:</form:label>
		<form:input path="name" />
		<br>
		<form:label path="email">Email:</form:label>
		<form:input path="email" />
		<br>
		<form:label path="phone">Phone:</form:label>
		<form:input path="phone" />
		<br>
		<h2>Permanent Address</h2>
		<form:label path="permanentAddress.addressType">Address Type:</form:label>
		<form:input path="permanentAddress.addressType" />
		<br>
		<form:label path="permanentAddress.line1">Address Line 1:</form:label>
		<form:input path="permanentAddress.line1" />
		<br>
		<form:label path="permanentAddress.line2">Address Line 2:</form:label>
		<form:input path="permanentAddress.line2" />
		<br>
		<form:label path="permanentAddress.city">City:</form:label>
		<form:input path="permanentAddress.city" />
		<br>
		<form:label path="permanentAddress.state">State:</form:label>
		<form:input path="permanentAddress.state" />
		<br>
		<form:label path="permanentAddress.country">Country:</form:label>
		<form:input path="permanentAddress.country" />
		<br>
		<form:label path="permanentAddress.zipcode">Zipcode:</form:label>
		<form:input path="permanentAddress.zipcode" />
		<br>
		<h2>Correspondence Address</h2>
		<form:label path="correspondenceAddress.addressType">Address Type:</form:label>
		<form:input path="correspondenceAddress.addressType" />
		<br>
		<form:label path="correspondenceAddress.line1">Address Line 1:</form:label>
		<form:input path="correspondenceAddress.line1" />
		<br>
		<form:label path="correspondenceAddress.line2">Address Line 2:</form:label>
		<form:input path="correspondenceAddress.line2" />
		<br>
		<form:label path="correspondenceAddress.city">City:</form:label>
		<form:input path="correspondenceAddress.city" />
		<br>
		<form:label path="correspondenceAddress.state">State:</form:label>
		<form:input path="correspondenceAddress.state" />
		<br>
		<form:label path="correspondenceAddress.country">Country:</form:label>
		<form:input path="correspondenceAddress.country" />
		<br>
		<form:label path="correspondenceAddress.zipcode">Zipcode:</form:label>
		<form:input path="correspondenceAddress.zipcode" />
		<br>
		<form:button type="submit">Submit</form:button>
	</form:form>


</body>
</html>