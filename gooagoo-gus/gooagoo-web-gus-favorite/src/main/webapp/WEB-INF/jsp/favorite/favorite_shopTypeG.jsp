<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include  file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<c:if test="${!empty data}"> 
	<dd><a href="javascript:void(0);" onclick="selectShopG('')">全部</a></dd>
	<c:forEach items="${data}" var="d">
		<dd><a href="javascript:void(0);" onclick="selectShopG1('${d.shopTypeId}')">${d.shopTypeName}</a></dd>
	</c:forEach>
</c:if>
