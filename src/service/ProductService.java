package service;

import java.util.Collection;

import javax.persistence.TypedQuery;

import model.Product;

import org.springframework.stereotype.Repository;

import exceptions.InvalidCategoryException;

@Repository
public class ProductService extends JpaService {
	public void addProduct(Product p){
		openTransaction();
		try{
			entityManager.persist(p);
		} finally {
			closeTransaction();
		}
	}
	
	public Collection<Product> findByType(String type) throws InvalidCategoryException{
		openTransaction();
		try{
			if(!Product.isValidType(type)){
				throw new InvalidCategoryException(type);
			}
			TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p "
					+ "WHERE p.category=:category", Product.class)
					.setParameter("category", type);
			return query.getResultList();
		} finally {
			closeTransaction();
		}
	}
	
	
}
