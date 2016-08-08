package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ErrorHandleFilter implements Filter {

	@Override
	public void destroy() {
		// ...
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
	}

	@Override
	public void doFilter(ServletRequest request, 
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		try {
			HttpServletResponse res = new HttpServletResponseWrapper
					((HttpServletResponse)response);
			chain.doFilter(request, res);
			res.addHeader("X-FRAME-OPTIONS", Modes.DENY);
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
		}

	}

}