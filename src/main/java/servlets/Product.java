package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CategoryService;
import service.ProductService;

import java.io.IOException;
import java.util.*;

public class Product extends HttpServlet {
	ProductService prodService = new ProductService();
	private static final long serialVersionUID = 1L;

    public Product() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService catService = new CategoryService();
		List<String> categories = catService.getCategories();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/product.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("prodName");
		String description = request.getParameter("description");
		int quanity = Integer.parseInt(request.getParameter("quantity"));
		int thresholdQuantity = Integer.parseInt(request.getParameter("thresholdQuantity"));
		double price = Double.parseDouble(request.getParameter("price"));
		int category = Integer.parseInt(request.getParameter("category"));
		int discount = Integer.parseInt(request.getParameter("discount"));
		String imgUrl = request.getParameter("image");

		int userId = (int) request.getSession().getAttribute("loggedInUserID");
		entity.Product product = new entity.Product(userId, category, productName, price, description, quanity, thresholdQuantity, discount, imgUrl);
		prodService.addProductToDB(product);
		request.getRequestDispatcher("/sellerDashboard.jsp").forward(request, response);
	}
	
//	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int productId = Integer.parseInt(request.getParameter("id"));
//		System.out.println(productId);
//		ProductDTO product = prodService.getSingleProductDetail(productId);
//		CategoryService catService = new CategoryService();
//		List<String> categories = catService.getCategories();
//		request.setAttribute("categories", categories);
//		request.setAttribute("product", product);
//		System.out.print(product);
//		request.getRequestDispatcher("/product.jsp").forward(request, response);
//	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		prodService.deleteProduct(productId);
		doGet(request, response);
	}
}
