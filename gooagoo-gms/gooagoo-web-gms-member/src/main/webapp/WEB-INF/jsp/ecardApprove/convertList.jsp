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
			'titleShow'			: false,
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
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable table_list" >
    <tr class="table_1">
		<th width="5%">${shopVo.wordNames['cpme038']}</th><!-- 序号 -->
		<th width="20%">${shopVo.wordNames['cpme061']}</th><!-- 物理卡号 -->
		<th width="10%">${shopVo.wordNames['cpme062']}</th><!-- 姓名-->
		<th style="display: none;">${shopVo.wordNames['cpme063']}</th><!-- 身份证号码 -->
		<th style="display: none;">${shopVo.wordNames['cpme064']}</th><!-- 手机号码 -->
		<th width="15%">${shopVo.wordNames['cpme065']}</th><!-- 当前会员卡 -->
		<th width="15%">${shopVo.wordNames['cpme066']}</th><!-- 转换后会员卡 -->
		<th width="10%">${shopVo.wordNames['cpme067']}</th><!-- 信息来源 -->
<%-- 		<th width="10%">${shopVo.wordNames['cpme068']}</th> --%><!-- 状态-->
		<th width="10%">${shopVo.wordNames['cpme069']}</th><!-- 申请日期 -->
		<th width="10%">${shopVo.wordNames['cpmf043']}</th><!-- 操作 -->
	</tr>
	<c:if test="${not empty pm.result}">
		<c:forEach var="temp" items="${pm.result }" varStatus="i">
			<tr height="28" class="table_2" id="${temp.applicationId }" bgcolor=${xh.count%2==0?"#CCCCFE":""}>
			    <td>${pm.pageSize*(pm.pageIndex-1)+i.index+1}</td>
				<td>${temp.phyNo}</td>
				<td>${temp.realName}</td>
				<td style="display: none;">${temp.idNo}</td>
				<td style="display: none;">${temp.mobile}</td>
				<td>${temp.cardName}</td>
				<td>${temp.convertCardName}</td>
				<td>${temp.source}</td>
<%-- 				<td>${temp.status }</td> --%>
				<td><fmt:formatDate value="${temp.applyTime }" pattern="yyyy-MM-dd" /></td>
				<td style="display: none;"><c:if test="${temp.status=='N' || temp.status=='P'}">
						<fmt:formatDate value="${temp.cTimeStamp}" pattern="yyyy-MM-dd" />
					</c:if>
				</td>
				<td style="display: none;">${temp.auditNote}</td>
				<td>
					<c:if test="${temp.status!='P' }">
					 	<check:hasAuthority authorityID="240302">
					 		<a href="${basePath}memberOfCard.do?method=approvalPsyConvertForm&id=${temp.applicationId}&indexNum=${i.index+1}" class="handle book fancybox"  title="${shopVo.wordNames['cpme039']}"></a>
					 	</check:hasAuthority>
					</c:if>
				    <check:hasAuthority authorityID="240303">
				       <a class="detailMark fancybox" href="${basePath}memberOfCard.do?method=approvalPsyConvertDetail&id=${temp.applicationId}&indexNum=${i.index+1}" title="${shopVo.wordNames['cpmf037']}"></a>
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
		<tr style="height:  30px;">
			<td colspan="11"><strong>${shopVo.wordNames['gmsb093']}</strong></td>
		</tr>
	</c:if>
</table>
