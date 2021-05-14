package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Artisan;
import metier.FacadeArtisan;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/AfficheArtisans")
public class AfficheArtisans extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FacadeArtisan facade;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Artisan> listeArtisans = (ArrayList<Artisan>) facade.listeArtisans();
		
		JsonElement jsonElem = (new Gson()).toJsonTree(listeArtisans, new TypeToken<ArrayList<Artisan>>() {}.getType());
		JsonArray jsonArray = jsonElem.getAsJsonArray();
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonArray);
	}
	

}
