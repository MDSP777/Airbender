package service;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserService extends JpaService {
	public void addUser(User u){
		openTransaction();
		try{
			entityManager.persist(u);
		} finally {
//			closeTransaction();
		}
	}
	
	public String getHashFor(String username){
		openTransaction();
		try{
			TypedQuery<String> q = entityManager.createQuery("SELECT password FROM User u "
					+ "WHERE u.username=:username", String.class)
					.setParameter("username", username);
			return q.getResultList().get(0);
		} finally {
			closeTransaction();
		}
	}
}
