package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.WishlistService;

import java.io.IOException;
import java.util.*;

import dto.ProductDTO;

public class WishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	WishlistService wishlistService = new WishlistService();
      
    public WishlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Get method");
		HttpSession session = request.getSession();
		Integer value = (Integer) session.getAttribute("loggedInUserID");
		int userId = 0;
		if(value == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			userId = (int) value;
		}
		List<ProductDTO> products = wishlistService.getProductsFromWishlist(userId);
		request.setAttribute("allProducts", products);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/wishlist.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("loggedInUserID");
		wishlistService.addToWishlist(userId, productId);
		response.sendRedirect("/rev_shop_demo/api/v1/wishlist");
//		response.setStatus(200);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		int userId = (int) request.getSession().getAttribute("loggedInUserID");
		wishlistService.deleteFromWishlist(productId, userId);
		response.sendRedirect("/rev_shop_demo/api/v1/wishlist");
	}
}
