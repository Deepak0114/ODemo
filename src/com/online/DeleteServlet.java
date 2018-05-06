package com.online;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FirstName= request.getParameter("FirstName");
		System.out.println(FirstName);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?serverTimezone=EST", "root", "cloudera");
			String query = "delete from employee where fname=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, FirstName);
			ps.executeUpdate();	
				
			response.sendRedirect("View");
			}catch(Exception e) {
				e.printStackTrace();
	}

	}}
