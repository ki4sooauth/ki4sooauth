<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加角色</title>
</head>

<body>
<div class="user_message">
	<form action="sysRole.do?method=addRole" method="post" id="addForm" name="addForm">
		<ul>
			<li>
				<span><code>*</code>角色名称：</span>
				<input type="text"  class="name_input" id="roleName" name="roleName" value="${sysRole.roleName }"/>
				<label class="wrong" id="lblRoleName" style="width: 105px;display: none;">请输入角色名称！</label>
			</li>
			<li>
				<span class="f_b_t">备注：</span>
				<textarea  class="text_men" rows="" cols="" id="note" name="note"></textarea>
			</li>
				<li class="perMsg_commit">
				<input type="button" class="perMsg_btn" value="保存设置" onclick="saveRole()"/>
			</li>
		</ul>
	</form>
</div>
<script type="text/javascript">
$(function(){
	checkIsNull();
})
//非空校验 
function checkIsNull(){
	$("#roleName").bind("blur", checkRoleName);
	$("#roleName").bind("focus", function(){$("#lblRoleName").css({"display":"none"});});
}
//校验角色名称 
function checkRoleName() {
	if ($("#roleName").val() == "") {
		$("#lblRoleName").show();
		return false;
	} else {
		return true;
	}
}
//保存角色
function saveRole(){
	if(checkRoleName()){
		var url = "sysRole.do?method=addRole";
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