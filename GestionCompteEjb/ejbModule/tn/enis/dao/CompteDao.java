package tn.enis.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entities.Client;
import tn.enis.entities.Compte;

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
	
	public Compte getById(Long rib) {
		return em.find(Compte.class, rib);
	}
	
	public void delete (Compte compte) {
		em.remove(compte);
	}
	
	public void update(Compte compte) {
		em.merge(compte);
	}
	
	public List<Compte> getAll(){
		return em.createQuery("select cp FROM Compte cp", Compte.class).getResultList();
	}
	public void test() {
		Client client = new Client("015", "Molka", "Moalla", "Sfax");
		em.persist(client);
		
		Compte c1 = new Compte(client, 200);
		em.persist(c1);
		
		System.out.println(c1.getClient().getPrenom() + " " + c1.getSolde() );
		
		/* lorsqu'on ne fait pas mappedBy
		 * TypedQuery<Compte> query = em.createQuery("select cp from Compte cp wherre cp.client.cin = :cin,Compte.class);
		 * query.setParameter("cin", "015");
		 * List<Compte> comptes = query.getResultList();
		 * if (comptes != null && !comptes.isEmpty){
		 * compte = comptes.get(0);
		 * system.out.println(compte.getSolde()); */
		
		
		//client.setCompte(c1); // choix1
		// Client client = em .find(client.class, "015"); // choix 2 lorsqu'on a déja dans la base donnée si non elle ne marche pas car 
															//elle est dans lab mememethode meme transaction 
	//	System.out.println(client.getCompte().getSolde());
		
	
	}

}
