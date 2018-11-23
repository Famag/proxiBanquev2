package sn.objis.proxiBanquev2.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "COURANT") // Comme CompteCourant herite de la classe Compte, donc l'attribut  TYPE_CPTE aura comme valeur CC a chaque creation
public class CompteCourant extends Compte{
	
	
	private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}


	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CompteCourant(double solde, double decouvert) {
		super(solde);
		this.decouvert = decouvert;
	}


	@Override
	public String toString() {
		return "CompteCourant [getClass()=" + getClass() + "]";
	}
		


}
