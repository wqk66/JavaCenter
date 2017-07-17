//校验邮箱格式
function checkEmail(value){
	var patt = /([\w-])+@[\w-]{2,}\.[\w]{2,4}/;
	if(value!="" || value!=null){
		if(patt.exec(value)!=null){
			return true;
		}else{
			alert("邮箱格式不正确！");
			return;
		}
	}
	
}