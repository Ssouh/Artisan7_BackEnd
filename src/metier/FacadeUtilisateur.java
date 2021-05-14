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

import beans.Artisan;
import beans.Utilisateur;

@Stateless
public class FacadeUtilisateur {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void ajoutUtilisateur(String nom, String prenom, String email, String passw) {
		em.persist(new Utilisateur(nom, prenom, email,passw));
	}
	
	public Utilisateur ajoutUtilisateur(Utilisateur usr) {
		em.persist(usr);
		return usr;
	}
	 
	 @SuppressWarnings("unchecked")
	public Collection<Utilisateur> listeUtilisateurs(){
		 Query req =  em.createQuery("select p from Utilisateur p");
	     return req.getResultList();
	 }
	 
	public Optional<Utilisateur> rechercheUtilisateur(Integer id) {
			TypedQuery<Utilisateur> typedQuery = em.createQuery("SELECT t FROM Utilisateur t WHERE t.id = :id", Utilisateur.class).setParameter("id", id);
			try {
				Utilisateur user = typedQuery.getSingleResult();
				return Optional.of(user);
			} catch (NoResultException e) {
				java.util.logging.Logger.getLogger(Utilisateur.class.getName()).info(e.getLocalizedMessage());
			}
			return Optional.empty();
	}

	public void supprimeUtilisateur(Utilisateur user) {
			em.remove(user);
	}
	
	public void addNewArtisan(Utilisateur usr)
	{
		em.createQuery("INSERT INTO `Utilisateur` ( `name`, `phone`, `password`, `email`) VALUES ( '"+usr.getName()+"', '"+usr.getPhone()+"', '"+usr.getPassword()+"', '"+usr.getEmail()+"');");
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Utilisateur> getUtilisatuerById(Integer id)
	{
		Query ps = em.createQuery("select u from Utilisateur u where u.id='"+id+"'");
		return ps.getResultList();
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
