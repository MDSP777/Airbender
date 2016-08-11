package model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	@OneToOne
	private User user;
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePosted;
	private String content;
	
	protected Review(){}

	public Review(Product product, User user, String content) {
		super();
		this.product = product;
		this.user = user;
		this.content = content;
		this.datePosted = Calendar.getInstance().getTime();
	}

	public int getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public User getUser() {
		return user;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public String getContent() {
		return content;
	}
	
	public String getUsername(){
		return user.getUsername();
	}
}
