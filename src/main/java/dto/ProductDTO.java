package dto;

import java.util.*;

import service.CategoryService;

public class ProductDTO {
	private int prodId;
	private String prodName;
	private double price;
	private String description;
	private int quantity;
	private int categoryId;
	private int thresholdQty;
	private String categoryType;
	private int discount;
	private String imgUrl;
	
	public ProductDTO(int prodId, int categoryId, String prodName, double price, String description, int quantity, int thresholdQty, int discount, String imgUrl) {
		this.categoryId = categoryId;
		this.price = price;
		this.prodName = prodName;
		this.quantity= quantity;
		this.description = description;
		this.prodId = prodId;
		this.thresholdQty = thresholdQty;
		this.discount = discount;
		this.setImgUrl(imgUrl);
	}
		
	ArrayList<String> list = new ArrayList<>();
	public void func() {
		CategoryService catService = new CategoryService();
		list = catService.getCategories();
	}
		
	public String toString() {
		func();
		return "{ProductId: " + this.prodId + ", " + "Product Name: " + this.prodName + ", " + "Description: " + this.description + ", " + "Quantity: " + this.quantity + ", " + 
	"Price: " + this.price + ", " + "Category: " + list.get(this.categoryId-1) + "}"; 
	}
	
	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
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

	public int getThresholdQty() {
		return thresholdQty;
	}

	public void setThresholdQty(int thresholdQty) {
		this.thresholdQty = thresholdQty;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
