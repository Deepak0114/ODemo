package com.online;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		
		try{
			ServletContext context = request.getServletContext();
			String driver = context.getInitParameter("driver");
			Class.forName(driver);
			String url = context.getInitParameter("url");
			String username = context.getInitParameter("username");
			String password = context.getInitParameter("password");
			Connection con = DriverManager.getConnection(url,username,password);
			String query = "select * from employee where fname=? and lname=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, fname);
			ps.setString(2, lname);
			
			ResultSet rs = ps.executeQuery();	
			
			if(rs.next()) 
					//out.print("login success");
			{		HttpSession session = request.getSession();
					session.setAttribute("fname",fname);
					response.sendRedirect("home.jsp");
				//response.sendRedirect("home.jsp?fname="+fname);
			}
				else
					//out.print("login unsuccess");	
					response.sendRedirect("Login.jsp?error=Authentication Failed");
			}catch(Exception e) {
				e.printStackTrace();
		
	
			
	}

}
}
	