package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.actions.GetCompany;
import br.com.alura.gerenciador.actions.ListCompanies;
import br.com.alura.gerenciador.actions.NewCompany;
import br.com.alura.gerenciador.actions.RemoveCompany;
import br.com.alura.gerenciador.actions.UpdateCompany;

@WebServlet("/control")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("listCompanies")) {
			ListCompanies actionListCompanies = new ListCompanies();
			actionListCompanies.execute(request, response);
		}else if(action.equals("getCompany")){
			GetCompany actionGetCompany = new GetCompany();
			actionGetCompany.execute(request, response);
		}else if(action.equals("removeCompany")){
			RemoveCompany actionRemoveCompany = new RemoveCompany();
			actionRemoveCompany.execute(request, response);
		}else if(action.equals("newCompany")) {
			NewCompany actionNewCompany = new NewCompany();
			actionNewCompany.execute(request, response);
		}else if(action.equals("updateCompany")) {
			UpdateCompany actionUpdateCompany = new UpdateCompany();
			actionUpdateCompany.execute(request, response);
		}
	}

}
