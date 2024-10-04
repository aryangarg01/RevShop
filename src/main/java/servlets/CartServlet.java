package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CartService;

import java.io.IOException;
import java.util.*;

import dto.ProductDTO;
import entity.Cart;
import exception.InvalidException;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartService cartService = new CartService();

    public CartServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer value = (Integer) session.getAttribute("loggedInUserID");
		int userId = 0;
		if(value == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			userId = (int) value;
		}
		List<Cart> cartProducts = new ArrayList<>();
		try {
			cartProducts = cartService.viewCart(userId);
		} catch (InvalidException e) {
			e.printStackTrace();
		}
		List<ProductDTO> products = cartService.getProductFromCart(userId);
		request.setAttribute("allProducts", products);
		request.setAttribute("cart", cartProducts);
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		int userId = (int) request.getSession().getAttribute("loggedInUserID");
		try {
			cartService.addToCart(userId, productId, 1);
		} catch (InvalidException e) {
			e.printStackTrace();
		}
//		response.sendRedirect("/rev_shop_demo/api/v1/cart");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = (int) request.getSession().getAttribute("loggedInUserID");
		int productId = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cartService.updateQuantity(quantity, productId, userId);
		List<Cart> cartProducts = new ArrayList<>();
		try {
			cartProducts = cartService.viewCart(userId);
		} catch (InvalidException e) {
			e.printStackTrace();
		}
		List<ProductDTO> products = cartService.getProductFromCart(userId);
		request.setAttribute("allProducts", products);
		request.setAttribute("cart", cartProducts);
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
//		response.sendRedirect("/rev_shop_demo/api/v1/cart");
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int userId = (int) request.getSession().getAttribute("loggedInUserID");
		int productId = Integer.parseInt(request.getParameter("id"));
		cartService.removeProduct(productId, (int) request.getSession().getAttribute("loggedInUserID"));
		List<Cart> cartProducts = new ArrayList<>();
		try {
			cartProducts = cartService.viewCart(userId);
		} catch (InvalidException e) {
			e.printStackTrace();
		}
		List<ProductDTO> products = cartService.getProductFromCart(userId);
		request.setAttribute("allProducts", products);
		request.setAttribute("cart", cartProducts);
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}
}
