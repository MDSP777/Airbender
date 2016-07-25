@@ -1,65 +1,40 @@
package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User 
{
	private String username;
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	private Address billingAddress;
	@OneToOne(cascade=CascadeType.ALL)
	private Address shippingAddress;
	
	public User(String name, String username, String email,
			Address billingAddress, Address shippingAddress) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
		this.password = password;
		this.id = id;
	}

	public String getEmail() {
		return email;
	public void setUsername(String username) {
		this.username = username;
	}

	public Address getBillingAddress() {
		return billingAddress;

	public Address getShippingAddress() {
		return shippingAddress;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username
				+ ", email=" + email + ", billingAddress=" + billingAddress
				+ ", shippingAddress=" + shippingAddress + "]";
	
}