package br.com.alura.gerenciador.servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(urlPatterns = "/control")
public class FilterMonitoring implements Filter {
	private static final long serialVersionUID = 1L;
	
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
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Long before = System.currentTimeMillis();
		
		//Action execution
		chain.doFilter(request, response);
		
		Long after = System.currentTimeMillis();
		
		System.out.println("Tempo de execução:" + (after - before));
		
		
	}

}
