<%@ page language="java" contentType="text/html; charset=gb2312"%>
<html>
<head>
<title>提交页面</title>
</head>
<body>
	<form action="ServletDemo" method="get">
		用户名：<input type="text" name="username"/>
		<br/>
		密码：<input type="password" name="password"/>
		<br/>
		<input type="submit" value="提交"/>
		<input type="reset" value="重置"/>
	</form>	
</body>
</html>