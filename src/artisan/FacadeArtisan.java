package artisan;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import client.Client;

@Stateless
public class FacadeArtisan {
	
	@PersistenceContext
	private EntityManager em;
	
	public Artisan ajoutArtisan(Artisan artisan) {
		em.persist(artisan);
		return artisan;
	}
	
	public void ajoutArtisan(String nom, String email,String passw, String phone, String secteur) {
		 em.persist(new Artisan(nom, email, passw, phone, secteur));
	}	 
	 

	@SuppressWarnings("unchecked")
	public Collection<Artisan> getArtisanById(Integer id)
	{
		Query ps = em.createQuery("SELECT t FROM Artisan t WHERE t.id = '"+ id + "'");
		return ps.getResultList();
	}
	
	
	public Artisan getArtisanByEmail(String email) {
		Query req = em.createQuery("select a from Artisan a where a.email like :e");
		req.setParameter("e", email);
		if(req.getResultList().size() == 0)
		{
			return null;
		}
		return (Artisan) req.getResultList().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Artisan> getArtisanBySecteur(String email)
	{
		Query ps = em.createQuery("select * from Artisan where secteur='"+email+"'");
		return ps.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Artisan> listeArtisans(){
		 Query req =  em.createQuery("select a from Artisan a");
	     return req.getResultList();
	}
	
	public Optional<Artisan> rechercheArtisan(Integer id) {
		TypedQuery<Artisan> typedQuery = em.createQuery("select t from Artisan t where t.id = :id", Artisan.class).setParameter("id", id);
		try {	
			Artisan user = typedQuery.getSingleResult();
			return Optional.of(user);
		} catch (NoResultException e) {
			Logger.getLogger(Artisan.class.getName()).info(e.getLocalizedMessage());
		}
		return Optional.empty();
	}
	
	public void supprimeArtisan(Artisan user) {
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
