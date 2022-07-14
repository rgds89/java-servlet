package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.actions.Action;
import br.com.alura.gerenciador.actions.GetCompany;
import br.com.alura.gerenciador.actions.ListCompanies;
import br.com.alura.gerenciador.actions.NewCompany;
import br.com.alura.gerenciador.actions.NewCompanyForm;
import br.com.alura.gerenciador.actions.RemoveCompany;
import br.com.alura.gerenciador.actions.UpdateCompany;

@WebServlet("/control")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String PATH_JSP = "WEB-INF/views";
	private static String PATH_CLASS = "br.com.alura.gerenciador.actions.";
	private String action;
	private String regress;
	private String form;
	private String type;
	private String[] parts;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		action = request.getParameter("action");

		if (action == null)
			throw new ServletException("Null action");

		try {
			String nameClass = PATH_CLASS + action;
			Class typeClass = Class.forName(nameClass);
			Action actions = (Action) typeClass.newInstance();
			regress = actions.execute(request, response);

			parts = regress.split(":");
			type = parts[0];
			form = parts[1];
			if (type.equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher(PATH_JSP + form);
				rd.forward(request, response);
			} else {
				response.sendRedirect(form);
			}
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		} catch (InstantiationException e) {
			throw new ServletException(e);
		} catch (IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
}
