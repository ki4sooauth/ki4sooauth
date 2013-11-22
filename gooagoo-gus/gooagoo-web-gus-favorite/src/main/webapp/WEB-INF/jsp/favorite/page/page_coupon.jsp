<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<div class="page_box">
	<c:if test="${pageModel.pageIndex > 1 }">
		<a class="prev arrow" href="javascript:void(0);" onclick="javascript:doPage_coupon('${pageModel.pageIndex - 1 }');"></a><!--上一页-->
	</c:if>
	<c:if test="${pageModel.pages > 1}">
		<c:set var="pageMin" value="${3 - pageModel.pageIndex > 0 ? 3 - pageModel.pageIndex : 0 }"></c:set>
		<c:set var="pageMax" value="${2 + pageModel.pageIndex - pageModel.pages > 0 ? pageModel.pageIndex + 2 - pageModel.pages : 0 }"></c:set>
		<c:set var="pageIndexMin" value="${pageModel.pageIndex - 3 - pageMax < 1 ? 1 : pageModel.pageIndex - 3 - pageMax }"></c:set>
		<c:set var="pageIndexMax" value="${pageModel.pageIndex + 2 + pageMin < pageModel.pages ? pageModel.pageIndex + 2 + pageMin : pageModel.pages }"></c:set>
		<c:forEach begin="${pageIndexMin }" end="${pageModel.pageIndex }" var="item">
			<c:choose>
				<c:when test="${pageModel.pageIndex == item }">
					<a class="actived" href="javascript:void(0);">${item }</a>
				</c:when>
				<c:otherwise>
					<a href="javascript:void(0);" onclick="javascript:doPage_coupon('${item }');">${item }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:forEach begin="${pageModel.pageIndex + 1 }" end="${pageIndexMax }" var="item">
			<a href="javascript:void(0);" onclick="javascript:doPage_coupon('${item }');">${item }</a>
		</c:forEach>
	</c:if>
	<c:if test="${pageModel.pageIndex < pageModel.pages}">
		<a class="next arrow" href="javascript:void(0);" onclick="javascript:doPage_coupon('${pageModel.pageIndex + 1 }');"></a><!--下一页-->
	</c:if>
</div>