package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Auth;

import java.io.IOException;

import dto.UserDTO;
import exception.UserNotException;

public class Login extends HttpServlet {
	Auth auth = new Auth();
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			UserDTO userDTO = auth.login(email, password);
			System.out.println(userDTO.getUserId() + " " + userDTO.getRole());	
			if(userDTO.getRole() == 1) {
				response.sendRedirect("/api/v1/buyer");
			}else if(userDTO.getRole() == 2){
				response.sendRedirect("/api/v1/seller");
			}
		} catch (UserNotException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
