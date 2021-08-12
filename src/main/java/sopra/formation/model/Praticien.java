package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("stagiaire")
public class Praticien extends Compte {
	@Column(name="Lieu")
	private String lieu;
	@Transient
	@OneToMany(mappedBy = "Praticien")
	private List<PraticienSpecialite> spe = new ArrayList<PraticienSpecialite>();
	@Transient
	@OneToMany(mappedBy = "Praticien")
	private List<Creneaux> creneaux = new ArrayList<Creneaux>();
	
	public Praticien() {
		super();
	}

	public Praticien(Long id, int version, String nom, String prenom, String email, String mdp) {
		super(id, version, nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}

	public Praticien(Long id, int version, String nom, String prenom, String email, String mdp, String lieu, List<PraticienSpecialite> spe, List<Creneaux> creneaux) {
		super(id, version, nom, prenom, email, mdp);
		this.lieu = lieu;
		this.spe = spe;
		this.creneaux = creneaux;
	}
	
	


	public Praticien(String nom, String prenom, String email, String mdp,String lieu) {
		super(nom, prenom, email, mdp);
		this.lieu = lieu;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public List<PraticienSpecialite> getSpe() {
		return spe;
	}

	public void setSpe(List<PraticienSpecialite> spe) {
		this.spe = spe;
	}

	public List<Creneaux> getCrenaux() {
		return creneaux;
	}

	public void setCrenaux(List<Creneaux> creneaux) {
		this.creneaux = creneaux;
	}

	@Override
	public String toString() {
		return "Praticien [lieu=" + lieu + ", spe=" + spe + ", crenaux=" + creneaux + ", getId()=" + getId()
				+ ", getVersion()=" + getVersion() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getEmail()=" + getEmail() + ", getMdp()=" + getMdp() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}



	
}