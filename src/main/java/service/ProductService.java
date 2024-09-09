package service;

import java.util.*;
import java.sql.*;
import dao.ProductDAO;
import dto.ProductDTO;
import dto.UserDTO;
import entity.Product;

public class ProductService {
	ProductDAO productDAO;

	public ProductService() {
		productDAO = new ProductDAO();
	}

	public void addProductToDB(Product product) {
		productDAO.addProduct(product);
	}

	public List<ProductDTO> getAllProducts(UserDTO userDTO) {
		int userId = userDTO.getUserId();
		List<ProductDTO> allProducts = new ArrayList<>();
		ResultSet rs = productDAO.getProductsBySeller(userId);
		try {
			while (rs.next()) {
				allProducts.add(
						new ProductDTO(rs.getInt("product_id"), rs.getInt("category_id"), rs.getString("product_name"), rs.getDouble("price"), rs.getString("description"), rs.getInt("quantity")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allProducts;
	}
	
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}
	
	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);
	}
	
	public Product getSingleProductDetail(int productId) {
		return productDAO.getProduct(productId);
	}
	
	public List<ProductDTO> getAllProductsForCustomers() {
		List<ProductDTO> allProducts = new ArrayList<>();
		ResultSet rs1 = productDAO.getAllProductsFromTable();
		try {
			while(rs1.next()) {
				allProducts.add(
						new ProductDTO(rs1.getInt("product_id"), rs1.getInt("category_id"), rs1.getString("product_name"), rs1.getDouble("price"), rs1.getString("description"), rs1.getInt("quantity")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allProducts;
	}
	
	public List<ProductDTO> filterProducts(int categoryId){
		List<ProductDTO> allProductsByCategory = new ArrayList<>();
		ResultSet rs = productDAO.getProductsByCategory(categoryId);
		try {
			while (rs.next()) {
				allProductsByCategory.add(
						new ProductDTO(rs.getInt("product_id"), rs.getInt("category_id"), rs.getString("product_name"), rs.getDouble("price"), rs.getString("description"), rs.getInt("quantity")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allProductsByCategory;
	}
}
