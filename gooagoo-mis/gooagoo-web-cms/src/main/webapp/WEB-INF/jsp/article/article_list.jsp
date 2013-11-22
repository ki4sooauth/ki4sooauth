<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script>
	var pIndex = '${page_cur}';
	var curSize = '${fn:length(pm.result)}';

	$(document).ready(function(){
		$(".selectAll").click(function(){
			$(".articleTable .num input[type='checkbox']").attr("checked",true);
		})
		$(".cancel").click(function(){
			$(".articleTable .num input[type='checkbox']").attr("checked",false);
		})
	})
</script>
<table class="articleTable" width="100%" border="0" cellspacing="1" cellpadding="0">
	<c:if test="${not empty pm.result}">
		<c:forEach var="itemChild" items="${pm.result}" varStatus="xh">
			<tr>
				<td class="num">
					<input type="checkbox" value="${itemChild.cmsContentId}"/>${pm.pageSize*(pm.pageIndex-1)+xh.index+1}
					<input type="hidden" id="status" value="${itemChild.publishStatus}"/>
					<input type="hidden" id="channelType" value="${itemChild.channelType}"/>
					<input type="hidden" id="parentCmsContentId" value="${itemChild.parentCmsContentId}"/>
					<input type="hidden" id="cmsContentUrl" value="${itemChild.cmsContentUrl}"/>
					<textarea id="templateData" style="display: none;" rows="" cols="">${itemChild.templateData}</textarea>
				</td>
				<td class="articleTitle ${itemChild.isTop == 'Y' ? 'curr' : ''}">
					<a href="javascript:void(0);" onclick="getArticle('${itemChild.cmsContentId}');" title="查看详细">${itemChild.cmsContentName}</a>
				</td>
				<td class="time"><fmt:formatDate value="${itemChild.publishTime }" type="both" pattern="yyyy-MM-dd" /></td>
				<td class="status ${itemChild.publishStatus == 'W' ? 'no' : (itemChild.publishStatus == 'A' ? 'yes' :'' )}">
					<c:forEach items="${publish_status}" var="type">
						<c:if test="${itemChild.publishStatus==type.key}">${type.value}</c:if>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty pm.result}">
		<tr>
			<td colspan="4">暂无文章信息！</td>
		</tr>
	</c:if>
</table>
<c:if test="${not empty pm.result}">
	<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
	<div class="sBox">
 		<span class="selectAll">全&nbsp;选</span>
 		<span class="cancel">取消全选</span>
	</div>
</c:if>