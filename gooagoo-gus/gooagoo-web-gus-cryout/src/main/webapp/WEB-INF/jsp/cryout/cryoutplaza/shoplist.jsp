<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${isSuccess && data != null && fn:length(data) > 0 }">
<div class="acc_point_content">
	<div class="price_interval">
		<h2>商家:</h2>
	   	<ul>
	    	<li><a href="javascript: void(0);" class="curr" onclick="javascript: doSelectShop(null);">不限</a></li>
	    	<c:forEach items="${data }" var="simpleShopInfo">
	        <li><a href="javascript: void(0);" onclick="javascript: doSelectShop('${simpleShopInfo.shopId }');">${simpleShopInfo.shopName }</a></li>
	        </c:forEach>
	   	</ul>
	</div>
</div>
</c:if>