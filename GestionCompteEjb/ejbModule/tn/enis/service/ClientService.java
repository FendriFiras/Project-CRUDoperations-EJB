package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import tn.enis.dao.ClientDao;
import tn.enis.entities.Client;
import tn.enis.entities.Compte;

@Stateless
@LocalBean
@Path("/clients/")
public class ClientService {
	
	@EJB
	private ClientDao dao;
	
	 
	 public void save(Client client) {
	    dao.save(client);
	 }
	    
	 public Client getById(String cin) {
		return dao.getById(cin);
	}
		
	public void delete (String cin) {
		Client client = getById(cin);
		dao.delete(client);
	}
		
	public void update(Client client) {
		dao.update(client);
	}
	
	@GET
	@Path("clients")
	@Produces({"application/json"})
	public List<Client> getAllClient(){
		return dao.getAll();
	}
	
	@GET
	@Path("comptes-by-cin/{cin}")
	@Produces({"application/json"})
	public List<Compte> getComptesByCin(@PathParam("cin")String cin){
		Client client = dao.getById(cin);
		return dao.getComptes(client);
		}013023


}
