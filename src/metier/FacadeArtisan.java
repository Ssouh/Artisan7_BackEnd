package metier;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import beans.Artisans;
import beans.Utilisateurs;

@Stateless
public class FacadeArtisan {
	
	@PersistenceContext
	private EntityManager em;
	
	public void ajoutArtisan(String nom, String prenom, String metier,String adr, String email, String passw) {
		 em.persist(new Artisans(nom, prenom, metier, adr,email,passw));
	}	 
	 
	@SuppressWarnings("unchecked")
	public Collection<Artisans> listeArtisans(){
		 Query req =  em.createQuery("select a from Artisans a");
	     return req.getResultList();
	}
	
	public Optional<Artisans> rechercheArtisan(Integer id) {
		TypedQuery<Artisans> typedQuery = em.createQuery("SELECT t FROM Artisans t WHERE t.id = :id", Artisans.class).setParameter("id", id);
		try {
			Artisans user = typedQuery.getSingleResult();
			return Optional.of(user);
		} catch (NoResultException e) {
			java.util.logging.Logger.getLogger(Artisans.class.getName()).info(e.getLocalizedMessage());
		}
		return Optional.empty();
	}

	public void supprimeArtisan(Artisans user) {
			em.remove(user);
	}
	
	 /*public void associer(int personneId, int AddressId) {
		 Personne p = em.find(Personne.class, personneId);
		 Address address = em.find(Address.class, AddressId);
		 
		 for(Address adr : p.getAddresses()) {
			 if(adr.equals(address)) {
				 return;
			 }
		 }
		 p.addAddress(address);
		 em.persist(p);
	 }*/
	

}
