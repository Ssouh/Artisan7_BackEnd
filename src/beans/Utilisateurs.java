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
public class Utilisateurs implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Artisans> artisans;
	

	public Utilisateurs(String nom, String prenom, String email, String passw) {
		super();
		this.nom = nom;
		this.setEmail(email);
		this.prenom = prenom;
		this.password = passw;
	}
	
	public Utilisateurs() {
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

	public List<Artisans> getArtisans() {
		return artisans;
	}
	
	public void addArtisans(Artisans adr) {
		this.artisans.add(adr);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
		
}