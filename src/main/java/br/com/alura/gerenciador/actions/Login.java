package br.com.alura.gerenciador.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.db.DataBase;
import br.com.alura.gerenciador.domain.User;

public class Login implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		DataBase db = new DataBase();
		
		User user = db.existUser(login, password);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "redirect:control?action=ListCompanies";
		} else {
			return "redirect:control?action=LoginForm";
		}
	}

}
