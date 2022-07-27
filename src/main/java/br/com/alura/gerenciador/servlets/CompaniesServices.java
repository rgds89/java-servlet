package br.com.alura.gerenciador.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.alura.gerenciador.domain.Company;
import br.com.alura.gerenciador.db.DataBase;

@WebServlet("/companies")
public class CompaniesServices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Company> companies = new DataBase().getCompanies();
		
		Gson gson = new Gson();
		String json = gson.toJson(companies);
		
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

}
