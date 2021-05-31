package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.entity.Compte;
import tn.enis.service.CompteServices;

/**
 * Servlet implementation class ComptServlet
 */
@WebServlet("/ComptServlet")
public class ComptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CompteServices compteService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String client = request.getParameter("client");
		float solde = Float.parseFloat(request.getParameter("solde"));
	
		Compte compte = new Compte(client, solde);
		compteService.save(compte);

		response.getWriter().append("success");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
