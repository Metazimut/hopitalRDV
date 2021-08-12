package sopra.formation.repository.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Praticien;
import sopra.formation.model.PraticienSpecialite;
import sopra.formation.model.Specialite;

public interface IPraticienSpecialiteRepository extends JpaRepository<PraticienSpecialite, Long>{

	PraticienSpecialite findPraticienSpecialiteBySpecialite(@Param("specialite") Specialite specialite);

}
