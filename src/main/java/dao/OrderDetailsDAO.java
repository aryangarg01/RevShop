package dao;

import java.sql.*;

import entity.OrderDetails;
import util.DatabaseConnection;

public class OrderDetailsDAO {
	Connection connection;
	
	public OrderDetailsDAO() {
		connection = DatabaseConnection.getInstance().getConnection();
	}
	
	public void addOrderDetails(OrderDetails orderDetails) {
		String query = "insert into order_details (amount, product_id, order_id, quantity) values(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setDouble(1, orderDetails.getAmount());
			ps.setInt(2, orderDetails.getProductId());
			ps.setInt(3, orderDetails.getOrderId());
			ps.setInt(4, orderDetails.getQuantity());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getOrderDetails(int orderId) {
		ResultSet rs = null;
		String query = "Select * from order_details where order_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getOrderDetailsForSeller(int productId) {
		ResultSet rs = null;
		String query = "Select * from order_details where product_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, productId);
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	} 
}
