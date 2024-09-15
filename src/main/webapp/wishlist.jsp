<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.product-card {
    border: none;
    transition: all 0.3s ease;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.product-card:hover {
    transform: translateY(-10px);
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
}

/* Hover Effect for Product Image */
.card-img-top {
    transition: transform 0.3s ease-in-out;
}

.card-img-top:hover {
    transform: scale(1.05);
}

/* Cart Button Elevation and Hover */
.btn-cart {
    background-color: #28a745;
    color: white;
    font-weight: bold;
    box-shadow: 0 4px 12px rgba(40, 167, 69, 0.3);
    border: none;
    transition: all 0.3s ease;
}

.btn-cart:hover {
    background-color: #218838;
    box-shadow: 0 6px 16px rgba(40, 167, 69, 0.5);
}

/* Remove Button */
.btn-danger {
    transition: background-color 0.3s ease;
}

.btn-danger:hover {
    background-color: #dc3545;
    box-shadow: 0 4px 12px rgba(220, 53, 69, 0.3);
}

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
	<%@ include file="buyerNav.jsp"%>
	<div class="d-flex">
		<%
		List<ProductDTO> list = (ArrayList<ProductDTO>) request.getAttribute("allProducts");
		if(!list.isEmpty()) {
		for (ProductDTO i : list) {
		%>
		<div class="card product-card m-3" style="width: 20rem;">
			<img style="height: 350px; width: 100%;"  src="<%= i.getImgUrl() %>" class="card-img-top" alt="product-img">
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
				<a class="btn btn-cart btn-primary btn-sm" onclick="addToCart(<%= i.getProdId() %>)"> Add To Cart</a>
				<a class="btn btn-danger btn-sm" onclick="removeFromWishlist(<%= i.getProdId() %>)">Remove From Wishlist</a>
			</div>
		</div>
		<%
		}
		}else{
		%>
		<div class="container empty-cart">
			<!-- Empty Cart Icon -->
			<div class="empty-cart-icon">
				<i class="fas fa-shopping-cart"></i>
			</div>

			<!-- Optionally, an Image for Empty Cart -->
			<img src="https://cdn.dribbble.com/users/1010436/screenshots/13921028/dribble_shot_62_4x.jpg" alt="Empty Cart"
				class="empty-cart-img">

			<!-- Empty Cart Heading -->
			<h1>Your Wishlist is Empty</h1>
		<%} %>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
		<script>
		const removeFromWishlist = (productId) => {
			fetch("/rev_shop_demo/api/v1/wishlist?id="+productId, {
				method: "DELETE",
			}).then((response)=>{
				console.log(response);
			}).then((data)=>{
				console.log(data);
			}).catch((error)=>{
				console.log(error);
			})
		}
		
		const addToCart = (productId) => {
			fetch("/rev_shop_demo/api/v1/cart?id="+productId, {
				method: "POST"
			})
		}
		</script>
	</body>
</html>