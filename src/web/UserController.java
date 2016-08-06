package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@RequestMapping({"/patatas.htmlxxx", "/"})
	public void goToIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}
	
	@RequestMapping({"/error"})
	public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
	}
	
	@RequestMapping({"/signup"})
	public void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/signup.jsp").forward(request, response);
	}
	
	@RequestMapping({"/categories"})
	public void goToCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/category.jsp").forward(request, response);
	}
	
	@RequestMapping({"/hello"})
	public void goToHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("WEB-INF/view/hello.jsp").forward(request, response);
	}
	
	@RequestMapping({"/login"})
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String username = request.getParameter("username");
		String pw = request.getParameter("password");
		
		String hash = uService.getHashFor(username);
		if(BCrypt.checkpw(pw, hash)){
			User u = uService.findBy(username);
			request.setAttribute("name", u.getName());
			System.out.println(u.getName());
			request.getRequestDispatcher("WEB-INF/view/hello.jsp").forward(request, response);
		} else {
			response.sendRedirect("error");
		}
	}
	
	
}
