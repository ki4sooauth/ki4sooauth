<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${isSuccess && data != null && fn:length(data) > 0 }">
<input type="hidden" name="returnType" value="C" />
<input type="hidden" name="integralTradeType" value="C" />
	<ul class="product_list_box">
		<c:forEach items="${data }" var="uShopIntegral">
			<li class="content productC">
				<a href="${uShopIntegral.typeVisitUrl }?shopIntegralId=${uShopIntegral.shopIntegralId }" target="_blank"><img src="${uShopIntegral.typeImageUrl.middleImgUrl }" width="180" height="180" /></a>
				<p class="msg">${uShopIntegral.typeName }</p>
				<p class="red">所需积分:<samp>${uShopIntegral.convertIntegralValue }</samp></p>
				<p class="user_point ">可用积分:<samp>${uShopIntegral.useableIntegralNumber }</samp></p>
				<p class="buyed ">
					<a href="javascript: void(0);" class="btnOrange" onclick="javascript: doConvert('${uShopIntegral.shopIntegralId }','${uShopIntegral.shopId}');">兑换</a><strong>已被兑换<samp>${uShopIntegral.convertCount}</samp>次</strong>
				</p>
				<p class="shops">
					来自<span>${uShopIntegral.shopName }</span>
				</p></li>
		</c:forEach>
	</ul>
</c:if>
<c:if test="${data == null || fn:length(data) <= 0 }">
	<div class="sorryPrompt" align="center">
		<samp>${message}</samp>
	</div>
</c:if>