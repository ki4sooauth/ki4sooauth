<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商家角色</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul style="width: 500px;">
				<li><span><code>*</code>角色名称：</span>
					<input type="hidden" name="roleId" value="${role.roleId }"/>
					<input type="text" class="name_input" id="roleName" name="roleName" value="${role.roleName }" />
					<label class="wrong" id="lblRoleName" style="float:none; display: none;">请输入角色名称！</label>
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
$(function() {
	checkIsNull();
	initData();
})

// 非空校验 
function checkIsNull() {
	$("#roleName").bind("blur", checkRoleName);
	$("#roleName").bind("focus", function() {$("#lblRoleName").css({"display" : "none"});});
}

//初始化数据 
function initData(){
	$("#note").val('${role.note}');
	$("#note").show();
}
	
//角色名称
function checkRoleName() {
	if ($("#shopId").val() == "") {
		$("#lblRoleName").show();
		return false;
	} else {
		return true;
	}
}

// 保存商家角色
function saveDic() {
	if (checkRoleName()) {
		var url = "shopRoleManage.do?method=updateShopRoleManage";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonMessageByData(url,data);
		if(ret.success){
			alert(ret.message);
			(document.parentWindow || document.defaultView).parent.closeFancyBox();
			(document.parentWindow || document.defaultView).parent.page(1);
		}else{
			alert(ret.message);
		}
	}
}
</script>
</html>