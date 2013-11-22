<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${isSuccess && data != null && fn:length(data) > 0 }">
<script type="text/javascript" src="${imgPath}/gus/mall/js/exchange-record.js"></script>
<c:choose>
	<c:when test="${type == 'C'}">
		<c:forEach var="record" items="${data }">
			<li>
				<div class="figure">
					<a href="${record.typeVisitUrl}" target="_blank"><img src="${record.typeImage.middleImgUrl }" width="105" height="105" /></a>
				</div>
				<table width="884" border="0" cellspacing="1" cellpadding="0" class="recordProductTable">
					<tr>
						<th width="30%">名称</th>
						<th width="30%">来自商家</th>
						<th width="20%">使用积分</th>
						<th width="20%">兑换时间</th>
					</tr>
					<tr class="ProofTd">
						<td>${record.typeName }</td>
						<td>${record.shopName }</td>
						<td>${record.integralValue }</td>
						<td>${record.exchangeTime }</tr>
				</table>
				<div style="clear: both"></div>
			</li>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<c:forEach var="record" items="${data }">
			<li>
				<div class="figure">
					<a href="${record.typeVisitUrl}" target="_blank"><img src="${record.typeImage.middleImgUrl }" width="105" height="105" /></a>
					<div class="name <c:if test='${record.deliveryStatus != 3 }'>selected</c:if>">${record.typeName }</div>
				</div>
				<table width="884" border="0" cellspacing="1" cellpadding="0" class="recordProductTable">
					<tr>
						<th width="30%">来自商家</th>
						<th width="20%">使用积分</th>
						<th width="20%">兑换时间</th>
						<th width="10%">状态</th>
						<th width="20%">收货地址</th>
					</tr>
					<tr>
						<td>${record.shopName }</td>
						<td>${record.integralValue }</td>
						<td>${record.exchangeTime }</td>
						<td>
							<c:choose>
							<c:when test="${record.deliveryStatus == 0}">未收到货物</c:when>
							<c:when test="${record.deliveryStatus == 1}">商家已拣货</c:when>
							<c:when test="${record.deliveryStatus == 2}">商家已发货</c:when>
							<c:otherwise>已收取货物</c:otherwise>
							</c:choose>
						</td>
						<td><a href="javascript:void(0)" class="AddressClick">查看地址</a></td>
					</tr>
					<tr class="addressNone">
						<td colspan="5" class="AddressMsg">收货人：${record.consigneeName }　　　邮　编：${record.consigneeZipCode }　　　手　机：${record.consigneePhone }<br />地　址：${record.consigneeAddress }</td>
					</tr>
				</table>
				<div style="clear: both"></div>
			</li>
		</c:forEach>
	</c:otherwise>
</c:choose>
</c:if>
<c:if test="${data == null || fn:length(data) <= 0 }">
		<div class="sorryPrompt" align="center">
		     <samp>${message }</samp>
		</div>
</c:if>