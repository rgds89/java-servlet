package br.com.alura.gerenciador.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<ul>");
		for (Company company : companies) {
			out.println("<li>" + company.getName() + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
	}

}
