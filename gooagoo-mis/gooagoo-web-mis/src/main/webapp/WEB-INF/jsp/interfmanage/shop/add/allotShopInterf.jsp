<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>
</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#shopUrlAddress1").focus();
});
var parentWinow1 = (document.parentWindow || document.defaultView).parent;
//提交
function submitForm(){
	var shopUrlAddress = $("#shopUrlAddress1").val().trim();
	if(shopUrlAddress　== null || "" == shopUrlAddress){
		alert("请输入商家域名!");
		$("#shopUrlAddress1").focus();
		return false;
	}else if(shopUrlAddress.indexOf(":/") != -1) {
		alert("不可输入http://");
		$("#shopUrlAddress1").focus();
		return false;
	}else if(shopUrlAddress.indexOf(".com") == -1){
		alert("目前仅支持.com的域名");
		$("#shopUrlAddress1").focus();
		return false;
	}
	
	var url = "interfshop.do?method=allotShopInterf";
	var data = "&shopId=${shopId}&shopUrlAddress="+shopUrlAddress;
	var ret = ajaxJsonVoByData(url,data);
	alert(ret);
	closeWinow1();
}
//关闭弹出层
function closeWinow1(){
	parentWinow1.closeFancyBoxWindow();
}
</script>
</head>

<body>
<div style="display:none;">
	<input id="shopId1" type="hidden" value="${shopId}" />
</div>
<div class="user_message">
	<ul>
		<li>
			<span>请输入商家域名：</span>
			<input id="shopUrlAddress1" type="text" class="name_input" style="width: 300px;" maxlength="32"/>
			<span >例：www.gooagoo.com</span>
		</li>
		<li>
		</li>
		<li class="perMsg_commit">
			<input type="button" class="perMsg_btn" value="确定" onclick="submitForm()"/>
			<input type="button" class="perMsg_btn" value="取消" onclick="closeWinow1()"/>
		</li>
	</ul>
</div>
</body>
</html>