<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${!empty recommendationGoodsList}">
		<c:forEach items="${recommendationGoodsList}" var="list">
			<li class="content productC"><a href="${list.goodsVisitUrl}" target="_blank"><img src="${list.goodsImage.middleImgUrl}"width="180" height="180" style="display:block" /></a>
				<p class="msg">${list.goodsName}</p>
		   </li>
		</c:forEach>
</c:if>
       