package client;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import artisan.Artisan;

@Stateless
public class FacadeClient {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void ajoutUtilisateur(String nom, String prenom, String email, String passw) {
		em.persist(new Client(nom, prenom, email,passw));
	}
	
	public Client ajoutUtilisateur(Client usr) {
		em.persist(usr);
		return usr;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Client> getUtilisatuerById(Integer id)
	{
		Query ps = em.createQuery("select u from Client u where u.id='"+id+"'");
		return ps.getResultList();
	}
	 
	public Client getClientByEmail(String email) {
		Query req = em.createQuery("select a from Client a where a.email like :e");
		req.setParameter("e", email);
		if(req.getResultList().size() == 0)
		{
			return null;
		}
		return (Client) req.getResultList().get(0);
	}
	
	 @SuppressWarnings("unchecked")
	public Collection<Client> listeUtilisateurs(){
		 Query req =  em.createQuery("select p from Client p");
	     return req.getResultList();
	 }
	 
	public Optional<Client> rechercheUtilisateur(Integer id) {
			TypedQuery<Client> typedQuery = em.createQuery("SELECT t FROM Client t WHERE t.id = :id", Client.class).setParameter("id", id);
			try {
				Client user = typedQuery.getSingleResult();
				return Optional.of(user);
			} catch (NoResultException e) {
				java.util.logging.Logger.getLogger(Client.class.getName()).info(e.getLocalizedMessage());
			}
			return Optional.empty();
	}

	public void supprimeUtilisateur(Client user) {
			em.remove(user);
	}
	
	//Ajouter une association entre utilisateur et client
	public void addNewArtisan(Client usr)
	{
		em.createQuery("INSERT INTO `Client` ( `name`, `phone`, `password`, `email`) VALUES ( '"+usr.getName()+"', '"+usr.getPhone()+"', '"+usr.getPassword()+"', '"+usr.getEmail()+"');");
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
