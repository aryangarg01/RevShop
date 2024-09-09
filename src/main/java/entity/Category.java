package entity;

public class Category {
	private int categoryId;
	private String categoryType;
	
	public Category(String categoryType) {
		this.setCategoryType(categoryType);
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	

}
