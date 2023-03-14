<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.newproject.test.model.Order"%>
<%@ page import="java.util.List, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
</head>
<body>

        <h1>Order List</h1>
	<table>
		<tr>
			<th>Order ID</th>
			<th>Company ID</th>
			<th>Side</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Order Status</th>
		</tr>
		<c:forEach var="order" items="${orderlist}">
			<tr>

				<td><a href="ModifyOrder?order_id=${order.order_id}">${order.order_id}</a></td>
				<td>${order.company_Id}</td>
				<td>${order.side}</td>
				<td>${order.quantity}</td>
				<td>${order.price}</td>
				<td>${order.order_status}</td>

			</tr>
		</c:forEach>

	</table>
</body>
</html>
