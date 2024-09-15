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

<style>

.navbar-brand {
    font-size: 1.7rem; /* Larger and bold brand text */
    font-weight: bold;
    color: #007bff; /* Primary blue color */
    letter-spacing: 0.05em; /* Slightly spaced letters for a modern look */
}

.navbar-toggler {
    border: none; /* Remove default border */
}

.navbar-toggler-icon {
    background-image: url('data:image/svg+xml,<svg xmlns="http://www.w3.org/2000/svg" fill="%23007bff" viewBox="0 0 30 30"><path stroke="rgba(0, 0, 0, 0.5)" stroke-width="2" d="M4 7h22M4 15h22M4 23h22"/></svg>');
}

.navbar-nav .nav-link {
    color: #343a40; /* Dark grey link text */
    font-size: 1rem;
    padding: 0.5rem 1rem; /* Space between the links */
    transition: color 0.3s ease-in-out; /* Smooth transition for hover */
}

.navbar-nav .nav-link:hover {
    color: #007bff; /* Blue color on hover */
    font-weight: bold; /* Make links bold when hovered */
}

.navbar-nav .active {
    color: #007bff; /* Active link color */
    font-weight: bold; /* Emphasize the active link */
}

.form-control {
    width: 250px; /* Fixed width for a clean look */
    border-radius: 30px; /* Rounded corners */
    border: 1px solid #ced4da; /* Subtle border */
    padding: 0.5rem 1rem; /* Add padding inside the input */
    transition: box-shadow 0.3s ease-in-out; /* Smooth shadow transition */
}

.form-control:focus {
    box-shadow: 0 0 8px rgba(0, 123, 255, 0.5); /* Blue shadow on focus */
    border-color: #007bff; /* Border turns blue when focused */
}

.btn-outline-success {
    border-radius: 30px; /* Rounded buttons */
    padding: 0.5rem 1.5rem;
    border-color: #28a745; /* Green border */
    color: #28a745; /* Green text */
    transition: background-color 0.3s ease, color 0.3s ease; /* Smooth transition */
}

.btn-outline-success:hover {
    background-color: #28a745; /* Green background on hover */
    color: white; /* White text on hover */
}

.btn-outline-primary {
    margin-left: 1rem;
    border-radius: 30px; /* Rounded button */
    padding: 0.5rem 1.5rem;
    border-color: #007bff;
    color: #007bff;
    transition: background-color 0.3s ease, color 0.3s ease; /* Smooth transition */
}

.btn-outline-primary:hover {
    background-color: #007bff;
    color: white;
}

@media (max-width: 992px) {
    .navbar-collapse {
        text-align: center; /* Center items on smaller screens */
    }

    .form-control {
        width: 100%; /* Full width on smaller screens */
        margin-top: 0.5rem;
    }

    .btn-outline-primary, .btn-outline-success {
        width: 100%; /* Full width buttons for better mobile experience */
        margin: 0.5rem 0;
    }
}

.navbar-collapse {
    justify-content: space-between; /* Space out content nicely */
    align-items: center; /* Vertically center items */
}

.navbar-nav {
    margin-right: 1rem;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand">RevShop</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a
						class="nav-link" href="/rev_shop_demo/api/v1/seller">View All
						Products</a> <a class="nav-link" href="/rev_shop_demo/api/v1/allOrders">View Orders</a>
					<a class="nav-link" href="/rev_shop_demo/api/v1/product">Add New Product</a>
				<a class="nav-link btn btn-outline-primary" href="/rev_shop_demo/api/v1/login">Logout</a>
				</div>
			</div>
		</div>
	</nav>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>