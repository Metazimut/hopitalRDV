package sopra.formation.repository.custom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Compte;
import sopra.formation.model.Specialite;

public interface ISpecialiteRepository extends JpaRepository<Specialite, Long> {
	Specialite findBySpecialiteId(Long idSpecialite);	// TODO

	List<Specialite> findAllById(Long idSpecialite);
}
