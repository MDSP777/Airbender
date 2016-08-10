package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import exceptions.UsernameOrEmailAlreadyTakenException;
import model.Address;
import model.Purchase;
import model.User;
import service.ProductService;
import service.PurchaseService;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private ProductService pService;
	@Autowired
	private PurchaseService oService;
	private User user;
	
	@RequestMapping({"/signup"})
	public void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/signup.jsp").forward(request, response);
	}

	@RequestMapping({"/pm"})
	public void productManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/productManager.jsp").forward(request, response);
	}
	
	@RequestMapping({"/view_sales_reports"})
	public void accountingManager(@RequestParam String type, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("type", type);
		Collection<Object[]> results = new ArrayList<Object[]>();
		if(Purchase.TOTAL.equals(type)){
			double totalSales = oService.getTotalSales();
			results.add(new Object[]{"Total Sales", totalSales});
		} else if(Purchase.CATEGORY.equals(type)){
			results = oService.getTotalSalesByType();
		} else if(Purchase.PRODUCT.equals(type)){
			results = oService.getTotalSalesById();
		} else {
			
		}
		request.setAttribute("sales", results);
		request.getRequestDispatcher("WEB-INF/view/financialManager.jsp").forward(request, response);
	}
	
	@RequestMapping({"/ad"})
	public void admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/admin.jsp").forward(request, response);
	}
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
	public void loginPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String username = request.getParameter("username");
		String pw = request.getParameter("password");
		
		String hash = uService.getHashFor(username);
		if(BCrypt.checkpw(pw, hash)){
			User u = uService.findBy(username);
			request.getSession().setAttribute("user", u);
			user = u;
			response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		} else {
			response.sendRedirect("");
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.sendRedirect("");
	}
	
	@RequestMapping({"/logout"})
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if(user!=null){
			System.out.println("Logging out "+user.getUsername());
			user = null;
			request.getSession().setAttribute("user", user);
			request.getSession().invalidate();
		}
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", "https://localhost:8443/SECURDE/");
//		response.sendRedirect("");
	}
	
	@RequestMapping({"/register"})
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pw = request.getParameter("password");

		String fName = request.getParameter("fname");
		String mName = request.getParameter("mname");
		String lName = request.getParameter("lname");

		String billHouseNum = request.getParameter("billHouseNum");
		String billStreet = request.getParameter("billStreet");
		String billSubd = request.getParameter("billSubd");
		String billCity = request.getParameter("billCity");
		String billPostal = request.getParameter("billPostal");
		String billCountry = request.getParameter("billCountry");
		
		String shipHouseNum = request.getParameter("shipHouseNum");
		String shipStreet = request.getParameter("shipStreet");
		String shipSubd = request.getParameter("shipSubd");
		String shipCity = request.getParameter("shipCity");
		String shipPostal = request.getParameter("shipPostal");
		String shipCountry = request.getParameter("shipCountry");

		Address billingAddress = new Address(billHouseNum, billStreet, billSubd, billCity, billPostal, billCountry);
		Address shippingAddress = new Address(shipHouseNum, shipStreet, shipSubd, shipCity, shipPostal, shipCountry);
		
		try {
			uService.validate(email, username);
			User u = new User(fName, mName, lName, username, email, pw, billingAddress, shippingAddress);
			uService.register(u);
			response.sendRedirect("");
		} catch (UsernameOrEmailAlreadyTakenException e){
			e.printStackTrace();
		}	
		
	}

	@RequestMapping({"/purchase"})
	public void purchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
//		Product p = pService.findBy(Integer.parseInt(request.getParameter("productId")));
//		int quantity = Integer.parseInt(request.getParameter("quantity"));
//		String creditCard = request.getParameter("creditcard");
//		user.order(p, quantity, creditCard);
//		uService.update(user);
//		response.sendRedirect("/");
		System.out.println("HI "+request.getParameter("productId"));
		System.out.println("HI "+request.getParameter("price"));
		System.out.println("HI "+request.getParameter("quantity"));
		System.out.println("HI "+request.getParameter("creditcard"));
	}

//	@RequestMapping({"/testshit"})
//	public void goToTESTSHIT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
//		if(user!=null){
//			System.out.println("HI");
//			user.order(pService.findBy(2), 2);
//			user.order(pService.findBy(4), 2);
//			user.order(pService.findBy(6), 2);
//			user.order(pService.findBy(8), 2);
//			uService.update(user);
//			
//		}
//	}
}
