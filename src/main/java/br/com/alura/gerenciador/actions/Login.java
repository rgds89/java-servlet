package br.com.alura.gerenciador.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;

public class Login implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		DataBase db = new DataBase();

		if (db.existUser(login, password)) {
			return "redirect:control?action=ListCompanies";
		} else {
			return "redirect:control?action=LoginForm";
		}
	}

}
