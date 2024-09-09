package service;

import dao.CartDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import dto.UserDTO;
import entity.Cart;
import entity.Product;
import exception.InvalidException;

public class CartService {
	CartDAO cartDAO;

	public CartService() {
		cartDAO = new CartDAO();
	}

	public void addToCart(UserDTO userDTO, int prodId, int quantity, ProductService prodService)
			throws InvalidException {
		Product prod = prodService.getSingleProductDetail(prodId);
		if (quantity > prod.getQuantity()) {
			throw new InvalidException("The quantity you entered is too high");
		}
		Cart cart = new Cart(userDTO.getUserId(), prodId, quantity);
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
}
