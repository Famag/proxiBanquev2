package sn.objis.proxiBanquev2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import sn.objis.proxiBanquev2.entities.Client;
import sn.objis.proxiBanquev2.entities.Compte;
import sn.objis.proxiBanquev2.entities.CompteCourant;
import sn.objis.proxiBanquev2.entities.CompteEpargne;
import sn.objis.proxiBanquev2.entities.Employe;
import sn.objis.proxiBanquev2.entities.Operations;
import sn.objis.proxiBanquev2.services.IBanqueService;

/**
 * Action de gestion des {@link Client}
 */
@Component
public class ClientAction extends ActionSupport implements SessionAware {

	// ==================== Attributs ====================
	@Autowired
	private IBanqueService metier;
	public String nomClient;
	public String adresseClient;
	public String emailClient;
	public String telClient;
	public Long idclient;
	public Long idemp;
	public String idcpte;
	public Long codeClient;
	public String typeOperation;
	public String numeroCompte;
	public String numeroCompte2;
	public String idcpte2;
	public double montant;
	private boolean typeCourant;
	private boolean typeEpargne;
	// ----Initialisation des comptes, fixer une somme à l'ouverture et mettre	
	//---- un decouvert si c'est courant et mettre un taux si c'est epargne
	private Compte cptcou = new CompteCourant(10000, 1000);
	private Compte cptep = new CompteEpargne(10000, 2.5);
	public String compteCou;
	public String compteEp;
	private List<Client> listclient;
	private List<Compte> listcpte;
	private List<String> typeOp;
	private List<Operations> listeop;
	private String login;
	private String password;
	// ----- Eléments Struts
	private Map<String, Object> session;
	private Employe employe;
	private Compte compte;
	private Compte compte2;
	private Client client;

	// ==================== Getters/Setters ====================

	@Override
	public void setSession(Map<String, Object> pSession) {
		this.session = pSession;
	}

	public Compte getCompte2() {
		return compte2;
	}

