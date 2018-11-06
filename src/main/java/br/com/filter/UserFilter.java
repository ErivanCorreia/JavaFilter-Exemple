package br.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.filter.entity.User;

@WebFilter("/*")
public class UserFilter implements Filter {

   
    public UserFilter() {
   
    }

	
	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		HttpSession session = httpServletRequest.getSession();
		
		User user = (User) session.getAttribute("user");
		session.setMaxInactiveInterval(30);
				
		if(!session.isNew() || user != null) {
			
			chain.doFilter(request, response);
		}else {
			httpServletResponse.sendRedirect("login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}

}
