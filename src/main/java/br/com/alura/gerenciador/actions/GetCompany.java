package br.com.alura.gerenciador.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;
import br.com.alura.gerenciador.domain.Company;

public class GetCompany {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		DataBase database = new DataBase();
		Company company = database.getCompanyById(id);		
		request.setAttribute("company", company);		
		return "forward:/updateCompany.jsp";
	}
}
