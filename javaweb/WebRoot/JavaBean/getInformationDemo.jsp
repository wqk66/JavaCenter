<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>基本信息</title>
</head>
<body>
	<%
		request.setCharacterEncoding("gb2312");
	 %>
	<jsp:useBean id="info" scope="page" class="com.javaweb.javabean.Information"></jsp:useBean>
	<jsp:setProperty property="*" name="info"/>
	<jsp:getProperty property="username" name="info"/>
	<jsp:getProperty property="age" name="info"/>
	<jsp:getProperty property="sex" name="info"/>
	<jsp:getProperty property="interest" name="info"/>
</body>
</html>