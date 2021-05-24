package demande;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import artisan.Artisan;

@Stateless
public class FacadeDemande {
	
	@PersistenceContext
	private EntityManager em;

	public Demande ajoutDemande(Demande demande) {
		em.persist(demande);
		return demande;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Demande> listeDemandes() {
		Query req =  em.createQuery("select a from Demande a");
	    return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Collection<Demande> getDemandeById(Integer id) {
		Query ps = em.createQuery("SELECT t FROM Demande t WHERE t.id = '"+ id + "'");
		return ps.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Collection<Demande> getDemandeBySecteur(String id) {
		Query ps = em.createQuery("select * from Demande where secteur='"+id+"'");
		return ps.getResultList();
	}


	public Optional<Demande> rechercheDemande(Integer id) {
		TypedQuery<Demande> typedQuery = em.createQuery("select t from Demande t where t.id = :id", Demande.class).setParameter("id", id);
		try {	
			Demande user = typedQuery.getSingleResult();
			return Optional.of(user);
		} catch (NoResultException e) {
			Logger.getLogger(Demande.class.getName()).info(e.getLocalizedMessage());
		}
		return Optional.empty();
	}

	public void supprimeDemande(Demande demande) {
		em.remove(demande);
	}

}
