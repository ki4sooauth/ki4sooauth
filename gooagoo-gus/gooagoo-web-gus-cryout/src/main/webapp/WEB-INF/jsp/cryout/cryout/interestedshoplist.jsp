<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${isSuccess && data != null && fn:length(data) > 0 }">
<div class="may_like">
	<p class="title"><span class="arrow"></span><strong>可能感兴趣的商家</strong></p>
	<c:forEach items="${data }" var="interestedShop">
	<ul class="like_list">
		<li>
			<p>
				<strong>${interestedShop.shopName }</strong><br />
				<a class="brandFocus btnOrange" href="javascript: void(0);" onclick="javascript: attentionShopRequest(this, '${interestedShop.shopId }', '${interestedShop.shopName }');"><b>+</b>&nbsp;关注</a><br />
				<span>${interestedShop.attentionNum }</span>人关注
			</p>
			<c:choose>
			<c:when test="${interestedShop.attentionCardUrl.smallImgUrl == null || interestedShop.attentionCardUrl.smallImgUrl == '' }">
			<a href="${interestedShop.shopUrl }" target="_blank"><img src="${imgPath }/gus/common/images/userHeader.png" width="56" height="56" /></a>
			</c:when>
			<c:otherwise>
			<a href="${interestedShop.shopUrl }" target="_blank"><img src="${interestedShop.attentionCardUrl.smallImgUrl }" width="56" height="56" /></a>
			</c:otherwise>
			</c:choose>
		</li>
	</ul>
	</c:forEach>
</div>
</c:if>