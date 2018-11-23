package sn.objis.proxiBanquev2.dao;

import java.util.List;

import javax.persistence.Query;



import sn.objis.proxiBanquev2.entities.Client;
import sn.objis.proxiBanquev2.entities.Compte;
import sn.objis.proxiBanquev2.entities.Employe;
import sn.objis.proxiBanquev2.entities.Operations;



public interface IBanqueDao {
	 
    public Client  addClient (Client c);
    public Client updateClient(Client c);
    public Client getClient(Long id);
    public Employe findEmploye(Long codeEmp);
    public Employe  addEmploye (Employe conseiller);
    public Compte  addCompte(Compte compte, Long codeClient, Long codeEmploye);
    public Operations  addOperation(Operations operation, String codeCompte, Long codeEmploye);
    public Compte consulterCompte(String codeCompte);   
    public List<Operations> consulterOperations(String codeCompte);   
    public List<Compte> getComptesByClient(Long codeClient);
    public List<Employe> getAllEmployes();
    public List<Client> consulterClients(Long codeEmploye);
    public List<Client> findAll();
   public Long maxIdClient();
   public Client editer(Long id);
   public Employe getEmploye(String login, String password);
}
