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
@WebServlet("/CreerUtilisateur")
public class CreerUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FacadeUtilisateur facade;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom = (String) request.getParameter("prenom");
		String nom = (String) request.getParameter("nom");
		String email = (String) request.getParameter("email");
		String passw = (String) request.getParameter("password");
		facade.ajoutUtilisateur(nom,prenom,email,passw);
	}
	

}