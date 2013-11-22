<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<table class="goodsList_table" cellpadding="0" cellspacing="1"
	border="0">
	<tr>
		<th width="204">${shopVo.wordNames['gmse086']}</th>
		<th width="102">${shopVo.wordNames['gmse087']}</th>
		<th width="142">${shopVo.wordNames['gmse089']}</th>
		<th width="266">${shopVo.wordNames['gmse095']}</th>

	</tr>
	<check:hasAuthority authorityID="150402">
	<c:forEach items="${list }" var="feature">
		<tr>
		<td><span>${feature.code }</span></td>
		<td>${feature.name }</td>
		<td>
		<c:forEach items="${feature.values }" var="item">
			${item }&nbsp;&nbsp; 
		</c:forEach>
		</td>
		<td>
		<check:hasAuthority authorityID="15010201">
		<a title="${shopVo.wordNames['gmse008']}" href="${basePath }/feature.do?method=update&id=${feature.id}" class="handle pencil"></a>
		</check:hasAuthority>
		<check:hasAuthority authorityID="15010202">
		<a title="${shopVo.wordNames['gmse009']}" href="javascript:void(0)"  onclick="feature_delete('${feature.id}');" class="handle del"></a>
		</check:hasAuthority>
		</td>
	</tr>
	</c:forEach>
	<c:if test="${fn:length(list) != 0 }">
	<tr>
	<td colspan="4">
	<%@include file="/WEB-INF/jsp/common/page.jsp"%>
	</td>
	</tr>
	</c:if>
	</check:hasAuthority>
	<c:if test="${fn:length(list) == 0 }">
		<tr><td colspan="4">${shopVo.wordNames['gmse096']}</td></tr>
	</c:if>
</table>