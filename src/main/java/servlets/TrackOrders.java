package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrderDetailsService;
import service.OrderService;
import service.ProductService;

import java.io.IOException;
import java.util.*;

import dto.ProductDTO;
import entity.OrderDetails;

public class TrackOrders extends HttpServlet {
	OrderService orderService = new OrderService();
	OrderDetailsService orderDetailsService = new OrderDetailsService();
	ProductService productService = new ProductService();
	private static final long serialVersionUID = 1L;

    public TrackOrders() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = (int) request.getSession().getAttribute("loggedInUserID");
		List<entity.Order> ordersOfBuyer = orderService.getAllOrdersId(userId);
		List<OrderDetails> orderDetails = new ArrayList<>();
		List<ProductDTO> products = new ArrayList<>();
		for(entity.Order i: ordersOfBuyer) {
			List<OrderDetails> list = orderDetailsService.getOrderDetails(i.getOrderId());
			for(OrderDetails j: list) {
				products.add(productService.getSingleProductDetail(j.getProductId()));
			}
			orderDetails.addAll(list);
		}
		
		request.setAttribute("orderDetails", orderDetails);
		request.setAttribute("orderedProducts", products);
		request.setAttribute("orders", ordersOfBuyer);
		request.getRequestDispatcher("/buyerOrders.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
