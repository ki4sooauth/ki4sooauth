<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!--内容-->

	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
		<tr>
			<th width="5%">${shopVo.wordNames['gmsc026']}</th>
	    	<th width="26%">${shopVo.wordNames['gmsc221']}</th>
	       	<th width="20%">${shopVo.wordNames['gmsc222']}</th>
	       	<th width="15%">${shopVo.wordNames['gmsc218']}</th>
	       	<th width="15%">${shopVo.wordNames['gmsc018']}</th>
	   	</tr>
		<c:if test="${not empty pm.result}">
			<c:forEach var="itemChild" items="${pm.result}" varStatus="xh">
	       		<tr>
			    <td>${pm.pageSize*(pm.pageIndex-1)+xh.index+1}</td>
	            	<td><span>${itemChild.cryoutTitle}</span></td>
					<td><span>${itemChild.cryoutType=="L" ? "现场" : (itemChild.cryoutType=="R" ? "远程" : "未知类型")}</span></td>
					<td>
	               	<span>${itemChild.publishStatus=="W" ? "-待审核-" : (itemChild.publishStatus=="A" ? "-通过-" : (itemChild.publishStatus=="B" ? "-未通过-" :(itemChild.publishStatus=="P" ? "-已发布-" : "未知状态")))}</span>
	            </td>
					<td>
					 <check:hasAuthority authorityID='13060201'>
	                  <c:if test="${itemChild.publishStatus=='W'||itemChild.publishStatus=='B'}">
		                	<a href="javascript:formCryout('${itemChild.cryoutInfoId}');" class="handle pencil" title="${shopVo.wordNames['gmsc013']}"></a>
		                </c:if>
	                  </check:hasAuthority>
	                  <check:hasAuthority authorityID='13060203'>
	                  <c:if test="${itemChild.publishStatus=='A'}">
	                    <a href="javascript:formReleaseCont('${itemChild.cryoutInfoId}','${itemChild.cryoutTitle}','${itemChild.activityName}','<fmt:formatDate value="${itemChild.activeStartTime}" type="both" pattern="yyyy-MM-dd" />','<fmt:formatDate value="${itemChild.activeEndTime}" type="both" pattern="yyyy-MM-dd" />');" class="handle issue" title="${shopVo.wordNames['gmsc017']}" ></a>
	                   </c:if>	
	                   </check:hasAuthority>
	                <a href="javascript:void(0)" onclick="cryoutDetail('${itemChild.cryoutInfoId}');" title="${shopVo.wordNames['gmsc015']}" class="detailMark" ></a>        
	                 <c:if test="${itemChild.publishStatus=='P'}"><a href="javascript:searchDetail('${itemChild.ruleId}','${itemChild.activityName}');" class="issueDetial" title="${shopVo.wordNames['gmsc219']}"></a></c:if> 
	                    <check:hasAuthority authorityID='13060205'>					
					 <a href="javascript:deleteCryout('${itemChild.cryoutInfoId}');" title="${empty shopVo.wordNames['gmsd046'] ? '删除' : shopVo.wordNames['gmsd046']}" class="handle del"></a>
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
