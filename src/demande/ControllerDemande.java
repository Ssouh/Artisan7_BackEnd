package demande;

import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import artisan.Artisan;


@Stateless
@Path("/Demande")
public class ControllerDemande {
	@EJB
	private FacadeDemande dao;
	
	@POST
	@Path("/ajout")
	@Produces(MediaType.APPLICATION_JSON)
	public Demande ajoutDemande(Demande demande) {
		return dao.ajoutDemande(demande);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response index() {
		return Response.ok(dao.listeDemandes()).build();
	}
	
	@GET
	@Path("id={id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showid(@PathParam("id") Integer id) {
		return Response.ok(dao.getDemandeById(id)).build();
	}
	
	@GET
	@Path("secteur={id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showsmetier(@PathParam("id") String id) {
		return Response.ok(dao.getDemandeBySecteur(id)).build();
	}
	
	@DELETE
	@Path("/supprime={id}")
	@TransactionAttribute
	public Response delete(@PathParam("id") Integer id) {
		Optional<Demande> optional = dao.rechercheDemande(id);
		if (optional.isPresent()) {
			dao.supprimeDemande(optional.get());
			return Response.noContent().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
}
