<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商家管理权限表页面</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul>
				<li><span><code>*</code>权限ID：</span>
					<input type="text" class="name_input" id="authorityId" name="authorityId" />
					<label class="wrong" id="lblAuthorityId" style="display: none;">请输入权限ID！</label>
				</li>
				<li><span><code>*</code>权限名称：</span>
					<input type="text" class="name_input" id="authorityName" name="authorityName" />
					<label class="wrong" id="lblAuthorityName" style="display: none;">请输入权限名称！</label>
				</li>
				<li><span><code>*</code>父权限ID：</span>
					<input type="text" class="name_input" id="parentAuthorityId" name="parentAuthorityId" />
					<label class="wrong" id="lblParentAuthorityId" style="display: none;">请输入父权限ID！</label>
				</li>
				<li><span class="f_b_t">链接：</span>
					<input type="text" class="name_input" id="link" name="link" />
				</li>
				<li><span><code>*</code>排序编号：</span>
					<input type="text" class="name_input" id="orderNo" name="orderNo" />
					<label class="wrong" id="lblOrderNo" style="display: none;">请输入排序编号！</label>
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
	$("#authorityId").bind("blur", checkAuthorityId);
	$("#authorityId").bind("focus", function() {$("#lblAuthorityId").css({"display" : "none"});});
	$("#authorityName").bind("blur", checkAuthorityName);
	$("#authorityName").bind("focus", function() {$("#lblAuthorityName").css({"display" : "none"});});
	$("#parentAuthorityId").bind("blur", checkParentAuthorityId);
	$("#parentAuthorityId").bind("focus", function() {$("#lblParentAuthorityId").css({"display" : "none"});});
	$("#orderNo").bind("blur", checkOrderNo);
	$("#orderNo").bind("focus", function() {$("#lblOrderNo").css({"display" : "none"});});
}
	
// 权限ID
function checkAuthorityId() {
	if ($("#authorityId").val() == "") {
		$("#lblAuthorityId").show();
		return false;
	} else {
		return true;
	}
}
	
// 权限名称
function checkAuthorityName() {
	if ($("#authorityName").val() == "") {
		$("#lblAuthorityName").show();
		return false;
	} else {
		return true; 
	}
}

// 父权限ID
function checkParentAuthorityId() {
	if ($("#parentAuthorityId").val() == "") {
		$("#lblParentAuthorityId").show();
		return false;
	} else {
		return true;
	}
}

// 排序编号
function checkOrderNo() {
	if ($("#orderNo").val() == "") {
		$("#lblOrderNo").show();
		return false;
	} else {
		return true;
	}
}

// 保存字典 
function saveDic() {
	if (checkAuthorityId() && checkAuthorityName() && checkParentAuthorityId() && checkOrderNo()) {
		var url = "shopAuth.do?method=addDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url, data);
		alert(ret);
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.page(1);
	}
}
</script>
</html>