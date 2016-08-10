package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private User user;
	@OneToOne
	private Product product;
	private int quantity;
	private double totalPrice;
	
	protected Order(){}
	
	public Order(User user, Product product, int quantity, double totalPrice) {
		super();
		this.user = user;
		this.product = product;
		this.quantity = quantity;
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
	
	
}
