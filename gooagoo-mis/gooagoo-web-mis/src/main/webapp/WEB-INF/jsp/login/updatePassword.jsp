<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<style type="text/css">
/*psw*/
*{padding:0;margin:0;font-size:12px;}
ul li{list-style-type:none;}
.user_message ul{width:250px;margin:0 auto;padding-top:15px;}
.user_message ul li{margin-bottom:15px;position:relative;float:left;width:250px;}
.user_message ul li input{height:25px;width:150px;border:1px solid orange;vertical-align:middle;}
.user_message ul li span{width:80px;display:inline-block;}
.user_message ul li code{color:red;padding:0 3px;}
.user_message .wrong{padding-left:87px;margin-top:10px;color:red;}
.user_message ul .perMsg_commit{text-align:center;padding-top:15px;}
.user_message ul .perMsg_commit input{width:97px;height:34px;background:url(${imgPath}/mis/images/botnn.jpg) no-repeat;border:none 0;cursor:pointer;color:#ea7c1d;font-weight:bold;font-size:14px;}
</style>
</head>

<body>
<div class="user_message" id="popupContact">
	<form action="" method="post" id="frmInput" name="frmInput">
		<ul>
			<li>
				<span><code>*</code>当前密码：</span>
				<input type="text"  class="name_input" id="oldPassword" name="oldPassword" value="" />
				<label class="wrong" id="lbloldPassword" style="width: 250px;display:none;">请输入原始密码！</label>
			</li>
			<li>
				<span><code>*</code>新密码：</span>
				<input type="password"  class="name_input" id="newPassword" name="newPassword" value="" />
				<label class="wrong" id="lblpassword" style="width: 250px;display: none;">请输入新密码！</label>
			</li>
			<li>
				<span><code>*</code>确认密码：</span>
				<input type="password"  class="name_input" id="confirmpwd" name="confirmpwd" value="" />
				<label class="wrong" id="lblconfirmpwd" style="width: 250px;display: none;">请输入确认密码！</label>
				<label class="wrong" id="lblpwdinfo" style="width: 250px;display: none;">两次输入的密码不一致！</label>
			</li>
				<li class="perMsg_commit">
				<input type="button" class="perMsg_btn" value="保存设置" onclick="doSave();"/>&nbsp;&nbsp;
				<input type="button" class="perMsg_btn" value="重&nbsp;&nbsp;置" onclick="doClear();"/>
			</li>
		</ul>
	</form>
</div>
<div id="backgroundPopup"></div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	checkIsNull();
});
//非空校验
function checkIsNull(){
	$("#oldPassword").bind("blur", checkPswOld);
	$("#oldPassword").bind("focus", function(){$("#lbloldPassword").css({"display":"none"});});	

	$("#newPassword").bind("blur", checkPsw);
	$("#newPassword").bind("focus", function(){$("#lblpassword").css({"display":"none"});});

	$("#confirmpwd").bind("blur", checkPswAck);
	$("#confirmpwd").bind("focus", function(){$("#lblconfirmpwd").css({"display":"none"});$("#lblpwdinfo").css({"display":"none"});});	
}
//校验原始密码
function checkPswOld() {
	if ($("#oldPassword").val() == "") {
		$("#lbloldPassword").show();
		return false;
	} else {
		return true;
	}
}
//校验新密码 
function checkPsw() {
	if ($("#newPassword").val() == "") {
		$("#lblpassword").show();
		return false;
	} else if(!checkPasswd($("#newPassword").val(),6,10)){
		return false;
	} else {
		return true;
	}
}
//校验确认密码 
function checkPswAck() {
	if ($("#confirmpwd").val() == "") {
		$("#lblconfirmpwd").show();
		return false;
	} else if($("#newPassword").val() != $("#confirmpwd").val()) {
		$("#lblpwdinfo").show();
		return false;
	} else{
		return true;
	}
}

//验证 
function checkForm(){
	if(!checkPswOld() || !checkPsw() || !checkPswAck()){
		return false;
	} 
	return true;
}

//保存设置
function doSave(){
	if(checkForm()){
		var url = "login.do?method=modifyPwd";
		var data = $("#frmInput").serialize();
		var ret = ajaxJsonVoByData(url,data);
		alert(ret);
		window.opener.top.location.href = "${passport}/mislogin";
		window.close();
	} 
}

//重置
function doClear(){
	document.getElementById("frmInput").reset();
}
</script> 
</html>