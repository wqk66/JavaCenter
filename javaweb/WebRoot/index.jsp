<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="/javaweb/common/js/common.js"></script>
<script type="text/javascript" src="/javaweb/common/js/SimpleCalendar.js"></script>
<script type="text/javascript">
	function submit1(){
		fm.action = "input.jsp";
		fm.submit();
	}
</script>
</head>
<body>
	<form name="fm" method="post">
		<input type="text" name="inputName" />
		<button onclick="submit1()">Ìá½»</button>
	</form>
</body>
</html>