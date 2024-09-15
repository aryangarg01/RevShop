package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CategoryService;
import service.ProductService;

import java.io.IOException;
import java.util.List;

import dto.ProductDTO;

public class UpdateProduct extends HttpServlet {
	ProductService prodService = new ProductService();
	private static final long serialVersionUID = 1L;
       
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    int productId;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productId = Integer.parseInt(request.getParameter("id"));
		ProductDTO product = prodService.getSingleProductDetail(productId);
		CategoryService catService = new CategoryService();
		List<String> categories = catService.getCategories();
		request.setAttribute("categories", categories);
		request.setAttribute("data", product);
		request.getRequestDispatcher("/updateProduct.jsp").forward(request, response);
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
		ProductDTO product = new ProductDTO(userId, category, productName, price, description, quanity, thresholdQuantity, discount, imgUrl);
		product.setProdId(productId);
		prodService.updateProduct(product);
//		request.getRequestDispatcher("/product.jsp").forward(request, response);
	}

}
