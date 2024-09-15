package dao;

import java.sql.*;

import util.DatabaseConnection;

public class WishlistDAO {
	Connection connection;

	public WishlistDAO() {
		connection = DatabaseConnection.getInstance().getConnection();
	}
	
	public void removeProductFromWishlist(int productId, int userId) {
		String query = "Delete from favourites where product_id = ? and buyer_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, productId);
			ps.setInt(2, userId);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addProductToWishlist(int buyerId, int productId) {
		String query = "insert into favourites(buyer_id, product_id) values(?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, buyerId);
			ps.setInt(2, productId);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public ResultSet getAllProducts(int userId) {
		ResultSet rs = null;
		String query = "Select * from favourites where buyer_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
