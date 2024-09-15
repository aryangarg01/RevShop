package entity;

public class BankAccount {
	private int transactionId;
	private long accountNumber;
	private int cvv;
	private String holderName;
	private int userId;
	
	public BankAccount(int transactionId, long accountNumber, int cvv, String holderName, int userId) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.cvv = cvv;
		this.holderName = holderName;
		this.setUserId(userId);
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
