<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:choose>
<c:when test="${isSuccess && data != null && fn:length(data) > 0 }">
<ul class="bestSell">
	<li class="titleName">${data[0].positionName }销售排行榜</li>
	<c:forEach items="${data }" var="positionMarketingRankResponse" varStatus="status">
	<c:choose>
	<c:when test="${status.count == 1 }">
	<li>
		<a href="${positionMarketingRankResponse.goodsVisitUrl }" target="_blank">
     	<span class="font color1">01</span>
     	<div class="txt">
      		<span class="titleName">${positionMarketingRankResponse.goodsName }</span><span class="moneyNum">${positionMarketingRankResponse.buyTime }次购买</span><br>
       		<span class="personNum">￥${positionMarketingRankResponse.goodsPrice }</span>
		</div>
		</a>
     </li>
	</c:when>
	<c:when test="${status.count == 2 }">
	<li>
		<a href="${positionMarketingRankResponse.goodsVisitUrl }" target="_blank">
     	<span class="font color2">02</span>
     	<div class="txt">
      		<span class="titleName">${positionMarketingRankResponse.goodsName }</span><span class="moneyNum">${positionMarketingRankResponse.buyTime }次购买</span><br>
       		<span class="personNum">￥${positionMarketingRankResponse.goodsPrice }</span>
		</div>
		</a>
     </li>
	</c:when>
	<c:when test="${status.count == 3 }">
	<li>
		<a href="${positionMarketingRankResponse.goodsVisitUrl }" target="_blank">
     	<span class="font color3">03</span>
     	<div class="txt">
      		<span class="titleName">${positionMarketingRankResponse.goodsName }</span><span class="moneyNum">${positionMarketingRankResponse.buyTime }次购买</span><br>
       		<span class="personNum">￥${positionMarketingRankResponse.goodsPrice }</span>
		</div>
		</a>
     </li>
	</c:when>
	<c:otherwise>
	<li>
		<a href="${positionMarketingRankResponse.goodsVisitUrl }" target="_blank">
		<c:choose>
		<c:when test="${status.count >= 10 }">
		<span class="font">${status.count }</span>
		</c:when>
		<c:otherwise>
		<span class="font">0${status.count }</span>
		</c:otherwise>
		</c:choose>
     	<div class="txt">
      		<span class="titleName">${positionMarketingRankResponse.goodsName }</span><span class="moneyNum">${positionMarketingRankResponse.buyTime }次购买</span><br>
       		<span class="personNum">￥${positionMarketingRankResponse.goodsPrice }</span>
		</div>
		</a>
     </li>
	</c:otherwise>
	</c:choose>
	</c:forEach>
</ul>
</c:when>
<c:otherwise>
<%@ include file="/WEB-INF/jsp/merchant/error/index.jsp" %>
</c:otherwise>
</c:choose>