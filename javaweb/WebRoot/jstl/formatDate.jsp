<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:set var="now"  value="<%=new Date() %>"></c:set>
<fmt:formatDate type="time" value="${now}"/>
<br/>
<fmt:formatDate type="both" value="${now}"/>
<br/>
<fmt:formatDate pattern="yyyy-MM-dd hh:MM:dd" value="${now}"/>
</body>
</html>