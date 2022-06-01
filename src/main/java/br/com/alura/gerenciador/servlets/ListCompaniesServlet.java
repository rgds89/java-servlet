package br.com.alura.gerenciador.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;
import br.com.alura.gerenciador.domain.Company;

@WebServlet("/listCompanies")
public class ListCompaniesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataBase dataBase = new DataBase();
		List<Company> companies = dataBase.getCompanies();
		request.setAttribute("companies", companies);
		RequestDispatcher rd = request.getRequestDispatcher("/listCompanies.jsp");
		rd.forward(request, response);
		
	}

}
