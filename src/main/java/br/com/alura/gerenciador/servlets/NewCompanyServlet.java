package br.com.alura.gerenciador.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("nameCompany");
			Date opendate = format.parse(request.getParameter("openDate"));

			Company company = new Company();
			company.setName(name);
			company.setOpendate(opendate);

			DataBase database = new DataBase();

			database.add(company);
			
			response.sendRedirect("listCompanies");

		} catch (ParseException e) {
			throw new ServletException(e);
		}

	}

}
