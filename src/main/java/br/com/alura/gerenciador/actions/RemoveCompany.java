package br.com.alura.gerenciador.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;

public class RemoveCompany implements Action{
	private long id;
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase databse = new DataBase();

		id = Long.valueOf(request.getParameter("id"));

		databse.removeCompany(id);

		return "redirect:control?action=ListCompanies";
	}

}
