<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script>
	var index = "${page_cur}";
	
	//弹出层（列表）
	initFancybox()
	function initFancybox(){
		$(".fancybox").fancybox({
			'padding'			: 0,
			'autoScale'			: false,
			'autoDimensions'    : true,
			'titleShow'			: false,
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
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable table_list">
	<tr>
	    <th width="5%">${shopVo.wordNames['cpme038']}</th> <!-- 序号 -->
	    <th width="10%">${shopVo.wordNames['cpme045']}</th><!-- 姓名 -->
	    <th style="display: none">${shopVo.wordNames['cpme046']}</th><!-- 性别 -->
	    <th style="display: none">${shopVo.wordNames['cpme047']}</th><!-- 出生日期 -->
	    <th style="display: none">${shopVo.wordNames['cpme048']}</th><!-- 证件类型 -->
	    <th style="display: none">${shopVo.wordNames['cpme049']}</th><!-- 证件号码 -->
	    <th width="15%">${shopVo.wordNames['cpme050']}</th><!-- 当前拥有会员卡 -->
	   　　 <th width="15%">${shopVo.wordNames['cpme051']}</th><!-- 审批后拥有会员卡 -->
	    <th style="display: none">${shopVo.wordNames['cpme052']}</th><!-- 手机号码 -->
	    <th style="display: none">${shopVo.wordNames['cpme053']}</th><!-- 联系电话 -->
	    <th width="20%">${shopVo.wordNames['cpme054']} </th><!-- 电子邮箱 -->
	    <th width="10%">${shopVo.wordNames['cpme057']}</th><!-- 申请时间 -->
	    <th width="10%">${shopVo.wordNames['cpme058']}</th><!-- 信息来源 -->
    	<th style="display: none">${shopVo.wordNames['cpme055']}</th><!-- 邮政编码 -->
	  	<th style="display: none">${shopVo.wordNames['cpme056']}</th><!-- 审批时间 -->
	  	<th width="10%">${shopVo.wordNames['cpmf043']}</th><!-- 操作 -->
	</tr>
	<c:if test="${not empty pm.result}">
		<c:forEach var="temp" items="${pm.result }" varStatus="i">
			<tr>
			    <td>${pm.pageSize*(pm.pageIndex-1)+i.index+1}</td>
				<td>${temp.name}</td>
				<td style="display: none;">${temp.sex=="M"?shopVo.wordNames['gmsb090']:(temp.sex=="F"?shopVo.wordNames['gmsb091']:shopVo.wordNames['gmsb092'])}</td>
				<td style="display: none;"><fmt:formatDate value="${temp.birthday }" pattern="yyyy-MM-dd" /></td>
				<td style="display: none;">${temp.idType}</td>
				<td style="display: none;">${temp.idNo}</td>
				<td>${temp.cardName}</td>
				<td>${temp.applyCardName}</td>
				<td style="display: none;">${temp.mobile}</td>
				<td style="display: none;">${temp.telephone}</td>
				<td>${temp.email }</td>
				<td><fmt:formatDate value="${temp.applyTime }" pattern="yyyy-MM-dd" /></td>
				<td><c:forEach items="${applicationStatus}" var = "type">
						<c:if test="${temp.status == type.key}">${type.value}</c:if>
	        		</c:forEach>
<%-- 				${temp.source=="W" ? shopVo.wordNames['cpmf130'] : (temp.source=="M" ? shopVo.wordNames['cpmf131'] : shopVo.wordNames['cpmf132']) } --%>
				</td>
				<td style="display: none;">${temp.postcode }</td>
				<td style="display: none;">${temp.address }</td>
				<td style="display: none;"><c:if test="${temp.status=='N' || temp.status=='P'}">
						<fmt:formatDate value="${temp.cTimeStamp}" pattern="yyyy-MM-dd" />
					</c:if>
				</td>
				<td style="display: none;">${temp.auditNote}</td>
				<td>
					<c:if test="${temp.status!='P' }">
						<check:hasAuthority authorityID="240202"><a href="${basePath}memberOfCard.do?method=approvalAppCardForm&id=${temp.applicationId}&indexNum=${i.index+1}" class="handle book fancybox"  title="${shopVo.wordNames['cpme039']}"></a></check:hasAuthority>
					</c:if>
				   <check:hasAuthority authorityID="240203">
				      <a class="detailMark fancybox" href="${basePath}memberOfCard.do?method=approvalAppCardDetail&id=${temp.applicationId}&indexNum=${i.index+1}" title="${shopVo.wordNames['cpmf037']}"></a>
                   </check:hasAuthority>				
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9">
			 	<%@include file="/WEB-INF/jsp/common/page.jsp"%>	
			</td>
		</tr>
	</c:if>
	<c:if test="${empty pm.result}">
		<tr style="height:  30px;">
			<td colspan="10"><strong>${shopVo.wordNames['gmsc008']}</strong></td>
		</tr>
	</c:if>
</table>
