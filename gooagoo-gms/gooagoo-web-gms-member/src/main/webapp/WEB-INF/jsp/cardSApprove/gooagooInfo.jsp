<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript">
	initFancybox()
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable table_list_G">
	<tr>
		<th width="5%">${shopVo.wordNames['cpme038']}</th>
	 	<th width="8%">${shopVo.wordNames['cpme087']}</th>
	  	<th width="5%">${shopVo.wordNames['cpmb014']}</th>
	 	<th width="8%">${shopVo.wordNames['cpme089']}</th>
	 	<th width="15%">${shopVo.wordNames['cpme101']}</th>
	 	<th width="10%">${shopVo.wordNames['cpme102']}</th>
		<th width="10%">${shopVo.wordNames['cpme103']}</th>
	 	<th width="10%">${shopVo.wordNames['cpme094']}</th>
	 	<th width="15%">${shopVo.wordNames['cpme095']}</th>
	 	<th width="5%">${shopVo.wordNames['cpme040']}</th>
	</tr>
	<c:if test="${not empty temp}">
		<tr height="28" class="table_2" id="">
			<td>1</td>
			<td style="display: none">${temp.phyCardNo}</td>
			<td>${temp.realName}</td>
			<td>${temp.sex=="M" ? shopVo.wordNames['gmsb090'] : (temp.sex=="F" ? shopVo.wordNames['gmsb091'] : shopVo.wordNames['gmsb092'])}</td>
			<td><fmt:formatDate value="${temp.birthday }" pattern="yyyy-MM-dd" /></td>
			<td>${temp.idType=="00" ? shopVo.wordNames['gmsg135'] : (temp.idType=="01" ? shopVo.wordNames['gmsg136'] : (temp.idType=="02" ? shopVo.wordNames['gmsg137']: (temp.idType=="03" ? shopVo.wordNames['gmsg138'] : "未知")))}</td>
			<td>${temp.idNo}</td>
			<td>${temp.gradeName}</td>
			<td style="display: none">${temp.phone}</td>
			<td>${temp.telephone}</td>
			<td>${temp.email}</td>
			<td>
			  	<check:hasAuthority authorityID="240502"><a href="${basePath}memberOfCard.do?method=getCardList&userId=${temp.userId}&gradeId=${temp.gradeId}&indexNum=1&sType=G" class="handle book fancybox"></a></check:hasAuthority>
			</td>
		</tr>
	</c:if>
	<c:if test="${empty temp && isFirst}">
		<tr style="height:30px;">
			<td colspan="10"><strong>${shopVo.wordNames['gmsc008']}</strong></td>
		</tr>
	</c:if>
</table>

