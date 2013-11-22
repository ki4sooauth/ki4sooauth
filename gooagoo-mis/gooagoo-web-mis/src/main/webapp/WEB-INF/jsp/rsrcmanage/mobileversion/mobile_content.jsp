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
	var url = "mobileDevices.do?method=addPage";
	$("#sysuserFancybox2").attr("href",url).click();
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
	</c:forEach>
</div>
<div class="list_box_search" style="padding:0 0 0 1px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th width="5%">序号</th>
			<th width="12%">APP识别码</th>
			<th width="7%">移动设备类型</th>
			<th width="13%">版本名称</th>
			<th width="4%">版本号</th>
			<th width="40%">连接地址</th>
			<th width="9%">所属商圈</th>
			<th width="4%">是否删除</th>
			<th width="6%">创建时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td>${im.count + ((page_cur-1) * 10)}</td>
				<td><span class="">${item.appCode }</span></td>
				<td>
					<c:forEach items="${mobile_type }" var="mobile">
						<c:if test="${mobile.englishName eq item.mobileType }">${mobile.chineseName }</c:if>
					</c:forEach>
				</td>
				<td>${item.versionName }</td>
				<td>${item.version }</td>
				<td>${item.link }</td>
				<td>
					<c:forEach items="${tradeList }" var="trade">
						<c:if test="${trade.tradeAreaId eq item.platform}">${trade.tradeAreaName }</c:if>
					</c:forEach>
				</td>
				<td>
					<c:choose>
						<c:when test="${item.isDel == 'Y'}">是</c:when>
						<c:when test="${item.isDel == 'N'}">否</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="9"><strong>暂无信息</strong></td>
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