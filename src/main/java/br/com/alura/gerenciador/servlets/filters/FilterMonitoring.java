package br.com.alura.gerenciador.servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/control")
public class FilterMonitoring implements Filter {

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
