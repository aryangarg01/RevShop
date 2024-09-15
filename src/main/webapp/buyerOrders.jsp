<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.ProductDTO"%>
<%@ page import="entity.Cart"%>
<%@ page import="entity.OrderDetails"%>
<%@ page import="entity.Order"%>
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
	<%
	List<ProductDTO> list = (ArrayList<ProductDTO>) request.getAttribute("orderedProducts");
	List<OrderDetails> details = (ArrayList<OrderDetails>) request.getAttribute("orderDetails");
	List<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
	%>
	<%@ include file="/buyerNav.jsp"%>
	<div class="container">
		<%if (!list.isEmpty()) {%>
		<% int count = 1; %>
			<% for(Order j: orders){ %>
			Order #<strong><%= count++ %></strong>
			<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Product Name</th>
					<th scope="col">Description</th>
					<th scope="col">Price Per Unit</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
				</tr>
			</thead>
			<tbody>
			
				<%for (ProductDTO i : list) {
					if(j.getOrderId() == details.get(list.indexOf(i)).getOrderId()) {%>
				<tr>
					<th><%=i.getProdName()%></th>
					<td><%=i.getDescription()%></td>
					<td><%=i.getPrice()%></td>
					<td><%=i.getCategoryType()%></td>
					<td><%= details.get(list.indexOf(i)).getQuantity() %></td>
				</tr>
				<% } 
				}	%>
			</tbody>
		</table>
		<table class="table">
			<tr>
			<th>Total Paid: </th>
			<td class="text-center"><%= orders.get(orders.indexOf(j)).getTotalPrice() %></td>
			</tr>
		</table>
		<%  }
		} else {	%>
		<div class="container empty-cart">
			<!-- Empty Cart Icon -->
			<div class="empty-cart-icon">
				<i class="fas fa-shopping-cart"></i>
			</div>

			<!-- Optionally, an Image for Empty Cart -->
			<img src="https://evyapari.com/static/media/empty_cart.45e2dadaaca71284eb3a.jpg" alt="Empty Cart"
				class="empty-cart-img">

			<!-- Empty Cart Heading -->
			<h1>No Orders Yet</h1>
			<% }%>
		</div>
</body>
</html>