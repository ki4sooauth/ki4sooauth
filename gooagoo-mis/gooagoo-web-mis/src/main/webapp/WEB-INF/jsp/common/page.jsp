<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<div class="shopping_Flip">
	<c:if test="${page_cur != page_end }">
		<!-- 小数计算时会有误差，所以装换成整数在计算 -->
		<a href="javascript:void(0);" class="flip_downBtn" 
			<c:choose>
				<c:when test="${pm.count % 10 == 0}">onclick="page(${pm.count / 10});"</c:when>
				<c:otherwise>onclick="page(${(((pm.count / 10) + 1) * 10 - (pm.count % 10 / 10) * 10) / 10});"</c:otherwise>
			</c:choose>
		>末&nbsp;&nbsp;页</a>
		<a href="javascript:void(0);" class="flip_downBtn" onclick="page(${page_cur + 1 });">下一页</a>
	</c:if>
	<div class="flip_Num_box">
		<c:if test="${pageModel.count!=0}">
			<c:forEach begin="${page_start }" end="${page_end }" step="1" varStatus="item">
				<c:choose>
					<c:when test="${(page_cur==page_start+item.count-1)}">
					     <a href="javascript:void(0);"    class="Actived"  onclick="page(${page_start+item.count-1 });">${page_start+item.count-1 }</a>
					</c:when>
					<c:otherwise>
                        <a href="javascript:void(0);"  onclick="page(${page_start+item.count-1 });">${page_start+item.count-1 }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:if>
	</div>
	<c:if test="${page_cur != 1 }">
		<a href="javascript:void(0);" class="flip_upBtn" onclick="page(${page_cur - 1 });">上一页</a>
		<a href="javascript:void(0);" class="flip_upBtn" onclick="page(1);">首&nbsp;&nbsp;页</a>
	</c:if>
</div>
