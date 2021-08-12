package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("stagiaire")
public class Praticien extends Compte {
	@Column(name="Lieu")
	private String lieu;
	@OneToMany(mappedBy = "Praticien")
	private List<PraticienSpecialite> spe = new ArrayList<PraticienSpecialite>();
	@OneToMany(mappedBy = "Praticien")
	private List<Crenaux> crenaux = new ArrayList<Crenaux>();
	
	public Praticien() {
		super();
	}

	public Praticien(Long id, int version, String nom, String prenom, String email, String mdp) {
		super(id, version, nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}

	public Praticien(Long id, int version, String nom, String prenom, String email, String mdp, String lieu, List<PraticienSpecialite> spe, List<Crenaux> crenaux) {
		super(id, version, nom, prenom, email, mdp);
		this.lieu = lieu;
		this.spe = spe;
		this.crenaux = crenaux;
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

	public List<Crenaux> getCrenaux() {
		return crenaux;
	}

	public void setCrenaux(List<Crenaux> crenaux) {
		this.crenaux = crenaux;
	}

	@Override
	public String toString() {
		return "Praticien [lieu=" + lieu + "]";
	}

	
}