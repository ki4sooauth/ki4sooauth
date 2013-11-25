<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity2",720,580,true);
});

// 分配商家角色
function assign(){
	if("" == ids || ids == null){
		alert("请选择要分配的商家！");
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

// 展示分配商家角色页面
function showUpdateJsp(id){
	var url = "shopUserManange.do?method=assignShopUserManangePage&shopId="+ id;
	$("#sysuserFancybox2").attr("href",url).click();
}
</script>

<div style="display:none;">
	<a href="#" id="sysuserFancybox2" class="fancybox_activity2" ></a>
</div>
<div class="div_but">
	<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
		<c:if test="${item.pId eq parentId2 and item.name eq '分配角色'}">
			<input type="button" value="分配角色" onclick="assign()" />
		</c:if>
	</c:forEach>
</div>
<div class="list_box_search" style="padding:0 0 0 1px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"/>序号</th>
			<th>商家名称</th>
			<th>电子邮箱</th>
			<th>商家状态</th>
			<th>是否连锁</th>
			<th>部署模式</th>
			<th>更新时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input id="cb${im.count}" type="checkbox" name="single" value="${item.shopId}" sShopStatus="${item.shopStatus}"/>&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td id="shopName${im.count }">${item.shopName }</td>
				<td>${item.email }</td>
				<td>
					<c:choose>
						<c:when test="${item.shopStatus eq 'L'}">锁定</c:when>
						<c:when test="${item.shopStatus eq 'P'}">待营业</c:when>
						<c:when test="${item.shopStatus eq 'U'}">正常营业</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${item.isChain eq 'Y'}">连锁</c:when>
						<c:when test="${item.isChain eq 'N'}">非连锁</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${item.serviceStyle eq 'A'}">gooagoo代理</c:when>
						<c:when test="${item.serviceStyle eq 'S'}">商家独享</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td><fmt:formatDate value="${item.cTimeStamp}" type="both" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="7"><strong>暂无信息</strong></td>
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