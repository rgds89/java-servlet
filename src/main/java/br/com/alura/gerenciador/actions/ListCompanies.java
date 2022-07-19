package br.com.alura.gerenciador.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.db.DataBase;
import br.com.alura.gerenciador.domain.Company;

public class ListCompanies implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//
//		if (session.getAttribute("user") == null) {
//			return "redirect:control?action=LoginForm";
//		} else {
			DataBase dataBase = new DataBase();
			List<Company> companies = dataBase.getCompanies();
			request.setAttribute("companies", companies);
			return "forward:/listCompanies.jsp";
//		}
	}

}
