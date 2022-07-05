package br.com.alura.gerenciador.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.db.DataBase;

public class RemoveCompany {
	private long id;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DataBase databse = new DataBase();

		id = Long.valueOf(request.getParameter("id"));

		databse.removeCompany(id);

		response.sendRedirect("control?action=listCompanies");
	}

}
