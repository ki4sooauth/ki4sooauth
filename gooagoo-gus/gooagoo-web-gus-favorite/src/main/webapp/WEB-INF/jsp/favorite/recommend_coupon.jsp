<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${!empty RecommendCouponResponseList}">
	<c:forEach  items="${RecommendCouponResponseList}"  var="list">
		<li class="content productC"><a href="${list.couponVisitUrl}" target="_blank"><img src="${list.couponImage.middleImgUrl}"  width="180" height="180"  style="display:block" /></a>
			<p class="msg">${list.couponName}</p>
	   </li>
	</c:forEach>
</c:if>