package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Purchase;
import model.Product;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import exceptions.ExpiredAccountException;
import exceptions.InvalidCategoryException;
import exceptions.UsernameOrEmailAlreadyTakenException;
import service.ProductService;
import service.PurchaseService;
import service.UserAttemptsService;
import service.UserService;

import javax.servlet.ServletContext;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private ProductService pService;
	@Autowired
	private PurchaseService oService;
	@Autowired
	private UserAttemptsService uaService;
	private User user;
	
	@RequestMapping({"/activateAccount"})
	public void activateAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newPass = request.getParameter("newPass");
		user.setPassword(newPass);
		user.activateUserType();
		uService.update(user);
		response.sendRedirect("");
	}
	
	@RequestMapping({"/signup"})
	public void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/signup.jsp").forward(request, response);
	}

	@RequestMapping({"/pm"})
	public void productManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Product> products = pService.getAllProducts();
		request.setAttribute("products", products);
		request.getRequestDispatcher("WEB-INF/view/categoryPM.jsp").forward(request, response);
	}
	
	@RequestMapping({"/editproduct"})
	public void editProduct(@RequestParam int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Product p = pService.findBy(id);
		request.setAttribute("headerName", "Edit");
		request.setAttribute("product", p);
		request.getRequestDispatcher("WEB-INF/view/productManager.jsp").forward(request, response);
	}
	
	@RequestMapping({"/edit_product"})
	public void saveCurrentProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvalidCategoryException {	
		int id = Integer.parseInt(request.getParameter("productId"));
		String name = request.getParameter("productName");
		String desc = request.getParameter("productDescription");
		double price = Double.parseDouble(request.getParameter("productPrice"));
		String category = request.getParameter("productCategory");
	
		Product p = pService.findBy(id);
		p.setName(name);
		p.setDescription(desc);
		p.setPrice(price);
		p.setCategory(category.toLowerCase());
		pService.updateProduct(p);
		response.sendRedirect("pm");
	}

	@RequestMapping({"/addproduct"})
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("headerName", "Add");	
		request.getRequestDispatcher("WEB-INF/view/productManager.jsp").forward(request, response);
	}
	
	@RequestMapping({"/add_product"})
	public void saveNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String name = request.getParameter("productName");
		String desc = request.getParameter("productDescription");
		double price = Double.parseDouble(request.getParameter("productPrice"));
		String category = request.getParameter("productCategory");

		Product p = new Product(name, desc, category, price);
		pService.addProduct(p);
		response.sendRedirect("pm");
	}
	
	@RequestMapping({"/delete"})
	public void saveNewProduct(@RequestParam int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		pService.deleteProduct(pService.findBy(id));
		response.sendRedirect("pm");
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
			response.sendRedirect("home");
		}
		request.setAttribute("sales", results);
		request.getRequestDispatcher("WEB-INF/view/financialManager.jsp").forward(request, response);
	}
	
	@RequestMapping({"/ad"})
	public void admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("isAdmin", "yes");
		request.getRequestDispatcher("WEB-INF/view/signup.jsp").forward(request, response);
	}
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
	public void loginPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String username = request.getParameter("username");
		String pw = request.getParameter("password");
		String hash = uService.getHashFor(username);
		if(hash==null)
		{
			String errorMsg = "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Failed!</strong> Wrong username and/or password.";
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
			//response.sendRedirect("home");
			return;
		}
		if(!uaService.checkIfLocked(username)){
			if(BCrypt.checkpw(pw, hash)){
				User u;
				try {
					u = uService.findBy(username);
				} catch (ExpiredAccountException e) {
					System.out.println("Error. Account expired.");
					e.printStackTrace();
					String errorMsg = "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Failed!</strong> Error. Account expired.";
					request.setAttribute("errorMsg", errorMsg);
					request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
					//response.sendRedirect("home");
					return;
				}
				request.getSession().setAttribute("user", u);
				user = u;
				response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
				request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
			} else {
				uaService.updateFailedAttempts(username);
				String errorMsg = "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Failed!</strong> Wrong username and/or password. 5 Consecutive failed attempts would lock out your Account";
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
				//response.sendRedirect("home");
				return;
			}
		} else {
			if(BCrypt.checkpw(pw, hash)){
				if(uaService.finishedWaitTime(username)){
					User u;
					try {
						u = uService.findBy(username);
					} catch (ExpiredAccountException e) {
						System.out.println("Error. Account expired.");
						e.printStackTrace();
						String errorMsg = "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Failed!</strong> Error. Account expired.";
						request.setAttribute("errorMsg", errorMsg);
						request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
						//response.sendRedirect("home");
						return;
					}
					request.getSession().setAttribute("user", u);
					user = u;
					uaService.resetFailedAttempts(username);
				} 
			}
			String errorMsg = "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Failed!</strong> Your Account has been locked out due to multiple failed attempts to login.";
			request.setAttribute("errorMsg", errorMsg);
			response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.sendRedirect("home");
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
	
	@RequestMapping({"/item"})
	public void goToItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(user!=null) request.setAttribute("isLoggedIn", "yes");
		if(id == -1)
		{
			response.sendRedirect("");
		}
		else
		{
			Product p = pService.findBy(id);
			if(p == null)
			{
				response.sendRedirect("");
			}
			else
			{
				request.setAttribute("product", p);
				request.getRequestDispatcher("WEB-INF/view/product.jsp").forward(request, response);
			}
		}
	}
	
	@RequestMapping({"/register"})
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pw = request.getParameter("password");
		String cpw = request.getParameter("confirmpassword");

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
			User u = new User(fName, mName, lName, username, email, pw, billingAddress, shippingAddress);
			uService.register(u);
			response.sendRedirect("home");
		} catch (UsernameOrEmailAlreadyTakenException e){
			//e.printStackTrace();
			String errorMsg = "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Failed!</strong> Username or Email is already taken.";
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("WEB-INF/view/signup.jsp").forward(request, response);
			
		}	
		
	}
	
	@RequestMapping({"/admin_register"})
	public void registerWithType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pw = request.getParameter("password");
		String cpw = request.getParameter("confirmpassword");

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
		
		String category = request.getParameter("userCategory");
		System.out.println("YES");
		try {
			uService.validate(email, username);
			User u = new User(fName, mName, lName, username, email, pw, billingAddress, shippingAddress);
			if("Product Manager".equals(category)){
				u.setUserType(User.INACTIVE_PM);
			} else if("Accounting Manager".equals(category)) {
				u.setUserType(User.INACTIVE_AM);
			}
			uService.register(u);
			response.sendRedirect("home");
		} catch (UsernameOrEmailAlreadyTakenException e){
			//e.printStackTrace();
			String errorMsg = "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Failed!</strong> Username or Email is already taken.";
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("WEB-INF/view/signup.jsp").forward(request, response);
			
		}	
		
	}

	@RequestMapping({"/purchase"})
	public void purchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Product p = pService.findBy(Integer.parseInt(request.getParameter("productId")));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String creditCard = request.getParameter("creditcard");
		if(user == null)
		{
			String errorMsg = "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Failed!</strong> Login/Sign up first.";
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("product", p);
			request.getRequestDispatcher("WEB-INF/view/product.jsp").forward(request, response);
		}
		else
		{
			user.order(p, quantity, creditCard);
			uService.update(user);
			response.sendRedirect("home");
		}
	}

	@RequestMapping({"/review"})
	public void review(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int id = Integer.parseInt(request.getParameter("productId"));
		String content = request.getParameter("review");

		if(user == null)
		{
			String errorMsg = "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Failed!</strong> Login/Sign up first.";
			request.setAttribute("errorMsg", errorMsg);	
			Product p = pService.findBy(id);
			request.setAttribute("product", p);
			request.getRequestDispatcher("WEB-INF/view/product.jsp").forward(request, response);
		}
		else
		{
		
			if(user.review(pService.findBy(id), content))
			{
				response.sendRedirect("home");
			}
			else
			{
				String errorMsg = "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Failed!</strong> Only users who have bought the product are allowed to make a review.";
				request.setAttribute("errorMsg", errorMsg);
				if(user!=null) request.setAttribute("isLoggedIn", "yes");
				
				Product p = pService.findBy(id);
				request.setAttribute("product", p);
				request.getRequestDispatcher("WEB-INF/view/product.jsp").forward(request, response);
			}
		}
	}
}
