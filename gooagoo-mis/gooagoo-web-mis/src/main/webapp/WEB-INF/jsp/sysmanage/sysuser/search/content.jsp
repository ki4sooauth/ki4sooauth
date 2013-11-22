<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity1",610,500,true);
	initFancyBox("fancybox_activity2",610,320,true);
});
</script>
<div style="display:none;">
	<a href="#" id="sysuserFancybox1" class="fancybox_activity1" ></a>
	<a href="#" id="sysuserFancybox2" class="fancybox_activity2" ></a>
</div>
<div class="div_but">
	<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
		<c:if test="${item.pId eq parentId2 and item.name eq '新增'}">
			<input type="button" value="新增" onclick="addJsp()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '编辑'}">
			<input type="button" value="编辑" onclick="edit()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '删除'}">
			<input type="button" value="删除" onclick="del()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '分配角色'}">
			<input type="button" value="分配角色" onclick="allotRole()" />
		</c:if>
	</c:forEach>
</div>
<div class="list_box_search">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th width="5%"><input type="checkbox" name="Seleted_all" style="margin-right: 3px;" />序号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>出生日期</th>
			<th>邮箱地址</th>
			<th>证件类型</th>
			<th>证件号码</th>
			<th>所属部门</th>
			<th>用户状态</th>
			<th>创建时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.userId }" isDel="${item.isDel}" />&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.name }</td>
				<td>
					<c:choose>
						<c:when test="${item.sex == 'M'}">男</c:when>
						<c:when test="${item.sex == 'F'}">女</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td><fmt:formatDate value="${item.birthday }" type="both" pattern="yyyy-MM-dd" /></td>
				<td>${item.userId }</td>
				<td>
					<c:choose>
						<c:when test="${item.idType == '00' }">身份证</c:when>
						<c:when test="${item.idType == '01' }">护照</c:when>
						<c:when test="${item.idType == '02' }">军官证</c:when>
						<c:when test="${item.idType == '03' }">其他</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td>${item.idNo }</td>
				<td>${item.department }</td>
				<td>
					<c:choose>
						<c:when test="${item.status == 0}">停用</c:when>
						<c:when test="${item.status == 1}">启用</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td><fmt:formatDate value="${item.createTime}" type="both" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="10"><strong>暂无信息</strong></td>
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
<script type="text/javascript">
//编辑 
function edit(){
	if("" == ids || ids == null){
		alert("请选择要编辑的用户！");
		return;
	}
	if(checkOnly()){
		showUpdateJsp(ids);
	}
}
//删除
function del(){
	if("" == ids || ids == null){
		alert("请选择要删除的用户！");
		return;
	} else{
		if($("input[name='single']:checkbox:checked").attr("isDel") == 'Y'){
			alert("已删除用户无法进行此操作");
			return false;	
		}
		if(confirm("确定删除选中信息？")){
			var url = "sysuser.do?method=delSysUser";
			var data = "&id=" + ids;
			ajaxJsonTipByData(url,data,true);
			page(pIndex);
		}
	}
}
//分配角色
function allotRole(){
	if("" == ids || ids == null){
		alert("请选择要分配角色的用户！");
		return;
	}
	if(checkOnly()){
		if($("input[name='single']:checkbox:checked").attr("isDel") == 'Y'){
			alert("已删除用户无法进行此操作");
			return false;	
		}
		showRoleList(ids);
	}
}
//选择一条数据进行操作 
function checkOnly(){
	var arrayMemberId = null;
	if(ids != null){
		arrayMemberId = ids.split(",");
		if((arrayMemberId.length - 1) > 1){
			alert("只能选择一个用户进行操作！");
			page(1);
				return false;
		} return true;
	} return false;
}
//角色列表展示
function showRoleList(userId){
	var url = "sysuser.do?method=allotRole&id="+userId;
	$("#sysuserFancybox2").attr("href",url).click();
}
//显示编辑页面 
function showUpdateJsp(userId){
	var url = "sysuser.do?method=showModifySysUser&id="+ userId;
	$("#sysuserFancybox1").attr("href",url).click();
}
//显示新增页面 
function addJsp(){
	var url = "sysuser.do?method=showAddSysUser";
	$("#sysuserFancybox1").attr("href",url).click();
}	
</script>		
