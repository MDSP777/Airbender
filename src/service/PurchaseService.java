package service;

import java.util.Collection;

import javax.persistence.TypedQuery;

import model.Purchase;
import model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import exceptions.InvalidCategoryException;
import exceptions.InvalidIdException;

@Repository
public class PurchaseService extends JpaService {
	
	public void addPurchase(Purchase o){
		openTransaction();
		try{
			entityManager.persist(o);
		} finally {
			closeTransaction();
		}
	}
	
	public double getTotalSales(){
		openTransaction();
		try{
			TypedQuery<Double> query = 
					entityManager.createQuery("SELECT sum(o.totalPrice) FROM Purchase o", Double.class);
			return query.getResultList().get(0);
		} finally {
			closeTransaction();
		}
	}
	
	public Collection<Object[]> getTotalSalesByType(){
		openTransaction();
		try{
			TypedQuery<Object[]> query = entityManager.createQuery("SELECT p.category, sum(o.totalPrice) "
					+ "FROM Purchase o "
					+ "LEFT JOIN o.product p "
					+ "GROUP BY p.category", Object[].class);
			return query.getResultList();
		} finally {
			closeTransaction();
		}
	}
	
	public Collection<Object[]> getTotalSalesById() {
		openTransaction();
		try{
			TypedQuery<Object[]> query = entityManager.createQuery("SELECT p.name, sum(o.totalPrice) "
					+ "FROM Purchase o "
					+ "LEFT JOIN o.product p "
					+ "GROUP BY p.name", Object[].class);
			return query.getResultList();
		} finally {
			closeTransaction();
		}
	}
}
