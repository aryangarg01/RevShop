<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
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
	<%@include file="sellerNav.jsp" %>	
	<div class="d-flex">
		<%
		List<ProductDTO> list = (ArrayList<ProductDTO>) request.getAttribute("products");
		if(!list.isEmpty()){
			for (ProductDTO i : list) {
			%>
			<div class="card m-4" style="width: 350px;">
				<img style="height: 400px; width: 100%;" src="<%= i.getImgUrl() %>" class="card-img-top" alt="product-img">
				<div class="card-body">
					<h5 class="card-title">
						<%=i.getProdName()%></h5>
					<p class="card-text">
						<%=i.getDescription()%></p>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Price: $<%= i.getPrice() %></li>
						<li class="list-group-item">Quantity: <%= i.getQuantity() %></li>
						<li class="list-group-item">Threshold Quantity:  <%= i.getThresholdQty() %></li>
						<li class="list-group-item">Category: <%= i.getCategoryType() %></li>
					</ul>
					<a class="btn btn-success btn-sm" href="/rev_shop_demo/api/v1/updateProduct?id=<%= i.getProdId() %>">Update</a> <a
						class="btn btn-danger btn-sm" onclick="deleteProduct(<%= i.getProdId() %>)">Delete</a>
				</div>
			</div>
		<%
		} }else{
		%>
		<div class="container empty-cart">
			<!-- Empty Cart Icon -->
			<div class="empty-cart-icon">
				<i class="fas fa-shopping-cart"></i>
			</div>

			<!-- Optionally, an Image for Empty Cart -->
			<img src="https://img.freepik.com/free-vector/hand-drawn-no-data-concept_52683-127823.jpg?size=626&ext=jpg&ga=GA1.1.2008272138.1726272000&semt=ais_hybrid" alt="Empty Cart"
				class="empty-cart-img">

			<!-- Empty Cart Heading -->
			<h2>No Products Yet!. First You need to add the product.</h2>
		<%} %>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
		<script>
		const deleteProduct = (productId) => {
			fetch("/rev_shop_demo/api/v1/product?id="+productId, {
				method: "DELETE"
			}).then((response)=>{
				console.log(response);
			}).then((data)=>{
				console.log(data);
			}).catch((error)=>{
				console.log(error);
			})
		}
		</script>
</body>
</html>