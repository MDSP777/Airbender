package web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import exceptions.InvalidCategoryException;
import model.Product;
import service.ProductService;

@Controller
public class PageController {
	@Autowired
	private ProductService pService;
	
	@RequestMapping({"/","/home"})
	public void goToIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
        System.out.println(request.getSession().getAttribute("user_name")+" "+request.getSession().getAttribute("user"));
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}
	
	@RequestMapping({"/error"})
	public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
	}
	
	@RequestMapping({"/product"})
	public void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/product.jsp").forward(request, response);
	}
	
	@RequestMapping({"/categories"})
	public void goToCategory(@RequestParam String type, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("type", type);
		
		if(type.equals("productManager"))
		{
			Collection<Product> products;
			products = pService.getAllProducts();
			request.setAttribute("products", products);
			request.getRequestDispatcher("WEB-INF/view/categoryPM.jsp").forward(request, response);
		}
		else
		{
			try {
				Collection<Product> products = pService.findByType(type);
				request.setAttribute("products", products);
				request.getRequestDispatcher("WEB-INF/view/category.jsp").forward(request, response);
			} catch(InvalidCategoryException e){
				e.printStackTrace();
				response.sendRedirect("");
			}
		}
	}

	@RequestMapping({"/hello"})
	public void goToHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/hello.jsp").forward(request, response);
	}
}
