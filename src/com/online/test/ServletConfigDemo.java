package com.online.test;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletConfig config;
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
	}
	//servlet config
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String wish = config.getInitParameter("wish");
	String name = config.getInitParameter("name");
	System.out.println(wish+" "+name);
	
	
	//servlet context
	ServletContext context = request.getServletContext();
	String driver = context.getInitParameter("driver");
	String uname = context.getInitParameter("username");
	System.out.println(driver+" "+uname);
	
	}
	public void destroy() {
	}
}


