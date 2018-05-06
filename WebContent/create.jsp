<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
String phone = request.getParameter("phone");
String course = request.getParameter("course");
String area = request.getParameter("area");
String country = request.getParameter("country");
try {
		System.out.println("connection");
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		String url ="jdbc:mysql://localhost:3306/first?serverTimezone=EST";
		String username ="root";
		String password ="cloudera";
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("connection established");
		String query = "insert into employee values(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setInt(3, phone);
			ps.setString(4, course);
			ps.setString(5, area);
			ps.setString(6, country);
			ps.executeUpdate();
			
			response.sendRedirect("View.jsp");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			}
%>
</body>
</html>