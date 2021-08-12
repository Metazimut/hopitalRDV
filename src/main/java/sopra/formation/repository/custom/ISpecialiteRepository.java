package sopra.formation.repository.custom;

import java.util.List;


import sopra.formation.model.Specialite;

public interface ISpecialiteRepository {
	Specialite findBySpecialiteId(Long idSpecialite);	// TODO

	List<Specialite> findAllById(Long idSpecialite);
}
