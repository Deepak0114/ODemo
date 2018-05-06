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
			<% 
			Employee emp = new Employee();  //obj creation and emp reference
			emp.setFirstName("david");
			emp.setLastName("d");
			emp.setPhone("12413");
			emp.setCourse("cse");
			emp.setArea("sda");
			emp.setCountry("usa");
			%>
			
			First Name = <%= emp.getFirstName()  %> </br>
			Last Name = <%= emp.getLastName()  %></br>
			Phone = <%= emp.getPhone()  %></br>
			Course = <%= emp.getCourse()  %></br>
			Area = <%= emp.getArea()  %></br>
			Country = <%= emp.getCountry()  %></br>

<jsp:useBean id="emp2" class="com.online.Employee" />

<jsp:setProperty property="firstName" name="emp2" value="David"/> // firstname is uppercase in employee.java you should have to give different because you are using employee class in the top so give differnet 
<jsp:setProperty property="lastName" name="emp2" value="D"/>
<jsp:setProperty property="phone" name="emp2" value="213134"/>
<jsp:setProperty property="course" name="emp2" value="cse"/>
<jsp:setProperty property="area" name="emp2" value="bone"/>
<jsp:setProperty property="country" name="emp2" value="usa"/>


FirstName <jsp:getProperty property="firstName" name="emp2"/>
LastName <jsp:getProperty property="lastName" name="emp2"/>
Phone <jsp:getProperty property="phone" name="emp2"/>
Course <jsp:getProperty property="course" name="emp2"/>
Area <jsp:getProperty property="area" name="emp2"/>
Country <jsp:getProperty property="country" name="emp2"/>

</body>
</html>