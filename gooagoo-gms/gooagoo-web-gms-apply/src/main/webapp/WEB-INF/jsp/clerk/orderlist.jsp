<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<td colspan="8">
		    <ul class="desk-num-poup" style="width:700px;padding: 20px 0 1px 28px;">
				<li style="margin-right: 15px">
					<div ${not empty gmsLoginInfo.shopEntityId?'style="display: none"':'style="display: block"'}>
						<span>实体店</span>
						<select class="borderStyle select"  id="selectName" >
					   		<option value="">${shopVo.wordNames['gmsg134']}</option>
					   		<c:forEach items="${entityList}" var="entity">
					   			<option value="${entity.shopEntityId}">${entity.shopEntityName}</option>
					   		</c:forEach>
					 	</select>
					</div>
					<span style="margin-left: 10px">会员卡号</span>
					<input type="text" name="inputName" class="borderStyle text" value=""/>
					<a href="javascript:void(0);" onclick="page(1)" class="inputBtn blueBtn" style="width: 80px; height: 20px; line-height:20px; margin-left:20px;">${shopVo.wordNames['gmsg230']}</a>
				</li>
			</ul> 
		</td>
	</tr>
	<tr>
		<th width="20%">会员卡号</th>
	   	<th width="20%">实际支付价格</th>
	   	<th width="20%">商品总数</th>
	   	<th width="20%">订单状态</th>
		<th width="20%">结账时间</th>
		<th width="6%">详细</th>
	</tr>
	<c:forEach items="${pageModel.result}" var="bill">
		<tr>
			<td>${bill.scardNo}</td>
			<td>${bill.payPrice}</td>
			<td>${bill.goodsTotalNum}</td>
			<td>${bill.billTypeName}</td>
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
