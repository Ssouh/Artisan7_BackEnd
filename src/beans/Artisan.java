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
public class Artisan implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int available;
	private float note;
	private String name,email,password,phone,biographie,photo,secteur;
	private String adresse;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Utilisateur> personne;
	
	
	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public Artisan(){}
	
	public Artisan(String name, String email, String password, String phone , String secteur) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.secteur = secteur;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBiographie() {
		return biographie;
	}
	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
		
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adr) {
		this.adresse = adr;
	}
		
	public List<Utilisateur> getUtilisateurs() {
		return personne;
	}
	
	public void addUtilisateurs(Utilisateur usr) {
		this.personne.add(usr);
	}

}