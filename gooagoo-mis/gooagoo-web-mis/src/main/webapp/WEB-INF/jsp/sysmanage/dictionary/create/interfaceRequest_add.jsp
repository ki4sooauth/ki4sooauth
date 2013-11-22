<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>接口请求参数信息表页面</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul>
				<li><span><code>*</code>接口编码：</span>
					<input type="text" class="name_input" id="iCode" name="iCode" />
					<label class="wrong" id="lblICode" style="display: none;">请输入接口编码！</label>
					<label class="wrong" id="lblCheckICode"></label>
				</li>
				<li><span><code>*</code>参数英文名称：</span>
					<input type="text" class="name_input" id="nameEn" name="nameEn" />
					<label class="wrong" id="lblIName" style="display: none;">请输入参数英文名称！</label>
				</li>
				<li><span><code>*</code>参数中文名称：</span>
					<input type="text" class="name_input" id="nameCn" name="nameCn" />
					<label class="wrong" id="lblIType" style="display: none;">请输入参数中文名称！</label>
				</li>
				<li>
					<span><code>*</code>是否必填：</span>
					<input type="radio" name="isRequired" class="other_add" value="Y"/><label class="other_add_txt">是</label>
					<input type="radio" name="isRequired" class="other_add" value="N" checked="checked"/><label class="other_add_txt">否</label>
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
	$("#iCode").bind("blur", checkICode);
	$("#iCode").bind("focus", function() {$("#lblICode").css({"display" : "none"});});
	$("#nameEn").bind("blur", checkNameEn);
	$("#nameEn").bind("focus", function() {$("#lblNameEn").css({"display" : "none"});});
	$("#nameCn").bind("blur", checkNameCn);
	$("#nameCn").bind("focus", function() {$("#lblNameCn").css({"display" : "none"});});
}
	
// 接口编码
function checkICode() {
	if ($("#iCode").val() == "") {
		$("#lblICode").show();
		return false;
	} else {
		ajaxCheckTheUniqueness("interRequ.do?method=checkIcode",$("#iCode").val(),"lblCheckICode","接口编码不存在！");
	}
}

// 是否有提示信息
function checkMessage() {
	if ($("#iCode").val() == "") {
		$("#lblICode").show();
		return false;
	}
	if($("#lblCheckICode").htm() == ""){
		return true;
	}
	return false;
}
	
// 英文名称
function checkNameEn() {
	if ($("#iName").val() == "") {
		$("#lblIName").show();
		return false;
	} else {
		return true; 
	}
}

// 中文名称
function checkNameCn() {
	if ($("#iType").val() == "") {
		$("#lblIType").show();
		return false;
	} else {
		return true;
	}
}

// 保存字典 
function saveDic() {
	if (checkMessage() && checkNameEn() && checkNameCn()) {
		var url = "interRequ.do?method=addDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url, data);
		alert(ret);
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.page(1);
	}
}
</script>
</html>