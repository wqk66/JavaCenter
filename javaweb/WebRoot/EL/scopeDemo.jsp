<%@ page language="java" contentType="text/html; charset=gb2312"%>
<html>
<head>
<title>取值</title>
</head>
<body>
	<%
		pageContext.setAttribute("name","page_name");
		request.setAttribute("name","request_name");
		session.setAttribute("name","session_name");
		application.setAttribute("name","application_name");
	 %>
	 page:${pageScope.name}<br/>
	 request:${requestScope.name }<br/>
	 session:${sessionScope.name }<br/>
	 application:${applicationScope.name}<br/>
	 没有取值范围：${name }
</body>
</html>