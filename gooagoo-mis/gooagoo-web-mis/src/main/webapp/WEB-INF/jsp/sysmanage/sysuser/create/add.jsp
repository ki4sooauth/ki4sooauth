<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员添加页面</title>
</head>

<body>
<div class="user_message">
	<form action="" method="post" id="addForm" name="addForm">
		<ul>
			<li>
				<span><code>*</code>用户名：</span>
				<input type="text" class="name_input" id="userId" name="userId" />
				<label class="wrong" id="lbluserid" style="display: none;">请输入正确邮箱！</label>
			</li>
			<li>
				<span><code>*</code>密码：</span>
				<input type="password" class="name_input" id="password" name="password" />
				<label class="wrong" id="lblpassword" style="display: none;">请输入密码！</label>
			</li>
			<li>
				<span><code>*</code>确认密码：</span>
				<input type="password" class="name_input" id="confirmpwd" name="confirmpwd" />
				<label class="wrong" id="lblconfirmpwd" style="display: none;">请输入确认密码！</label>
				<label class="wrong" id="lblpwdInfo" style="display: none;">两次输入密码不一致！</label>
			</li>
			<li>
				<span><code>*</code>真实姓名：</span>
				<input type="text" class="name_input" id="name" name="name" />
				<label class="wrong" id="lbReadName" style="display: none;">请输入真实姓名！</label>
			</li>
			<li>
				<span><code>*</code>性别：</span>  
				<input type="radio" name="sex" class="other_add" value="M" checked="checked"/><label class="other_add_txt">男</label>
				<input type="radio" name="sex" class="other_add" value="F"/><label class="other_add_txt">女</label>
			</li>
			<li>
				<span><code>*</code>出生日期：</span>
				<input id="birthday" name="birthday" class="Wdate" type="text" onfocus="WdatePicker()" style="cursor: pointer;"/>
				<label class="wrong" id="lblbirthday" style="display: none;">请选择出生日期！</label>
			</li>
			<li>
				<span><code>*</code>证件类型：</span>
				<select class="city select_style" id="idType" onchange="" name="idType">
					<option value="-1">--请选择--</option>
					<option value="00">身份证</option>
					<option value="01">护照</option>
					<option value="02">军官证</option>
					<option value="03">其他</option>
				</select>
				<label class="wrong" id="lblidtype" style="display: none;">请选择证件类型！</label>
			</li>
			<li>
				<span><code>*</code>证件号码：</span>
				<input type="text" class="address" id="idNo" name="idNo" />
				<label class="wrong" id="lblidno" style="display: none;">请输入证件号码！</label>
				<label class="wrong" id="lblidwrong" style="display: none;">身份证格式不正确！</label>
				<label class="wrong" id="lblIDBirthwrong" style="display: none; width: 145px;">证件号码与出生日期不符！</label>
			</li>
			<li>
				<span class="f_b_t">所属部门：</span>
				<input type="text" class="address" id="department" name="department" />
			</li>
				<li class="perMsg_commit">
				<input type="button" class="perMsg_btn" value="保存设置" onclick="saveUserInfo()"/>
			</li>
		</ul>
	</form>
</div>
<script type="text/javascript">
$(document).ready(function(){
	checkIsNull();
});
//非空校验
function checkIsNull(){
	$("#userId").bind("blur", checkUserId);
	$("#userId").bind("focus", function(){$("#lbluserid").css({"display":"none"});});
	
	$("#password").bind("blur", checkPsw);
	$("#password").bind("focus", function(){$("#lblpassword").css({"display":"none"});});
	
	
	$("#confirmpwd").bind("blur", checkPswAck);
	$("#confirmpwd").bind("focus", function(){$("#lblconfirmpwd").css({"display":"none"});$("#lblpwdInfo").css({"display":"none"});});
	
	$("#name").bind("blur", checkRealName);
	$("#name").bind("focus", function(){$("#lbReadName").css({"display":"none"});});
	
	$("#birthday").bind("blur", checkBirthday);
	$("#birthday").bind("focus", function(){$("#lblbirthday").css({"display":"none"});});
	
	$("#idType").bind("blur", checkIdType);
	$("#idType").bind("focus", function(){$("#lblidtype").css({"display":"none"});});
	
	$("#idNo").bind("blur", checkIdNo);
	$("#idNo").bind("focus", function(){$("#lblidno").css({"display":"none"});});
	$("#idNo").bind("focus", function(){$("#lblidwrong").css({"display":"none"});});
	$("#idNo").bind("focus", function(){$("#lblIDBirthwrong").css({"display":"none"});});
}
//校验电子邮件格式
function checkEmail() {
	var value = $("#userId").val();
	var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	var flag = reg.test(value);
	if(!flag){    
		$("#lbluserid").show();
		$("#userId").focus();
		return false;
	} else{
		return true;		
	}
}
//校验用户名
function checkUserId() {
	if ($("#userId").val() == "" || !checkEmail($("#userId").val())) {
		$("#lbluserid").show();
		return false;
	} else{
		return true;
	}
}
//校验密码
function checkPsw() {
	if ($("#password").val() == "") {
		$("#lblpassword").show();
		return false;
	} else if(!checkPasswd($("#password").val(),6,10)){
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
	} else if($("#password").val() != $("#confirmpwd").val()) {
		$("#lblpwdInfo").show();
		return false;
	} else{
		return true;
	}
}
//校验真实姓名
function checkRealName() {
	if ($("#name").val() == "") {
		$("#lbReadName").show();
		return false;
	} else {
		return true;
	}
}
//校验生日 
function checkBirthday() {
	if ($("#birthday").val() == "") {
		$("#lblbirthday").show();
		return false;
	} else {
		return true;
	}
}
//校验证件号码
function checkIdNo() {
	var birthday = $("#birthday").val();
	var idBirthday = "";
	var flag;
	if ($("#idNo").val() == "") {
		$("#lblidno").show();
		return false;
	} else if($("#idType").val() == '00'){
		flag = checkIDNo($("#idNo").val());
		if(flag == false){
			$("#lblidwrong").show();
			return false;
		} else {
			idBirthday = getBirthdayFromIDNo($("#idNo").val());
			if(birthday != idBirthday){
				$("#lblIDBirthwrong").show();
				return false;
			} else {
				return true;
			}
		}
	} else {
		return true;
	}
}

//校验证件类型
function checkIdType() {
	if ($("#idType").get(0).selectedIndex == 0) {
		$("#lblidtype").show();
		return false;
	} else {
		return true;
	}
}
//验证form
function checkForm(){
	if(!checkEmail() || !checkUserId() || !checkPsw() || !checkPswAck() || !checkRealName() || !checkBirthday() || !checkIdNo() || !checkIdType()){
		return false;
	} else {
		return true;		
	}
}
//保存用户信息 
function saveUserInfo(){
	if(checkForm()){
		var url = "sysuser.do?method=saveSysUser";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url,data);
		alert(ret);
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.refresh();
		page(1);
	}
}
</script>
</body>
</html>