package br.com.alura.gerenciador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;
import br.com.alura.gerenciador.domain.Company;

@WebServlet("/newCompany")
public class NewCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("nameCompany");
		Company company = new Company();
		company.setName(name);
		
		DataBase database = new DataBase();
		
		database.add(company);
		
		RequestDispatcher rd = request.getRequestDispatcher("/newCompany.jsp");
		request.setAttribute("nameCompany", company.getName());
		rd.forward(request, response);
	}

}
