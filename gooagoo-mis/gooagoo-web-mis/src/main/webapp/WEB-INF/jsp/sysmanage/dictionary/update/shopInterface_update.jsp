<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>字典修改页面</title>
</head>

<body>
<div class="user_message">
	<form action="" method="post" id="addForm" name="addForm">
		<ul>
			<li><span><code>*</code>名称编码：</span>
				<input type="hidden" id="id" name="id" value="${shopIn.id }"/>
				<input type="text" class="name_input" id="nameCode" name="nameCode" value="${shopIn.nameCode }"/>
				<label class="wrong" id="lblNameCode" style="display: none;">请输入名称编码！</label>
			</li>
			<li><span><code>*</code>名称值：</span>
				<input type="text" class="name_input" id="nameValue" name="nameValue" value="${shopIn.nameValue }"/>
				<label class="wrong" id="lblNameValue" style="display: none;">请输入名称值！</label>
			</li>
			<li><span><code>*</code>所属系统：</span>
				<input type="text" class="name_input" id="sys" name="sys" value="${shopIn.sys }"/>
				<label class="wrong" id="lblSys" style="display: none;">请输入所属系统！</label>
			</li>
			<li><span><code>*</code>所属模块：</span>
				<input type="text" class="name_input" id="module" name="module" value="${shopIn.module }"/>
				<label class="wrong" id="lblModule" style="display: none;">请输入所属模块！</label>
			</li>
			<li><span><code>*</code>版本号：</span>
				<input type="text" class="name_input" id="version" name="version" value="${shopIn.version }"/>
				<label class="wrong" id="lblVersion" style="display: none;">请输入版本号！</label>
			</li>
			<li><span><code>*</code>版本号说明：</span>
				<input type="text" class="name_input" id="versionNote" name="versionNote" value="${shopIn.versionNote }"/>
				<label class="wrong" id="lblVersionNote" style="display: none;">请输入版本号说明！</label>
			</li>
			<li>
				<span class="f_b_t">备注：</span>
				<textarea  class="text_men" rows="" cols="" id="note" name="note"></textarea>
			</li>
			<li class="perMsg_commit">
				<input type="button" class="perMsg_btn" value="保存设置" onclick="saveDic()"/>
			</li>
		</ul>
	</form>
</div>
</body>
<script type="text/javascript">
$(function(){
	checkIsNull();
	initData();
});

//初始化数据 
function initData(){
	$("#note").val('${shopIn.note}');
	$("#note").show();
}

// 非空校验 
function checkIsNull(){
	$("#nameCode").bind("blur", checkNameCode);
	$("#nameCode").bind("focus", function() {$("#lblNameCode").css({"display" : "none"});});

	$("#nameValue").bind("blur", checkNameValue);
	$("#nameValue").bind("focus", function() {$("#lblNameValue").css({"display" : "none"});});

	$("#sys").bind("blur", checkSys);
	$("#sys").bind("focus", function() {$("#lblSys").css({"display" : "none"});});

	$("#module").bind("blur", checkModule);
	$("#module").bind("focus", function() {$("#lblModule").css({"display" : "none"});});

	$("#version").bind("blur", checkVersion);
	$("#version").bind("focus", function() {$("#lblVersion").css({"display" : "none"});});

	$("#versionNote").bind("blur", checkVersionNote);
	$("#versionNote").bind("focus", function() {$("#lblVersionNote").css({"display" : "none"});});
}

//校验名称编码
function checkNameCode() {
	if ($("#nameCode").val() == "") {
		$("#lblNameCode").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验名称值
function checkNameValue() {
	if ($("#nameValue").val() == "") {
		$("#lblNameValue").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验所属系统
function checkSys() {
	if ($("#sys").val() == "") {
		$("#lblSys").show();
		return false;
	} else {
		return true;
	}
}

// 校验所属模块
function checkModule() {
	if ($("#module").val() == "") {
		$("#lblModule").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验版本号
function checkVersion() {
	if ($("#version").val() == "") {
		$("#lblVersion").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验版本号说明
function checkVersionNote() {
	if ($("#versionNote").val() == "") {
		$("#lblVersionNote").show();
		return false;
	} else {
		return true;
	}
}
	
//保存字典 
function saveDic() {
	if (checkNameCode() && checkNameValue() && checkSys() && checkModule() && checkVersion() && checkVersionNote()) {
		var url = "shopInter.do?method=editDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url,data);
		alert(ret);
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.page(1);
	}
}
</script>
</html>