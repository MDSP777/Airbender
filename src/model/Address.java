package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int houseNum;
	private String street;
	private String subdivision;
	private String city;
	private int postalCode;
	private String country;
	
	protected Address(){}
	
	public Address(int houseNum, String street, String subdivision,
			String city, int postalCode, String country) {
		super();
		this.houseNum = houseNum;
		this.street = street;
		this.subdivision = subdivision;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public int getHouseNum() {
		return houseNum;
	}

	public String getStreet() {
		return street;
	}

	public String getSubdivision() {
		return subdivision;
	}

	public String getCity() {
		return city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNum=" + houseNum + ", street="
				+ street + ", subdivision=" + subdivision + ", city=" + city
				+ ", postalCode=" + postalCode + ", country=" + country + "]";
	}
	
	
}
