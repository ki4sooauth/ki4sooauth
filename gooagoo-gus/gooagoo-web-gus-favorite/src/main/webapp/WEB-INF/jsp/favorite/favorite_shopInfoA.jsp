<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include  file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
	<dd><a href="javascript:void(0);" onclick="selectShopInfoA('')">全部</a></dd>
	<c:if test="${!empty data}"> 
		<c:forEach items="${data}" var="d">
			<dd><a href="javascript:void(0);" onclick="selectShopInfoA('${d.shopId}')">${d.shopName}</a></dd>
		</c:forEach>
	</c:if>
