package sopra.formation.repository.custom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Admin;
import sopra.formation.model.Compte;
import sopra.formation.model.Patient;
import sopra.formation.model.Praticien;
import sopra.formation.model.Specialite;



public interface ICompteRepository extends JpaRepository<Compte, Long> {

	Admin findAdminById(@Param("id") Long id);
	
	Patient findPatientById(@Param("id") Long id);
	
	Praticien findPraticienById(@Param("id") Long id);
	
	@Query("select a from Admin a")
	List<Admin> findAllAdmin(); // @Query

	@Query("select p from Patient p")
	List<Patient> findAllPatient(); // @Query
	
	@Query("select pr from Praticien pr")
	List<Praticien> findAllPraticien(); // @Query

	Admin findAdminByEmail(@Param("email") String email); // NamedQuery 

	Patient findPatientByEmail(@Param("email") String email); // NamedQuery
	
	Praticien findPraticienByEmail(@Param("email") String email); // NamedQuery
	
	Admin findAdminByNom(@Param("Nom") String nom); // NamedQuery 

	Patient findPatientByNom(@Param("Nom") String nom); // NamedQuery
	
	Praticien findPraticienByNom(@Param("Nom") String nom); // NamedQuery
	
	@Query("select ps.praticien from PraticienSpecialite ps where ps.id = (select ps.id from PraticienSpecialite ps join ps.specialite s where s =:spe)")
	Praticien findPraticienBySpe(@Param("spe") Specialite spe);


}
