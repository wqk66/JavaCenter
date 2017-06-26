<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie c = new Cookie("username","root");
		response.addCookie(c);
	 %>
	 <a href="getCookieDemo.jsp">ªÒµ√cookie÷µ</a>
</body>
</html>