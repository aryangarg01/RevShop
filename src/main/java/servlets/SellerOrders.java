package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrderDetailsService;
import service.OrderService;
import service.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.ProductDTO;
import entity.OrderDetails;

public class SellerOrders extends HttpServlet {
	OrderService orderService = new OrderService();
	OrderDetailsService orderDetailsService = new OrderDetailsService();
	ProductService productService = new ProductService();
	private static final long serialVersionUID = 1L;

    public SellerOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer value = (Integer) request.getSession().getAttribute("loggedInUserID");
		int userId = 0;
		if(value == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			userId = (int) value;
		}
		List<ProductDTO> products = productService.getAllProducts(userId);
		List<OrderDetails> orderDetails = new ArrayList<>();
		for(ProductDTO i: products) {
			orderDetails.addAll(orderDetailsService.getOrderDetailsByProductId(i.getProdId()));
		}
		request.setAttribute("orderDetails", orderDetails);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/sellerOrders.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
