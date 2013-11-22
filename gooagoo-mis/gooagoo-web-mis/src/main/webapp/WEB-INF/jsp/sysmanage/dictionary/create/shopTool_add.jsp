<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商家服务工具字典页面</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul style="width: 590px;">
				<li><span style="width: 160px;"><code>*</code>服务工具编号：</span>
					<input type="text" class="name_input" id="toolId" name="toolId" />
					<label class="wrong" id="lblToolId" style="float:none; display: none;">请输入服务工具编号！</label>
				</li>
				<li><span style="width: 160px;"><code>*</code>服务工具名称：</span>
					<input type="text" class="name_input" id="toolName" name="toolName" />
					<label class="wrong" id="lblToolName" style="float:none; display: none;">请输入服务工具名称！</label>
				</li>
				<li><span style="width: 160px;"><code>*</code>工具介绍URL：</span>
					<input type="text" class="name_input" id="toolUrl" name="toolUrl" />
					<label class="wrong" id="lblToolUrl" style="float:none; display: none;">请输入工具介绍URL！</label>
				</li>
				<li><span style="width: 160px;"><code>*</code>工具图标（选中）：</span>
					<input type="text" class="name_input" id="toolIcoFocus" name="toolIcoFocus" readOnly="readonly" />
					<input id="btnIcoFocus" type="button" value="浏览" class="fileUpload btnOrange" style="width: 50px;"/>
					<label class="wrong" id="lblToolIcoFocus" style="float:none; display: none;">请上传工具图标（选中）！</label>
				</li>
				<li><span style="width: 160px;"><code>*</code>工具图标（非选中状态）：</span>
					<input type="text" class="name_input" id="toolIcoUnfocus" name="toolIcoUnfocus" readOnly="readonly" />
					<input id="btnIcoUnfocus" type="button" value="浏览" class="fileUpload btnOrange" style="width: 50px;"/>
					<label class="wrong" id="lblToolIcoUnfocus" style="float:none; display: none;">请上传工具图标（非选中状态）！</label>
				</li>
				<li><span style="width: 160px;"><code>*</code>服务工具类型：</span>
					<input type="text" class="name_input" id="toolType" name="toolType" />
					<label class="wrong" id="lblToolType" style="float:none; display: none;">请输入服务工具类型！</label>
				</li>
				<li><span style="width: 160px;"><code>*</code>手机本地命令：</span>
					<input type="text" class="name_input" id="localCmd" name="localCmd" />
					<label class="wrong" id="lblLocalCmd" style="float:none; display: none;">请输入手机本地命令！</label>
				</li>
				<li><span style="width: 160px;"><code>*</code>版本：</span>
					<input type="text" class="name_input" id="ver" name="ver" />
					<label class="wrong" id="lblVer" style="float:none; display: none;">请输入版本！</label>
				</li>
				<li><span style="width: 150px; padding-left:10px;">备注：</span>
					<textarea class="text_men" id="remark" name="remark" rows="" cols="" ></textarea> 
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
	initFileUpload("btnIcoFocus");
	initFileUpload("btnIcoUnfocus");
})

// 非空校验 
function checkIsNull() {
	$("#toolId").bind("blur", checkToolId);
	$("#toolId").bind("focus", function() {$("#lblToolId").css({"display" : "none"});});

	$("#toolName").bind("blur", checkToolName);
	$("#toolName").bind("focus", function() {$("#lblToolName").css({"display" : "none"});});

	$("#toolUrl").bind("blur", checkToolUrl);
	$("#toolUrl").bind("focus", function() {$("#lblToolUrl").css({"display" : "none"});});

	$("#toolIcoFocus").bind("blur", checkIcoFocus);
	$("#toolIcoFocus").bind("focus", function() {$("#lblToolIcoFocus").css({"display" : "none"});});

	$("#toolIcoUnfocus").bind("blur", checkIcoUnfocus);
	$("#toolIcoUnfocus").bind("focus", function() {$("#lblToolIcoUnfocus").css({"display" : "none"});});

	$("#toolType").bind("blur", checkToolType);
	$("#toolType").bind("focus", function() {$("#lblToolType").css({"display" : "none"});});
	
	$("#localCmd").bind("blur", checkLocalCmd);
	$("#localCmd").bind("focus", function() {$("#lblLocalCmd").css({"display" : "none"});});
	
	$("#ver").bind("blur", checkVer);
	$("#ver").bind("focus", function() {$("#lblVer").css({"display" : "none"});});
}

//图片上传返回url
function initFileUpload(id) {
	$("#"+id).submitFile({
		action : "upload.do?method=uploadFile",
		zindex : 0,
		type : "text",
		success : function(url, obj) {
			if(id == 'btnIcoFocus'){
				$("#toolIcoFocus").val(url);
				$("#lblToolIcoFocus").hide();
			} else if(id == 'btnIcoUnfocus'){
				$("#toolIcoUnfocus").val(url);
				$("#lblToolIcoUnfocus").hide();
			}
		}
	});
}
	
// 校验服务工具编号
function checkToolId() {
	if ($("#toolId").val() == "") {
		$("#lblToolId").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验服务工具名称
function checkToolName() {
	if ($("#toolName").val() == "") {
		$("#lblToolName").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验工具介绍URL
function checkToolUrl() {
	if ($("#toolUrl").val() == "") {
		$("#lblToolUrl").show();
		return false;
	} else {
		return true;
	}
}

// 校验工具图标（选中）
function checkIcoFocus() {
	if ($("#toolIcoFocus").val() == "") {
		$("#lblToolIcoFocus").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验工具图标（非选中状态）
function checkIcoUnfocus() {
	if ($("#toolIcoUnfocus").val() == "") {
		$("#lblToolIcoUnfocus").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验服务工具类型
function checkToolType() {
	if ($("#toolType").val() == "") {
		$("#lblToolType").show();
		return false;
	} else {
		return true;
	}
}

//校验服务工具类型
function checkLocalCmd() {
	if ($("#localCmd").val() == "") {
		$("#lblLocalCmd").show();
		return false;
	} else {
		return true;
	}
}

//校验服务工具类型
function checkVer() {
	if ($("#ver").val() == "") {
		$("#lblVer").show();
		return false;
	} else {
		return true;
	}
}

//保存字典 
function saveDic() {
	if (checkToolId() && checkToolName() && checkToolUrl() && checkIcoFocus() && checkIcoUnfocus() && checkToolType() && checkLocalCmd() && checkVer()) {
		var url = "shopTool.do?method=addDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url, data);
		alert(ret);
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.page(1);
	}
}
</script>
</html>