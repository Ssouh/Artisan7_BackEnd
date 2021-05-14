package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import beans.Artisan;
import beans.Utilisateur;
import metier.FacadeArtisan;
import metier.FacadeUtilisateur;

@Stateless
@Path("/Utilisateur")
public class ControllerUtilisateur {
	@EJB
	private FacadeUtilisateur dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response index() {
		return Response.ok(dao.listeUtilisateurs()).build();
	}
	
	@POST
	@Path("/Ajout")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur ajoutArtisan(Utilisateur usr) {
		return dao.ajoutUtilisateur(usr);
	}

	@GET
	@Path("/isValid={id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") Integer id) {
		return Response.ok(dao.rechercheUtilisateur(id)).build();
	}
	
	@GET
	@Path("id={id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showid(@PathParam("id") Integer id) {
		return Response.ok(dao.getUtilisatuerById(id)).build();
	}
		
	@DELETE
	@Path("/supprimer={id}")
	@TransactionAttribute
	public Response delete(@PathParam("id") Integer id) {
		Optional<Utilisateur> optional = dao.rechercheUtilisateur(id);
		if (optional.isPresent()) {
			dao.supprimeUtilisateur(optional.get());
			return Response.noContent().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	
}
