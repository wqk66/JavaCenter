<%--
****************************************************************************
* DESC       ：农险平台修正数据查询
* AUTHOR     ：weiqiankun
* CREATEDATE ：2016-01-12
* MODIFYLIST ：  Name      Date     Reason/Contents
*          --------------------------------------------------
****************************************************************************
--%>
<%@page errorPage="/UIErrorPage"%>
<%@page import="com.sinosoft.utility.string.Date"%>
<%@page import="com.sinosoft.utility.string.ChgDate"%>
<%
	ChgDate idate = new ChgDate();
	String strDate  = idate.getCurrentTime("yyyy-MM-dd");
	com.sinosoft.utility.string.Date sinosoftDate = new com.sinosoft.utility.string.Date();
	sinosoftDate.set(sinosoftDate.DATE,sinosoftDate.get(sinosoftDate.DATE)-2);
	String strPreWeekDate = idate.toFormat(sinosoftDate.getString(sinosoftDate.YEAR+sinosoftDate.MONTH+sinosoftDate.DATE));
	
%>
<html>
  <head>
    <title>农险平台修正数据查询条件页面</title>
    <link rel="stylesheet" type="text/css" href="/payment/css/Standard.css">
    <script src="/payment/commonship/sff/UISffCommon.js"></script>
    <script src="/payment/commonship/pub/UICommon.js"></script>
    <script src="/payment/commonship/pub/UICodeSelect.js"></script>
    <script src="/payment/commonship/sff/UICodeSelectPrepare.js"></script>
    <script language=javascript>
    var LISTDELIMITERNew = "\r\n";
      function submit1(field)
      {
        var operationStartDate = trim(fm.OperationStartDate.value);
        var operationEndDate = trim(fm.OperationEndDate.value);
        var batchNo = trim(fm.OperationBatchNo.value);//批次号
        if(operationStartDate=="" || operationEndDate == ""){
        	alert("操作日期区间不能为空！");
        	return false;
        }
        var a = /^(\d{4})-(\d{2})-(\d{2})$/;
        if (!a.test(operationStartDate)) { 
            alert("起始日期格式不正确!") 
            return; 
        }
        var a = /^(\d{4})-(\d{2})-(\d{2})$/;
        if (!a.test(operationEndDate)) { 
            alert("截止日期格式不正确!") 
            return; 
        }
        if(compareFullDate(operationStartDate,operationEndDate)== 1) {
            alert("操作终止日期必须大于操作起始日期！");
            fm.OperationEndDate.focus();	  	
            return;
          }
        fm.buttonSubmit1.disabled = true;
        fm.buttonSubmit2.disabled = true;
        fm.action="../CreateExcel?bachNo="+batchNo;
      }

    </script>
  </head>
  <body>
    <form name=fm method=post>
      <table class="common1" cellpadding="4" cellspacing="1" align="center">
        <tr>
          <td class=formtitle colspan="4">农险平台修正数据查询 </td>
        </tr>
        <tr>
          <td class=title colspan="4" style="color:red" >友情提示：请尽量输入精确的查询条件（譬如：批次号等），否则会大大降低查询的效率！</td>
        </tr>
        <tr>
          <td class=title>批次号：</td>        
          <td class=input>
            <select class=query name="OperationBatchNoSign">
              <option value="=" selected>=&nbsp;</option>
  	        </select> 	    
            <input class=common maxLength=25 name="OperationBatchNo" value=""></td>   
             <td class=title>保单号：</td>        
          <td class=input>
            <select class=query name="OperationPolicyNoSign">
              <option value="=" selected>=&nbsp;</option>
  	        </select> 	    
            <input class=common maxLength=25 name="OperationPolicyNo" value=""></td> 
        </tr>
        <tr>
          <td class=title>序列号：</td>        
          <td class=input>
            <select class=query name="OperationSerialNoSign">
              <option value="=" selected>=&nbsp;</option>
  	        </select> 	    
            <input class=common maxLength=25 name="OperationSerialNo" value=""></td> 
          <td class=title>接口类型：</td>        
          <td class=input>
            <select class=query name="OperationIntfaceTypeSign">
              <option value="=" selected>=&nbsp;</option>
  	        </select> 	
  	        <select class=query name="OperationIntfaceCode" style="width:200px">
              <option value=""></option>
              <option value="uploadClaimPayInfo">赔案支付信息接口</option>
              <option value="uploadPrepaidPayInfo">预赔支付信息接口</option>
              <option value="uploadPremiumPayInfo">保费实收/付信息接口</option>
              <option value="uploadReturnedBillInfo">退票信息接口</option>
  	        </select>    
        </tr>
        <tr>
          <td class=title>日期：</td>        
          <td class=input>
            <select class=query name="OperationDateStartSign">
              <option value=">=" selected>>=&nbsp;</option>
  	        </select> 	    
            <input class=common maxLength=19 name="OperationStartDate" value=<%=strPreWeekDate %>  onBlur="checkFullDate(this)"></td> 	
  	      <td class=title>日期：</td>
          <td class=input>
            <select class=query name="OperationDateEndSign">
              <option value="<=" selected><=&nbsp;</option>
  	        </select> 	    
            <input class=common maxLength=19 name="OperationEndDate" value=<%=strDate%>  onBlur="checkFullDate(this)"></td>    
        </tr>
      </table>
      <table width=100%>
        <tr>
          <td class=button>
            <input class="button" type="button" name="buttonSubmit1" alt="组织报文" value="组织报文" onclick="submit1();">
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
            <input class="button" type="button" name="buttonSubmit2" alt=" 重 置 " value="重 置" onclick="reset();">

          </td>
        </tr>
      </table>
      </form>
  </body>
</html>