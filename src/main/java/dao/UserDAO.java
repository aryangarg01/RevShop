package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.User;
import util.DatabaseConnection;

public class UserDAO {
	private Connection connection;

	public UserDAO() {
		connection = DatabaseConnection.getInstance().getConnection();
	}

	public void addUser(User user) {
		String query = "Insert into users (first_name, middle_name, last_name, email, password, contact, address, city, state, role) values (?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getMiddleName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getContact());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getCity());
			ps.setString(9, user.getState());
			ps.setInt(10, user.getRole());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getUserByEmail(String email) {
		User user = null;
		String query = "Select * from users where email = ?";
		try{
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User(
						rs.getString("first_name"),
						rs.getString("middle_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("contact"),
						rs.getString("address"),
						rs.getString("city"),
						rs.getString("state"),
						rs.getInt("role"));
				user.setUserId(rs.getInt("user_id"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
