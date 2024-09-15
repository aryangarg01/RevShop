package service;

import dao.BankDAO;

public class BankService {
	BankDAO bankDAO;

	public BankService() {
		bankDAO = new BankDAO();
	}
	
	public void addBankDetails(long accountNumber, String accountHolder, int cvv, int userId) {
		bankDAO.addBankDetails(accountNumber, accountHolder, cvv, userId);
	}
	
	public void deleteBankDetails(long accountNumber) {
		bankDAO.deleteAccount(accountNumber);
	}
	
	public int getTransactionId(long accountNumber) {
		return bankDAO.getTransactionId(accountNumber);
	}
}
