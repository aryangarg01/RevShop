package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUserID", userDTO.getUserId());
			if(userDTO.getRole() == 1) {
				response.sendRedirect("/rev_shop_demo/api/v1/user");
			}else if(userDTO.getRole() == 2){
				response.sendRedirect("/rev_shop_demo/api/v1/seller");
			}
		} catch (UserNotException e) {
			e.printStackTrace();
		}
	}

}
