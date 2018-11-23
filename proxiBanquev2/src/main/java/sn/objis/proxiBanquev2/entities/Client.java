package sn.objis.proxiBanquev2.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CLIENTS")
public class Client implements Serializable {
	
	// ==================== Attributs ====================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODE_CLI")
	private Long codeClient;
    private String nomClient;
    private String adresseClient;
    private String emailClient;
    private String telClient;
    
    @OneToMany(mappedBy="client", fetch=FetchType.LAZY)
    private Collection<Compte> comptes;  // Un client peut avoir plusieurs comptes et la relation est bidirectionnelle

    @ManyToOne
    private Employe employe;
    
 // ==================== Getters/Setters ====================
	    
    public Long getCodeClient() {
		return codeClient;
	}
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	public String getTelClient() {
		return telClient;
	}
	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	// ==================== Constructeurs ====================
	public Client() {
		super();
	}
	
	public Client(Long codeClient) {
		super();
		this.codeClient = codeClient;
	}
	
	public Client(String nomClient, String adresseClient) {
		super();
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
	}
	public Client(String nomClient, String adresseClient,String emailClient, String telClient, Employe employe) {
		super();
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
		this.emailClient = emailClient;
		this.telClient = telClient;
		this.employe = employe;
	}
	
	public Client(Long codeClient, String nomClient, String adresseClient, String emailClient, String telClient,Employe employe) {
		super();
		this.codeClient = codeClient;
		this.nomClient = nomClient;
		this.adresseClient = adresseClient;
		this.emailClient = emailClient;
		this.telClient = telClient;
		this.employe = employe;
	}
	
	
	
	
}
