<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户分配角色页面</title>
</head>
<body>
<div class="popMsg">
<h2>分配用户角色</h2>
  <ul>
  	<c:forEach var="item" items="${sysRolesResult }">
    	<li><input type="checkbox" value="${item.roleId }" name="chkrole" class="cBoxN" /><label>${item.roleName}</label></li>
    </c:forEach>
  </ul>
  <div class="popBtn">
    <input class="addbtn517 left" type="button" value="确定" onclick="javascript:saveUserRole();"/>
    <input class="addbtn517" type="button" value="取消" onclick="javascript:closefbox();"/>
  </div>
</div>
<script type="text/javascript">
$(function(){
	initData();
})
//初始化数据
function initData(){
	var arrlen = "${rolelen}";
	eval("var ids=" + '${userrole}');
	$("input[name='chkrole']").each(function(){
		for(var i = 0; i < arrlen; i++){
			if($(this).val() == ids[i] ){
				$(this).attr("checked","true");
			}
		}
	})
}
//获取用户Id
function getUserId(){
	return "${userId}";
}
//保存用户角色 
function saveUserRole(){
	var userId = getUserId();
	var roleIds = "";
	$("input[name='chkrole']:checkbox:checked").each(function(){
		roleIds += $(this).val() + ",";
		})
	var url = "sysuser.do?method=saveUserRole";
	var data = "&roleIds=" + roleIds + "&userId=" + userId;
	$.ajax({
		type: "POST",
		async: false,
		url: url,
		data: data,
		dataType:"json",
		success: function(result){
			(document.parentWindow || document.defaultView).parent.closeFancyBox();
			(document.parentWindow || document.defaultView).parent.page(1);
			alert("分配角色成功！");
		}
	});
}
//取消按钮点击
function closefbox(){
	(document.parentWindow || document.defaultView).parent.closeFancyBox();
}
</script>
</body>
</html>