package tn.enis.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.Compte;
import tn.enis.entity.Product;

@Singleton
@LocalBean
public class ProductDao {
	@PersistenceContext
	private EntityManager em;

	public void save(Product product) {
		em.persist(product);
	}

	public void delete(Long id) {
		em.createQuery("delete from Product p where p.id=:id").setParameter("id", id).executeUpdate();

	}

	public void update(Product product, Long id) {
		em.createQuery("UPDATE Product AS p SET p.name =:name,p.price=:price,p.quantity=:quantity where p.id=:id")
				.setParameter("name", product.getName()).setParameter("price", product.getPrice())
				.setParameter("quantity", product.getQuantity()).setParameter("id", id).executeUpdate();

	}

	public Product getById(Long id) {
		return em.find(Product.class, id);
	}

	public List<Product> getAll() {
		return em.createQuery("from Product", Product.class).getResultList();
	}

}
