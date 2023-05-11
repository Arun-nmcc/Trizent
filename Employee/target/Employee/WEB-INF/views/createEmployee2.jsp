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

<form method="POST" action="/create">
    <label for="name">Name:</label>
    <input type="text" name="name"><br>
    <label for="email">Email:</label>
    <input type="text" name="email"><br>
    <label for="phone">Phone:</label>
    <input type="text" name="phone"><br>
    <h2>Permanent Address</h2>
    <label for="permanentAddressType">Address Type:</label>
    <input type="text" name="permanentAddressType"><br>
    <label for="permanentAddressLine1">Address Line 1:</label>
    <input type="text" name="permanentAddressLine1"><br>
    <label for="permanentAddressLine2">Address Line 2:</label>
    <input type="text" name="permanentAddressLine2"><br>
    <label for="permanentCity">City:</label>
    <input type="text" name="permanentCity"><br>
    <label for="permanentState">State:</label>
    <input type="text" name="permanentState"><br>
    <label for="permanentCountry">Country:</label>
    <input type="text" name="permanentCountry"><br>
    <label for="permanentZipcode">Zipcode:</label>
    <input type="text" name="permanentZipcode"><br>
    <h2>Correspondence Address</h2>
    <label for="correspondenceAddressType">Address Type:</label>
    <input type="text" name="correspondenceAddressType"><br>
    <label for="correspondenceAddressLine1">Address Line 1:</label>
    <input type="text" name="correspondenceAddressLine1"><br>
    <label for="correspondenceAddressLine2">Address Line 2:</label>
    <input type="text" name="correspondenceAddressLine2"><br>
    <label for="correspondenceCity">City:</label>
    <input type="text" name="correspondenceCity"><br>
    <label for="correspondenceState">State:</label>
    <input type="text" name="correspondenceState"><br>
    <label for="correspondenceCountry">Country:</label>
    <input type="text" name="correspondenceCountry"><br>
    <label for="correspondenceZipcode">Zipcode:</label>
    <input type="text" name="correspondenceZipcode"><br>
    <input type="submit" value="Submit">
</form> 
</body>
</html>