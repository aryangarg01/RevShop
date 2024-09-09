package service;

import dao.UserDAO;
import entity.User;
import exception.InvalidException;
import exception.UserNotException;
import dto.UserDTO;

public class Auth {
	private UserDAO userDAO;
	public Auth() {
		userDAO = new UserDAO();
	}
	
	public void registerBuyer(User user) throws InvalidException{
		if(user.getContact().length() != 10 || user.getPassword().length() < 8) {
			throw new InvalidException("The contact number you entered is not valid");
		}
		userDAO.addUser(user);	
	}
	
	public UserDTO login(String email, String password) throws UserNotException{
		User user = userDAO.getUserByEmail(email);
		if(user == null || !user.getPassword().equals(password)) {
			throw new UserNotException("Wrong email/password");
		}
		return new UserDTO(user.getUserId(), user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getEmail(), user.getContact(), user.getAddress(), user.getCity(), user.getState(), user.getRole());
	}
}
