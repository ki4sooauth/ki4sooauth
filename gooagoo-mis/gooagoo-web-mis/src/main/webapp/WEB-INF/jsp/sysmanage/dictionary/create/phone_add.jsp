<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>手机型号字典页面</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul>
				<li><span><code>*</code>手机mac地址段：</span>
					<input type="text" class="name_input" id="macAddress" name="macAddress" />
					<label class="wrong" id="lblMacAddress" style="display: none;">请输入手机mac地址段！</label>
				</li>
				<li><span><code>*</code>手机型号：</span>
					<input type="text" class="name_input" id="phoneType" name="phoneType" />
					<label class="wrong" id="lblPhoneType" style="display: none;">请输入手机型号！</label>
				</li>
				<li>
					<span class="f_b_t">备注：</span>
					<textarea  class="text_men" rows="" cols="" id="note" name="note"></textarea>
				</li>
				<li class="perMsg_commit">
					<input type="button" class="perMsg_btn" value="保存设置" onclick="saveDic()" />
				</li>
			</ul>
		</form>
	</div>
</body>
<script type="text/javascript">
$(function() {
	checkIsNull();
})

// 非空校验 
function checkIsNull() {
	$("#macAddress").bind("blur", checkMacAddress);
	$("#macAddress").bind("focus", function() {$("#lblMacAddress").css({"display" : "none"});});

	$("#phoneType").bind("blur", checkPhoneType);
	$("#phoneType").bind("focus", function() {$("#lblPhoneType").css({"display" : "none"});});
}
	
// 手机mac地址段
function checkMacAddress() {
	if ($("#macAddress").val() == "") {
		$("#lblMacAddress").show();
		return false;
	} else {
		return true;
	}
}
	
// 手机型号
function checkPhoneType() {
	if ($("#macAddress").val() == "") {
		$("#lblPhoneType").show();
		return false;
	} else {
		return true;
	}
}

//保存字典 
function saveDic() {
	if (checkMacAddress() && checkPhoneType()) {
		var url = "phone.do?method=addDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url, data);
		alert(ret);
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.page(1);
	}
}
</script>
</html>