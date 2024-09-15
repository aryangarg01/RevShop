package dao;

import util.DatabaseConnection;
import java.sql.*;

public class BankDAO {
	Connection connection;
	
	public BankDAO() {
		connection = DatabaseConnection.getInstance().getConnection();
	}
	
	public void addBankDetails(long accountNumber, String accountHolder, int cvv, int userId) {
		String query = "insert into bankaccount (account_number, account_holder, cvv, user_id) values(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, accountNumber);
			ps.setString(2, accountHolder);
			ps.setInt(3, cvv);
			ps.setInt(4, userId);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAccount(long accountNumber) {
		String query = "Delete from bankaccount where accountNumber = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, accountNumber);
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getTransactionId(long accountNumber) {
		int transactionId = 0;
		String query = "Select transaction_id from bankaccount where account_number = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				transactionId = rs.getInt("transaction_id");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return transactionId;
	}
}
