package sn.objis.proxiBanquev2.services;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.objis.proxiBanquev2.dao.IBanqueDao;
import sn.objis.proxiBanquev2.entities.Client;
import sn.objis.proxiBanquev2.entities.Compte;
import sn.objis.proxiBanquev2.entities.Employe;
import sn.objis.proxiBanquev2.entities.Operations;
import sn.objis.proxiBanquev2.entities.Retrait;
import sn.objis.proxiBanquev2.entities.Versement;


@Transactional
public class BanqueServiceImpl implements IBanqueService {
	
	//Couplage faible
	private IBanqueDao  dao;

	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
	return dao.addClient(c);
	}

	@Override
	public Employe addEmploye(Employe conseiller) {
	return dao.addEmploye(conseiller);
	}
	@Override
	public Compte addCompte(Compte compte, Long codeClient, Long codeEmploye) {
	return dao.addCompte(compte, codeClient, codeEmploye);
	}

	@Override
	public Operations addOperation(Operations operation, String codeCompte, Long codeEmploye) {
	return dao.addOperation(operation, codeCompte, codeEmploye);
	}

	@Override
	public Compte consulterCompte(String codeCompte) {
	return dao.consulterCompte(codeCompte);
	}

	@Override
	public List<Operations> consulterOperations(String codeCompte) {
	return dao.consulterOperations(codeCompte);
	}

	@Override
	public List<Compte> getComptesByClient(Long codeClient) {
	return dao.getComptesByClient(codeClient);
	}

	@Override
	public List<Employe> getAllEmployes() {
	return dao.getAllEmployes();
	}


	@Override
	public List<Client> consulterClients(Long  codeEmploye) {
	return dao.consulterClients(codeEmploye);
	}

	@Override
	public void retirer(double mnt, String cpt, Long CodeEmploye) {
		dao.addOperation(new Retrait(new Date(), mnt), cpt, CodeEmploye);
		Compte cp = dao.consulterCompte(cpt);
		cp.setSolde(cp.getSolde()-mnt);
		
	}

	@Override
	public void verser(double mnt, String cpt, Long CodeEmploye) {
	dao.addOperation(new Versement(new Date(), mnt), cpt, CodeEmploye);
	Compte cp = dao.consulterCompte(cpt);
	cp.setSolde(cp.getSolde()+mnt);
		
	}

	@Override
	public void virement(double mnt, String cpt1, String cpt2, Long CodeEmploye) {
	retirer(mnt, cpt1, CodeEmploye);
	verser(mnt, cpt2, CodeEmploye);		
	}

	@Override
	public Employe findEmploye(Long codeEmp) {
	return dao.findEmploye(codeEmp);
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Long maxIdClient() {
		if (dao.maxIdClient()==null) {
			return 1L;
		}else {
	return dao.maxIdClient()+1;
	}
		
	}

	@Override
	public Client editer(Long id) {
	return dao.editer(id);
	}

	@Override
	public Client updateClient(Client c) {
		// TODO Auto-generated method stub
		return dao.updateClient(c);
	}

	@Override
	public Client getClient(Long id) {
		// TODO Auto-generated method stub
		return dao.getClient(id);
	}

	@Override
	public Employe getEmploye(String login, String password) {
		// TODO Auto-generated method stub
		return dao.getEmploye(login, password);
	}

}
