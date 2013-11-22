<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>接口基础信息表页面</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul style="width: 500px;">
				<li><span style="width: 140px;"><code>*</code>接口编码：</span>
					<input type="text" class="name_input" id="iCode" name="iCode" />
					<label class="wrong" id="lblICode" style="float:none; display: none;">请输入接口编码！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>接口名称：</span>
					<input type="text" class="name_input" id="iName" name="iName" />
					<label class="wrong" id="lblIName" style="float:none; display: none;">请输入接口名称！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>接口类型：</span>
					<input type="text" class="name_input" id="iType" name="iType" />
					<label class="wrong" id="lblIType" style="float:none; display: none;">请输入接口类型！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>功能分类：</span>
					<input type="text" class="name_input" id="iFunction" name="iFunction" />
					<label class="wrong" id="lblIFunction" style="float:none; display: none;">请输入功能分类！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>接口地址：</span>
					<input type="text" class="name_input" id="iUrl" name="iUrl" />
					<label class="wrong" id="lblIUrl" style="float:none; display: none;">请输入接口地址！</label>
				</li>
				<li><span class="f_b_t" style="width: 130px;">行为类型：</span>
					<input type="text" class="name_input" id="behaveType" name="behaveType" />
				</li>
				<li>
					<span style="width: 140px;"><code>*</code>是否可分配：</span>
					<input type="radio" name="canAllocate" class="other_add" value="Y"/><label class="other_add_txt">是</label>
					<input type="radio" name="canAllocate" class="other_add" value="N" checked="checked"/><label class="other_add_txt">否</label>
				</li>
				<li><span class="f_b_t" style="width: 130px;">报文示例（XMl）URL：</span>
					<input type="text" class="name_input" id="dataXml" name="dataXml" />
				</li>
				<li><span class="f_b_t" style="width: 130px;">报文示例（JSON）URL：</span>
					<input type="text" class="name_input" id="dataJson" name="dataJson" />
				</li>
				<li>
					<span class="f_b_t" style="width: 130px;">业务逻辑说明URL：</span>
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
	$("#iName").bind("blur", checkIName);
	$("#iName").bind("focus", function() {$("#lblIName").css({"display" : "none"});});
	$("#iType").bind("blur", checkIType);
	$("#iType").bind("focus", function() {$("#lblIType").css({"display" : "none"});});
	$("#iFunction").bind("blur", checkIFunction);
	$("#iFunction").bind("focus", function() {$("#lblIFunction").css({"display" : "none"});});
	$("#iUrl").bind("blur", checkIUrl);
	$("#iUrl").bind("focus", function() {$("#lblIUrl").css({"display" : "none"});});
}
	
// 接口编码
function checkICode() {
	if ($("#iCode").val() == "") {
		$("#lblICode").show();
		return false;
	} else {
		return true;
	}
}
	
// 接口名称
function checkIName() {
	if ($("#iName").val() == "") {
		$("#lblIName").show();
		return false;
	} else {
		return true;
	}
}

// 接口类型
function checkIType() {
	if ($("#iType").val() == "") {
		$("#lblIType").show();
		return false;
	} else {
		return true;
	}
}

// 功能分类
function checkIFunction() {
	if ($("#iFunction").val() == "") {
		$("#lblIFunction").show();
		return false;
	} else {
		return true;
	}
}

// 接口地址
function checkIUrl() {
	if ($("#iUrl").val() == "") {
		$("#lblIUrl").show();
		return false;
	} else {
		return true;
	}
}

// 保存字典 
function saveDic() {
	if (checkICode() && checkIName() && checkIType() && checkIFunction() && checkIUrl()) {
		var url = "interBase.do?method=addDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url, data);
		alert(ret);
		if(ret != "接口编码具有唯一性，请修改"){
			(document.parentWindow || document.defaultView).parent.closeFancyBox();
			(document.parentWindow || document.defaultView).parent.page(1);
		}
	}
}
</script>
</html>