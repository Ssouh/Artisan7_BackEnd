package controller;

import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import beans.Artisans;
import beans.Utilisateurs;
import metier.FacadeArtisan;

@Path("Artisans")
public class ControllerArtisan {
	private static final long serialVersionUID = 1L;
	@EJB
	private FacadeArtisan dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response index() {
		return Response.ok(dao.listeArtisans()).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") Integer id) {
		return Response.ok(dao.rechercheArtisan(id)).build();
	}
	
	@DELETE
	@Path("/{id}")
	@TransactionAttribute
	public Response delete(@PathParam("id") Integer id) {
		Optional<Artisans> optional = dao.rechercheArtisan(id);
		if (optional.isPresent()) {
			dao.supprimeArtisan(optional.get());
			return Response.noContent().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	
}
