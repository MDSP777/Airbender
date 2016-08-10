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
	public static String REGULAR = "regular";
	public static String PRODUCT_MANAGER = "PM";
	public static String ACCOUNTING_MANAGER = "AM";
	public static String ADMIN = "admin";
	
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
	private String userType;
	
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
		this.userType = User.REGULAR;
		
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
	
	public void order(Product p, int quantity, String creditCard){
		Purchase o = new Purchase(this, p, quantity, creditCard);
		oService.addPurchase(o);
		purchasedProducts.add(p.getId());
	}
	
	public boolean hasPurchased(Product p){
		return purchasedProducts.contains(p.getId());
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		if(valid(userType)) this.userType = userType;
	}
	
	private boolean valid(String type) {
		return type.equals(REGULAR) ||
				type.equals(PRODUCT_MANAGER) ||
				type.equals(ACCOUNTING_MANAGER) ||
				type.equals(ADMIN);
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
