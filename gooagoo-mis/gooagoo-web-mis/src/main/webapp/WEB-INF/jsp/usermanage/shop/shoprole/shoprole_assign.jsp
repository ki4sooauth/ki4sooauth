<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商家角色权限设置</title>
<link rel="stylesheet" type="text/css" href="${imgPath}/common/ztree/css/zTreeStyle/zTreeStyle.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${imgPath}/common/ztree/css/window/treeWindow.css" media="screen" />
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/ztree-common.js"></script>
<script type="text/javascript">
$(function(){
	initTree();
});
//获取角色Id 
function getRoleId(){
	return "${ids}";
}
//初始化树
function initTree(){
	var url = "shopRoleManage.do?method=assignShopRoleManageLoad";
	var data = "&ids=" + getRoleId();
	$.ajax({
		type: "POST",
		async: false,
		url: url,
		data: data,
		dataType:"json",
		success: function(result){
			initZtreeSimple("positionTree",true,true,result);
		}
	});
}
//保存权限 
function saveAuthority(){
	var roleId = getRoleId();
	var authoritys = getCheckedNodes("positionTree");
	var ids = "";
	for(var i = 0; i < authoritys.length; i++){
		ids += authoritys[i].id + ",";
	}
	var url = "shopRoleManage.do?method=assignShopRoleManage";
	var data = "&authoritys=" + ids + "&roleId=" + roleId;
	$.ajax({
		type: "POST",
		async: false,
		url: url,
		data: data,
		dataType:"json",
		success: function(result){
			if(result.success){
				alert("权限设置成功");
			}else{
				alert("权限设置失败");
			}
			(document.parentWindow || document.defaultView).parent.closeFancyBox();
			(document.parentWindow || document.defaultView).parent.page(1);
		}
	});
}
</script>
<style type="text/css">
.publish_n_top_scroll{height:430px;}
</style>
</head>

<body>
<div class="publish">
	<div class="publish_top">
		<p class="publish_top_p1"></p>
		<span>设置权限</span>
		<p class="publish_top_p2"></p>
	</div>
	<div class="publish_n">
		<div class="publish_n_top_scroll">
			<!--内容 -->
			<ul id="positionTree" class="ztree"></ul>
		</div>
		<div class="publish_n_buttom" >
			<input type="button" value="确定" onclick="saveAuthority()"/>
		</div>
	</div>
</div>
</body>
</html>