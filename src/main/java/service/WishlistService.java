package service;

import dao.WishlistDAO;
import dto.UserDTO;

public class WishlistService {
	WishlistDAO wishlistDAO;
	
	public WishlistService() {
		wishlistDAO = new WishlistDAO();
	}
	
	public void addToWishlist(UserDTO userDTO, int productId) {
		int buyerId = userDTO.getUserId();
		System.out.println("Service Method");
		wishlistDAO.addProductToWishlist(buyerId, productId);
	}
	
	public void deleteFromWishlist(int prodId) {
		wishlistDAO.removeProductFromWishlist(prodId);
	}
}
