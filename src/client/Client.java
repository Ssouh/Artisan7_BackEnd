package client;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import artisan.Artisan;

@Entity
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name ,phone;
	
	private String email;
	
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Artisan> artisans;
	

	public Client(String nom, String phone, String email, String passw) {
		super();
		this.name = nom;
		this.phone = phone;
		this.setEmail(email);
		this.password = passw;
	}
	
	public Client() {
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