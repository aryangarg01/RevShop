package dao;

import java.sql.*;
import entity.Cart;
import util.DatabaseConnection;

public class CartDAO {
	Connection connection;
	public CartDAO() {
		connection = DatabaseConnection.getInstance().getConnection();
	}
	
	public void addProductToCart(Cart cart) {
		String query = "Insert into cart (product_id, buyer_id, quantity) values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareCall(query);
			ps.setInt(1, cart.getProductId());
			ps.setInt(2, cart.getBuyerId());
			ps.setInt(3, cart.getQuantity());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProductFromCart(int prodId) {
		String query = "Delete from cart where product_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, prodId);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getAllProductsFromCart(int userID) {
		ResultSet rs = null;
		String query = "Select * from cart where buyer_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
