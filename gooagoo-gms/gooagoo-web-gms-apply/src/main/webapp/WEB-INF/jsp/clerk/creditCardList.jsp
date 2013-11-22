<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<th width="20%">卡号</th>
		<th width="6%">是否成功</th>
		<th width="18%">刷卡时间</th>
	</tr>
	<c:forEach items="${pageModel.result}" var="invo">
		<tr>
			<td>${invo.objectCode}</td>
			<td>${invo.operateResult eq "Y"?"成功":"失败"}</td>
			<td><fmt:formatDate value="${invo.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
	</c:forEach>
	<c:if test="${fn:length(pageModel.result)<=0}">
		<tr>
			<td colspan="8">${shopVo.wordNames['gmsg272']}</td>
		</tr>
	</c:if>
	<c:if test="${fn:length(pageModel.result) >0}">
		<tr>
		  	<td colspan="8">
		      	<%@include file="/WEB-INF/jsp/common/page.jsp" %>
	 		</td>
		</tr>
	</c:if>
</table>
