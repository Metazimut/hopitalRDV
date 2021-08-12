package sopra.formation.repository.custom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Admin;
import sopra.formation.model.Compte;
import sopra.formation.model.Patient;
import sopra.formation.model.Praticien;



public interface ICompteRepository extends JpaRepository<Compte, Long> {

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


}
