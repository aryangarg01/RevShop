package entity;

public class Order {
	private int order_id;
	private int buyer_id;
	private int transaction_id;
	private String order_date;
	private double total_price;
	private String shipping_status;
	
	public Order(int buyer_id, int transaction_id, String order_date, double total_price, String shipping_status) {
		this.buyer_id = buyer_id;
		this.transaction_id = transaction_id;
		this.order_date = order_date;
		this.total_price = total_price;
		this.shipping_status = shipping_status;
	}
	
	public int getOrderId() {
		return order_id;
	}
	
	public void setOrderId(int order_id) {
		this.order_id = order_id;
	}
	public int getBuyerId() {
		return buyer_id;
	}
	
	public void setBuyerId(int buyer_id) {
		this.buyer_id = buyer_id;
	}
	
	public int getTransactionId() {
		return transaction_id;
	}
	
	public void setTransactionId(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	public String getOrderDate() {
		return order_date;
	}
	
	public void setOrderDate(String order_date) {
		this.order_date = order_date;
	}
	
	public double getTotalPrice() {
		return total_price;
	}
	
	public void setTotalPrice(double total_price) {
		this.total_price = total_price;
	}
	
	public String getShippingStatus() {
		return shipping_status;
	}
	
	public void setShippingStatus(String shipping_status) {
		this.shipping_status = shipping_status;
	}
	
}
