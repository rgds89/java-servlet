package br.com.alura.gerenciador.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;


@WebServlet("/removeCompany")
public class RemoveCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private long id;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase databse = new DataBase();
		
		id = Long.valueOf(request.getParameter("id"));
		
		databse.removeCompany(id);
		
		response.sendRedirect("listCompanies");
		
	}

}
