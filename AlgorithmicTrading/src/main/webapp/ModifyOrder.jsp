<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.newproject.test.model.Order"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%  
   Order order = (Order)request.getAttribute("order");
   int orderid =order.getOrder_id();
    String companyid =order.getCompany_Id();
   
%>

<form action="order_save" method="post">
    <label>order_id:</label>
    <input type="number" name="order_id" value="<%= orderid %>" readonly /><br/><br/>
    
    <label>Company_Id:</label>
    <input type="text" name="company_id" value="<%= companyid %>" readonly /><br/><br/>
    
    <label>Side:</label>
    <input type="text" name="side" value="<c:out value='${order.side}'/>" readonly /><br/><br/>

    <label>Quantity:</label>
    <input type="number" name="quantity" value="<c:out value='${order.quantity}'/>"/><br/><br/>

    <label>Price:</label>
    <input type="number" name="price" value="<c:out value='${order.price}'/>"/><br/><br/>

    <label>Order_Status:</label>
    <input type="text" name="order_status" value="<c:out value='${order.order_status}'/>" readonly /><br/><br/>

    <input type="hidden" name="action" id="action" value="" />

    <button type="submit" onclick="document.getElementById('action').value='modify'">Modify</button>
    <button type="submit" onclick="document.getElementById('action').value='delete'">Delete</button><br/><br/>
</form>

</body>
</html>
