package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.service.CalcService;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// demende a la serveur de creee une instance dans ce variable
	// mecanisme (niveau code)'injection de dependance' (niveau conceptuelle)IOC invertion of controll
	@EJB
	private CalcService calservice;

	public CalcServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int  a =Integer.parseInt(request.getParameter("a")) ;
		int  b =Integer.parseInt(request.getParameter("b")) ;
		if("add".equals(request.getParameter("add"))){
			int res = calservice.add(a, b);
			response.getWriter().print(res);
		}else {
			int res = calservice.mult(a, b);
			response.getWriter().print(res);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
