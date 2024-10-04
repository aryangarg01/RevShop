package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BankService;
import service.CartService;
import service.OrderDetailsService;
import service.OrderService;
import service.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.ProductDTO;
import entity.Cart;
import entity.OrderDetails;
import exception.InvalidException;

public class Order extends HttpServlet {
	CartService cartService = new CartService();
	ProductService productService = new ProductService();
	
	private static final long serialVersionUID = 1L;
       
    public Order() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("/order.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
		int cvv = Integer.parseInt(request.getParameter("cvv"));
		String holderName = request.getParameter("holderName");
		
		BankService bankService = new BankService();
		Integer value = (Integer) request.getSession().getAttribute("loggedInUserID");
		int userId = 0;
		
		if(value == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			userId = (int) value;
		}
		
		bankService.addBankDetails(accountNumber, holderName, cvv, userId);
		int transactionId = bankService.getTransactionId(accountNumber);
		
		List<Cart> cartProducts = new ArrayList<>();
		try {
			cartProducts = cartService.viewCart(userId);
		} catch (InvalidException e) {
			e.printStackTrace();
		}
		List<ProductDTO> products = cartService.getProductFromCart(userId);
		double totalPrice = 0;
		for(ProductDTO i: products) {
			totalPrice += i.getPrice() * cartProducts.get(products.indexOf(i)).getQuantity();
		}
		entity.Order order = new entity.Order(userId, transactionId, new Date().toString(), totalPrice, "Pending");
		OrderService orderService = new OrderService();
		orderService.addOrder(order);
		
		int orderId = orderService.getOrderId(userId);
		for(ProductDTO i: products) {
			OrderDetails orderDetails = new OrderDetails(i.getPrice(), orderId, i.getProdId(), cartProducts.get(products.indexOf(i)).getQuantity());
			OrderDetailsService orderDetailsService = new OrderDetailsService();
			orderDetailsService.addOrderDetails(orderDetails);
			int updatedQty = i.getQuantity() - cartProducts.get(products.indexOf(i)).getQuantity();
			i.setQuantity(updatedQty);
			productService.updateProduct(i);
			cartService.removeProduct(i.getProdId(), userId);
		}
		
		request.getRequestDispatcher("/successOrder.jsp").forward(request, response);
	}

}
