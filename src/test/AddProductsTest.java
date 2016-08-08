package test;

import model.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ApplicationContext.xml" })
public class AddProductsTest {
	@Autowired
	private ProductService pService;

	@Test
	public void addProducts(){
		Product boots1 = new Product("Boots 1", "hello world", Product.BOOTS, 125);
		Product boots2 = new Product("Boots 2", "goodbye world", Product.BOOTS, 250);

		Product shoes1 = new Product("Shoes 1", "hello world", Product.SHOES, 125);
		Product shoes2 = new Product("Shoes 2", "goodbye world", Product.SHOES, 250);

		Product sandals1 = new Product("Sandals 1", "hello world", Product.SANDALS, 125);
		Product sandals2 = new Product("Sandals 2", "goodbye world", Product.SANDALS, 250);

		Product slippers1 = new Product("Slippers 1", "hello world", Product.SLIPPERS, 125);
		Product slippers2 = new Product("Slippers 2", "goodbye world", Product.SLIPPERS, 250);

		pService.addProduct(boots1);
		pService.addProduct(boots2);
		pService.addProduct(shoes1);
		pService.addProduct(shoes2);
		pService.addProduct(sandals1);
		pService.addProduct(sandals2);
		pService.addProduct(slippers1);
		pService.addProduct(slippers2);
	}
}
