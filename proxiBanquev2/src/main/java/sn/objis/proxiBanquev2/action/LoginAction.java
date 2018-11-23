package sn.objis.proxiBanquev2.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import sn.objis.proxiBanquev2.entities.Employe;
import sn.objis.proxiBanquev2.services.IBanqueService;

/**
 * Action de gestion de la connexion/déconnexion d'un utilisateur
 */
@Component
public class LoginAction extends ActionSupport {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
	@Autowired
	private IBanqueService metier;
	
    private String login;
    private String password;
    private Employe employe;


    // ==================== Getters/Setters ====================
    public String getLogin() {
        return login;
    }
    public void setLogin(String pLogin) {
        login = pLogin;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String pPassword) {
        password = pPassword;
    }

    


public IBanqueService getMetier() {
	return metier;
}



public void setMetier(IBanqueService metier) {
	this.metier = metier;
}



public Employe getEmploye() {
	return employe;
}



public void setEmploye(Employe employe) {
	this.employe = employe;
}






    // ==================== Méthodes ====================
   /* *//**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     *//*
    public String doLogin() {
        String vResult = ActionSupport.INPUT;
        try {
			employe = metier.getEmploye(employe.getLogin(), employe.getPassword());
			     System.out.println(employe.getLogin());
			     System.out.println(employe.getPassword());
			     Long idemp = employe.getCodeEmployer();
			     System.out.println("idEmp"+idemp);
			     vResult = ActionSupport.SUCCESS;          			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ko ko");
		}
        return vResult;
    }
 */

/*	*//**
     * Action de déconnexion d'un utilisateur
     * @return success
     *//*
    public String doLogout() {
        return ActionSupport.SUCCESS;
    }*/
}