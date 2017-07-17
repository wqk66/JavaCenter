<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<%
	//一个计数器
	int num  = 0;
	synchronized(application){
		if(application.getAttribute("times")==null){
			num = 1;
		}else{
			num = Integer.parseInt((String)application.getAttribute("times"));
			num++;
		}
		application.setAttribute("times",String.valueOf(num));
	}
%>
</head>
<body>
	
	刷新：<p><%=num%></p>
</body>
</html>