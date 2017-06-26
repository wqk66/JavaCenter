<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form name="fm" action="param.jsp" method="post">
		用户名：<input type="text" name="username"/>
		<br/>
		密码：<input type="password" name="pass"/>
		<br/>
		姓名：<input type="text" name="name"/>
		<br/>
		性别：<input type="radio" name="sex" value="男" checked="checked"/>男
		<input type="radio" name="sex" value="女"/>女
		<br/>
		爱好：
		<input type="checkbox" name="interest" value="电影"/>电影
		<input type="checkbox" name="interest" value="游戏" />游戏
		<input type="checkbox" name="interest" value="运动" />运动
		<br/>
		<input type="submit" value="提交"/>
		<input type="reset" value="重置"/>		
	</form>
</body>
</html>