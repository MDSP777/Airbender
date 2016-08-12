package service;

import javax.persistence.TypedQuery;

import model.User;

import org.springframework.stereotype.Repository;

import exceptions.ExpiredAccountException;
import exceptions.UsernameOrEmailAlreadyTakenException;

@Repository
public class UserService extends JpaService {
	public void register(User u) throws UsernameOrEmailAlreadyTakenException{
		openTransaction();
		try{
			validate(u.getEmail(), u.getUsername());
			entityManager.persist(u);
			System.out.println("Added User: "+u);
		} finally {
			closeTransaction();
		}
	}
	
	public void update(User u){
		openTransaction();
		try{
			entityManager.merge(u);
			System.out.println("Updated User: "+u);
		} finally {
			closeTransaction();
		}
	}
	
	public User findBy(String username) throws ExpiredAccountException{
		openTransaction();
		try{
			System.out.println("Retrieving "+username);
			User user = entityManager.find(User.class, username);
			double diffInSecs = (System.currentTimeMillis()-user.getDateCreated().getTime())/1000;
			if(!user.isActivated() && diffInSecs>86400) throw new ExpiredAccountException();
			return user;
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
	
	public void validate(String email, String username) throws UsernameOrEmailAlreadyTakenException {
		TypedQuery<String> q = entityManager.createQuery("SELECT username FROM User u "
				+ "WHERE u.username=:username OR u.email=:email", String.class)
				.setParameter("username", username)
				.setParameter("email", email);
		if(!q.getResultList().isEmpty()){
			throw new UsernameOrEmailAlreadyTakenException("Username or email already taken.");
		}
	}
}
