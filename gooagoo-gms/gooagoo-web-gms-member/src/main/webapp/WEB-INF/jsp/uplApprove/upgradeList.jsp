<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script>
	var pIndex = "${page_cur}";

	//弹出层（列表）
	initFancybox()
	function initFancybox(){
		$(".fancybox").fancybox({
			'padding'			: 0,
			'autoScale'			: false,
			'autoDimensions'    : true,
			'transitionIn'		: 'yes',
			'transitionOut'		: 'yes',
			'href'				: $(this).attr('href'),
			'type'				:'inline',
			'hideOnOverlayClick': false,
			'showCloseButton'	: true,
			'changeSpeed'		:200
		});
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr class="table_1">
		<td>${shopVo.wordNames['cpme038']}</td><!-- 序号 -->
		<td>${shopVo.wordNames['cpme071']}</td><!-- 物理卡号 -->
		<td>${shopVo.wordNames['cpme072']}</td><!-- 姓名 -->
		<td style="display: none;">${shopVo.wordNames['cpme073']}</td><!-- 性别 -->
		<td style="display: none;">${shopVo.wordNames['cpme074']}</td><!-- 出生日期 -->
		<td style="display: none;">${shopVo.wordNames['cpme075']}</td><!-- 证件类型 -->
		<td style="display: none;">${shopVo.wordNames['cpme076']}</td><!-- 证件号码 -->
		<td>${shopVo.wordNames['cpme077']}</td><!-- 当前会员卡 -->
		<td>${shopVo.wordNames['cpme078']}</td><!-- 积分升级可获得的会员卡 -->
		<td>${shopVo.wordNames['cpme079']}</td><!-- 会员升级所需积分 -->
		<td>${shopVo.wordNames['cpme080']}</td><!-- 历史总积分 -->
		<td style="display: none;">${shopVo.wordNames['cpme081']}</td><!-- 手机号码 -->
		<td style="display: none;">${shopVo.wordNames['cpme082']}</td><!-- 联系电话 -->
		<td>${shopVo.wordNames['cpme083']}</td><!-- 电子邮箱-->
		<td>${shopVo.wordNames['cpme039']}</td><!-- 操作 -->
	</tr>
	<c:if test="${not empty pm.result}">
		<c:forEach var="temp" items="${pm.result}" varStatus="i">
			<tr height="28" class="table_2" id="${temp.userId}" bgcolor=${xh.count%2==0?"#CCCCFE":""}>
			    <td>${pm.pageSize*(pm.pageIndex-1)+i.index+1}</td>
				<td>${temp.phyNo}</td>
				<td>${temp.name}</td>
				<td style="display: none;">${temp.sex=="M"?shopVo.wordNames['gmsb090']:(temp.sex=="F"?shopVo.wordNames['gmsb091']:shopVo.wordNames['gmsb092'])}</td>
				<td style="display: none;"><fmt:formatDate value="${temp.birthday }" pattern="yyyy-MM-dd" /></td>
				<td style="display: none;">${temp.idType}</td>
				<td style="display: none;">${temp.idNo}</td>
				<td>${temp.cardName}</td>
				<td>${temp.upCardName}</td>
				<td>${temp.needIntegral}</td>
				<td>${temp.historyTotalIntegral }</td>
				<td style="display: none;">${temp.mobile}</td>
				<td style="display: none;">${temp.telephone}</td>
				<td>${temp.email}</td>
				<td> 
					<check:hasAuthority authorityID="240402">
						<a href="${basePath}memberOfCard.do?method=integralUpgradeForm&userId=${temp.userId}&cardId=${temp.cardId}&indexNum=${i.index+1}" class="handle book fancybox"></a>
					</check:hasAuthority>
			   	</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9">
	       		<%@ include file="/WEB-INF/jsp/common/page.jsp"%>     
	       	</td>
		</tr>
	</c:if>
	<c:if test="${empty pm.result}">
		<tr style="height: 30px;">
			<td colspan="9"><strong>${shopVo.wordNames['gmsb093']}</strong></td>
		</tr>
	</c:if>
</table>
