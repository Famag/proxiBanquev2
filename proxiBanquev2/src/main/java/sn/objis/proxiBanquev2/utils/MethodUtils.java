package sn.objis.proxiBanquev2.utils;

import java.text.DecimalFormat;

public class MethodUtils {
	
	/**
	 * Methode qui genere un Numcompte 
	 * @param id
	 * @param type
	 * @return
	 */
	
	public static String genererNumero(long id, String type) {
		DecimalFormat nf = new DecimalFormat("0000000");
		String numformat = nf.format(id);
		String num = null;		
		num = numformat + type.substring(6, 9);		
		return num;
	}
	

}
