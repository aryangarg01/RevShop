<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.*" %>
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
	<div class="container login d-flex flex-column justify-content-center">
		<h3 class="text-center mb-7">Product Details</h3>
		<form action="/rev_shop_demo/api/v1/product" method="POST">
			<div class="row">
				<div class="col-lg-12">
					<div class="mb-3">
						<label for="prodName" class="form-label">Product Name
							address</label> <input type="text" class="form-control"
							id="prodName" name="prodName">
					</div>
					<div class="mb-3">
						<label for="description" class="form-label">Description
							</label> <textarea class="form-control"
							id="description" name="description"></textarea>
					</div>
					<div class="mb-3">
						<label for="price" class="form-label">Price
							</label> <input class="form-control"
							id="price" name="price">
					</div>
					<div class="mb-3">
						<label for="image" class="form-label">Image URL
							</label> <input class="form-control"
							id="image" name="image">
					</div>
						<div class="mb-3">
						<label for="quantity" class="form-label">Quantity
							</label> <input class="form-control"
							id="quantity" name="quantity">
					</div>
					<div class="mb-3">
						<label for="thresholdQuantity" class="form-label">Threshold Quantity
							</label> <input class="form-control"
							id="thresholdQuantity" name="thresholdQuantity">
					</div>
						<div class="mb-3">
						<label for="discount" class="form-label">Discount
							</label> <input class="form-control"
							id="discount" name="discount">
					</div>
					<div
						class="col-lg-12">
							<label for="category" class="form-label">Choose the Category
							</label>
						<select name="category" class="form-select" id="category"
							aria-label="Default select example">
							<% List<String> categories = (ArrayList<String>)request.getAttribute("categories");  
							for(String i: categories) {%>							
							<option value=<%= categories.indexOf(i) + 1 %>><%= i %></option>
							<%} %>
						</select>
					</div>
				</div>
				<button class="btn btn-success mt-3">Add the Product</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>