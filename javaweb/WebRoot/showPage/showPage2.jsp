<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>分页</title>
<%
	int recordCount;//总记录数
	int pageCount;//总页数
	int showPage;//页码
	int pageSize=5;//每页显示的记录数
	int remainCount;
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
	recordCount = arr.size();//取总记录数
	pageCount = (recordCount%pageSize==0)?(recordCount/pageSize):(recordCount/pageSize+1);//取总页数
	String integer = request.getParameter("showPage");//取页码
	//页码为空或为0时取首页
	if(integer == null ||integer.length()==0 ||"0".equals(integer)){
		integer="1";
	}
	try{
		showPage = Integer.parseInt(integer);
	}catch(Exception e){
		showPage = 1;
	}
	//若页码大于总页数，页码取总页数
	if(showPage>pageCount){
		showPage = pageCount;
	}
	remainCount = recordCount%5;//如果为奇数页，最后一页显示的记录数
 %>
</head>
<body>
	<%
		if(showPage<pageCount){
			for(int i=0;i<pageSize;i++){
	 %>
	 		<table>
	 			<tr>
	 				<td><%=arr.get(i+5*(showPage-1))%></td>
	 			</tr>
	 		</table>
	 <%
		}}else{ 
			for(int k=0;k<remainCount;k++){
	 %>
	 		<table>
	 			<tr>
	 				<td><%=arr.get(k+5*(showPage-1))%></td>
	 			</tr>
	 		</table>
	 <%
	 	}}
	  %>
	  <span>
	  	<a href="showPage2.jsp?showPage=1">首页</a>
	  	<a href="showPage2.jsp?showPage=<%=showPage-1 %>">上一页</a>
	  </span>
	  <span>
	  	<%
	  		for(int m=0;m<pageCount;m++){
	  		System.out.println("m+1:"+(m+1));
	  	 %>
	  	 	<a href="showPage2.jsp?showPage=<%=(m+1)%>"><%=(m+1) %></a>
	  	 <%
	  	 	}
	  	  %>
	  </span>
	  <span>
	  	<a href="showPage2.jsp?showPage=<%=(showPage+1) %>">下一页</a>
	  	<a href="showPage2.jsp?showPage=<%=pageCount %>">末页</a>
	  </span>
	  <form name="fm" action="showPage2.jsp" method="post">
	  	跳转到第<input type="text" name="showPage" size="2"/>页
	  	<input type="submit" name="butName" value="跳转" />
	  </form>
	  <div>第<%=showPage %>页（共<%=pageCount %>页）</div>
</body>
</html>