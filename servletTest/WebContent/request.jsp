<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form name="fm" action="*.requestTest" method="get" enctype="application/x-www-form-urlencoded">
		<span>名称：
		<input type="text" name="userName"></span>
		<span>
			密码：
			<input type="file" name="userPass">
		</span>
		<span><input type="submit" value="提交"></span>
	</form>
</body>
</html>