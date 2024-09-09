package service;

import java.util.*;

import dao.CategoryDAO;
import entity.Category;
import exception.InvalidException;

public class CategoryService {
	CategoryDAO categoryDAO;
	public CategoryService() {
		categoryDAO = new CategoryDAO();
	}
	
	public Category getDetails(Category category) throws InvalidException {
		Category categoryDetails = categoryDAO.getIdByCategoryName(category);
		if(categoryDetails == null) {
			throw new InvalidException("Invalid Category");
		}
		return categoryDetails;
	}
	
	public ArrayList<String> getCategories() {
		return categoryDAO.getAllCategory();
	}
}
