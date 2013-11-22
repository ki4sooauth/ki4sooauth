<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${data != null && fn:length(data) > 0 }">
	<c:forEach items="${data}" var="FCoupon" >
		<li>
			<input type="hidden" name="couponId" id="couponId" value="${FCoupon.couponId}"/>
			<c:choose>
     			<c:when test="${!empty FCoupon.visitUrl}">
		            <a href="${FCoupon.visitUrl}" target="_blank">
						<img style="display: block;" src="${FCoupon.couponUrl.middleImgUrl}" width="168" height="168" />
					</a>
     			</c:when>
     			<c:otherwise>
		            <a href="javascript: void(0);">
						<img style="display: block;" src="${FCoupon.couponUrl.middleImgUrl}" width="168" height="168" />
					</a>
     			</c:otherwise>
     		</c:choose>
			<p class="fav_pre">${FCoupon.couponName}</p>
			<p class="shops">来自<span>${FCoupon.shopName}</span></p>
			<p class="addfav"><a id="btn_${FCoupon.couponId}" class="cou" href="javascript: void(0);" onclick="javascript:sub('${FCoupon.couponId}','${FCoupon.shopId}','${FCoupon.couponName}')"><b></b>加入收藏</a></p>
		</li>
	</c:forEach>
</c:if>
<c:if test="${data == null || fn:length(data) <= 0 }">
	<div>
		<div class="sorryPrompt" align="center">
		     <samp>${message}</samp>
		</div>
	</div>
</c:if>
