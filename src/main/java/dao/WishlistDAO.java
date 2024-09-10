package dao;

import java.sql.*;

import util.DatabaseConnection;

public class WishlistDAO {
	Connection connection;

	public WishlistDAO() {
		connection = DatabaseConnection.getInstance().getConnection();
	}
	
	public void removeProductFromWishlist(int productId) {
		String query = "Delete from wishlist where product_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, productId);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addProductToWishlist(int buyerId, int productId) {
		String query = "insert into wishlist(buyer_id, product_id) values(?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, buyerId);
			ps.setInt(2, productId);
			ps.execute();
			System.out.println("Buyer ID: " + buyerId + " " + "Product ID: " + productId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
