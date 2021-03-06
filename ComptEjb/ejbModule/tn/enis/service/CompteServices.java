package tn.enis.service;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.enis.dao.CompteDao;
import tn.enis.entity.Compte;

/**
 * Session Bean implementation class CompteServices
 */
@Stateless
@LocalBean
public class CompteServices {

	@EJB
	private CompteDao compteDao;

	public void save(Compte compte) {
		compteDao.save(compte);
	}

	public void delete(Compte compte) {
		compteDao.delete(compte);
	}

	public void update(Compte compte) {
		compteDao.update(compte);
	}

	public Compte getById(Long rib) {
		return compteDao.getById(rib);
	}



}
