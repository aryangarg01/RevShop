package entity;

public class Cart {
	private int cartId;
	private int buyerId;
	private int productId;
	private int quantity;

	public Cart(int buyerId, int productId, int quantity) {
		this.buyerId = buyerId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public String toString() {
		return "{BuyerId: " + this.buyerId + ", " + "ProductId: " + this.productId + ", " + "Quantity: " + this.quantity + "}";
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
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
