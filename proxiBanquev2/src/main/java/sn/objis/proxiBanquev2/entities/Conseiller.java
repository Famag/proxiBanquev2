package sn.objis.proxiBanquev2.entities;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Conseiller")
public class Conseiller extends Employe {
	


	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	public Conseiller(String nomEmployer, String prenomEmployer, String emailEmployer, Employe gerent) {
		super(nomEmployer, prenomEmployer, emailEmployer, gerent);
		// TODO Auto-generated constructor stub
	}


	public Conseiller(Long codeEmployer) {
		super(codeEmployer);
		// TODO Auto-generated constructor stub
	}



	public Conseiller(Long codeEmployer, String nomEmployer, String prenomEmployer, String login, String password) {
		super(codeEmployer, nomEmployer, prenomEmployer, login, password);
		// TODO Auto-generated constructor stub
	}



	public Conseiller(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}



	public Conseiller(String nomEmployer, String prenomEmployer, String emailEmployer, String adresseEmployer,
			String telEmployer, String login, String password) {
		super(nomEmployer, prenomEmployer, emailEmployer, adresseEmployer, telEmployer, login, password);
		// TODO Auto-generated constructor stub
	}




}
