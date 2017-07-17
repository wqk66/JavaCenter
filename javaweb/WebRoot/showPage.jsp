<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int pageSize = 5;//每页中记录数
	int pageCount;//页数
	int showPage;//当前页，即页码
	int recordCount;//总记录数
	ArrayList<String> arr = new ArrayList<String>();
	arr.add("1");
	arr.add("2");
	arr.add("3");
	arr.add("4");
	arr.add("5");
	arr.add("6");
	arr.add("7");
	arr.add("8");
	arr.add("9");
	arr.add("10");
	arr.add("11");
	recordCount = arr.size();//总条数
	pageCount=(recordCount%pageSize==0)?(recordCount/pageSize):(recordCount/pageSize+1);
	String integer = request.getParameter("showPage");
	if(integer == null || integer.length()==0||"0".equals(integer)){
		integer = "1";
	}
	try{
		showPage = Integer.parseInt(integer);
	}catch(Exception e){
		showPage = 1;
	}
	if(showPage<=1){
		showPage = 1;
	}
	if(showPage>=pageCount){
		showPage = pageCount;
	}
	//如果要显示第showPage页，那么游标应该移动到的position的值
	int remainNum = recordCount%5;//如果为奇数页，最后一页显示的记录数
	if(showPage<pageCount){
	for(int i=0;i<pageSize;i++){
%>
	<table>
		<tr>
			<td><%=arr.get(i+(5*(showPage-1))) %></td>
		</tr>
	</table>

<%
}}else{
	for(int k=0;k<remainNum;k++){
 %>
 <table>
		<tr>
			<td><%=arr.get(k+(5*(showPage-1))) %></td>
		</tr>
	</table>
 <%}} %>
 <br/>
  <br>
 第<%=showPage %>页（共<%=pageCount %>页）
 <br>
 <a href="showPage.jsp?showPage=1">首页</a>
 <a href="showPage.jsp?showPage=<%=showPage-1 %>">上一页</a>
<%
	for(int i=0;i<pageCount;i++){
 %>
 	<a href="showPage.jsp?showPage=<%=i+1%>"><%=(i+1) %></a>
 <%
 }
  %>
<a href="showPage.jsp?showPage=<%=showPage+1 %>">下一页</a>
<a href="showPage.jsp?showPage=<%=pageCount%>">末页</a>
<!-- 通过表单提交用户想要显示的页数 -->
<form method="post" action ="showPage.jsp?showPage=<%=showPage-1%>"/>
	跳转到第<input type="text" name="showPage" size="4"/>页
	<input type="submit" name="submit" value="跳转"/>
</form>