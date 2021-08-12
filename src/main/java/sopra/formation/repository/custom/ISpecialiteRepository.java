package sopra.formation.repository.custom;


import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Specialite;

public interface ISpecialiteRepository extends JpaRepository<Specialite, Long> {

}
