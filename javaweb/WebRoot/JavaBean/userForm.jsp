<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>提交表单</title>
</head>
<body>
	<form name="fm" action="getInformationDemo.jsp" method="post">
		姓名：<input type="text" name="username" />
		<br/>
		年龄：<input type="password"  name="age"/>
		<br/>
		性别：<input type="radio" name="sex" value="女" checked="checked"/>女
		<input type="radio" name="sex" value="男"/>男
		<br/>
		爱好：<input type="checkbox" name="interest" value="电影"/>电影
		<input type="checkbox" name="interest" value="游戏"/>游戏
		<input type="checkbox" name="interest" value="运动"/>运动
		<br/>
		<input type="submit" value="提交"/>
		<input type="reset" value="重置"/>
	</form>
</body>
</html>