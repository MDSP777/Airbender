package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String username;
	private String email;
	private String password;
	private String salt;
	@OneToOne(cascade=CascadeType.ALL)
	private Address billingAddress;
	@OneToOne(cascade=CascadeType.ALL)
	private Address shippingAddress;
	
	public User(String name, String username, String email, String pw,
			Address billingAddress, Address shippingAddress) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.salt = BCrypt.gensalt(12);
		this.password = BCrypt.hashpw(pw, salt);
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username
				+ ", email=" + email + ", billingAddress=" + billingAddress
				+ ", shippingAddress=" + shippingAddress + "]";
	}
	
	
}
