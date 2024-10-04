<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dto.ProductDTO"%>
<%@ page import="entity.Cart"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	List<ProductDTO> list = (ArrayList<ProductDTO>) request.getAttribute("allProducts");
	List<Cart> cart = (ArrayList<Cart>) request.getAttribute("cart");
	double total = 0;
	%>
	<%@ include file="/buyerNav.jsp"%>
	<div class="container">
		<%
		if (!list.isEmpty()) {
		%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Product Name</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (ProductDTO i : list) {
				%>
				<%
				int idx = list.indexOf(i);
				%>
				<tr>
					<th><%=i.getProdName()%></th>
					<td><%=i.getDescription()%></td>
					<td><%=i.getPrice()%></td>
					<td><%=i.getCategoryType()%></td>
					<td>
						<button	onclick="increment(<%=i.getProdId()%>, <%=cart.get(idx).getQuantity()%>)"
								class="btn btn-sm btn-primary">+</button>
								 <%=cart.get(idx).getQuantity()%>
							<button onclick="decrement(<%=i.getProdId()%>, <%=cart.get(idx).getQuantity()%>)"
								class="btn btn-sm btn-primary">-</button>
					</td>
					<td><button
							onclick="deleteProductFromCart(<%=i.getProdId()%>)"
							class="btn btn-sm btn-danger">Remove From Cart</button></td>
					<%
					total += cart.get(idx).getQuantity() * i.getPrice();
					%>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="/rev_shop_demo/api/v1/order" class="btn btn-primary btn-sm">Proceed
			Further To Place Order</a>
		<%
		} else {
		%>
		<div class="container empty-cart">
			<!-- Empty Cart Icon -->
			<div class="empty-cart-icon">
				<i class="fas fa-shopping-cart"></i>
			</div>

			<!-- Optionally, an Image for Empty Cart -->
			<img src="https://evyapari.com/static/media/empty_cart.45e2dadaaca71284eb3a.jpg" alt="Empty Cart"
				class="empty-cart-img">

			<!-- Empty Cart Heading -->
			<h1>Your Cart is Empty</h1>
			<%
			} if (!list.isEmpty()) {
			%>
			<table class="table">
				<tr>
					<th>Total</th>
					<td class="text-center"><%=total%></td>
				</tr>
			</table>
			<%
			}
			%>
		</div>
		<script>
		const increment = (productId, quantity)=> {
			quantity++;
			fetch("/rev_shop_demo/api/v1/cart?id="+productId+"&quantity="+quantity, {
				method: "PUT"
			})
		}
		
		const decrement = (productId, quantity) => {
			if(quantity > 0){				
				quantity--;
			}
			fetch("/rev_shop_demo/api/v1/cart?id="+productId+"&quantity="+quantity, {
				method: "PUT"
			})
		}
		
		function deleteProductFromCart(productId){
			fetch("/rev_shop_demo/api/v1/cart?id="+productId, {
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