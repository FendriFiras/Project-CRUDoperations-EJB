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
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	ClientService service;
	
	@EJB
	CompteService compteService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("add") != null) {
			String cin = request.getParameter("cin");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
			
			Client client = new Client(cin, nom, prenom, adresse);
			service.save(client);
		}
			else if(request.getParameter("delete") !=null) {
				String cin = request.getParameter("cin");
				service.delete(cin);
			} else if (request.getParameter("edit") != null) {
				String cin = request.getParameter("cin");
				Client client = service.getById(cin);
				request.setAttribute("client",  client);
				RequestDispatcher rd = request.getRequestDispatcher("edit-client.jsp");
				rd.forward(request,  response);
				return;
				
			}else if (request.getParameter("update") !=null) {
				String cin = request.getParameter("cin");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String adresse = request.getParameter("adresse");
				Client client = new Client(cin, nom, prenom, adresse);
				service.update(client);
			}
			List<Client> clients = service.getAllClient();
			request.setAttribute("clients", clients);
			RequestDispatcher rd = request.getRequestDispatcher("clients.jsp");
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
