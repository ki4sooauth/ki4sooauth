<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<input type="hidden" name="returnType" value="G" />
<c:choose>
	<c:when test="${isSuccess && data != null && fn:length(data) > 0 }">
		<%@ include file="/WEB-INF/jsp/mall/mall/moregoodslist.jsp"%>
	</c:when>
	<c:otherwise>
		<div class="sorryPrompt">
			<samp>${message }</samp>
		</div>
	</c:otherwise>
</c:choose>