<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clothing</title>
<style>
.login {
	width: 27% !important;
	height: 80vh;
}
</style>
</head>
<body>
<%@ include file="navbar.jsp" %>
	<div class="container login d-flex flex-column justify-content-center">
		<h3 class="text-center mb-7">Login</h3>
		<form action="/rev_shop_demo/api/v1/login" method="POST">
			<div class="col-lg-12">
				<div class="mb-3">
					<label class="form-label" for="email">Email<sup
						class="star">*</sup></label> <input id="email" class="form-control"
						name="email" />
				</div>
			</div>
			<div class="col-lg-12">
				<div class="mb-3">
					<label class="form-label" for="password">Password<sup
						class="star">*</sup></label> <input id="password" type="password"
						class="form-control" name="password" />
				</div>
			</div>
			<button class="btn btn-success">Login</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>