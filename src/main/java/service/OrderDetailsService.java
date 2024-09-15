package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dao.OrderDetailsDAO;
import entity.OrderDetails;

public class OrderDetailsService {
	OrderDetailsDAO orderDetailsDAO;

	public OrderDetailsService() {
		orderDetailsDAO = new OrderDetailsDAO();
	}
	
	public void addOrderDetails(OrderDetails orderDetails) {
		orderDetailsDAO.addOrderDetails(orderDetails);
	}
	
	public List<OrderDetails> getOrderDetails(int orderId){
		List<OrderDetails> orderDetails = new ArrayList<>();
		ResultSet rs = orderDetailsDAO.getOrderDetails(orderId);
		try {
			while(rs.next()) {
				OrderDetails order = new OrderDetails(rs.getDouble("amount") ,rs.getInt("order_id"), rs.getInt("product_id"), rs.getInt("quantity"));
				orderDetails.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	
	public List<OrderDetails> getOrderDetailsByProductId(int productId){
		List<OrderDetails> orderDetails = new ArrayList<>();
		ResultSet rs = orderDetailsDAO.getOrderDetailsForSeller(productId);
		try {
			while(rs.next()) {
				OrderDetails order = new OrderDetails(rs.getDouble("amount") ,rs.getInt("order_id"), rs.getInt("product_id"), rs.getInt("quantity"));
				orderDetails.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
}
