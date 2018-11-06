package br.com.filter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.filter.entity.User;
import br.com.filter.repository.UserRepository;

@WebServlet("/UserServlet")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserRepository userRepository;
    
    public UserController() {
       this.userRepository = new UserRepository();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username, password);
		
		userRepository.save(user);
		
		User user2 = userRepository.findUser(user);
		if(user2 != null) {
			System.out.println(" "+user2.getUsername()+"\n"+user2.getPassword());
		}
		
		response.sendRedirect("register-user.jsp");
		
	}

}
