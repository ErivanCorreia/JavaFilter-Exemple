package br.com.filter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.filter.entity.User;
import br.com.filter.repository.UserRepository;


@WebServlet("/UserUthorizedServlet")
public class UserAuthotizationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserRepository userRepository;
	
    public UserAuthotizationController() {
       this.userRepository = new UserRepository();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		HttpSession session = request.getSession(false);
//		
//		if(session != null) {
//			session.invalidate();
//		}
//		
//		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User userAutenticated = new User(username, password);
		
		User user =userRepository.findUser(userAutenticated);
		
		if( user != null) {
			
			request.getSession().setAttribute("user", user);
			
			request.getRequestDispatcher("ok.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
