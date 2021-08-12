package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

public class Specialite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name="libelle")
	private String  libelle;
	@OneToMany(mappedBy="specialite")
	private List<PraticienSpecialite> praticienSpecialites = new ArrayList<PraticienSpecialite>();
	@OneToMany(mappedBy="motif")
	private List<Motif> motifs = new ArrayList<Motif>();
	
	
	public Specialite() {
		super();
	}
	
	public Specialite(Long id, String Libelle) {
		this.id=id;
		this.libelle=libelle;
	}
	
	public Specialite(String Libelle) {
		this.libelle=libelle;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public PraticienSpecialite getPraticienSpecialite() {
		return praticienSpecialite;
	}

	public void setPraticienSpecialite(PraticienSpecialite praticienSpecialite) {
		this.praticienSpecialite = praticienSpecialite;
	}

	@Override
	public String toString() {
		return "Specialite [id=" + id + ", version=" + version + ", libelle=" + libelle + "]";
	}

	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}
	
	
	
}
