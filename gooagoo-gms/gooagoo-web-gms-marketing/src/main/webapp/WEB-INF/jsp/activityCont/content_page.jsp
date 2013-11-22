<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<th width="5%">${shopVo.wordNames['gmsc026']}</th>     
      	<th width="20%">${shopVo.wordNames['gmsc216']}</th>
      	<th width="20%">${shopVo.wordNames['gmsd076']}</th>
      	<th width="20%">所属活动</th>
      	<th width="15%">${shopVo.wordNames['gmsc218']}</th>     	
      	<th width="20%">${shopVo.wordNames['gmsc018']}</th>
	</tr>
	<c:if test="${not empty pm.result}">
		<c:forEach var="itemChild" items="${pm.result}" varStatus="xh">
			<tr>
				<td>${xh.count+(page_cur-1)*pm.pageSize}</td>        				
				<td><span>
				         <c:if test="${not empty itemChild.contentUrl && itemChild.publishStatus=='P'}">
	                		<a href="javascript:preView('${itemChild.contentUrl}');" title="预览">${itemChild.title}</a>
                		</c:if>
                		<c:if test="${empty itemChild.contentUrl || itemChild.publishStatus!='P'}">
                			${itemChild.title}
                		</c:if>
				
				</span></td>
               	<td>
	                <span>
		                <c:if test="${itemChild.channelCode=='1'}">吆喝</c:if>
		                <c:if test="${itemChild.channelCode=='2'}">通知</c:if>
		                <c:if test="${itemChild.channelCode=='3'}">短信</c:if>
		                <c:if test="${itemChild.channelCode=='4'}">邮件</c:if>
		                <c:if test="${itemChild.channelCode=='5'}">购好奇</c:if>
		                <c:if test="${itemChild.channelCode=='6'}">手机服务</c:if>
<%-- 		                <c:if test="${itemChild.channelCode=='7'}">手机虚拟商家</c:if> --%>
<%-- 		                <c:if test="${itemChild.channelCode=='8'}">网站虚拟商家</c:if> --%>
		            
	                </span>
              	</td>
              	<td><span><a href="javascript:goToActivityDetail('${itemChild.activityId}');" title="点击进入活动管理">${itemChild.activityName}</a></span></td>
             	<td>
	               	<span>${itemChild.publishStatus=="W" ? "-待审核-" : (itemChild.publishStatus=="A" ? "-通过-" : (itemChild.publishStatus=="B" ? "-未通过-" :(itemChild.publishStatus=="P" ? "-已发布-" : "未知状态")))}</span>
	            </td>
               	<td>
                 	<check:hasAuthority authorityID="13050201">
		               	<c:if test="${itemChild.publishStatus=='W'||itemChild.publishStatus=='B'}">
		                	<a href="javascript:formActivityCont('${itemChild.id}','${itemChild.channelCode}');" class="handle pencil" title="${shopVo.wordNames['gmsc013']}"></a>
		                </c:if>
		           </check:hasAuthority>
		            <check:hasAuthority authorityID="13050203">
	                 	<c:if test="${itemChild.publishStatus=='W'}">
				       		<a href="javascript:${imgPath}/gms/marketing/images/auditing.png" onclick="formCheckActivityCont('${itemChild.id}','${itemChild.channelCode}');" class="handle book" title="${shopVo.wordNames['gmsc016']}"></a>
						</c:if>
				    </check:hasAuthority>
                     <a href="javascript:formDetailCont('${itemChild.id}','${itemChild.channelCode}');" title="${shopVo.wordNames['cpmb064']}" class="detailMark" ></a>
			         <c:if test="${itemChild.publishStatus=='P'}"><a href="javascript:searchDetail('${itemChild.ruleId}');" class="issueDetial" title="${shopVo.wordNames['gmsc219']}" style="padding-top: -5px;"></a></c:if>							
				  <check:hasAuthority authorityID="13050202">
               			<a href="javascript:deleteContent('${itemChild.id}','${itemChild.channelCode}');" class="handle del" title="${shopVo.wordNames['gmsc014']}"></a>
				 </check:hasAuthority>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
			 	<%@include file="/WEB-INF/jsp/common/page.jsp"%>	
			</td>
		</tr>
	</c:if>
	<c:if test="${empty pm.result}">
		<tr style="height: 30px;">
			<td colspan="8"><strong>${shopVo.wordNames['gmsc008']}</strong></td>
		</tr>
	</c:if>
</table>
