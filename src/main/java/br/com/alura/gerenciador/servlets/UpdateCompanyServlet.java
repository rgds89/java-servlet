package br.com.alura.gerenciador.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;
import br.com.alura.gerenciador.domain.Company;



@WebServlet("/updateCompany")
public class UpdateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Long id = Long.valueOf(request.getParameter("id"));
			String name = request.getParameter("nameCompany");
			Date openDate = format.parse(request.getParameter("openDate"));
			
			DataBase dataBase = new DataBase();
			Company company = dataBase.getCompanyById(id);
			company.setName(name);
			company.setOpenDate(openDate);
			response.sendRedirect("listCompanies");
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
	}

}
