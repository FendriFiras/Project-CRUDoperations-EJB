package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.enis.dao.ProductDao;
import tn.enis.entity.Product;

/**
 * Session Bean implementation class ShopService
 */
@Stateless
@LocalBean
public class ShopService {
	@EJB
	private ProductDao productDao;

	public void save(Product product) {
		productDao.save(product);
	}

	public void delete(Long id) {
		productDao.delete(id);
	}

	public void update(Product product, Long id) {
		productDao.update(product, id);
	}

	public Product getById(Long id) {
		return productDao.getById(id);
	}

	public List<Product> getAll() {
		return productDao.getAll();
	}

}
