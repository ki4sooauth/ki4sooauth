<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<table class="listTable" cellspacing="0" cellpadding="0" style="width:100%">
	<tr>
		<th width="5%">${shopVo.wordNames['gmsj24']}</th>
		<th width="10%">${shopVo.wordNames['gmsj25']}</th>
		<th width="20%">${shopVo.wordNames['gmsj26']}</th>
		<th width="20%">${shopVo.wordNames['gmsj27']}</th>
		<th width="10%">${shopVo.wordNames['gmsj28']}</th>
		<th width="20%">${shopVo.wordNames['gmsj29']}</th>
		<th width="10%">${shopVo.wordNames['gmsj30']}</th>
	</tr>
	<c:choose>
		<c:when test="${fn:length(pageModel.result)>0}">
			<c:forEach items="${pageModel.result}" var="bidR" varStatus="count">
				<tr>
					<td>${pageModel.pageSize*(pageModel.pageIndex-1)+(count.index+1)}</td>
					<td><span>${bidR.adName}</span></td>
					<td><fmt:formatDate value="${bidR.effectStartDate}" pattern="yyyy.MM.dd"/>-<fmt:formatDate value="${bidR.effectEndDate}" pattern="yyyy.MM.dd"/></td>
					<td>${bidR.effectStartTime}-${bidR.effectEndTime}</td>
					<td>${bidR.bidAmount}</td>
					<td><fmt:formatDate value="${bidR.bidDate}" pattern="yyyy.MM.dd HH:mm:ss"/></td>
					<td>${bidR.result}</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="7">${shopVo.wordNames['gmsj35']}</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>
<%@include file="/WEB-INF/jsp/common/page.jsp"%>