<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.*" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Clothing</title>
</head>
<body>
	<%@ include file="navbar.jsp" %>
    <!-- Hero Section -->
    <section class="bg-light text-center py-5">
        <div class="container">
            <h1 class="display-4">Welcome to Our Awesome Platform</h1>
            <p class="lead">Join us today and explore amazing content!</p>
            <a href="/rev_shop_demo/api/v1/login" class="btn btn-primary btn-lg me-3">Login</a>
            <a href="/rev_shop_demo/api/v1/register" class="btn btn-outline-primary btn-lg">Register</a>
        </div>
    </section>

    <!-- About Section -->
    <section class="container py-5">
        <div class="row">
            <div class="col-lg-6">
                <h2>About Our Website</h2>
                <p>
                    Our website offers a wide variety of content tailored just for you. Whether you're looking to 
                    connect with others, find resources, or just enjoy great content, we have something for everyone.
                </p>
                <p>
                    With a simple and intuitive interface, you'll feel right at home as you explore the full 
                    features available after login or registration.
                </p>
            </div>
            <div class="col-lg-6">
                <img style="width: 65%"; src="https://st.depositphotos.com/1001877/3814/i/450/depositphotos_38143799-stock-photo-e-commerce-shopping-cart-with.jpg" class="img-fluid rounded" alt="About Us">
            </div>
        </div>
    </section>

    <!-- Features Section -->
    <section class="bg-dark text-white py-5">
        <div class="container">
            <div class="row text-center">
                <div class="col-lg-4">
                    <h3>Easy to Use</h3>
                    <p>Our platform is designed with simplicity in mind. Navigate and access your favorite features seamlessly.</p>
                </div>
                <div class="col-lg-4">
                    <h3>Secure & Private</h3>
                    <p>Your privacy is our priority. All your data is securely stored and protected.</p>
                </div>
                <div class="col-lg-4">
                    <h3>24/7 Support</h3>
                    <p>Need help? We're here for you. Contact us any time for assistance.</p>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="bg-dark text-white text-center py-3">
        <p>&copy; 2024 OurWebsite. All rights reserved.</p>
    </footer>	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>