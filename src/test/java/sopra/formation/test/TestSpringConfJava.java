package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.formation.config.ApplicationConfig;
import sopra.formation.model.Admin;
import sopra.formation.model.Compte;
import sopra.formation.model.Creneaux;
import sopra.formation.model.Motif;
import sopra.formation.model.Patient;
import sopra.formation.model.Praticien;
import sopra.formation.model.PraticienSpecialite;
import sopra.formation.model.Rdv;
import sopra.formation.model.Specialite;
import sopra.formation.model.Status;
import sopra.formation.repository.custom.ICompteRepository;
import sopra.formation.repository.custom.ICreneauxRepository;
import sopra.formation.repository.custom.IMotifRepository;
import sopra.formation.repository.custom.IPraticienSpecialiteRepository;
import sopra.formation.repository.custom.IRdvRepository;
import sopra.formation.repository.custom.ISpecialiteRepository;

public class TestSpringConfJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);


		ICompteRepository CompteRepo = context.getBean(ICompteRepository.class);
		IMotifRepository MotifRepo = context.getBean(IMotifRepository.class);
		ISpecialiteRepository SpecialiteRepo = context.getBean(ISpecialiteRepository.class);
		IPraticienSpecialiteRepository PraticienSpecialiteRepo = context.getBean(IPraticienSpecialiteRepository.class);
		IRdvRepository RDVRepo = context.getBean(IRdvRepository.class);
		ICreneauxRepository creneauxRepo = context.getBean(ICreneauxRepository.class);


		Compte pat1 = new Patient( "W", "mat","w.mat@gmail.com","123");
		CompteRepo.save(pat1);
		
		Compte adm2 = new Admin( "D", "xav","d.xav@gmail.com","321");
		CompteRepo.save(adm2);
		
		
		
		Specialite spe1= new Specialite("generaliste");
		SpecialiteRepo.save(spe1);
		
		PraticienSpecialite praSpe1 = new PraticienSpecialite();
		praSpe1.setSpecialite(spe1);
		
		Compte pra3 = new Praticien("Der", "sta","d.sta@gmail.com","321","paris");
		praSpe1.setPraticien((Praticien) pra3);
		CompteRepo.save(pra3);
		PraticienSpecialiteRepo.save(praSpe1);
		
		Motif mot1 = new Motif("consultation",15);
		mot1.setSpecialite(spe1);
		MotifRepo.save(mot1);

		Date date2 = null;
		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-21");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Creneaux cre1 = new Creneaux(date2);
		cre1.setPraticien((Praticien)pra3);
		creneauxRepo.save(cre1);
		
		
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-12");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Status state1 = Status.En_cours;
		Rdv rdv1 = new Rdv("paris",date1,state1);
		rdv1.setMotif(mot1);
		rdv1.setPatient((Patient)pat1);
		rdv1.setCreneaux(cre1);
		RDVRepo.save(rdv1);
		
		

		
		System.out.println("must find xav"+CompteRepo.findAdminByEmail("d.xav@gmail.com"));
		System.out.println("must find mat"+CompteRepo.findPatientByNom("W"));
		System.out.println("must find stan"+CompteRepo.findPraticienByNom("Der"));
		context.close();
		
	}

}
