<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ÁªÏµ</title>
</head>
<body>
<%
	String[] arr = new String[5];
	arr[0]="111";
	arr[1]="222";
	arr[2]="333";
	arr[3]="444";
	arr[4]="555";
	request.setAttribute("arrs",arr);
 %>
<c:forEach items="${arrs}"  var="x" begin="0" end="4" step="1" varStatus="s">
	${s.last}
	<br/>
</c:forEach>
</body>
</html>