<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <%@include file="Header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    
    <th>Permanent Address</th>
    <th>Correspondence Address</th>
  </tr>
  

  <c:forEach var="employee" items="${employees}">
    <tr>
      <td>${employee.id}</td>
      <td>${employee.name}</td>
      <td>${employee.email}</td>
      
      <td>
        <c:forEach var="address" items="${employee.address}" varStatus="status">
          <c:if test="${address.addressType == 'permanentAddressType'}">
            <p>Address ${status.index + 1}:</p>
            <p>Address Line 1: ${address.line1}</p>
            <p>Address Line 2: ${address.line2}</p>
            <p>City: ${address.city}</p>
            <p>State: ${address.state}</p>
            <p>Country: ${address.country}</p>
            <p>Zipcode: ${address.zipcode}</p>
          </c:if>
        </c:forEach>
      </td>
      <td>
        <c:forEach var="address" items="${employee.address}" varStatus="status">
          <c:if test="${address.addressType == 'CorrespondenceAddressType'}">
            <p>Address ${status.index + 1}:</p>
            <p>Address Line 1: ${address.line1}</p>
            <p>Address Line 2: ${address.line2}</p>
            <p>City: ${address.city}</p>
            <p>State: ${address.state}</p>
            <p>Country: ${address.country}</p>
            <p>Zipcode: ${address.zipcode}</p>
          </c:if>
        </c:forEach>
      </td>
      <td><a href="http://localhost:8080/Employee/update?id=${employee.id}">update</a>
      </td>
      <td><a href="http://localhost:8080/Employee/delete?id=${employee.id}">delete</a>
      </td>
    </tr>
  </c:forEach>
</table>


</body>
</html>