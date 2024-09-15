package service;

import java.util.*;
import java.sql.*;
import dao.ProductDAO;
import dto.ProductDTO;
import entity.Product;

public class ProductService {
	ProductDAO productDAO;

	public ProductService() {
		productDAO = new ProductDAO();
	}

	public void addProductToDB(Product product) {
		productDAO.addProduct(product);
	}

	CategoryService catService = new CategoryService();
	public List<ProductDTO> getAllProducts(int userId) {
		List<ProductDTO> allProducts = new ArrayList<>();
		ResultSet rs = productDAO.getProductsBySeller(userId);
		try {
			while (rs.next()) {
				ProductDTO product = new ProductDTO(rs.getInt("product_id"), rs.getInt("category_id"),
						rs.getString("product_name"), rs.getDouble("price"), rs.getString("description"),
						rs.getInt("quantity"), rs.getInt("threshold_quantity"), rs.getInt("discount"), rs.getString("img_url"));
				String type = catService.getCategoryType(rs.getInt("category_id"));
				product.setCategoryType(type);
				allProducts.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allProducts;
	}

	public void updateProduct(ProductDTO product) {
		productDAO.updateProduct(product);
	}

	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);
	}

	public ProductDTO getSingleProductDetail(int productId) {
		ProductDTO product = productDAO.getProduct(productId);
		String category = catService.getCategoryType(product.getCategoryId());
		product.setCategoryType(category);
		return product;
	}

	public List<ProductDTO> getAllProductsForCustomers() {
		List<ProductDTO> allProducts = new ArrayList<>();
		ResultSet rs1 = productDAO.getAllProductsFromTable();
		try {
			while (rs1.next()) {
				ProductDTO product = new ProductDTO(rs1.getInt("product_id"), rs1.getInt("category_id"),
						rs1.getString("product_name"), rs1.getDouble("price"), rs1.getString("description"),
						rs1.getInt("quantity"), rs1.getInt("threshold_quantity"), rs1.getInt("discount"), rs1.getString("img_url"));
				String type = catService.getCategoryType(rs1.getInt("category_id"));
				product.setCategoryType(type);
				allProducts.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allProducts;
	}

	public List<ProductDTO> filterProducts(int categoryId) {
		List<ProductDTO> allProductsByCategory = new ArrayList<>();
		ResultSet rs = productDAO.getProductsByCategory(categoryId);
		try {
			while (rs.next()) {
				allProductsByCategory.add(new ProductDTO(rs.getInt("product_id"), rs.getInt("category_id"),
						rs.getString("product_name"), rs.getDouble("price"), rs.getString("description"),
						rs.getInt("quantity"), rs.getInt("threshold_quantity"), rs.getInt("discount"), rs.getString("img_url")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allProductsByCategory;
	}
}
