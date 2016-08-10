package web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.ProductService;
import exceptions.InvalidCategoryException;

@Controller
public class PageController {
	@Autowired
	private ProductService pService;
	
	@RequestMapping({"/patatas.htmlxxx", "/"})
	public void goToIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}
	
	@RequestMapping({"/error"})
	public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
	}
	
	@RequestMapping({"/categories"})
	public void goToCategory(@RequestParam String type, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("type", type);
		try {
			Collection<Product> products = pService.findByType(type);
			request.setAttribute("products", products);
		} catch(InvalidCategoryException e){
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/view/category.jsp").forward(request, response);
	}

	@RequestMapping({"/hello"})
	public void goToHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/hello.jsp").forward(request, response);
	}

	@RequestMapping({"/item"})
	public void goToItem(@RequestParam int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Product p = pService.findBy(id);
		request.setAttribute("product", p);
		request.getRequestDispatcher("WEB-INF/view/product.jsp").forward(request, response);
	}
	
}
