<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<th width="20%">会员卡号</th>
		<th width="20%">实际支付价格</th>
		<th width="20%">商品总数</th>
		<th width="18%">结账时间</th>
		<th width="6%">详细</th>
	</tr>
	<c:forEach items="${pageModel.result}" var="bill">
		<tr>
			<td>${bill.scardNo}</td>
			<td>${bill.payPrice}</td>
			<td>${bill.goodsTotalNum}</td>
			<td><fmt:formatDate value="${bill.paymentTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>
				<a href="javascript:void(0)" class="detailMark" onclick="detail('${bill.orderId}')" title="${shopVo.wordNames['gmsg123']}"></a>
			</td>
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
