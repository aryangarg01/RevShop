<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clothing</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h2>Enter Bank Details to proceed the Order</h2>
		<form action="/rev_shop_demo/api/v1/order" method="post">
			<div class="mb-3">
				<label for="holderName" class="form-label">Account Holder
					Name</label> <input type="text" class="form-control" id="holderName"
					name="holderName">
			</div>
			<div class="mb-3">
				<label for="accountNumber" class="form-label">Account Number</label>
				<input type="number" class="form-control" id="accountNumber" name="accountNumber">
			</div>
			<div class="mb-3">
				<label for="cvv" class="form-label">CVV</label> <input
					type="password" class="form-control" id="cvv" name="cvv">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>