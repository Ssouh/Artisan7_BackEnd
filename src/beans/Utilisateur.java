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
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name ,phone;
	
	private String email;
	
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Artisan> artisans;
	

	public Utilisateur(String nom, String phone, String email, String passw) {
		super();
		this.name = nom;
		this.phone = phone;
		this.setEmail(email);
		this.password = passw;
	}
	
	public Utilisateur() {
		super();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	public List<Artisan> getArtisans() {
		return artisans;
	}
	
	public void addArtisans(Artisan adr) {
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
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
		
}