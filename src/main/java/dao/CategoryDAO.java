package dao;

import java.sql.*;
import java.util.*;
import entity.Category;
import exception.InvalidException;
import util.DatabaseConnection;

public class CategoryDAO {
	Connection connection;
	public CategoryDAO() {
		connection = DatabaseConnection.getInstance().getConnection();
	}
	
	public Category getIdByCategoryName(Category category) throws InvalidException{
		String query = "Select category_id from category where type = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, category.getCategoryType());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				category.setCategoryId(rs.getInt("category_id"));
			}
			else {
				throw new InvalidException("There is no category available");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public ArrayList<String> getAllCategory() {
		ArrayList<String> categories = new ArrayList<>();
		String query = "Select * from category";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				categories.add(rs.getString("type"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
}
