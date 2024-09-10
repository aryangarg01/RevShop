<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container login d-flex flex-column justify-content-center">
		<h3 class="text-center mb-7">Product Details</h3>
		<form action="/rev_shop_demo/api/v1/register" method="POST">
			<div class="row">
				<div class="col-lg-12">
					<div class="mb-3">
						<label for="prodName" class="form-label">Product Name
							address</label> <input type="text" class="form-control"
							id="prodName" name="prodName">
					</div>
					<div class="mb-3">
						<label for="description" class="form-label">Description
							address</label> <textarea class="form-control"
							id="description" name="description"></textarea>
					</div>
					<div class="mb-3">
						<label for="price" class="form-label">Price
							address</label> <input class="form-control"
							id="price" name="price">
					</div>
					<div
						class="col-lg-12">
							<label for="category" class="form-label">Choose the Category
							address</label>
						<select name="category" class="form-select" id="category"
							aria-label="Default select example">
							<option value="Tshirts">Tshirts</option>
							<option value="Shirts">Shirts</option>
						</select>
					</div>
				</div>
				<button class="btn btn-success">Add the Product</button>
		</form>
	</div>
</body>
</html>