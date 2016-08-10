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
	
	public void updateProduct(Product p){
		openTransaction();
		try{
			entityManager.merge(p);
		} finally {
			closeTransaction();
		}
	}
	
	public void deleteProduct(Product p){
		openTransaction();
		try{
			entityManager.remove(p);
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
	
	public Product getProduct(int id)
	{
		openTransaction();
		try{
			TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p "
					+ "WHERE p.id=:id", Product.class)
					.setParameter("id", id);
			return query.getSingleResult();
		} finally {
			closeTransaction();
		}
		
	}
	
	public Collection<Product> getAllProducts(){
		openTransaction();
		try{
			TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p ", Product.class);
			return query.getResultList();
		} finally {
			closeTransaction();
		}
	}
	
	
	public Product findBy(int id) {
		openTransaction();
		try{
			return entityManager.find(Product.class, id);
		} finally {
			closeTransaction();
		}
	}
}
