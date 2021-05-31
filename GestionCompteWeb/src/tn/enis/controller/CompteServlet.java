package tn.enis.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.enis.entities.Client;
import tn.enis.entities.Compte;
import tn.enis.service.ClientService;
import tn.enis.service.CompteService;

/**
 * Servlet implementation class CompteService
 */
@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	CompteService service;
	
	@EJB
	ClientService clientService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getParameter("add") != null) {
		String cin = request.getParameter("cin");
		Client client = clientService.getById(cin);
		float solde = Float.parseFloat(request.getParameter("solde"));
		
		Compte compte = new Compte(client, solde);
		service.save(compte);
		
	}else if(request.getParameter("delete") !=null) {
			Long rib = Long.valueOf(request.getParameter("rib"));
			service.delete(rib);
			return;
		} else if (request.getParameter("edit") != null) {
			Long rib = Long.valueOf(request.getParameter("rib"));
			Compte compte = service.getById(rib);
			request.setAttribute("compte",  compte);
			RequestDispatcher rd1 = request.getRequestDispatcher("edit-compte.jsp");
			rd1.forward(request,  response);
			return;
			
		}else if (request.getParameter("update") !=null) {
			Long rib = Long.valueOf(request.getParameter("rib"));
			String cin = request.getParameter("cin");
			Client client = clientService.getById(cin);
			float solde = Float.parseFloat(request.getParameter("solde"));	
			Compte compte = new Compte(rib, client, solde);
			service.update(compte);
		}
		List<Compte> comptes = service.getAll();
		request.setAttribute("comptes", comptes);
		RequestDispatcher rd = request.getRequestDispatcher("comptes.jsp");
		rd.forward(request,  response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
