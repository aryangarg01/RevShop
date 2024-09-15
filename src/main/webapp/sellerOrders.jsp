<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.ProductDTO"%>
<%@ page import="entity.Cart"%>
<%@ page import="entity.OrderDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/sellerNav.jsp"%>
	<div class="container">
	<%
	List<ProductDTO> list = (ArrayList<ProductDTO>) request.getAttribute("products");
	List<OrderDetails> details = (ArrayList<OrderDetails>) request.getAttribute("orderDetails");
	
	for(OrderDetails i: details){ 
		for(ProductDTO j: list){ 
			if(i.getProductId() == j.getProdId()){ %>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th scope="col">Order ID</th>
							<th scope="col">Product Name</th>
							<th scope="col">Price Per Unit</th>
							<th scope="col">Category</th>
							<th scope="col">Quantity</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><%= i.getOrderId() %></td>
							<td><%=j.getProdName()%></td>
							<td><%=j.getPrice()%></td>
							<td><%=j.getCategoryType()%></td>
							<td><%= i.getQuantity() %></td>
						</tr>
					</tbody>
				</table>
				<%} %>
		 <%} %>
	<%} %>
	</div>
</body>
</html>