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
                <input type="text" name="address[0].line1" value="${employee.address[0].line1}" placeholder="line1" /><br>
                <input type="text" name="address[0].line2" value="${employee.address[0].line2}" placeholder="line2" /><br>
                <input type="text" name="address[0].city" value="${ employee.address[0].city}" placeholder="city" /><br>
                <input type="text" name="address[0].state" value="${ employee.address[0].state}"  placeholder="state"/><br>
                <input type="text" name="address[0].country" value="${ employee.address[0].country}" placeholder="country" /><br>
                <input type="text" name="address[0].zipcode" value="${ employee.address[0].zipcode}"  placeholder="zipcode"/><br>
                
                
                
                
                <!-- another address -->
                <br><br>
                <input type="text" name="address[1].line1" value="${ employee.address[1].line1}" placeholder="line1" /><br>
                <input type="text" name="address[1].line2" value="${ employee.address[1].line2}" placeholder="line2" /><br>
                <input type="text" name="address[1].city" value="${ employee.address[1].city}" placeholder="city" /><br>
                <input type="text" name="address[1].state" value="${ employee.address[1].state}"  placeholder="state"/><br>
                <input type="text" name="address[1].country" value="${ employee.address[1].country}"  placeholder="country"/><br>
                <input type="text" name="address[1].zipcode" value="${ employee.address[1].zipcode}"  placeholder="zipcode"/><br>
<input type="hidden" name ="empid" value="${employee.address[0].employeeId}">
				<input type="hidden" name ="id2" value="${employee.address[1].id}">
		<input type="hidden" name ="id1" value="${employee.address[0].id}">
								
				
<input type="submit">
</form>


</body>
</html>