<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<ul class="product_list_box">
	<dd><a href="javascript: void(0);" onclick="javascript: loadShopList('', '全部');">全部</a></dd>
	<c:if test="${isSuccess && data != null && fn:length(data) > 0 }">
	<c:forEach items="${data }" var="uShopType">
	<dd><a href="javascript: void(0);" onclick="javascript: loadShopList('${uShopType.shopTypeId }', '${uShopType.shopTypeName }');">${uShopType.shopTypeName }</a></dd>
	</c:forEach>
	</c:if>
</ul>