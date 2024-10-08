package dao;

import util.DatabaseConnection;
import java.sql.*;
import entity.Product;

public class ProductDAO {
	Connection connection;

	public ProductDAO() {
		connection = DatabaseConnection.getInstance().getConnection();
	}
	
	public void addProduct(Product product) {
		String query = "Insert into products (product_name, price, description, quantity, user_id, category_id, threshold_quantity) values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, product.getProdName());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getDescription());
			ps.setInt(4, product.getQuantity());
			ps.setInt(5, product.getUserId());
			ps.setInt(6, product.getCategoryId());
			ps.setInt(7, product.getThresholdQty());
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getAllProductsFromTable() {
		ResultSet rs = null;
		String query = "Select * from products";
		try{
			Statement st = connection.createStatement();
			rs = st.executeQuery(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getProductsBySeller(int userId){
		ResultSet rs = null;
		String query = "Select * from products where user_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void updateProduct(Product product) {
		String query = "Update products set product_name = ?, quantity= ?, description = ?, price = ?, threshold_quantity = ? where product_id = ? and user_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, product.getProdName());
			ps.setInt(2, product.getQuantity());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getThresholdQty());
			ps.setInt(6, product.getProdId());
			ps.setInt(7, product.getUserId());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(int prodId) {
		String query = "Delete from products where product_id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)){
			ps.setInt(1, prodId);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public Product getProduct(int productId) {
		Product product = null;
		String query = "Select * from products where product_id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)){
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				product = new Product(rs.getInt("user_id"), rs.getInt("category_id"), rs.getString("product_name"), rs.getDouble("price"),
						rs.getString("description"), rs.getInt("quantity"), rs.getInt("threshold_quantity"));
				product.setProdId(rs.getInt("product_id"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public ResultSet getProductsByCategory(int categoryId) {
		ResultSet rs = null;
		String query = "Select * from products where category_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}