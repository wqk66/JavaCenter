<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	function jisuan(){
	
		var n = document.getElementById("jisuan").value;
		for(var i=1;i<=n;i++){
			document.write(diaoyong(i)+"\t");
			if(n%5==0){
				document.write();
			}
		}
	}
	function diaoyong(n){
		if(n==1||n==2){
			return 1;
		}
		return diaoyong(n-1)+diaoyong(n-2);
	}
</script>
</head>
<body>
	<input type="text" id="jisuan" />
	<input type="button" name="btn_name"  value="¼ÆËã" onclick="jisuan();"/>
</body>
</html>