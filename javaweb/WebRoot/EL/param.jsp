<%@ page language="java" contentType="text/html; charset=gb2312"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("gb2312");
	 %>
	用户名：${param.username }<br/>
	密码：${param.pass }<br/>
	姓名：${param.name }<br/>
	性别：${param.sex }<br/>
	爱好：${paramValues.interest[0] }
	${paramValues.interest[1] }
</body>
</html>