<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--	<jsp:forward page="second.jsp"> <%-- one way this will move the pointer to second.jsp page --%> --%>
	<%--	<jsp:param value="hi" name="wish"/> <%-- it will pass hi in webpage using wish as connector --%>
	<%--	</jsp:forward>  --%>
		
		first</br>
		<jsp:include page="second.jsp">  <%--this will point to next page and comes back to first page --%>
		<jsp:param value="hi" name="wish"/> <%--two way --%>
		</jsp:include> 
		After
		
</body>
</html>