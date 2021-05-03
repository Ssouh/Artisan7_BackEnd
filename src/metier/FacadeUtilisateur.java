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
public class FacadeUtilisateur {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void ajoutUtilisateur(String nom, String prenom, String email, String passw) {
		em.persist(new Utilisateurs(nom, prenom, email,passw));
	}
	 
	 @SuppressWarnings("unchecked")
	public Collection<Utilisateurs> listeUtilisateurs(){
		 Query req =  em.createQuery("select p from Utilisateurs p");
	     return req.getResultList();
	 }
	 
	public Optional<Utilisateurs> rechercheUtilisateur(Integer id) {
			TypedQuery<Utilisateurs> typedQuery = em.createQuery("SELECT t FROM Utilisateurs t WHERE t.id = :id", Utilisateurs.class).setParameter("id", id);
			try {
				Utilisateurs user = typedQuery.getSingleResult();
				return Optional.of(user);
			} catch (NoResultException e) {
				java.util.logging.Logger.getLogger(Utilisateurs.class.getName()).info(e.getLocalizedMessage());
			}
			return Optional.empty();
	}

	public void supprimeUtilisateur(Utilisateurs user) {
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
