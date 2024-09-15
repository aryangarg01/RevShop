package Main;

//import java.util.*;
//
//import dto.ProductDTO;
//import dto.UserDTO;
//import entity.Cart;
//import entity.Category;
//import entity.Product;
//import entity.User;
//import exception.InvalidException;
//import exception.UserNotException;
//import service.Auth;
//import service.CartService;
//import service.CategoryService;
//import service.ProductService;
//import service.WishlistService;

public class Main {

//	static ProductService prodService = new ProductService();
//	static CategoryService catService = new CategoryService();
//	static CartService cartService = new CartService();
//	static WishlistService wishlistService = new WishlistService();

	public static void main(String[] args) {
		System.out.println("Hello");
	}
//		Auth auth = new Auth();
//		Scanner sc = new Scanner(System.in);
//		while (true) {
//			System.out.println("1.Register" + " " + "2.Login" + " " + "3.Exit");
//
//			int num = sc.nextInt();
//			switch (num) {
//			case 1:
//				System.out.println("Enter the First Name");
//				String first_name = sc.next();
//
//				System.out.println("Enter the Middle Name");
//				String middle_name = sc.next();
//
//				System.out.println("Enter the Last Name");
//				String last_name = sc.next();
//
//				System.out.println("Enter the Email");
//				String email = sc.next();
//
//				System.out.println("Enter the Password");
//				String password = sc.next();
//
//				System.out.println("Enter the Contact Number");
//				String contact = sc.next();
//
//				System.out.println("Enter the Address");
//				String address = sc.next();
//
//				System.out.println("Enter the City");
//				String city = sc.next();
//
//				System.out.println("Enter the State");
//				String state = sc.next();
//
//				System.out.println("Press 1. Buyer or Press 2. Seller");
//				int role = sc.nextInt();
//
//				User user = new User(first_name, middle_name, last_name, email, password, contact, address, city, state,
//						role);
//				try {
//					auth.registerBuyer(user);
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//				System.out.println("Successfully Registered");
//				break;
//
//			case 2:
//				System.out.println("Enter the Email");
//				String loginEmail = sc.next();
//
//				System.out.println("Enter the Password");
//				String loginPassword = sc.next();
//				try {
//					UserDTO userDTO = auth.login(loginEmail, loginPassword);
//					if (userDTO.getRole() == 2) {
//						loggedInSeller(userDTO, sc);
//					} else {
//						loggedInCustomer(userDTO, sc);
//					}
//				} catch (UserNotException e) {
//					System.out.println(e.getMessage());
//				}
//				break;
//
//			case 3:
//				System.out.println("Exiting...");
//				sc.close();
//				System.exit(0);
//				break;
//			}
//		}
//	}
//
//	public static void loggedInSeller(UserDTO userDTO, Scanner sc) {
//		System.out.println("Logged in as seller");
//		while (true) {
//			System.out.println("1.Add the product" + " " + "2.Edit the product" + " " + "3.Delete the product" + " "
//					+ "4.Get the products" + " " + "5.Exit");
//			int choice = sc.nextInt();
//
//			switch (choice) {
//			case 1:
//				System.out.println("Enter the category Name for the product you want to add");
//				ArrayList<String> allCategories = catService.getCategories();
//				for (int i = 0; i < allCategories.size(); i++) {
//					System.out.print(i + 1 + "." + allCategories.get(i) + " ");
//				}
//				System.out.println();
//
//				String categoryType = sc.next();
//
//				Category category = new Category(categoryType);
//				try {
//					catService.getDetails(category);
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//
//				System.out.println("Enter the Product Name");
//				String prodName = sc.next();
//
//				System.out.println("Enter the price");
//				double price = sc.nextDouble();
//
//				System.out.println("Enter the description");
//				String description = sc.next();
//
//				System.out.println("Enter the quantity");
//				int quantity = sc.nextInt();
//
//				System.out.println("Enter the threshold quantity");
//				int thresholdQty = sc.nextInt();
//
//				AddToProduct(userDTO, category, prodName, price, description, quantity, thresholdQty);
//				break;
//
//			case 2:
//				getProducts(userDTO);
//				System.out.println("Enter the id of the product you want to edit");
//				int productId = sc.nextInt();
//
//				Product product = prodService.getSingleProductDetail(productId);
//
//				System.out.println("Enter the Product Name");
//				String prod_name = sc.next();
//
//				System.out.println("Enter the price");
//				double prod_price = sc.nextDouble();
//
//				System.out.println("Enter the description");
//				String prod_description = sc.next();
//
//				System.out.println("Enter the quantity");
//				int prod_quantity = sc.nextInt();
//
//				System.out.println("Enter the threshold quantity");
//				int threshold_qty = sc.nextInt();
//
//				editProduct(product, prod_name, prod_price, prod_description, prod_quantity, threshold_qty);
//				break;
//
//			case 3:
//				getProducts(userDTO);
//				System.out.println("Enter the id of the product you want to delete");
//
//				int product_id = sc.nextInt();
//				deleteProduct(product_id);
//				break;
//
//			case 4:
//				getProducts(userDTO);
//				break;
//
//			case 5:
//				System.out.println("Exiting....");
//				return;
//			}
//		}
//	}
//
//	public static void AddToProduct(UserDTO userDTO, Category category, String prodName, double price,
//			String description, int quantity, int thresholdQty) {
//		Product prod = new Product(userDTO.getUserId(), category.getCategoryId(), prodName, price, description,
//				quantity, thresholdQty, 100);
//		prodService.addProductToDB(prod);
//	}
//
//	public static List<ProductDTO> getProducts(UserDTO userDTO) {
//		List<ProductDTO> list = prodService.getAllProducts(userDTO.getUserId());
//		for (ProductDTO i : list) {
//			System.out.println(i);
//		}
//		return list;
//	}
//
//	public static void editProduct(Product product, String prodName, double price, String description, int quantity,
//			int thresholdQty) {
//		Product product1 = new Product(product.getUserId(), product.getCategoryId(), prodName, price, description,
//				quantity, thresholdQty, 100);
//		product1.setProdId(product.getProdId());
//		prodService.updateProduct(product1);
//	}
//
//	public static void deleteProduct(int product_id) {
//		prodService.deleteProduct(product_id);
//	}
//
//	public static void loggedInCustomer(UserDTO userDTO, Scanner sc) {
//		System.out.println("Logged in as customer");
//		System.out.println("1. View all the Products");
//		System.out.println("2. Browse Product By Category");
//
//		int input = sc.nextInt();
//		switch (input) {
//		case 1:
//			viewAllProducts();
//
//			System.out.println("Enter the opeation number to perform");
//			System.out.println("1. Cart" + " " + "2. Wishlist");
//
//			int num = sc.nextInt();
//			switch (num) {
//			case 1:
//				manageCart(userDTO, prodService, sc);
//				break;
//			case 2:
//				manageWishlist(userDTO, sc);
//				break;
//			}
//			break;
//
//		case 2:
//			ArrayList<String> allCategories = catService.getCategories();
//			for (int i = 0; i < allCategories.size(); i++) {
//				System.out.print(i + 1 + "." + allCategories.get(i) + " ");
//			}
//			System.out.println();
//			System.out.println("Enter the Category Name");
//			String catType = sc.next();
//			try {
//				getProductsByCategory(catType);
//				manageCart(userDTO, prodService, sc);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			break;
//		}
//	}
//
//	public static void viewAllProducts() {
//		List<ProductDTO> allProductsForCustomers = prodService.getAllProductsForCustomers();
//		for (ProductDTO i : allProductsForCustomers) {
//			System.out.println(i);
//		}
//	}
//
//	public static void getProductsByCategory(String catType) throws InvalidException {
//		Category category = new Category(catType);
//		Category category1 = catService.getDetails(category);
//		List<ProductDTO> filterByCategory = prodService.filterProducts(category1.getCategoryId());
//		for (ProductDTO i : filterByCategory) {
//			System.out.println(i);
//		}
//	}
//
//	public static void manageCart(UserDTO userDTO, ProductService prodService, Scanner sc) {
//		while (true) {
//			System.out.println("1. View the cart");
//			System.out.println("2. Add the product to cart");
//			System.out.println("3. Remove the product from cart");
//
//			int input = sc.nextInt();
//			switch (input) {
//			case 1:
//				viewCart(userDTO);
//				break;
//
//			case 2:
//				System.out.println("Enter the product id you want to add to cart");
//				int prodId = sc.nextInt();
//
//				System.out.println("Enter the quantity you want to add in the cart");
//				int quant = sc.nextInt();
//				addToCart(userDTO, prodId, quant, prodService);
//				break;
//
//			case 3:
//				System.out.println("Enter the product id you want to add to cart");
//				int prod_id = sc.nextInt();
//
//				deleteFromCart(prod_id);
//				break;
//			}
//		}
//	}
//
//	public static void viewCart(UserDTO userDTO) {
//		List<Cart> cartList = new ArrayList<>();
//		try {
//			cartList = cartService.viewCart(userDTO);
//		} catch (InvalidException e) {
//			e.printStackTrace();
//		}
//		for (Cart i : cartList) {
//			System.out.println(i);
//		}
//	}
//
//	public static void addToCart(UserDTO userDTO, int prodId, int quantity, ProductService prodService) {
//		try {
//			cartService.addToCart(userDTO, prodId, quantity, prodService);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	public static void deleteFromCart(int prodId) {
//		cartService.removeProduct(prodId);
//	}
//
//	public static void manageWishlist(UserDTO userDTO, Scanner sc) {
//		System.out.println("1.Add To Wishlist");
//		System.out.println("2.Remove From Wishlist");
//		int choice = sc.nextInt();
//		System.out.println("Enter the product id to add the product to favorites");
//		int productId = sc.nextInt();
//		switch (choice) {
//		case 1:
//			addWishlist(userDTO, productId);
//			
//		case 2:
//			removeProductFromWishlist(productId);
//		}
//	}
//
//	public static void addWishlist(UserDTO userDTO, int productId) {
//		wishlistService.addToWishlist(userDTO, productId);
//		System.out.println("Main Method called");
//	}
//
//	public static void removeProductFromWishlist(int prodId) {
//		wishlistService.deleteFromWishlist(prodId);
//	}
}
