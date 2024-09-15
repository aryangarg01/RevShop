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
</head>
<body>
	<%@include file="sellerNav.jsp" %>	
	<div class="d-flex">
		<%
		List<ProductDTO> list = (ArrayList<ProductDTO>) request.getAttribute("products");
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
		}
		%>
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