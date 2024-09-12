package service;

import dao.CartDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import dto.ProductDTO;
import dto.UserDTO;
import entity.Cart;
import exception.InvalidException;

public class CartService {
	CartDAO cartDAO;
	ProductService prodService = new ProductService();
	CategoryService catService = new CategoryService();
	
	public CartService() {
		cartDAO = new CartDAO();
	}

	public void addToCart(int userId, int prodId, int quantity)
			throws InvalidException {
		ProductDTO prod = prodService.getSingleProductDetail(prodId);
		if (quantity > prod.getQuantity()) {
			throw new InvalidException("The quantity you entered is too high");
		}
		Cart cart = new Cart(userId, prodId, quantity);
		cartDAO.addProductToCart(cart);
	}

	public void removeProduct(int productId) {
		cartDAO.deleteProductFromCart(productId);
	}

	public List<Cart> viewCart(UserDTO userDTO) throws InvalidException {
		List<Cart> list = new ArrayList<>();
		ResultSet rs = cartDAO.getAllProductsFromCart(userDTO.getUserId());
		if (rs == null) {
			throw new InvalidException("Invalid user");
		}
		try {
			while (rs.next()) {
				list.add(new Cart(rs.getInt("buyer_id"), rs.getInt("product_id"), rs.getInt("quantity")));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ProductDTO> getProductFromCart(int userId){
		List<ProductDTO> products = new ArrayList<>();
		ResultSet rs = cartDAO.getAllProductsFromCart(userId);
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
