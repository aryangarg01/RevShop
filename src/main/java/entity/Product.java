package entity;

public class Product {
	private int prodId;
	private int categoryId;
	private int userId;
	private String prodName;
	private double price;
	private String description;
	private int quantity;
	private int thresholdQty;
	private int discount;
	
	public Product(int userId, int categoryId, String prodName, double price, String description, int quantity, int thresholdQty, int discount) {
		this.setPrice(price);
		this.setProdName(prodName);
		this.setQuantity(quantity);
		this.setDescription(description);
		this.userId = userId;
		this.categoryId = categoryId;
		this.thresholdQty = thresholdQty;
		this.discount = discount;
	}
	
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getThresholdQty() {
		return thresholdQty;
	}

	public void setThresholdQty(int thresholdQty) {
		this.thresholdQty = thresholdQty;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
}
