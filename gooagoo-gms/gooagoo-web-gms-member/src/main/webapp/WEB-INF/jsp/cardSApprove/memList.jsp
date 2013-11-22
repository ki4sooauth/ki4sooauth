<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript">
	initFancybox();
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable table_list_S">
    <tr >
      	<th width="5%">${shopVo.wordNames['cpme038']}</th>
      	<th width="20%">${shopVo.wordNames['cpme086']}</th>
      	<th width="10%">${shopVo.wordNames['cpme087']}</th>
      	<th style="display: none;">${shopVo.wordNames['cpme088']}</th>
      	<th style="display: none;">${shopVo.wordNames['cpme089']}</th>
       	<th style="display: none;">${shopVo.wordNames['cpme090']}</th>
      	<th style="display: none;">${shopVo.wordNames['cpme091']}</th>
      	<th width="20%">${shopVo.wordNames['cpme092']}</th>
    	<th style="display: none;">${shopVo.wordNames['cpme093']}</th>
      	<th style="display: none;">${shopVo.wordNames['cpme094']}</th>
      	<th width="20%">${shopVo.wordNames['cpme095']}</th>
      	<th width="5%">${shopVo.wordNames['cpme040']}</th>
	</tr>
	<c:if test="${not empty pm.result}">
		<c:forEach var="temp" items="${pm.result }" varStatus="i">
			<tr height="28" class="table_2" id="${temp.id }" bgcolor=${xh.count%2==0?"#CCCCFE":""}>
			    <td>${pm.pageSize*(pm.pageIndex-1)+i.index+1}</td>
				<td>${temp.phyNo}</td>
				<td>${temp.name}</td>
				<td style="display: none;">${temp.sex=="M" ? shopVo.wordNames['gmsb090'] : (temp.sex=="F" ? shopVo.wordNames['gmsb091'] : shopVo.wordNames['gmsb092'])}</td>
				<td style="display: none;"><fmt:formatDate value="${temp.birthday }" pattern="yyyy-MM-dd" /></td>
				<td style="display: none;">${temp.idType=="00" ? shopVo.wordNames['gmsg135'] : (temp.idType=="01" ? shopVo.wordNames['gmsg136'] : (temp.idType=="02" ? shopVo.wordNames['gmsg137']: (temp.idType=="03" ? shopVo.wordNames['gmsg138'] : "未知")))}</td>
				<td style="display: none;">${temp.idNo}</td>
				<td>${temp.phyName}</td>
				<td style="display: none;">${temp.mobile}</td>
				<td style="display: none;">${temp.telephone}</td>
				<td>${temp.email}</td>
				<td>
					<check:hasAuthority authorityID="240502"><a href="${basePath}memberOfCard.do?method=getCardList&gradeId=${temp.gradeId}&userId=${temp.userId}&indexNum=${i.index+1}&sType=S" class="handle book fancybox"></a></check:hasAuthority>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
	       		<%@ include file="/WEB-INF/jsp/common/page.jsp"%>     
	       	</td>
		</tr>
	</c:if>
	<c:if test="${empty pm.result}">
		<tr style="height: 30px;">
			<td colspan="10"><strong>${shopVo.wordNames['gmsb193']}</strong></td>
		</tr>
	</c:if>
</table>
