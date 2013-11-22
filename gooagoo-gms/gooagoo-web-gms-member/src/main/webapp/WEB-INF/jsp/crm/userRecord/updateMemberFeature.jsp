<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style type="text/css">
.feature{
	height:18px;
	cursor:pointer;
}
</style>
<div class="rightTitle_add">
	<span class="peopleSpan">${shopVo.wordNames['cpmf092']}</span>
</div>
<div class="conditions_content">
	<div class="title">${shopVo.wordNames['cpmf048']}</div>
	<div class=shopBuild_fillout>
		<form action="" method="post" id="update_memberFeature">
			<ul id="featureAdd">
					<li><span>${shopVo.wordNames['cpmf049']}</span><input class="borderStyle" name="typeCode" type="text" value="${memberFeature.typeCode}" disabled="disabled" /></li>
					<li><span>${shopVo.wordNames['cpmf050']}</span><input class="borderStyle text" name="typeName" type="text" value="${memberFeature.typeName}" /></li>
					<c:forEach items="${fn:split(memberFeature.enumValue,' ')}" var="enum" varStatus="enumCount">
						<li id="count_${enumCount.index + 1 }">
							<span>${shopVo.wordNames['cpmf051']}</span><input class="borderStyle text enu" name="enumValue" type="text" value="${enum}" />
							<c:if test="${enumCount.index eq 0 }">
								<img src="${imgPath}/gms/member/images/createRule/in.png" class="feature" onclick="featureValue_add('add',0);" >
							</c:if>
							<c:if test="${enumCount.index gt 0 }">
								<img src="${imgPath}/gms/member/images/createRule/in2-01.png" class="feature" onclick="featureValue_add('delete','${enumCount.index + 1 }');" >
							</c:if>
						</li>
					</c:forEach>
			</ul>
			<input type="hidden" name="id" value="${memberFeature.id}" />
			<input type="hidden" name="typeCode" value="${memberFeature.typeCode}" />
			<input type="hidden" name="featureFlag" value="${memberFeature.typeCode}" />
			<a href="javascript:void(0)" id="update_memberFeature_button" onclick="updateMemberFeature();" class="savebtnS blueBtn">${shopVo.wordNames['cpmf035']}</a>
		</form>
	</div>
</div>
