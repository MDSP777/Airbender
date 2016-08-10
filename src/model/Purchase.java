package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Purchase {
	public static String TOTAL = "total";
	public static String CATEGORY = "category";
	public static String PRODUCT = "product";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private User user;
	@OneToOne
	private Product product;
	private int quantity;
	private double totalPrice;
	private String creditCard;
	
	protected Purchase(){}
	
	public Purchase(User user, Product product, int quantity, String creditCard) {
		super();
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.creditCard = creditCard;
		this.totalPrice = product.getPrice()*this.quantity;
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	
	public String getCreditCard(){
		return creditCard;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", product=" + product.getId()
				+ ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
