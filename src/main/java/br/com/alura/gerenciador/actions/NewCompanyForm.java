package br.com.alura.gerenciador.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCompanyForm {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		return "forward:/formNewCompany.jsp";
	}

}
