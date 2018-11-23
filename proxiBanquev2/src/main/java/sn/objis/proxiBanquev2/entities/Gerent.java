package sn.objis.proxiBanquev2.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "Gerent")
public class Gerent extends Employe {

	public Gerent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gerent(Long codeEmployer) {
		super(codeEmployer);
		// TODO Auto-generated constructor stub
	}

	public Gerent(Long codeEmployer, String nomEmployer, String prenomEmployer, String login, String password) {
		super(codeEmployer, nomEmployer, prenomEmployer, login, password);
		// TODO Auto-generated constructor stub
	}

	public Gerent(String nomEmployer, String prenomEmployer, String emailEmployer, Employe gerent) {
		super(nomEmployer, prenomEmployer, emailEmployer, gerent);
		// TODO Auto-generated constructor stub
	}

	public Gerent(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}

	public Gerent(String nomEmployer, String prenomEmployer, String emailEmployer, String adresseEmployer,
			String telEmployer, String login, String password) {
		super(nomEmployer, prenomEmployer, emailEmployer, adresseEmployer, telEmployer, login, password);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	}

	
	
	
