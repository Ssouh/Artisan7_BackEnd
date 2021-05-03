package beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artisans implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	private String prenom;
	
	private String metier;
	
	private String adresse;
	
	private String email;

	private String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Utilisateurs> personne;
	

	public Artisans(String nom, String prenom, String metier,String adr, String email,String passw) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.setMetier(metier);
		this.adresse = adr;
		this.email = email;
		this.password = passw;
	}
	
	public Artisans() {
		super();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adr) {
		this.adresse = adr;
	}
	
	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}
	
	public List<Utilisateurs> getUtilisateurs() {
		return personne;
	}
	
	public void addUtilisateurs(Utilisateurs usr) {
		this.personne.add(usr);
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
