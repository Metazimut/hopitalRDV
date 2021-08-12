package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Creneaux")
public class Creneaux {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name="date")
	private Date creneauxDispo;
	@OneToMany(mappedBy = "motif_id")
	private List<Motif> motif = new ArrayList<Motif>();
	
	public Creneaux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Creneaux(Long id, int version, Date creneauxDispo, List<Motif> motif) {
		super();
		this.id = id;
		this.version = version;
		this.creneauxDispo = creneauxDispo;
		this.motif = motif;
	}

	public Creneaux(Long id,  Date creneauxDispo, List<Motif> motif) {
		
		this.id = id;
		this.creneauxDispo = creneauxDispo;
		this.motif = motif;
	}
	public Creneaux(Date creneauxDispo, List<Motif> motif) {
				
		this.creneauxDispo = creneauxDispo;
		this.motif = motif;
	}
	
	public Creneaux(Date creneauxDispo) {
		
		this.creneauxDispo = creneauxDispo;
		
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

	public Date getCreneauxDispo() {
		return creneauxDispo;
	}

	public void setCreneauxDispo(Date creneauxDispo) {
		this.creneauxDispo = creneauxDispo;
	}

	public List<Motif> getMotif() {
		return motif;
	}

	public void setMotif(List<Motif> motif) {
		this.motif = motif;
	}
	
	
}
