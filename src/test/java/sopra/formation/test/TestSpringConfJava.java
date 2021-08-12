package sopra.formation.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.formation.config.ApplicationConfig;
import sopra.formation.model.Admin;
import sopra.formation.model.Compte;
import sopra.formation.model.Motif;
import sopra.formation.model.Patient;
import sopra.formation.model.Praticien;
import sopra.formation.model.PraticienSpecialite;
import sopra.formation.model.Specialite;
import sopra.formation.repository.custom.ICompteRepository;
import sopra.formation.repository.custom.IMotifRepository;
import sopra.formation.repository.custom.IPraticienSpecialiteRepository;
import sopra.formation.repository.custom.ISpecialiteRepository;

public class TestSpringConfJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ICompteRepository CompteRepo = context.getBean(ICompteRepository.class);
		IMotifRepository MotifRepo = context.getBean(IMotifRepository.class);
		ISpecialiteRepository SpecialiteRepo = context.getBean(ISpecialiteRepository.class);
		IPraticienSpecialiteRepository PraticienSpecialiteRepo = context.getBean(IPraticienSpecialiteRepository.class);


//		Compte com1 = new Patient( "W", "mat","w.mat@gmail.com","123");
//		CompteRepo.save(com1);
//		
//		Compte com2 = new Admin( "D", "xav","d.xav@gmail.com","321");
//		CompteRepo.save(com2);
		

		
		Motif mot1 = new Motif("consultation",15);
		MotifRepo.save(mot1);
		List<Motif> listMotif1 = new ArrayList();
		listMotif1.add(mot1);
		
		
		Specialite spe1= new Specialite("généraliste");
		spe1.setMotifs(listMotif1);
		SpecialiteRepo.save(spe1);
		
		PraticienSpecialite praSpe1 = new PraticienSpecialite();
		praSpe1.setSpecialite(spe1);
		PraticienSpecialiteRepo.save(praSpe1);
		
		Praticien com3 = new Praticien("Der", "sta","d.sta@gmail.com","321","paris");
		praSpe1.setPraticien(com3);
//		CompteRepo.save(com3);
		
		System.out.println(CompteRepo.findAdminByEmail("d.xav@gmail.com"));
		System.out.println(CompteRepo.findPatientByNom("W"));
		System.out.println(CompteRepo.findPraticienByNom("Der"));
		context.close();
		
		
	}

}
