package service;

import model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserService extends JpaService {
	public void addUser(User u){
		openTransaction();
		try{
			entityManager.persist(u);
		} finally {
			closeTransaction();
		}
	}
}
