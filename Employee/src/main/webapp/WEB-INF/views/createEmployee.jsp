<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="create">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${employee.name}" />
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="${employee.email}" />
                <c:if test="${not empty errorMessage}">
    ${errorMessage}<br>
</c:if><br>
<c:forEach items="${errors}" var="error">
${error.defaultMessage}<br>
</c:forEach>            
        </td>
        </tr>
        
        <tr>
            <td><br><br>Permanent Address:</td>
            <td><br><br>
                <input type="text" name="address[0].type" value="Permanent" readonly="true" /><br>
                <input type="text" name="address[0].line1" value="${employee.address[0].line1}" placeholder="line1" /><br>
                <input type="text" name="address[0].line2" value="${employee.address[0].line2}" placeholder="line2" /><br>
                <input type="text" name="address[0].city" value="${employee.address[0].city}" placeholder="city" /><br>
                <input type="text" name="address[0].state" value="${employee.address[0].state}"  placeholder="state"/><br>
                <input type="text" name="address[0].country" value="${employee.address[0].country}" placeholder="country" /><br>
                <input type="text" name="address[0].zipcode" value="${employee.address[0].zipcode}"  placeholder="zipcode"/><br>
            </td>
        </tr>
        <tr>
            <td><br><br>Correspondence Address:</td>
            <td><br><br>
                <input type="text" name="address[1].type" value="Correspondence" readonly="true" /><br>
                <input type="text" name="address[1].line1" value="${employee.address[1].line1}" placeholder="line1" /><br>
                <input type="text" name="address[1].line2" value="${employee.address[1].line2}" placeholder="line2" /><br>
                <input type="text" name="address[1].city" value="${employee.address[1].city}" placeholder="city" /><br>
                <input type="text" name="address[1].state" value="${employee.address[1].state}"  placeholder="state"/><br>
                <input type="text" name="address[1].country" value="${employee.address[1].country}"  placeholder="country"/><br>
                <input type="text" name="address[1].zipcode" value="${employee.address[1].zipcode}"  placeholder="zipcode"/><br>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>



</body>
</html>