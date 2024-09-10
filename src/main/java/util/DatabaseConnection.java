package util;
import java.sql.*;

public class DatabaseConnection {
	private static DatabaseConnection instance = null;
	private static Connection connection = null;

	private DatabaseConnection() {
		String url = "jdbc:mysql://localhost:3306/rev_shop";
		String user = "root";
		String password = "Aryan@123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static DatabaseConnection getInstance() {
		if(instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}
}
