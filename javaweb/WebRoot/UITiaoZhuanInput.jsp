<%@ page language="java" contentType="text/html; charset=gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
var checkSubmitFlg = false;

  function checkSubmit() {

  if (checkSubmitFlg == true) {
	alert("1111111dd");
  return false;

  }

  checkSubmitFlg = true;

  return true;

  }
function submit1(){
	fm.action = "UITiaoZhuanQuery.jsp";
	fm.target="id_iframe";
	fm.submit();
} 

</script>
</head>
<body>
	<form name="fm" method="post" onsubmit="return checkSubmit();"> 
	<input type="text" id="input_text" name="input_text1"/> 
	<button onclick="submit1();">Ã·Ωª</button>
	</form> 
	<iframe id="id_iframe" name="id_iframe" style="display:none;"></iframe> 

</body>
</html>