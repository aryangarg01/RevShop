package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ProductService;

import java.io.IOException;
import java.util.*;

import dto.ProductDTO;

public class Seller extends HttpServlet {
	ProductService productService = new ProductService();
	private static final long serialVersionUID = 1L;
       
    public Seller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<ProductDTO> data = productService.getAllProducts((int) session.getAttribute("loggedInUserID"));
		request.setAttribute("products", data);
		request.getRequestDispatcher("/sellerDashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
