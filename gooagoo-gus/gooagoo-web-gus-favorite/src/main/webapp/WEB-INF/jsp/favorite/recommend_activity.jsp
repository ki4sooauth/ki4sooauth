<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${!empty recommendActivityResponseList}">
	<c:forEach  items="${recommendActivityResponseList}" var ="list">
		<li class="content productC"><a href="${list.activeVisitUrl}" target="_blank"><img src="${list.activeImage.middleImgUrl}"  width="180" height="180" style="display:block"/></a>
			<p class="msg">${list.activeName}</p>
	    </li>
    </c:forEach>
</c:if>