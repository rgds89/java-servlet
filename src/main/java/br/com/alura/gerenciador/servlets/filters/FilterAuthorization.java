package br.com.alura.gerenciador.servlets.filters;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterAuthorization
 */
@WebFilter("/control")
public class FilterAuthorization extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean itsAProtectedAction = !(action.equals("Login") || action.equals("LoginForm"));

		if (action == null)
			throw new ServletException("Null action");

		if(itsAProtectedAction && session.getAttribute("user") == null) {
			response.sendRedirect("control?action=LoginForm");
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}



}
