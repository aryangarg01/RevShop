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
<title>Clothing</title>
<style>
	.empty-cart {
        text-align: center;
        padding: 50px;
    }
    .empty-cart h1 {
        font-size: 2.5rem;
        color: #333;
        margin-bottom: 20px;
    }

    .empty-cart-icon {
        font-size: 6rem;
        color: #ccc;
        margin-bottom: 30px;
    }
    
    .empty-cart-img {
        max-width: 300px;
        margin-bottom: 20px;
    }
</style>
</head>
<body>
	<%@ include file="/sellerNav.jsp"%>
	<div class="container mt-3">
	<%
	List<ProductDTO> list = (ArrayList<ProductDTO>) request.getAttribute("products");
	List<OrderDetails> details = (ArrayList<OrderDetails>) request.getAttribute("orderDetails");
	if(!details.isEmpty()) { %>
		<table class="table table-striped table-hover table-bordered">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Order ID</th>
						<th scope="col">Product Name</th>
						<th scope="col">Price Per Unit</th>
						<th scope="col">Category</th>
						<th scope="col">Quantity</th>
						<th scope="col">Image</th>
					</tr>
				</thead>
			<% for(OrderDetails i: details){ 
				for(ProductDTO j: list){ 
					if(i.getProductId() == j.getProdId()){ %>
							<tbody>
								<tr>
									<td><%= i.getOrderId() %></td>
									<td><%=j.getProdName() %></td>
									<td><%=j.getPrice() %></td>
									<td><%=j.getCategoryType() %></td>
									<td><%= i.getQuantity() %></td>
									<td><img style="width: 100px; height: 90px;" src="<%= j.getImgUrl() %>"></td>
								</tr>
							</tbody>
						<%} %>
				 <%} %>
			<%} %>
		</table>
		<% }else{ %>
		<div class="container empty-cart">
			<!-- Empty Cart Icon -->
			<div class="empty-cart-icon">
				<i class="fas fa-shopping-cart"></i>
			</div>

			<!-- Optionally, an Image for Empty Cart -->
			<img src="https://img.freepik.com/free-vector/purchase-ban-online-store-website-error-cancel-buying-order-placing-inability-buy-limit-budget-line-online-buyer-cartoon-character_335657-1173.jpg?semt=ais_hybrid" alt="Empty Cart"
				class="empty-cart-img">

			<!-- Empty Cart Heading -->
			<h2>No Orders Yet!</h2>
			<% }%>
		</div>
	</div>
</body>
</html>