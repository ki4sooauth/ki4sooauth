<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript">
/**
 * 添加/修改-会员特性页面-增加特征值列
 * flag 增加/修改标识
 * countLi 当前要删除的标识
 */
var count = 100;
function featureValue_add(flag,countLi){
	if(flag == "add"){
		count ++;
		var stradd = "<li id=count_" + count + "><span>枚举值</span><input class=\"borderStyle text enu\" name=\"enumValue\" type=\"text\" /><img src=\"${imgPath}/gms/member/images/createRule/in2-01.png\" class=\"feature\" onclick=\"featureValue_add('delete'," + count + ");\" ></li>";
		$("#featureAdd").append(stradd);
	}else if(flag == "delete"){
		$("#featureAdd li").remove("#count_" + countLi);
	}
}
</script>
<div class="rightTitle_add">
	<check:hasAuthority authorityID="210501"><a href="javascript:void(0)" onclick="memberFeature_add('toAddForm','');">${shopVo.wordNames['gmsc001']}</a></check:hasAuthority><span class="peopleSpan">会员特征列表</span>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="1"
	class="fileTable membeTable" id="membeTable">
	<tr>
		<th width="5%">${shopVo.wordNames['cpmf039']}</th>
		<th width="20%">${shopVo.wordNames['cpmf040']}</th>
		<th width="20%">${shopVo.wordNames['cpmf041']}</th>
		<th width="35%">${shopVo.wordNames['cpmf042']}</th>
		<th width="20%">${shopVo.wordNames['cpmf043']}</th>
	</tr>
	<c:forEach items="${result}" var="feature" varStatus="count">
		<tr>
			<td>${count.index + 1}</td>
			<td>${feature.typeCode}</td>
			<td>${feature.typeName}</td>
			<td><span class="lengthHide" title="${feature.enumValue}">${feature.enumValue}</span></td>
			<td><check:hasAuthority authorityID="21050201"><a href="javascript:void(0)" onclick="memberFeature_add('toUpdateForm','${feature.id}');"class="handle pencil"  title="${shopVo.wordNames['cpmf044']}"></a></check:hasAuthority>
			<check:hasAuthority authorityID="21050202"><a href="javascript:void(0)" onclick="deleteMemberFeature('${feature.id}');" class="handle del" title="${shopVo.wordNames['cpmf045']}"></a></check:hasAuthority></td>
		</tr>
	</c:forEach>
	<c:if test="${empty result}">
		<tr>
			<td colspan="5">暂无记录</td>
		</tr>
	</c:if>
</table>