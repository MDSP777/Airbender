package model;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import service.PurchaseService;

@Entity
@Component
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
	@ElementCollection
	private Collection<Integer> purchasedProducts;
	
	@Transient
	private static PurchaseService oService;
	
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
		
		purchasedProducts = new HashSet<Integer>();
	}

	@PostConstruct
	public void init() {
	    System.out.println("Initializing PurchaseService as [" +
	                oService + "]");
	}
	
	@Autowired
	public void setPurchaseService(PurchaseService oService) {
	    this.oService = oService;
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
	
	public void order(Product p, int quantity){
		Purchase o = new Purchase(this, p, quantity);
		oService.addPurchase(o);
		purchasedProducts.add(p.getId());
	}
	
	public boolean hasPurchased(Product p){
		return purchasedProducts.contains(p.getId());
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
