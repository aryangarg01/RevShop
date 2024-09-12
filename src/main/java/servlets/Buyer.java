package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dto.ProductDTO;
import entity.Category;
import exception.InvalidException;
import service.CategoryService;
import service.ProductService;

public class Buyer extends HttpServlet {
	CategoryService categoryService = new CategoryService();
	ProductService productService = new ProductService();
	Category categoryDetails;
	private static final long serialVersionUID = 1L;
       
    public Buyer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductDTO> data = productService.getAllProductsForCustomers();
		request.setAttribute("allProducts", data);
		request.getRequestDispatcher("/buyerDashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryType = request.getParameter("category");
		Category category = new Category(categoryType);
		try {
			categoryDetails = categoryService.getDetails(category);
			List<ProductDTO> filteredProducts =  productService.filterProducts(categoryDetails.getCategoryId());
			request.setAttribute("allProducts", filteredProducts);
			request.getRequestDispatcher("/buyerDashboard.jsp").forward(request, response);
		} catch (InvalidException e) {
			e.printStackTrace();
		}
	}

}
