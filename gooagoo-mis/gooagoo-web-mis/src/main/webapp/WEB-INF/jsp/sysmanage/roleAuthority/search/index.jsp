<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询角色</title>
<script>
var varPageIndex = 1;
$(function(){
	refresh();
});
//分页查询 
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	varPageIndex = index;
	var data = $("#searchForm").serialize() +"&pageIndex="+index;
	ajaxToPageByData("sysRole.do?method=showRoleListContent","resultlist",data);
}
//刷新 
function refresh(){
	page(varPageIndex);
}
</script>
</head>

<body>
<!--内容-右边栏-->
<div class="content_right">
	<div class="div_top">
		<div class="div_p">
			<form id="searchForm" name="searchForm">
				<p>
					<label class="lab1">
						<span>角色名称：</span>
						<input type="text" id="roleName" name="roleName" />
					</label>
					<label class="lab1">
						<span>创建时间：</span>
						<input id="createTime_FE" name="createTime_FE" class="Wdate" type="text" onfocus="WdatePicker()" style="cursor: pointer;" />
					</label>
					<label class="lab1">
						<span>至：</span>
						<input id="createTime_TE" name="createTime_TE" class="Wdate" type="text" onfocus="WdatePicker()" style="cursor: pointer;" />
					</label>
				</p>
				<p class="p1">
					<input type="reset" value="重置" /><input type="button" value="查询" onclick="javascript:page(1);" />
				</p>
			</form>
		</div>
		<div class="div_in">
			<input type="button" class="in6" />
		</div>
	</div>
	<div>
		<div class="big_box" id="resultlist">
		</div>
	</div>
</div>
<div class="clear"></div>
</body>
</html>