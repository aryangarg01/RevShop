<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/buyerNav.jsp"%>

	<h1>Cart</h1>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Product Name</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
				</tr>
			</thead>
			<tbody>
			<%
			List<ProductDTO> list = (ArrayList<ProductDTO>) request.getAttribute("allProducts");
			for(ProductDTO i: list) {%>
			<tr>
				<th><%= i.getProdName() %> </th>
				<td><%= i.getDescription() %></td>
				<td><%= i.getPrice() %></td>
				<td><%= i.getCategoryType() %></td>
				<td><button class="btn btn-sm btn-primary">+</button><%= i.getQuantity() %><button class="btn btn-sm btn-primary">-</button></td>
			</tr>
			<%} %>
			</tbody>
		</table>
	</div>
</body>
</html>