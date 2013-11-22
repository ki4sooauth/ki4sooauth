<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script>
	var pIndex = '${page_cur}';
	var curSize = '${fn:length(pm.result)}';
	
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
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable table_list" >
    <tr class="table_1">
		<th width="5%">${shopVo.wordNames['cpme038']}</th><!-- 序号 -->
		<th width="20%">${shopVo.wordNames['cpme098']}</th><!-- 物理卡号 -->
      	<th width="10%">${shopVo.wordNames['cpme099']}</th><!-- 姓名 -->
      	<th style="display: none;">${shopVo.wordNames['cpme100']}</th><!-- 性别 -->
       	<th style="display: none;">${shopVo.wordNames['cpme101']}</th><!-- 证件类型 -->
      	<th style="display: none;">${shopVo.wordNames['cpme102']}</th><!-- 证件号码 -->
      	<th width="20%">${shopVo.wordNames['cpme103']}</th><!-- 会员等级 -->
    	<th width="10%">${shopVo.wordNames['cpme104']}</th><!-- 可用积分 -->
    	<th width="10%">${shopVo.wordNames['cpme105']}</th><!-- 历史总积分 -->
      	<th style="display: none;">${shopVo.wordNames['cpme106']}</th><!-- 联系电话 -->
      	<th width="20%">${shopVo.wordNames['cpme107']}</th><!-- 电子邮箱 -->
    	<th width="5%">${shopVo.wordNames['cpme040']}</th><!-- 特批 -->
	</tr>
	<c:if test="${not empty pm.result}">
		<c:forEach var="temp" items="${pm.result }" varStatus="i">
			<tr height="28" class="table_2" id="" bgcolor=${xh.count%2==0?"#CCCCFE":""}>
			    <td>${pm.pageSize*(pm.pageIndex-1)+i.index+1}</td>
				<td>${temp.phyNo}</td>
				<td>${temp.name}</td>
				<td style="display: none;">${temp.sex=="M" ? shopVo.wordNames['gmsb090'] : (temp.sex=="F" ? shopVo.wordNames['gmsb091'] : shopVo.wordNames['gmsb092'])}</td>
<%-- 				<td style="display: none;"><fmt:formatDate value="${temp.birthday }" pattern="yyyy-MM-dd" /></td> --%>
				<td style="display: none;">${temp.idType=="00" ? shopVo.wordNames['gmsg135'] : (temp.idType=="01" ? shopVo.wordNames['gmsg136'] : (temp.idType=="02" ? shopVo.wordNames['gmsg137']: (temp.idType=="03" ? shopVo.wordNames['gmsg138'] : "未知")))}</td>
				<td style="display: none;">${temp.idNo}</td>
				<td>${temp.phyName}</td>
				<td>${temp.useableIntegralNumber}</td>
				<td>${temp.historyTotalIntegral}</td>
				<td  style="display: none;">${temp.mobile}</td>
				<td  style="display: none;">${temp.telephone}</td>
				<td>${temp.email}</td>
				<td>
					<check:hasAuthority authorityID="2406"><a href="${basePath}memberOfCard.do?method=iSApproveForm&integralId=${temp.integralId}&userId=${temp.userId}&indexNum=${i.index+1}" class="handle book fancybox"></a></check:hasAuthority>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="11">
	       		<%@ include file="/WEB-INF/jsp/common/page.jsp"%>     
	       	</td>
		</tr>
	</c:if>
	<c:if test="${empty pm.result}">
		<tr style="height:  30px;">
			<td colspan="12"><strong>${shopVo.wordNames['gmsb193']}</strong></td>
		</tr>
	</c:if>
</table>
