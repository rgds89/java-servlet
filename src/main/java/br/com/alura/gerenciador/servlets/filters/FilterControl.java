package br.com.alura.gerenciador.servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.actions.Action;

//@WebFilter("/control")
public class FilterControl implements Filter {

	private static final long serialVersionUID = 1L;
	private static String PATH_JSP = "WEB-INF/views";
	private static String PATH_CLASS = "br.com.alura.gerenciador.actions.";
	private String action;
	private String regress;
	private String form;
	private String type;
	private String[] parts;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@SuppressWarnings("unused")
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterControl");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		try {
			action = request.getParameter("action");

			String nameClass = PATH_CLASS + action;
			Class typeClass = Class.forName(nameClass);
			Action actions = (Action) typeClass.newInstance();
			regress = actions.execute(request, response);

			parts = regress.split(":");
			type = parts[0];
			form = parts[1];
			if (type.equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher(PATH_JSP + form);
				rd.forward(request, response);
			} else {
				response.sendRedirect(form);
			}
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		} catch (InstantiationException e) {
			throw new ServletException(e);
		} catch (IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
}
