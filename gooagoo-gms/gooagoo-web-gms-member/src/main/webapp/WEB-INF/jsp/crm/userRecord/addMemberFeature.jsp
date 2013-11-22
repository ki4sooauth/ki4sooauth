<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/memberFeature.js"></script>
<style type="text/css">
.feature{
	height:18px;
	cursor:pointer;
}
</style>
<div class="rightTitle_add">
	<span class="peopleSpan">${shopVo.wordNames['cpmf047']}</span>
</div>
<div class="conditions_content">
	<div class="title">${shopVo.wordNames['cpmf048']}</div>
	<div class=shopBuild_fillout>
		<form action="" method="post" id="add_memberFeature">
			<ul id="featureAdd">
				<li><span>${shopVo.wordNames['cpmf049']}</span><input class="borderStyle text" name="typeCode" type="text" /></li>
				<li><span>${shopVo.wordNames['cpmf050']}</span><input class="borderStyle text" name="typeName" type="text" /></li>
				<li><span>${shopVo.wordNames['cpmf051']}</span><input class="borderStyle text enu" name="enumValue" type="text" /><img src="${imgPath}/gms/member/images/createRule/in.png" class="feature" onclick="featureValue_add('add',0);" ></li>
			</ul>
			<a href="javascript:void(0)" id="add_memberFeature_button" onclick="addMemberFeature();" class="savebtnS blueBtn">${shopVo.wordNames['cpmf035']}</a>
		</form>
	</div>
</div>
