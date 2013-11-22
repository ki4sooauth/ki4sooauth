<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<td colspan="8">
			<ul class="desk-num-poup" style="width:700px;padding: 20px 0 1px 28px;">
				<li style="margin-right: 15px">
					<span >发票类型</span>
					<select class="borderStyle select"  id="selectName" style="margin-right: 20px;">
					   	<option value="">${shopVo.wordNames['gmsg134']}</option>
					   	<option value="1">公司</option>
					   	<option value="0">个人</option>
	 				</select>
					<span style="margin-left: 10px">发票抬头</span>
					<input type="text" name="inputName" class="borderStyle text" value=""/>
					<a href="javascript:void(0);" onclick="page(1)" class="inputBtn blueBtn" style="width: 80px; height: 20px; line-height:20px; margin-left:20px;">${shopVo.wordNames['gmsg230']}</a>
				</li>
			</ul> 
		</td>
       	</tr>
		<tr>
	        <th width="20%">发票抬头</th>
	        <th width="20%">发票类型</th>
	        <th width="20%">开发票项目</th>
	        <th width="20%">发票金额</th>
       		<th width="20%">开发票时间</th>
    	</tr>
        <c:forEach items="${pageModel.result}" var="invo">
        	<tr>
				<td>${invo.invoicedTile}</td>
				<td>${invo.invoicedType eq "0"?"个人":"公司"}</td>
				<td>${invo.invoicedItem}</td>
				<td>${invo.invoicedPrice}</td>
				<td><fmt:formatDate value="${invo.invoicedTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
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
