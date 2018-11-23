package sn.objis.proxiBanquev2.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING)
public class Compte implements Serializable {
	@Id
	private String numeroCompte;
	private Date dateCreation;
	private double solde;


	@ManyToOne
	@JoinColumn(name = "CODE_CLIENT")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "CODE_EMP")
	private Employe employe; 


	@OneToMany(mappedBy = "compte")
	private Collection<Operations> listeOperations;

	public String getNumeroCompte() {
		return numeroCompte;
	}


	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Employe getEmploye() {
		return employe;
	}


	public void setEmploye(Employe employe) {
		this.employe = employe;
	}


	public Collection<Operations> getListeOperations() {
		return listeOperations;
	}


	public void setListeOperations(Collection<Operations> listeOperations) {
		this.listeOperations = listeOperations;
	}


	public Compte(String numeroCompte, double solde, Client client, Employe employe) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.client = client;
		this.employe = employe;
	}

	public Compte( double solde, Client client, Employe employe) {
		super();
		this.solde = solde;
		this.client = client;
		this.employe = employe;
	}


	public Compte(String numeroCompte, double solde) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
	}


	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Compte(double solde) {
		super();
		this.solde = solde;
		this.dateCreation = new Date();
	}

	
	
}
