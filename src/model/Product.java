package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import exceptions.InvalidCategoryException;

@Entity
public class Product {
	public static String BOOTS = "boots";
	public static String SHOES = "shoes";
	public static String SANDALS = "sandals";
	public static String SLIPPERS = "slippers";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String category;
	private double price;
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private Collection<Review> reviews;
	
	protected Product(){}

	public Product(String name, String description, String category, double price) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		
		reviews = new ArrayList<Review>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCategory(String category) throws InvalidCategoryException {
		if(isValidType(category)){
			this.category = category;
		} else {
			throw new InvalidCategoryException(category);
		}
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static boolean isValidType(String type) {
		return type.equals(BOOTS) ||
				type.equals(SHOES) ||
				type.equals(SANDALS) ||
				type.equals(SLIPPERS);
	}

	public void addReview(Review r){
		reviews.add(r);
	}

	public Collection<Review> getReviews() {
		return reviews;
	}
	
	
}
