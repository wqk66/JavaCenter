<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>test</title>
</head>
<body>
	<jsp:useBean id="user" scope="page" class="com.javaweb.javabean.UserBean"></jsp:useBean>
	<%
		user.setUsername("jim");
		user.setPassword("123");
		out.println("username:"+user.getUsername()+"<br>");
		out.println("password:"+user.getPassword());
	 %>
</body>
</html>