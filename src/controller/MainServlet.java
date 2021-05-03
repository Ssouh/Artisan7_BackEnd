package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.FacadeArtisan;
import metier.FacadeUtilisateur;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FacadeArtisan facadeA;
	private FacadeUtilisateur facadeU;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = (String) request.getParameter("op");
		System.out.println(operation);
		if(request.getParameter("op").equals("liste")) {
			request.setAttribute("Utilisateurs", facadeU.listeUtilisateurs());
			request.getRequestDispatcher("liste.jsp").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = (String) request.getParameter("op");
		System.out.println(operation);
		if(request.getParameter("op").equals("liste")) {
			request.setAttribute("Utilisateurs", facadeU.listeUtilisateurs());
			request.getRequestDispatcher("liste.jsp").forward(request, response);
			}
	
	}
	

}