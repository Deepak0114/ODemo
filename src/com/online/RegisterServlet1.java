package com.online;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create1")
public class RegisterServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();

		String fname = (request.getParameter("fname"));
		String lname = (request.getParameter("lname"));
		int phone = Integer.parseInt(request.getParameter("phone"));
		String course = (request.getParameter("course"));
		String area = (request.getParameter("area"));
		String country = (request.getParameter("country"));
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?serverTimezone=EST", "root", "cloudera");
			
		
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setInt(3, phone);
			ps.setString(4, course);
			ps.setString(5, area);
			ps.setString(6, country);
			int ans = ps.executeUpdate();
			if(ans>0)
				out.print("successfully");
			else
				out.print("not");
		}catch(Exception e) {
			e.printStackTrace();
		
	}

	}}
