package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
public class User {
	private String firstName;
	private String middleName;
	private String lastName;
	@Id
	private String username;
	private String email;
	private String password;
	private String salt;
	@OneToOne(cascade=CascadeType.ALL)
	private Address billingAddress;
	@OneToOne(cascade=CascadeType.ALL)
	private Address shippingAddress;
	
	private Collection<Integer> purchasedProducts;
	
	protected User(){}
	
	public User(String firstName, String middleName, String lastName, 
			String username, String email, String pw,
			Address billingAddress, Address shippingAddress) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.salt = BCrypt.gensalt(12);
		this.password = BCrypt.hashpw(pw, salt);
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		
		purchasedProducts = new ArrayList<Integer>();
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", salt="
				+ salt + ", billingAddress=" + billingAddress
				+ ", shippingAddress=" + shippingAddress + "]";
	}

	
}
