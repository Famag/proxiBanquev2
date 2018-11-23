package sn.objis.proxiBanquev2.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sn.objis.proxiBanquev2.entities.Client;
import sn.objis.proxiBanquev2.entities.Compte;
import sn.objis.proxiBanquev2.entities.CompteCourant;
import sn.objis.proxiBanquev2.entities.CompteEpargne;
import sn.objis.proxiBanquev2.entities.Conseiller;
import sn.objis.proxiBanquev2.entities.Employe;
import sn.objis.proxiBanquev2.entities.Gerent;
import sn.objis.proxiBanquev2.entities.Operations;
import sn.objis.proxiBanquev2.services.IBanqueService;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
	IBanqueService metier = (IBanqueService) context.getBean("metier");
			  
	/*	  //Ajout Employer
		  Employe gerent = new Employe(1L);		  
		  Employe  emp1 = new Conseiller("Gueye","Fama","fama@imedia.sn",gerent);
		  Employe  emp2 = new Conseiller("Diedhiou","Mawa","awa@imedia.sn",gerent);		  
		  metier.addEmploye(emp1);
		  metier.addEmploye(emp2);
		  
           //Ajout client
		  Client cl1 = new Client("Pathe Ndiaye", "Dalifort", emp1);
		  Client cl2 = new Client("Nabou Dia", "Icotaf",emp2);
		  metier.addClient(cl1);
		  metier.addClient(cl2);*/
		  
	
	
	
		
		 List<Client> list = metier.findAll();
		 for(Client c: list) {
			 
			 System.out.println("================");
			 System.out.println("ID :"+  c.getCodeClient());
			 System.out.println("NOM :"+  c.getNomClient());
			 System.out.println("Adresse :"+  c.getAdresseClient());
			 System.out.println("================");
			 
		 }
		 
		 
/*		  metier.addCompte(new CompteCourant("cc1",3000, 1000), 1L, 1L);
		  metier.addCompte(new CompteEpargne("ce1",2000,2.5), 1L, 1L);
		  
		  System.out.println("++++++++++++++++");	 
		 //Opérations
		  metier.verser(3000, "cc1", 1L);
		  metier.verser(2000,"ce1",2L);
		  metier.virement(2000, "cc1", "ce1", 1L);*/
		  
	/*	  List<Operations> lisop = metier.consulterOperations("ce1");
		  for(Operations o : lisop) {
			  System.out.println("***********************");
			  System.out.println("Montant: " +o.getMontant());
			  System.out.println("Type:" +o.getClass().getSimpleName());
			 System.out.println("Employe"+o.getEmploye().getNomEmployer());
			  System.out.println("Date Operation:" +o.getDateOperation());
		  }*/
		
	}

}