	public void setCompte2(Compte compte2) {
		this.compte2 = compte2;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Operations> getListeop() {
		return listeop;
	}

	public void setListeop(List<Operations> listeop) {
		this.listeop = listeop;
	}

	public List<String> getTypeOp() {
		return typeOp;
	}

	public void setTypeOp(List<String> typeOp) {
		this.typeOp = typeOp;
	}

	public Long getIdemp() {
		return idemp;
	}

	public void setIdemp(Long idemp) {
		this.idemp = idemp;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListclient() {
		return listclient;
	}

	public void setListclient(List<Client> listclient) {
		this.listclient = listclient;
	}

	public IBanqueService getMetier() {
		return metier;
	}

	public void setMetier(IBanqueService metier) {
		this.metier = metier;
	}

	public boolean isTypeCourant() {
		return typeCourant;
	}

	public void setTypeCourant(boolean typeCourant) {
		this.typeCourant = typeCourant;
	}

	public boolean isTypeEpargne() {
		return typeEpargne;
	}

	public void setTypeEpargne(boolean typeEpargne) {
		this.typeEpargne = typeEpargne;
	}

	public Compte getCptcou() {
		return cptcou;
	}

	public void setCptcou(Compte cptcou) {
		this.cptcou = cptcou;
	}

	public Compte getCptep() {
		return cptep;
	}

	public void setCptep(Compte cptep) {
		this.cptep = cptep;
	}

	public List<Compte> getListcpte() {
		return listcpte;
	}

	public void setListcpte(List<Compte> listcpte) {
		this.listcpte = listcpte;
	}

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

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	// ==================== Méthodes ====================

	public String getSubForm() {
		return SUCCESS;
	}

	/**
	 * Action listant les comptes d' {@link Client}
	 * 
	 * @return success
	 */

	public String comptes() {
		client = metier.getClient(idclient);
		listcpte = metier.getComptesByClient(idclient);
		return SUCCESS;
	}
	
	
	/**
	 * Action permettant d'ajouter les bouttons radio
	 * et mettre en session l'id du compte
	 * @return success
	 */
	public String consulter() {
		compte = metier.consulterCompte(idcpte);
		numeroCompte = compte.getNumeroCompte();
		this.session.put("cpte", compte);
		this.session.put("numCpte", numeroCompte);
		typeOp = new ArrayList<String>();
		typeOp.add("Versement");
		typeOp.add("Retrait");
		typeOp.add("Virement");
		listeop = metier.consulterOperations(numeroCompte);
		return SUCCESS;
	}

	/**
	 * Action pour faire les opérations Versement, Retrait et Virement
	 * 
	 * @return success
	 */

	public String saveoperation() {
		typeOp = new ArrayList<String>();
		typeOp.add("Versement");
		typeOp.add("Retrait");
		typeOp.add("Virement");
		
		if (typeOperation.equals("Versement")) {
			employe = (Employe) this.session.put("user", employe);
			this.session.put("user", employe);
			compte = (Compte) this.session.put("cpte", compte);
			//this.session.put("cpte", compte);
			numeroCompte = compte.getNumeroCompte();
			metier.verser(montant, numeroCompte, employe.getCodeEmployer());
			listeop = metier.consulterOperations(numeroCompte);

		} else if (typeOperation.equals("Retrait")) {
			employe = (Employe) this.session.put("user", employe);
			this.session.put("user", employe);
			compte = (Compte) this.session.put("cpte", compte);
		//	this.session.put("cpte", compte);
			numeroCompte = compte.getNumeroCompte();
			metier.retirer(montant, numeroCompte, employe.getCodeEmployer());
			listeop = metier.consulterOperations(numeroCompte);
		}
		if (typeOperation.equals("Virement")) {
			employe = (Employe) this.session.put("user", employe);
			this.session.put("user", employe);
			compte = (Compte) this.session.put("cpte", compte);
			//this.session.put("cpte", compte);
			numeroCompte = compte.getNumeroCompte();
			compte2 = metier.consulterCompte(idcpte2);
			numeroCompte2 = compte2.getNumeroCompte();
			metier.retirer(montant, numeroCompte, employe.getCodeEmployer());
			metier.verser(montant, numeroCompte2, employe.getCodeEmployer());
			listeop = metier.consulterOperations(numeroCompte);
		}
		return SUCCESS;
	}

	/**
	 * Action permettant la connexion d'un utilisateur
	 * 
	 * @return input / success
	 */
	public String doLogin() {
		String vResult = ActionSupport.INPUT;
		try {
			employe = metier.getEmploye(employe.getLogin(), employe.getPassword());
			this.session.put("user", employe);
			vResult = ActionSupport.SUCCESS;
		} catch (Exception e) {
			throw new RuntimeException("ko ko");
		}
		return vResult;
	}

	/**
	 * Action permettant de créer un nouveau {@link Client}
	 * 
	 * @return success
	 */
	public String save() {
		employe = (Employe) this.session.put("user", employe);
		this.session.put("user", employe);
		idemp = employe.getCodeEmployer();
		client = new Client(client.getNomClient(), client.getAdresseClient(),client.getEmailClient(),client.getTelClient(), employe);
		if (typeEpargne == true && typeCourant == false) {
			System.out.println("j'ai choisi Epargne !!!");
			metier.addClient(client);
			metier.addCompte(cptep, client.getCodeClient(), idemp);
			client = new Client();
		} else if (typeEpargne == false && typeCourant == true) {
			System.out.println("j'ai choisi Courant !!!");
			metier.addClient(client);
			metier.addCompte(cptcou, client.getCodeClient(), idemp);
			client = new Client();
		} else if (typeEpargne == true && typeCourant == true) {
			System.out.println("j'ai choisi Courant / Epargne !!!");
			metier.addClient(client);
			metier.addCompte(cptep, client.getCodeClient(), idemp);
			metier.addCompte(cptcou, client.getCodeClient(), idemp);
			client = new Client();
		}
		listclient = metier.consulterClients(idemp);
		return ActionSupport.SUCCESS;
	}

	/**
	 * Action permettant d'éditer {@link Client}
	 * 
	 * @return success
	 */
	public String edit() {
		employe = (Employe) this.session.put("user", employe);
		this.session.put("user", employe);
		client = metier.editer(idclient);
		listclient = metier.consulterClients(employe.getCodeEmployer());
		return SUCCESS;
	}


	/**
	 * Action permettant de faire modifier {@link Client}
	 * 
	 * @return success
	 */
	public String update() {
		employe = (Employe) this.session.put("user", employe);
		this.session.put("user", employe);
		idemp = employe.getCodeEmployer();
		client = new Client(client.getCodeClient(), client.getNomClient(), client.getAdresseClient(),client.getEmailClient(),client.getTelClient(), employe);
		metier.updateClient(client);
		if (typeEpargne == true) {
			metier.addCompte(cptep, client.getCodeClient(), idemp);
		}
		if (typeCourant == true) {
			metier.addCompte(cptcou, client.getCodeClient(), idemp);
		}
		client = new Client();
		listclient = metier.consulterClients(idemp);
		return SUCCESS;
	}

	/**
	 * Action de déconnexion d'un utilisateur
	 * 
	 * @return success
	 */
	public String doLogout() {
		this.session.remove("user");
		return ActionSupport.SUCCESS;
	}

	public String doList() {
		String vResult = ActionSupport.INPUT;
		try {
			employe = (Employe) this.session.put("user", employe);
			listclient = metier.consulterClients(employe.getCodeEmployer());
			this.session.put("user", employe);
			vResult = ActionSupport.SUCCESS;
		} catch (Exception e) {
			throw new RuntimeException("ko ko");
		}
		return vResult;
	}
}
