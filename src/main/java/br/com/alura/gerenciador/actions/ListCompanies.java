package br.com.alura.gerenciador.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;
import br.com.alura.gerenciador.domain.Company;

public class ListCompanies {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase dataBase = new DataBase();
		List<Company> companies = dataBase.getCompanies();
		request.setAttribute("companies", companies);
		return "forward:/listCompanies.jsp";
	}

}
