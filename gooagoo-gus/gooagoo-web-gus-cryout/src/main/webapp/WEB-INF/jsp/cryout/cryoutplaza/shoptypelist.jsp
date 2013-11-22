<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${isSuccess && data != null && fn:length(data) > 0 }">
<h2 class="title">全部商家分类</h2>
<c:forEach items="${data }" var="simpleShopType">
<c:choose>
<c:when test="${simpleShopType.children == null || fn:length(simpleShopType.children) == 0 }">
<div class="list_menu">
	<h3><b>></b>${simpleShopType.shopTypeName }</h3>
	<div class="hide_box">
		<ul>
	       	<li><a href="javascript: void(0);" onclick="jsvascript: doLoadShoplist('${simpleShopType.shopTypeId }');">${simpleShopType.shopTypeName }</a></li>
		</ul>
	</div>
</div>
</c:when>
<c:otherwise>
<div class="list_menu">
	<h3><b>></b>${simpleShopType.shopTypeName }</h3>
	<div class="hide_box">
		<ul>
			<c:forEach items="${simpleShopType.children }" var="children" varStatus="status">
	       	<li><a href="javascript: void(0);" onclick="jsvascript: doLoadShoplist('${children.shopTypeId }');">${children.shopTypeName }</a>${status.count == fn:length(simpleShopType.children) ? "" : "<span>|</span>"  }</li>
	       	</c:forEach>
		</ul>
	</div>
</div>
</c:otherwise>
</c:choose>
</c:forEach>
</c:if>