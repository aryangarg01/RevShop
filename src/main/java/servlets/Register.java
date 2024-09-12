package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Auth;

import java.io.IOException;

import entity.User;
import exception.InvalidException;

public class Register extends HttpServlet {
	Auth auth = new Auth();
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int role = Integer.parseInt(request.getParameter("role"));
		
		
		if(firstName == "" && lastName == "" && role == 0 && contact.length() != 10 && password.length() < 8) {
			System.out.println("Invalid Inputs");			
		}else {
			try {
			User user = new User(firstName, middleName, lastName, email, password, contact, address, city, state, role);
			auth.registerBuyer(user);
			response.sendRedirect("/rev_shop_demo/api/v1/login");
			} catch (InvalidException e) {
				e.printStackTrace();
			}
		}
	}
}
