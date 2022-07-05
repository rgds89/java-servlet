package br.com.alura.gerenciador.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;
import br.com.alura.gerenciador.domain.Company;

public class NewCompany {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("nameCompany");
			Date openDate = format.parse(request.getParameter("openDate"));

			Company company = new Company();
			company.setName(name);
			company.setOpenDate(openDate);

			DataBase database = new DataBase();

			database.add(company);

			return "redirect:control?action=listCompanies";

		} catch (ParseException e) {
			throw new ServletException(e);
		}
	}

}
