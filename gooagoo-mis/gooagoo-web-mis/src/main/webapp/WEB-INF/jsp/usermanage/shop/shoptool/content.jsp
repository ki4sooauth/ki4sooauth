<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';
//发布
function formRelease(id){
	if(isEmpty(id)){
		return false;
	}
	var url = "shoptool.do?method=update";
	var data = "&id="+id + "&status=P";//发布P
	var ret = ajaxJsonVoByData(url,data);
	alert(ret);
	page(pIndex);
}
//删除
function formDisable(id){
	if(isEmpty(id)){
		return false;
	}
	if(confirm("确定删除选中信息？")){
		var url = "shoptool.do?method=update";
		var data = "&id="+id + "&isDel=Y";//逻辑删除Y
		var ret = ajaxJsonVoByData(url,data);
		alert(ret);
		page(pIndex);
	}

}
//审核页面
function formCheckEdit(id,shopId){
	if(isEmpty(id)){
		return false;
	}
	(document.parentWindow || document.defaultView).parent.formToolCheckOpen(id,shopId);
}
</script>

<div class="div_but" style="text-align: center;">
	服务工具信息列表
</div>
<div class="list_box_search">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th>序号</th>
			<th>商家名称</th>
			<th>服务工具名称</th>
			<th>状态</th>
			<th>是否删除</th>
			<th>操作</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td>${im.count + ((page_cur-1) * 10)}</td>
				<td>${pmShop.shopName}</td>
				<td>${item.toolName }</td>
				<td width="60">
					<c:choose>
						<c:when test="${item.status eq 'W'}">待审核</c:when>
						<c:when test="${item.status eq 'A'}">已审核通过</c:when>
						<c:when test="${item.status eq 'B'}">已审核不通过</c:when>
						<c:when test="${item.status eq 'P'}">已发布</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${item.isDel eq 'Y'}">是</c:when>
						<c:when test="${item.isDel eq 'N'}">否</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:forEach var="item1" items="${mis_login_auths}" varStatus="im1">
					
						<c:if test="${item1.pId eq parentId3 and item1.name eq '审核'}">
							<c:if test="${item.isDel eq 'N' && item.status eq 'W'}">
								<input type="button" value="审核" onclick="formCheckEdit('${item.id}','${item.shopId}')" />
							</c:if>
						</c:if>
						<c:if test="${item1.pId eq parentId3 and item1.name eq '发布'}">
							<c:if test="${item.isDel eq 'N' && item.status eq 'A'}">
								<input type="button" value="发布" onclick="formRelease('${item.id}')" />
							</c:if>
						</c:if>
						<c:if test="${item1.pId eq parentId3 and item1.name eq '删除'}">
							<c:if test="${item.isDel eq 'N'}">
								<input type="button" value="删除" onclick="formDisable('${item.id}')" />
							</c:if>
						</c:if>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="6"><strong>暂无信息</strong></td>
			</tr>
		</c:otherwise>
		</c:choose>
	</table>
</div>
<!--分页-->
<c:if test="${!empty pm.result }">
<div class="lasl" style="border:0;">
	<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
</div>
</c:if>