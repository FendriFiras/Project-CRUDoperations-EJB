package tn.enis.control;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.enis.entity.Product;
import tn.enis.service.ShopService;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ShopService shopService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("add".equals(request.getParameter("action"))) {
			String name = request.getParameter("name");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			float price = Float.parseFloat(request.getParameter("price"));
			Product prod = new Product(name, quantity, price);
			shopService.save(prod);
			List<Product> Produit = shopService.getAll();
			// Recupere la session
			HttpSession session = request.getSession(true);
			session.setAttribute("Produit", Produit);
			RequestDispatcher rd = request.getRequestDispatcher("Shop.jsp");
			rd.forward(request, response);
			/*
			 * response.getWriter().append("success");
			 * 
			 * request.getRequestDispatcher("Shop.jsp").forward(request, response);
			 */

		}

		if (request.getParameter("delete") != null) {
			Long id = Long.parseLong(request.getParameter("delete"));
			shopService.delete(id);
			List<Product> Produit = shopService.getAll();
			// Recupere la session
			HttpSession session = request.getSession(true);
			session.setAttribute("Produit", Produit);
			RequestDispatcher rd = request.getRequestDispatcher("Shop.jsp");
			rd.forward(request, response);
			return;
		}

		if (request.getParameter("edit") != null) {
			Long id = Long.parseLong(request.getParameter("edit"));
			request.setAttribute("editItem", shopService.getById(id));
			request.getRequestDispatcher("editItem.jsp").forward(request, response);
		}
		if (request.getParameter("action") != null) {
			String name = request.getParameter("name");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			float price = Float.parseFloat(request.getParameter("price"));
			Long id = Long.parseLong(request.getParameter("action"));
			Product prod = new Product(name, quantity, price);
			shopService.update(prod, id);
			List<Product> Produit = shopService.getAll();
			// Recupere la session
			HttpSession session = request.getSession(true);
			session.setAttribute("Produit", Produit);
			request.getRequestDispatcher("Shop.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
