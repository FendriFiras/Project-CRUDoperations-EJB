package tn.enis.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class ShopService
 */
@Stateful
@LocalBean
public class ShopService {
	private double total;
	private List <ProductDto> products=new ArrayList<>();
	public void add (ProductDto product) {
		products.add(product);
		
	}
	public void delete (int index) {
		products.remove(index);
		
	}
	public List <ProductDto>listProduits(){
		for(int j=0 ;j<products.size();j++) {
			for(int i =j+1;i<products.size();i++) {
				if(products.get(j).equals(products.get(i))) {
					products.get(j).setQuantity(products.get(j).getQuantity()+products.get(i).getQuantity());
					products.remove(i);
				}
			}
		}
		return products;
		
	}
	public double pTotal () {
		this.total=0;
		for(int i=0;i<products.size();i++) {
			this.total=this.total+products.get(i).getPrice()*products.get(i).getQuantity();
		}
		return this.total;
		
	}
	public ProductDto item(int i) {
		return products.get(i);
	}
	public void editItem(int i, String name, int quantity, float price) {
		products.get(i).setName(name);
		products.get(i).setQuantity(quantity);
		products.get(i).setPrice(price);
	}
	

}
