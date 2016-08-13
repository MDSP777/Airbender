package service;

import javax.persistence.TypedQuery;

import model.UserAttempts;

import org.springframework.stereotype.Repository;

import exceptions.AccountLockedException;

@Repository
public class UserAttemptsService extends JpaService {
	private int MAX_ATTEMPTS = 5;
	private int WAIT_TIME = 900;
	
	public void updateFailedAttempts(String username) {
		openTransaction();
		try{
			UserAttempts ua = entityManager.find(UserAttempts.class, username);
			ua.setAttempts(ua.getAttempts()+1);
			if(ua.getAttempts()>=MAX_ATTEMPTS){
				ua.lock();
			}
			entityManager.merge(ua);
		} finally {
			closeTransaction();
		}
	}
	
	public void resetFailedAttempts(String username){
		openTransaction();
		try{
			UserAttempts ua = entityManager.find(UserAttempts.class, username);
			ua.setAttempts(0);
			ua.unlock();
			entityManager.merge(ua);
		} finally {
			closeTransaction();
		}
	}

	public boolean checkIfLocked(String username) {
		openTransaction();
		try {
			UserAttempts ua = entityManager.find(UserAttempts.class, username);
			if(ua==null){
				entityManager.persist(new UserAttempts(username));
				return false;
			}
			return ua.isLocked();
		} finally {
			closeTransaction();
		}
	}

	public boolean finishedWaitTime(String username) {
		openTransaction();
		try{
			UserAttempts ua = entityManager.find(UserAttempts.class, username);
			double diffInSecs = (System.currentTimeMillis()-ua.getLastModified().getTime())/1000;
			return diffInSecs>WAIT_TIME;
		} finally {
			closeTransaction();
		}
	}
}
