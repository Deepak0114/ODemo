package com.online;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	int no = Integer.parseInt(request.getParameter("eno"));	
	String name = request.getParameter("ename");	
	int phone = Integer.parseInt(request.getParameter("ephone"));	
	double salary = Double.parseDouble(request.getParameter("esal"));

	
	try {
		System.out.println("connection");
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		String url ="jdbc:mysql://localhost:3306/first?serverTimezone=EST";
		String username ="root";
		String password ="cloudera";
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("connection established");
		String query = "insert into employee1 values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setInt(1, no);
		ps.setString(2, name);
		ps.setInt(3, phone);
		ps.setDouble(4, salary);
		int ans = ps.executeUpdate();
		if(ans>0)
			out.print("successfully");
		else
			out.print("not");
	}catch(Exception e) {
		e.printStackTrace();
	}

	}

}
