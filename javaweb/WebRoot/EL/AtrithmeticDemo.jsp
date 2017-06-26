<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>运算</title>
</head>
<body>
	<table border>
		<tr>
			<td>n算数运算</td>
			<td>结果</td>
		</tr>
		<tr>
			<td>\${1+1}</td>
			<td>${1+1}</td>
		</tr>
		<tr>
			<td>\${1-1 }</td>
			<td>${1-1}</td>
		</tr>
		<tr>
			<td>\${3/2 }</td>
			<td>${3/2 }</td>
		</tr>
		<tr>
			<td>\${2>3 && 4>3?"yes":"no" }</td>
			<td>${2>3 && 4>3?"yes":"no" }</td>
		</tr>
	</table>
</body>
</html>