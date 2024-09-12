<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Clothing</title>
</head>
<body>
	<%@ include file="navbar.jsp" %>
	<div class="container login d-flex flex-column justify-content-center">
		<h3 class="text-center mb-7">Register</h3>
		<form action="/rev_shop_demo/api/v1/register" method="POST">
			<div class="row">
				<div class="col-lg-4">
					<div class="mb-3">
						<label class="form-label" for="firstName">First Name<sup
							class="star">*</sup></label> <input id="firstName" class="form-control"
							name="firstName" />
					</div>
				</div>
				<div class="col-lg-4">
					<div class="mb-3">
						<label class="form-label" for="middleName">Middle Name</label> <input
							id="middleName" class="form-control" value="null" name="middleName" />
					</div>
				</div>
				<div class="col-lg-4">
					<div class="mb-3">
						<label class="form-label" for="lastName">Last Name<sup
							class="star">*</sup></label> <input id="lastName" class="form-control"
							name="lastName" />
					</div>
				</div>
				<div class="col-lg-6">
					<div class="mb-3">
						<label class="form-label" for="email">Email<sup
							class="star">*</sup></label> <input id="email" class="form-control"
							name="email" />
					</div>
				</div>
				<div class="col-lg-6">
					<div class="mb-3">
						<label class="form-label" for="password">Password<sup
							class="star">*</sup></label> <input id="password" type="password"
							class="form-control" name="password" />
					</div>
				</div>
				<div class="col-lg-4">
					<div class="mb-3">
						<label class="form-label" for="contact">Contact<sup
							class="star">*</sup></label> <input id="contact" class="form-control"
							name="contact" />
					</div>
				</div>
				<div class="col-lg-8">
					<div class="mb-3">
						<label class="form-label" for="address">Address<sup
							class="star">*</sup></label> <input id="address" class="form-control"
							name="address" />
					</div>
				</div>
				<div class="col-lg-4">
					<div class="mb-3">
						<label class="form-label" for="city">City<sup class="star">*</sup></label>
						<input id="city" class="form-control" name="city" />
					</div>
				</div>
				<div class="col-lg-4">
					<div class="mb-3">
						<label class="form-label" for="state">State<sup
							class="star">*</sup></label> <input id="state" class="form-control"
							name="state" />
					</div>
				</div>
				<div
					class="col-lg-4">
					<label class="form-label" for="role">Choose the role<sup
							class="star">*</sup></label> 
					<select name="role" class="form-select">
						<option value="1">Buyer</option>
						<option value="2">Seller</option>
					</select>
				</div>
			</div>
			<button class="btn btn-success">Register</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>