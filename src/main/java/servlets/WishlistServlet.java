package servlets;

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
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("loggedInUserID");
		List<ProductDTO> products = wishlistService.getProductsFromWishlist(userId);
		request.setAttribute("allProducts", products);
		request.getRequestDispatcher("/wishlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("loggedInUserID");
		wishlistService.addToWishlist(userId, productId);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		System.out.println(productId+ " Hello");
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("loggedInUserID");
		wishlistService.deleteFromWishlist(productId, userId);
	}
}
