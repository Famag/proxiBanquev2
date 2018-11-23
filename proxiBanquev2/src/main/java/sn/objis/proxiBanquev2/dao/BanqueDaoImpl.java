package sn.objis.proxiBanquev2.dao;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sn.objis.proxiBanquev2.entities.Client;
import sn.objis.proxiBanquev2.entities.Compte;
import sn.objis.proxiBanquev2.entities.Employe;
import sn.objis.proxiBanquev2.entities.Operations;
import sn.objis.proxiBanquev2.utils.MethodUtils;




public class BanqueDaoImpl implements IBanqueDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Client addClient(Client c) {
	em.persist(c);
		return c;
	}

	@Override
	public Employe  addEmploye(Employe conseiller) {
		em.persist(conseiller);
		return conseiller;
	}
	@Override
	public Compte  addCompte(Compte compte, Long codeClient, Long codeEmploye) {
		Client cl = em.find(Client.class, codeClient);
		Employe emp = em.find(Employe.class, codeEmploye);
		compte.setClient(cl);
		compte.setEmploye(emp);
		compte.setNumeroCompte(MethodUtils.genererNumero(this.maxIdClient(), compte.getClass().getSimpleName()));
		em.persist(compte);
		return compte;
	}

	@Override
	public Operations addOperation(Operations operation, String codeCompte, Long codeEmploye) {
		Compte cp = consulterCompte(codeCompte); 
		Employe emp = em.find(Employe.class, codeEmploye);
		operation.setCompte(cp);
		operation.setEmploye(emp);
		em.persist(operation);
		return operation;
	}

	@Override
	public Compte consulterCompte(String codeCompte) {
	Compte cp = em.find(Compte.class, codeCompte);
	if (cp == null) throw new RuntimeException("Compte introuvable !!!");
	return cp;
	}

	@Override
	public List<Operations> consulterOperations(String codeCpte) {
		Query  req = em.createQuery("select o from Operations o where o.compte.numeroCompte= :x");
		req.setParameter("x", codeCpte);
		return req.getResultList();
	}
	
	@Override
	public List<Client> consulterClients(Long codeEmploye) {
	Query req = em.createQuery("select c from Client  c  where  c.employe.codeEmployer = :x ");
	req.setParameter("x", codeEmploye);
	return req.getResultList();
	}

	@Override
	public List<Compte> getComptesByClient(Long codeClient) {
		Query req = em.createQuery("select c from Compte  c  where  c.client.codeClient = :x ");
		req.setParameter("x", codeClient);
		return req.getResultList();
	}

	@Override
	public List<Employe> getAllEmployes() {
		Query req = em.createQuery("select e from Employe e ");
		return req.getResultList();
	}

	@Override
	public Employe findEmploye(Long codeEmp) {
		Employe emp = em.find(Employe.class, codeEmp);
	return emp;
	}

	@Override
	public List<Client> findAll() {
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

	@Override
	public Long maxIdClient() {
		Query req = em.createQuery("select max(codeClient) from Client");
		return (Long) req.getSingleResult();
	}

	@Override
	public Client editer(Long id) {
	Client client = em.find(Client.class, id);
	return client;
	}

	@Override
	public Client updateClient(Client c) {
	return em.merge(c);
	}

	@Override
	public Client getClient(Long id) {
		// TODO Auto-generated method stub
		return em.find(Client.class, id);
	}

	@Override
	public Employe getEmploye(String login, String password) {
		Query req = em.createQuery("select e from Employe  e  where  e.login = :x and e.password = :y ");
		req.setParameter("x", login);
		req.setParameter("y", password);
		List <Employe> user = req.getResultList();
		if(user.isEmpty()) {
			return null;
		}else {
		return  user.get(0);
	}
}
}