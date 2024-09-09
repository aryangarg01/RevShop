package entity;

public class Wishlist {
	private int buyer_id;
	private int product_id;
	
	public Wishlist(int buyer_id, int product_id) {
		this.setProductId(product_id);
		this.setBuyerId(buyer_id);
	}

	public int getBuyerId() {
		return buyer_id;
	}

	public void setBuyerId(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public int getProductId() {
		return product_id;
	}

	public void setProductId(int product_id) {
		this.product_id = product_id;
	}
}
