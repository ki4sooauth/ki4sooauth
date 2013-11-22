<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script src="${imgPath}/mis/js/search.js" type="text/javascript"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity2",970,780,true);
});

//选择一条数据进行操作 
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

//新增
function add(){
	var url = "platformRegion.do?method=addPlatformRegionPage";
	$("#sysuserFancybox2").attr("href",url).click();
}

//编辑
function update(){
	if("" == ids || ids == null){
		alert("请选择要编辑的信息！");
		return;
	}
	if(checkOnly()){
		var url = "platformRegion.do?method=queryPlatformRegionInfo&platformId=" + ids;
		$("#sysuserFancybox2").attr("href",url).click();
	}
}

//删除
function del(){
	if("" == ids || ids == null){
		alert("请选择要删除的信息！");
		return;
	}
	if(confirm("是否将选择的信息删除？")){
		var data = "pageIndex=1&platformId=" + ids;
		ajaxJsonTipByData("platformRegion.do?method=deletePlatformRegion",data,true);
		page(1);
	}
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
			<input type="button" value="编辑" onclick="update()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '删除'}">
			<input type="button" value="删除" onclick="del()" />
		</c:if>
	</c:forEach>
</div>
<div class="list_box_search" style="padding:0 0 0 1px;overflow-x:auto;width:100%;white-space:nowrap">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th width="5%"><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"  />序号</th>
			<th width="15%">小平台名称</th>
			<th width="15%">描述</th>
			<th width="21%">备注</th>
			<th width="12%">更新时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.platformId }" />&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.platformName }</td>
				<td>${item.description }</td>
				<td>${item.note }</td>
				<td><fmt:formatDate value="${item.cTimeStamp}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="5"><strong>暂无信息</strong></td>
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