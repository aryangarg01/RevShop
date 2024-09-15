package dao;

import java.sql.*;

import entity.Order;
import util.DatabaseConnection;

public class OrderDAO {
	Connection connection;
	
	public OrderDAO() {
		connection = DatabaseConnection.getInstance().getConnection();
	}
	
	public void addToOrder(Order order) {
		String query = "insert into orders (transaction_id, buyer_id, total_price, order_date, shipping_status) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, order.getTransactionId());
			ps.setInt(2, order.getBuyerId());
			ps.setDouble(3,  order.getTotalPrice());
			ps.setString(4, order.getOrderDate());
			ps.setString(5, order.getShippingStatus());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getOrderId(int userId) {
		int orderId = 0;
		String query = "Select order_id from orders where buyer_id = ? order by order_id desc limit 1";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				orderId = rs.getInt("order_id");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderId;
	}
	
	public ResultSet getAllOrders(int userId) {
		ResultSet rs = null;
		String query = "Select * from orders where buyer_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getAllOrdersForSeller() {
		ResultSet rs = null;
		String query = "Select * from orders";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
