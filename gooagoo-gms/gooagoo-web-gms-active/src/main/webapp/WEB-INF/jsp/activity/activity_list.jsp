<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script>
	var pIndex = '${page_cur}';
	var curSize = '${fn:length(pm.result)}';
</script>
<!--内容-->
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<th width="5%">${shopVo.wordNames['gmsc026']}</th>
    	<th width="24%">${shopVo.wordNames['gmsc036']}</th>
       	<th width="20%">${shopVo.wordNames['gmsc037']}</th>
       	<th width="14%">${shopVo.wordNames['gmsc043']}</th>
       	<th width="11%">${shopVo.wordNames['gmsc038']}</th>
       	<th width="11%">${shopVo.wordNames['gmsc039']}</th>
       	<th width="15%">${shopVo.wordNames['gmsc018']}</th>
   	</tr>
	<c:if test="${not empty pm.result}">
		<c:forEach var="itemChild" items="${pm.result}" varStatus="xh">
			<fmt:formatDate value="${itemChild.endTime}" type="both" pattern="yyyy-MM-dd" var="eTime"/>
       		<tr>
			    <td>${pm.pageSize*(pm.pageIndex-1)+xh.index+1}</td>
            	<td>
            		<span>
	            		<c:if test="${empty itemChild.webVisitUrl}">${itemChild.activityName}</c:if>
	            		<c:if test="${not empty itemChild.webVisitUrl}">
	            			<a href="javascript:void(0);" onclick="window.open('${itemChild.webVisitUrl}');" title="预览">${itemChild.activityName}</a>
	            		</c:if>
            		</span>
            	</td>
				<td><span>${itemChild.title}</span></td>
				<td>
					<span>
						<c:forEach items="${publish_status}" var="type">
				       		<c:if test="${itemChild.publishStatus==type.key}">${type.value }</c:if>
				       	</c:forEach>
						<c:if test="${myToday gt eTime }"><font color="red">（已过期）</font></c:if>
					</span>
				</td>
				<td><span><fmt:formatDate value="${itemChild.startTime}" type="both" pattern="yyyy-MM-dd" /></span></td>
				<td><span><fmt:formatDate value="${itemChild.endTime}" type="both" pattern="yyyy-MM-dd" /></span></td>
                <td>
	                <check:hasAuthority authorityID='120201'>
		                <c:if test="${(itemChild.publishStatus=='W' || itemChild.publishStatus=='B') && myToday le eTime}">
		                	<a href="javascript:formActivity('${itemChild.activityId}');" class="handle pencil" title="${shopVo.wordNames['gmsc013']}"></a>
		                </c:if>
                	</check:hasAuthority>
                	<check:hasAuthority authorityID=''>
						<c:if test="${itemChild.publishStatus=='W' && myToday le eTime}">
	                		<a href="javascript:void(0);" onclick="checkActivity('${itemChild.activityId}');" class="handle book" title="${shopVo.wordNames['gmsc016']}"></a>
                		</c:if>
	                </check:hasAuthority>
                	<check:hasAuthority authorityID=''>
						<c:if test="${itemChild.publishStatus=='A' && myToday le eTime}">
	                		<a href="javascript:void(0);" onclick="publishActivity('${itemChild.activityId}');" class="handle issue" title="${shopVo.wordNames['gmsc017']}"></a>
                		</c:if>
	                </check:hasAuthority>
                	<check:hasAuthority authorityID=''>
						<c:if test="${itemChild.publishStatus=='P' && myToday le eTime}">
	                		<a href="javascript:void(0);" onclick="window.location.href='${basePath}activityCont.do?method=index&id=${itemChild.activityId}'" class="handle pencilMarketing" title="编辑营销信息"></a>
                		</c:if>
               		</check:hasAuthority>
                	<check:hasAuthority authorityID='120203'>
	                	<a href="javascript:detailActivity('${itemChild.activityId}');" class="detailMark" title="${shopVo.wordNames['gmsc015']}"></a>
	                </check:hasAuthority>
                	<check:hasAuthority authorityID='120202'>
						<a href="javascript:deleteActivity('${itemChild.activityId}');" class="handle del" title="${shopVo.wordNames['gmsc014']}"></a>
                	</check:hasAuthority>
                </td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				<%@ include file="/WEB-INF/jsp/common/page.jsp"%>     
			</td>
		</tr>
	</c:if>
   	<c:if test="${empty pm.result}">
		<tr style="height: 30px;">
			<td colspan="8"><strong>${shopVo.wordNames['gmsc008']}</strong></td>
		</tr>
	</c:if>
</table>
 
