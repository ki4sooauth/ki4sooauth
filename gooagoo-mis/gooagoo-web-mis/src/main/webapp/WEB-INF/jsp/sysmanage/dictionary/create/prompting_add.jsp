<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提示字典添加页面</title>
</head>

<body>
<div class="user_message">
	<form action="" method="post" id="addForm" name="addForm">
		<ul>
			<li>
				<span><code>*</code>提示信息编码：</span>
				<input type="text"  class="name_input" id="messageId" name="messageId" />
				<label class="wrong" id="lblMessageId" style="display: none;">请输入提示信息编码！</label>
			</li>
			<li>
				<span><code>*</code>提示信息内容：</span>
				<input type="text"  class="name_input" id="content" name="content" />
				<label class="wrong" id="lblContent" style="display: none;">请输入提示信息内容！</label>
			</li>
			<li>
				<span><code>*</code>所属系统：</span>
				<input type="text"  class="name_input" id="sys" name="sys" />
				<label class="wrong" id="lblSys" style="display: none;">请输入所属系统！</label>
			</li>
			<li>
				<span><code>*</code>所属功能：</span>
				<input type="text"  class="name_input" id="func" name="func" />
				<label class="wrong" id="lblFunc" style="display: none;">请输入所属功能！</label>
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
})

// 非空校验 
function checkIsNull(){
	$("#messageId").bind("blur", checkMessageId);
	$("#messageId").bind("focus", function(){$("#lblMessageId").css({"display":"none"});});
	
	$("#content").bind("blur", checkContent);
	$("#content").bind("focus", function(){$("#lblContent").css({"display":"none"});});
	
	$("#sys").bind("blur", checkSys);
	$("#sys").bind("focus", function(){$("#lblSys").css({"display":"none"});});
	
	$("#func").bind("blur", checkFunc);
	$("#func").bind("focus", function(){$("#lblFunc").css({"display":"none"});});
}

// 校验提示信息编码
function checkMessageId() {
	if ($("#messageId").val() == "") {
		$("#lblMessageId").show();
		return false;
	}else{
		return true;
	}
}

// 校验提示信息内容
function checkContent() {
	if ($("#content").val() == "") {
		$("#lblContent").show();
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

// 校验所属功能
function checkFunc() {
	if ($("#func").val() == "") {
		$("#lblFunc").show();
		return false;
	} else {
		return true;
	}
}

// 保存字典 
function saveDic(){
	if(checkMessageId() && checkContent() && checkSys() && checkFunc()){
		var url = "prompdict.do?method=addDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url,data);
		alert(ret);
		if(ret != "提示信息编码具有唯一性，请修改"){
			(document.parentWindow || document.defaultView).parent.closeFancyBox();
			(document.parentWindow || document.defaultView).parent.page(1);
		}
	}
}
</script>
</html>