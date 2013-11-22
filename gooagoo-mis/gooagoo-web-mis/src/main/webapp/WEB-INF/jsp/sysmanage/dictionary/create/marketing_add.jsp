<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>营销渠道字典页面</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul>
				<li><span><code>*</code>营销渠道编码：</span>
					<input type="text" class="name_input" id="channelCode" name="channelCode" />
					<label class="wrong" id="lblChannelCode" style="display: none;">请输入营销渠道编码！</label>
				</li>
				<li><span><code>*</code>营销渠道名称：</span>
					<input type="text" class="name_input" id="channelName" name="channelName" />
					<label class="wrong" id="lblChannelName" style="display: none;">请输入营销渠道名称！</label>
				</li>
				<li><span><code>*</code>父级编码：</span>
					<input type="text" class="name_input" id="parentChannelCode" name="parentChannelCode" />
					<label class="wrong" id="lblParentChannelCode" style="display: none;">请输入父级编码！</label>
				</li>
				<li><span><code>*</code>排序号：</span>
					<input type="text" class="name_input" id="sortOrder" name="sortOrder" />
					<label class="wrong" id="lblSortOrder" style="display: none;">请输入排序号！</label>
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
	$("#channelCode").bind("blur", checkChannelCode);
	$("#channelCode").bind("focus", function() {$("#lblChannelCode").css({"display" : "none"});});

	$("#channelName").bind("blur", checkChannelName);
	$("#channelName").bind("focus", function() {$("#lblChannelName").css({"display" : "none"});});

	$("#parentChannelCode").bind("blur", checkParentChannelCode);
	$("#parentChannelCode").bind("focus", function() {$("#lblParentChannelCode").css({"display" : "none"});});

	$("#sortOrder").bind("blur", checkSortOrder);
	$("#sortOrder").bind("focus", function() {$("#lblSortOrder").css({"display" : "none"});});
}

//校验营销渠道编码
function checkChannelCode() {
	if ($("#channelCode").val() == "") {
		$("#lblChannelCode").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验营销渠道名称
function checkChannelName() {
	if ($("#channelName").val() == "") {
		$("#lblChannelName").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验父级编码
function checkParentChannelCode() {
	if ($("#parentChannelCode").val() == "") {
		$("#lblParentChannelCode").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验排序号
function checkSortOrder() {
	if ($("#sortOrder").val() == "") {
		$("#lblSortOrder").show();
		return false;
	} else {
		return true;
	}
}
	
//保存字典 
function saveDic() {
	if (checkChannelCode() && checkChannelName() && checkParentChannelCode() && checkSortOrder()) {
		var url = "market.do?method=addDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url, data);
		alert(ret);
		if(ret !="营销渠道编码具有唯一性，请修改"){
			
		}
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.page(1);
	}
}
</script>
</html>