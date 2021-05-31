package tn.enis.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.Compte;

/**
 * Session Bean implementation class CompteDao
 */
@Singleton
@LocalBean
public class CompteDao {

	@PersistenceContext
	private EntityManager em;

	public void save(Compte compte) {
		em.persist(compte);
	}

	public void delete(Compte compte) {
		em.remove(compte);
	}

	public void update(Compte compte) {
		em.merge(compte);
	}

	public Compte getById(Long rib) {
		return em.find(Compte.class, rib);
	}

	public List<Compte> getAll() {
		return em.createQuery("from Compte", Compte.class).getResultList();
	}

}
