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
	
	public ProductDTO(int prodId, int categoryId, String prodName, double price, String description, int quantity) {
		this.categoryId = categoryId;
		this.price = price;
		this.prodName = prodName;
		this.quantity= quantity;
		this.description = description;
		this.prodId = prodId;
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
}
