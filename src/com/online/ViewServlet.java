package com.online;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/View")   //url mapping home.jsp 
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?serverTimezone=EST", "root", "cloudera");
			String query = "select * from employee";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();	
			
			/*request.setAttribute("results", rs);
			RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
			rd.forward(request, response);*/
			
			List<Employee> employees = new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setPhone(rs.getString(3));
				emp.setCourse(rs.getString(4));
				emp.setArea(rs.getString(5));
				emp.setCountry(rs.getString(6));
				employees.add(emp);
			}
			request.setAttribute("emps", employees);
			RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
			rd.forward(request, response);
			
			}catch(Exception e) {
				e.printStackTrace();
	}

	}}
