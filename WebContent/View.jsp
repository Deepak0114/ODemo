<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.*" %>
<%@page import ="com.online.Employee" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%--   <% ResultSet rs = (ResultSet)request.getAttribute("results"); %> --%> 
 <% List<Employee> employees = (ArrayList<Employee>)request.getAttribute("emps"); %>
		 	<% String fname = (String)session.getAttribute("fname"); %> 
			<h1 align="center">Welcome
		<%= fname %></h1> 
<table border="1" align="center"><h4 align="center"> Employees </h4>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Phone</th>
<th>Course</th>
<th>Area</th>
<th>Country</th>
</tr> 
<%-- 
<% while(rs.next()) { %>
	<tr> 
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getInt(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
		<td><%=rs.getString(6) %></td>
		
	</tr>
	<%} %>--%>
	
	<% for(Employee emp : employees) { %>
	<tr> 
		<td><%=emp.getFirstName() %></td>
		<td><%=emp.getLastName() %></td>
		<td><%=emp.getPhone() %></td>
		<td><%=emp.getCourse() %></td>
		<td><%=emp.getArea() %></td>
		<td><%=emp.getCountry() %></td>
		<td><a href="Delete?FirstName=<%= emp.getFirstName()%>">Delete</a></td>
	</tr>
	<% }%>
	
</table>

</body>
</html>