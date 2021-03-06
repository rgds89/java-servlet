package br.com.alura.gerenciador.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;
import br.com.alura.gerenciador.domain.Company;

public class UpdateCompany implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Long id = Long.valueOf(request.getParameter("id"));
			String name = request.getParameter("nameCompany");
			Date openDate = format.parse(request.getParameter("openDate"));
			
			DataBase dataBase = new DataBase();
			Company company = dataBase.getCompanyById(id);
			company.setName(name);
			company.setOpenDate(openDate);
			
			return "redirect:control?action=ListCompanies";
			
		} catch (ParseException e) {
			throw new ServletException(e);
		}
	}

}
