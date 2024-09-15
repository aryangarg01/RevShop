package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dao.OrderDAO;
import entity.Order;

public class OrderService {
	
	private OrderDAO orderDAO;
	public OrderService() {
		orderDAO = new OrderDAO();
	}
	
	public void addOrder(Order order) {
		orderDAO.addToOrder(order);
	}
	
	public int getOrderId(int userId) {
		return orderDAO.getOrderId(userId);
	}
	
	public List<Order> getAllOrdersId(int userId){
		List<Order> list = new ArrayList<>();
		ResultSet rs = orderDAO.getAllOrders(userId);
		try {
			while(rs.next()) {
				Order order = new Order(rs.getInt("buyer_id"), rs.getInt("transaction_id"), rs.getString("order_date"), rs.getDouble("total_price"),
						rs.getString("shipping_status"));
				order.setOrderId(rs.getInt("order_id"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Order> getAllOrders(){
		List<Order> list = new ArrayList<>();
		ResultSet rs = orderDAO.getAllOrdersForSeller();
		try {
			while(rs.next()) {
				Order order = new Order(rs.getInt("buyer_id"), rs.getInt("transaction_id"), rs.getString("order_date"), rs.getDouble("total_price"),
						rs.getString("shipping_status"));
				order.setOrderId(rs.getInt("order_id"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
