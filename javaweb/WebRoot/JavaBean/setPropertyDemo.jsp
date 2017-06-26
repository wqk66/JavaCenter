<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" scope="request" class="com.javaweb.javabean.UserBean"></jsp:useBean>
	<jsp:setProperty property="username" name="user" param="strname"/>
	<jsp:setProperty property="password" name="user" param="strpass"/>
	<jsp:getProperty property="username" name="user"/>
	<jsp:getProperty property="password" name="user"/>
</body>
</html>