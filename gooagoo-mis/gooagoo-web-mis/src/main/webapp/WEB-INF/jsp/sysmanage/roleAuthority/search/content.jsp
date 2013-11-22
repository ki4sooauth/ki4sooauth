<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity1",260,550,true);
	initFancyBox("fancybox_activity2",570,380,true);
});

//编辑 
function edit(){
	if("" == ids || ids == null){
		alert("请选择要编辑的角色！");
		return;
	}
	if(checkOnly()){
		showUpdateJsp(ids);
	}
}
//删除
function del(){
	if("" == ids || ids == null){
		alert("请选择要删除的角色！");
		return;
	} else{
		if($("input[name='single']:checkbox:checked").attr("isDel") == 'Y'){
			alert("已删除角色无法进行此操作");
			return false;	
		}
		if(confirm("确定删除选中信息？")){
			var url = "sysRole.do?method=delRole";
			var data = "&id=" + ids;
			ajaxJsonTipByData(url,data,true);
			page(pIndex);
		}
	}
}
//设置权限 
function allotAuthority(){
	if("" == ids || ids == null){
		alert("请选择要设置权限的角色！");
		return;
	}
	if(checkOnly()){
		if($("input[name='single']:checkbox:checked").attr("isDel") == 'Y'){
			alert("已删除角色无法进行此操作");
			return false;	
		}
		showAuthorityList(ids);
	}
}
//选择一条数据进行操作 
function checkOnly(){
	var arrayMemberId = null;
	if(ids != null){
		arrayMemberId = ids.split(",");
		if((arrayMemberId.length - 1) > 1){
			alert("只能选择一个角色进行操作！");
			page(1);
				return false;
		} return true;
	} return false;
}
//权限树展示
function showAuthorityList(id){
	var url = "sysRole.do?method=showSetAuthority&id=" + id;
	$("#sysuserFancybox1").attr("href",url).click();
}
//角色编辑页面
function showUpdateJsp(id){
	var url = "sysRole.do?method=showUpdateRole&id="+ id;
	$("#sysuserFancybox2").attr("href",url).click();
}
//角色新增页面
function add(id){
	var url = "sysRole.do?method=showAddRole";
	$("#sysuserFancybox2").attr("href",url).click();
}
</script>
<div style="display:none;">
	<a href="#" id="sysuserFancybox1" class="fancybox_activity1" ></a>
	<a href="#" id="sysuserFancybox2" class="fancybox_activity2" ></a>
</div>
<div class="div_but">
	<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
		<c:if test="${item.pId eq parentId2 and item.name eq '新增'}">
			<input type="button" value="新增" onclick="add()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '编辑'}">
			<input type="button" value="编辑" onclick="edit()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '删除'}">
			<input type="button" value="删除" onclick="del()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '分配权限'}">
			<input type="button" value="分配权限" onclick="allotAuthority()" />
		</c:if>
	</c:forEach>
</div>
<div class="list_box_search">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th width="5%"><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"/>序号</th>
			<th width="40%">角色名称</th>
			<th width="20%">创建时间</th>
			<th>备注</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.roleId }" isDel="${item.isDel}" />&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.roleName }</td>
				<td><fmt:formatDate value="${item.createTime}" type="both" pattern="yyyy-MM-dd" /></td>
				<td>${item.note }</td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="4"><strong>暂无信息</strong></td>
			</tr>
		</c:otherwise>
		</c:choose>
	</table>
</div>
<!--分页-->
<c:if test="${!empty pm.result }">
	<div class="lasl" id="Pagination" style="border:0;">
		<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
	</div>
</c:if>