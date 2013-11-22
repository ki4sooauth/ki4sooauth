<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${!empty data }">
<c:forEach items="${data }" var="list">
	<li><a href="${list.goodsVisitUrl}" target="_blank"><img src="${list.goodsImage.middleImgUrl}"  width="100" height="100"/></a></li>
</c:forEach>
</c:if>