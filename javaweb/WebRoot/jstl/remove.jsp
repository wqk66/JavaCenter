<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:set var="number" value="${1+1}" scope="page"></c:set>
	number:<c:out value="${number}" default="no data"></c:out>
	<br/>
	<c:remove var="number" scope="page"/>
	number2:<c:out value="${number}" default="no data"></c:out>
</body>
</html>