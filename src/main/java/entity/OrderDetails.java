package entity;

public class OrderDetails {
	private double amountPerUnit;
	private int orderId;
	private int productId;
	private int quantity;

	public OrderDetails(double amountPerUnit, int orderId, int productId, int quantity) {
		super();
		this.amountPerUnit = amountPerUnit;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public double getAmount() {
		return amountPerUnit;
	}
	
	public void setAmount(double amount) {
		this.amountPerUnit = amount;
	}
		
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
