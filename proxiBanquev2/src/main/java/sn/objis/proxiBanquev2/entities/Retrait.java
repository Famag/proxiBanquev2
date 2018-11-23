package sn.objis.proxiBanquev2.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value = "Retrait")
public class Retrait extends Operations {

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}
	/*
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Retrait";
	}*/

}
