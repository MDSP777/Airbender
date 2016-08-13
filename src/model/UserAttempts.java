package model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAttempts {
	@Id
	private String username;
	private int attempts;
	private Date lastModified;
	private boolean isLocked;
	
	protected UserAttempts(){}
	
	public UserAttempts(String user) {
		super();
		this.username = user;
		this.attempts = 0;
		this.lastModified = Calendar.getInstance().getTime();
		isLocked = false;
	}

	public String getUsername() {
		return username;
	}

	public int getAttempts() {
		return attempts;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
		updateLastModifiedDate();
	}

	private void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public void updateLastModifiedDate() {
		setLastModified(Calendar.getInstance().getTime());
	}
	
	public void lock(){
		isLocked = true;
	}
	
	public void unlock(){
		isLocked = false;
	}
	
	public boolean isLocked(){
		return isLocked; 
	}
	
}
