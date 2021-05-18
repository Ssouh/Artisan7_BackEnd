package artisan;

import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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

import client.Client;

@Stateless
@Path("/Artisan")
public class ControllerArtisan {
	@EJB
	private FacadeArtisan dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response index() {
		return Response.ok(dao.listeArtisans()).build();
	}
	
	@POST
	@Path("/ajout")
	@Produces(MediaType.APPLICATION_JSON)
	public Artisan ajoutArtisan(Artisan artisan) {
		return dao.ajoutArtisan(artisan);
	}

	@GET
	@Path("/estValide={id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response isValid(@PathParam("id") Integer id) {
		return Response.ok(dao.rechercheArtisan(id)).build();
	}
	
	@GET
	@Path("id={id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showid(@PathParam("id") Integer id) {
		return Response.ok(dao.getArtisanById(id)).build();
	}
	
	@GET
	@Path("secteur={id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showsmetier(@PathParam("id") String id) {
		return Response.ok(dao.getArtisanBySecteur(id)).build();
	}
	
	@DELETE
	@Path("/supprime={id}")
	@TransactionAttribute
	public Response delete(@PathParam("id") Integer id) {
		Optional<Artisan> optional = dao.rechercheArtisan(id);
		if (optional.isPresent()) {
			dao.supprimeArtisan(optional.get());
			return Response.noContent().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	
}
