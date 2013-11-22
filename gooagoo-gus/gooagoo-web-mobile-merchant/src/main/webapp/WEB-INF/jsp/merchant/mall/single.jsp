<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${isSuccess && data != null && fn:length(data) > 0 }">
<c:forEach items="${data }" var="convertThing" varStatus="status">
<section>
	<input type="hidden" name="shopIntegralId" value="${convertThing.shopIntegralId }" />
	<c:choose>
	<c:when test="${convertThing.type == 'G' }">
	<a href="${basePath }/integralMall.do?method=convertPageRequest&shopIntegralId=${convertThing.shopIntegralId }" class="o_btn"><span class="oin_btn">兑换＞</span></a>
	</c:when>
	<c:otherwise>
	<a href="javascript: void(0);" class="o_btn o_btnc"><span class="oin_btn">兑换＞</span></a>
	</c:otherwise>
	</c:choose>
	<div class="IntegralImg">
		<table width="100%" height="100%" align="center" valign="middle"  cellpadding="0" cellspacing="0">
			<tr>
				<td align="center" valign="middle"><a href="${convertThing.typeVisitUrl }?shopIntegralId=${convertThing.shopIntegralId }"><img src="${convertThing.typeImage.middleImgUrl }"></a></td>
			</tr>
		</table>
	</div>
	<ul class="IntegralName">
		<li class="name">${convertThing.typeName }</li>
		<li class="details"></li>
		<li class="Integral">所需积分：${convertThing.convertIntegralValue }</li>
	</ul>
</section>
</c:forEach>
</c:if>
