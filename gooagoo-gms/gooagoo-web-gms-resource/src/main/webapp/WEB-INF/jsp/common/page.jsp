<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<div class="pageBox">
	<c:if test="${page_cur > 1}">
		<a href="javascript:void(0);" class="prev" onclick="page(${page_cur - 1 },this);"></a>
	</c:if>
		<c:if test="${pageModel.count!=0}">
			<c:forEach begin="${page_start}" end="${page_end }" step="1"
				varStatus="item">
				<c:choose>
					<c:when test="${(page_cur==page_start+item.count-1)}">
					     <a href="javascript:void(0);"    class="curr"  onclick="page(${page_start+item.count-1 },this);">${page_start+item.count-1 }</a>
					</c:when>
					<c:otherwise>
                        <a href="javascript:void(0);"  onclick="page(${page_start+item.count-1 },this);">${page_start+item.count-1 }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:if>
	
	
	<c:if test="${page_cur != page_end }">
		<a href="javascript:void(0);" class="next"
			onclick="page(${page_cur + 1 });"></a>
	</c:if>
</div>
