package sopra.formation.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.formation.config.ApplicationConfig;
import sopra.formation.model.Admin;
import sopra.formation.model.Compte;
import sopra.formation.model.Patient;
import sopra.formation.repository.custom.ICompteRepository;

public class TestSpringConfJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ICompteRepository CompteRepo = context.getBean(ICompteRepository.class);


		Compte com1 = new Patient( "W", "mat","w.mat@gmail.com","123");
		CompteRepo.save(com1);
		
		Compte com2 = new Admin( "D", "xav","d.xav@gmail.com","321");
		CompteRepo.save(com2);
		
		System.out.println(CompteRepo.findAdminByEmail("d.xav@gmail.com"));
		System.out.println(CompteRepo.findPatientByNom("W"));
		context.close();
		
		
	}

}
