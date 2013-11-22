<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity2",670,480,true);
});

// 增加
function add(){
	var url = "shopTool.do?method=showDicAdd";
	$("#sysuserFancybox2").attr("href",url).click();
}

// 删除
function del(){
	if("" == ids || ids == null){
		alert("请选择要删除的字典！");
		return;
	}
	if(confirm("是否将此字典信息删除？")){
		var data = "pageIndex=1&id=" + ids;
		ajaxJsonTipByData("shopTool.do?method=delDict",data,true);
		page(1);
	}
}

// 编辑 
function edit(){
	if("" == ids || ids == null){
		alert("请选择要编辑的字典！");
		return;
	}
	if(checkOnly()){
		showUpdateJsp(ids);
	}
}

// 选择一条数据进行操作 
function checkOnly(){
	var arrayMemberId = null;
	if(ids != null){
		arrayMemberId = ids.split(",");
		if((arrayMemberId.length - 1) > 1){
			alert("只能选择一条数据进行操作！");
			page(1);
			return false;
		} 
		return true;
	} 
	return false;
}

// 展示字典编辑页面
function showUpdateJsp(id){
	var url = "shopTool.do?method=showDicEdit&id="+ id;
	$("#sysuserFancybox2").attr("href",url).click();
}

//导出
function exportEx(){
	var data = $("#searchForm").serialize();
	exportExcel('shopTool.do?method=exportExcel',data);
}
</script>
<div style="display:none;">
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
		<c:if test="${item.pId eq parentId2 and item.name eq '导入' }">
			<label title="导入Excel"><input id="importExcel" type="button" value="导入" onclick="importExcel('sysuserFancybox2','shopTool.do?method=importExcel')" /></label>
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '导出' }">
			<label title="导出Excel"><input id="exportExcel" type="button" value="导出" onclick="exportEx()" /></label>
		</c:if>
	</c:forEach>
</div>
<div class="list_box_search" style="padding:0 0 0 1px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th width="4%"><input type="checkbox" name="Seleted_all" style="margin-right: 3px;" />序号</th>
			<th width="8%">服务工具名称</th>
			<th width="17%">工具图标（选中）</th>
			<th width="17%">工具图标（非选中状态）</th>
			<th width="12%">服务工具类型</th>
			<th width="11%">版本</th>
			<th width="11%">工具介绍URL</th>
			<th width="10%">更新时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.toolId }" />&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.toolName }</td>
				<td><img src="${item.toolIcoFocus }"/></td>
				<td><img src="${item.toolIcoUnfocus }"/></td>
				<td>
					<c:forEach items="${tool_type}" var="type">
						<c:if test="${item.toolType eq type.englishName }">${type.chineseName }</c:if>
					</c:forEach>
				</td>
				<td>${item.ver }</td>
				<td><span title="${item.toolUrl }"><a href="${item.toolUrl }" target="_blank" >查看</a></span></td>
				<td><fmt:formatDate value="${item.cTimeStamp}" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="8"><strong>暂无信息</strong></td>
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