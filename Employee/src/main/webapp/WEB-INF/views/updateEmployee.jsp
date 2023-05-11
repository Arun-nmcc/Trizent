<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@include file="Header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateEmployee" method="post">
	<c:forEach var="address" items="${address}">
	<c:if test="${address.addressType == 'permanentAddressType'}">
		<h3> ${address.addressType}</h3>
		<label for="permanentAddressLine1">Address Line 1:</label>
		<input type="text" name="permanentAddressLine1" value="${address.line1}"><br>
		<label for="permanentAddressLine2">Address Line 2:</label>
		<input type="text" name="permanentAddressLine2" value="${address.line2}"><br>
		<label for="permanentCity">City:</label>
		<input type="text" name="permanentCity" value="${address.city}"><br>
		<label for="permanentState">State:</label>
		<input type="text" name="permanentState" value="${address.state}"><br>
		<label for="permanentCountry">Country:</label>
		<input type="text" name="permanentCountry" value="${address.country}"><br>
		<label for="permanentZipcode">Zipcode:</label>
		<input type="text" name="permanentZipcode" value="${address.zipcode}"><br>
						<input type="hidden" name ="id1" value="${address.id}">
		
	</c:if>
</c:forEach>
<c:forEach var="address" items="${address}">
	<c:if test="${address.addressType == 'CorrespondenceAddressType'}">
		<h3> ${address.addressType}</h3>
		<label for="correspondenceAddressLine1">Address Line 1:</label>
		<input type="text" name="correspondenceAddressLine1" value="${address.line1}"><br>
		<label for="correspondenceAddressLine2">Address Line 2:</label>
		<input type="text" name="correspondenceAddressLine2" value="${address.line2}"><br>
		<label for="correspondenceCity">City:</label>
		<input type="text" name="correspondenceCity" value="${address.city}"><br>
		<label for="correspondenceState">State:</label>
		<input type="text" name="correspondenceState" value="${address.state}"><br>
		<label for="correspondenceCountry">Country:</label>
		<input type="text" name="correspondenceCountry" value="${address.country}"><br>
		<label for="correspondenceZipcode">Zipcode:</label>
		<input type="text" name="correspondenceZipcode" value="${address.zipcode}"><br>
		<input type="hidden" name ="empid" value="${address.employeeId}">
				<input type="hidden" name ="id2" value="${address.id}">
		
	</c:if>
</c:forEach>
<input type="submit">
</form>


</body>
</html>