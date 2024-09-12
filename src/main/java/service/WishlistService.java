package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dao.WishlistDAO;
import dto.ProductDTO;


public class WishlistService {
	WishlistDAO wishlistDAO;
	
	CategoryService catService = new CategoryService();
	ProductService prodService = new  ProductService();
	
	public WishlistService() {
		wishlistDAO = new WishlistDAO();
	}
	
	public void addToWishlist(int buyerId, int productId) {
		System.out.println("Service Method");
		wishlistDAO.addProductToWishlist(buyerId, productId);
	}
	
	public void deleteFromWishlist(int prodId, int userId) {
		wishlistDAO.removeProductFromWishlist(prodId, userId);
	}
	
	public List<ProductDTO> getProductsFromWishlist(int userId){
		List<ProductDTO> products = new ArrayList<>();
		ResultSet rs = wishlistDAO.getAllProducts(userId);
		try {
			while(rs.next()) {
				int productId = rs.getInt("product_id");
				ProductDTO product = prodService.getSingleProductDetail(productId);
				String type = catService.getCategoryType(product.getCategoryId());
				product.setCategoryType(type);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}
