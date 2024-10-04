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
	<%@ include file="buyerNav.jsp"%>
	<% List<ProductDTO> list = (ArrayList<ProductDTO>) request.getAttribute("allProducts"); %>
	<!-- <form action="/rev_shop_demo/api/v1/user" method="post">
		<select class="form-select" name="category">
			<% for (ProductDTO i : list) {%>
			<option value="<%= i.getCategoryType() %>"><%= i.getCategoryType() %></option>
			<%} %>
		</select>
		<button class="btn btn-outline-success" type="submit">Search</button>
		</form>
	 -->
	<div class="d-flex row mx-4">
		<%
		for (ProductDTO i : list) {
		%>
		<div class="card m-2 col-lg-3 px-0" style="width: 350px;">
			<img style="height: 400px; width: 100%;" src="<%= i.getImgUrl() %>" class="card-img-top" alt="product-img">
			<div class="card-body">
				<h5 class="card-title">
					<%=i.getProdName()%></h5>
				<p>
					Price:
					<%=i.getPrice()%></p>
				<p class="card-text">
					Description:
					<%=i.getDescription()%></p>
				<p class="card-text">
					Category:
					<%=i.getCategoryType()%>
				</p>
				<a class="btn btn-primary btn-sm"
					onclick="addToCart(<%=i.getProdId()%>)"> Add To Cart</a> <a
					class="btn btn-primary btn-sm"
					onclick="addToWishlist(<%=i.getProdId()%>)"> Add To Wishlist</a>
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
		const addToWishlist = (productId) => {		
			fetch("/rev_shop_demo/api/v1/wishlist?id="+productId, {
				method: "POST"
			}).then((response)=>{
				console.log(response);
			}).catch((error)=>{
				console.log(error);
			})
		}
		
		
		function addToCart(productId) {
			fetch("/rev_shop_demo/api/v1/cart?id="+productId, {
				method: "POST"
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