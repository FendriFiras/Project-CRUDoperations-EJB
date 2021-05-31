package tn.enis.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.enis.entities.Client;
import tn.enis.entities.Compte;

@Singleton
@LocalBean
public class ClientDao {
	
	@PersistenceContext
    private EntityManager em;
	
	public void save(Client client) {
		em.persist(client);
	}
	
	public Client getById(String cin) {
		return em.find(Client.class, cin);
	}
	
	public void delete (Client client) {
		em.remove(client);
	}
	
	public void update(Client client) {
		em.merge(client);
	}
	
	public List<Client> getAll(){
		return em.createQuery("select cp FROM Client cp", Client.class).getResultList();
	}
	
	public List<Compte> getComptes(Client client){
		TypedQuery<Compte> query = em.createQuery("select cp FROM Compte cp where cp.client = :client", Compte.class);
		query.setParameter("client", client);
		List<Compte> comptes = query.getResultList();
		return comptes;
		
	}

}
