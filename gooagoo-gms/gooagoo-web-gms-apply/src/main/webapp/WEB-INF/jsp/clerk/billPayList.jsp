<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<th width="20%">订单编号</th>
		<th width="20%">结账时间</th>
		<th width="12%">商家是否处理</th>
		<th width="24%">商家处理时间</th>
		<th width="18%">创建时间</th>
	</tr>
	<c:forEach items="${pageModel.result}" var="invo">
		<tr>
			<td>${invo.orderId}</td>
			<td><fmt:formatDate value="${invo.applyTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${invo.isDeal eq "Y"?"是":"否"}</td>
			<td><fmt:formatDate value="${invo.dealTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
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
