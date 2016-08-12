package model;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import service.ProductService;
import service.PurchaseService;

@Entity
@Component
public class User {
	public static String REGULAR = "regular";
	public static String PRODUCT_MANAGER = "PM";
	public static String ACCOUNTING_MANAGER = "AM";
	public static String ADMIN = "admin";
	public static String INACTIVE_PM = "inactive_pm";
	public static String INACTIVE_AM = "inactive_am";
	
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Transient
	private static PurchaseService oService;
	@Transient
	private static ProductService pService;
	
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
		this.setPassword(pw);
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.userType = User.REGULAR;
		this.dateCreated = Calendar.getInstance().getTime();
		
		purchasedProducts = new HashSet<Integer>();
	}

	@PostConstruct
	public void init() {
	    System.out.println("Initializing PurchaseService as [" +
	                oService + "]"
	               + ", ProductService as [" + pService + "]");
	}
	
	@Autowired
	public void setPurchaseService(PurchaseService oService) {
	    User.oService = oService;
	}
	
	@Autowired
	public void setProductService(ProductService pService) {
	    User.pService = pService;
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
	
	public void setPassword(String password){
		this.salt = BCrypt.gensalt(12);
		this.password = BCrypt.hashpw(password, salt);
	}

	public void setUserType(String userType) {
		if(valid(userType)) this.userType = userType;
	}
	
	private boolean valid(String type) {
		return type.equals(REGULAR) ||
				type.equals(PRODUCT_MANAGER) ||
				type.equals(ACCOUNTING_MANAGER) ||
				type.equals(ADMIN) ||
				type.equals(INACTIVE_PM) ||
				type.equals(INACTIVE_AM);
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", billingAddress=" + billingAddress
				+ ", shippingAddress=" + shippingAddress + ", userType="
				+ userType + "]";
	}

	public boolean review(Product p, String content){
		if(purchasedProducts.contains(p.getId())){
			Review r = new Review(p, this, content);
			p.addReview(r);
			pService.updateProduct(p);
			return true;
		}
		else
		{
			return false;
		}
	}

	public void activateUserType() {
		if(userType.equals(INACTIVE_AM)) userType = ACCOUNTING_MANAGER;
		else if(userType.equals(INACTIVE_PM)) userType = PRODUCT_MANAGER;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public boolean isActivated() {
		return !(userType.equals(INACTIVE_AM) ||
				userType.equals(INACTIVE_PM));
	}
	
	
}
