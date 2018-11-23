package sn.objis.proxiBanquev2.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "EPARGNE")
public class CompteEpargne extends Compte {

	private double taux;
	

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}


	public CompteEpargne() {
		super();

	}

	public CompteEpargne(double solde, double taux) {
		super(solde);
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "CompteEpargne [getClass()=" + getClass() + "]";
	}

	
	
	
}
