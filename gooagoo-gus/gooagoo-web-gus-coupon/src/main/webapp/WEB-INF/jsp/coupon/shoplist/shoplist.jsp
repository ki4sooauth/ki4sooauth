<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${data != null && fn:length(data) > 0 }">
   <span class="caption_name">商 家:</span> 
   	<span class="name_links">
		<a href="javascript: void(0);" class="selected" onclick="javascript: doSelectShop('', this);">不 限</a> 
		<c:forEach items="${data }" var="simpleShopInfo">
	        <a href="javascript: void(0);" onclick="javascript: doSelectShop('${simpleShopInfo.shopId }', this);">${simpleShopInfo.shopName }</a>
	    </c:forEach>
	</span>
</c:if>
