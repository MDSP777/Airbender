package test;

import java.util.Calendar;

import model.Address;
import model.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ApplicationContext.xml" })
public class AddPostTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void addUser(){
		Address billingAddress = new Address(9, "Glacier Street", "Merville", "Paranaque City", 1700, "Philippines");
		Address shippingAddress = new Address(2401, "Taft Ave.", "Malate", "Manila", 1234, "Philippines");
		
		User u = new User("Marc San Pedro", "MDSP777", "mdsp777@outlook.com", 
				"helloworld", billingAddress, shippingAddress);
		userService.addUser(u);
		User u2 = new User("Marc San Pedro 2", "MDSP7772", "mdsp777@outlook.com", 
				"goodbyeworld", billingAddress, shippingAddress);
		userService.addUser(u2);
		
		String hash = userService.getHashFor("MDSP777");
		Assert.assertTrue(BCrypt.checkpw("helloworld", hash));
		hash = userService. getHashFor("MDSP7772");
		Assert.assertTrue(BCrypt.checkpw("goodbyeworld", hash));
	}
}
