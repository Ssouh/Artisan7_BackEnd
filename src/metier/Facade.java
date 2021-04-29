package metier;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Artisans;
import beans.Utilisateurs;

@Stateless
public class Facade {
	
	@PersistenceContext
	private EntityManager em ;
	
	
	
	public void ajoutPersonne(String nom, String prenom) {
		em.persist(new Utilisateurs(nom, prenom));
	}
	
	 public void ajoutAddress(String nom, String prenom, String metier,String ville) {
		 em.persist(new Artisans(nom, prenom, metier, ville));
	 }
	 
	 @SuppressWarnings("unchecked")
	public Collection<Utilisateurs> listePersonnes(){
		 Query req =  em.createQuery("select p from Personne p");
	     return req.getResultList();
	 }
	 
	@SuppressWarnings("unchecked")
	public Collection<Artisans> listeArtisans(){
		 Query req =  em.createQuery("select a from Artisans a");
	     return req.getResultList();
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
