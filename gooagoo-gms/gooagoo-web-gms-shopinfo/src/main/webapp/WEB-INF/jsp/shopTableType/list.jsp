<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<table width="100%" border="0" cellpadding="0" cellspacing="1"
	class="fileTable">
	<tr>
		<th width="20%">类型名称</th>
		<th width="20%">建议最小人数</th>
		<th width="20%">建议最大人数</th>
		<th width="20%">${shopVo.wordNames['gmsg334']}</th>
		<th width="20%">${shopVo.wordNames['gmsg061']}</th>
	</tr>
	
		<c:forEach items="${pageModel.result}" var="var">
			<tr>
				<td>${var.name}</td>
				<td>${var.minNums}</td>
				<td>${var.maxNums}</td>
				<td>${var.shopEntityName }</td>
				<td>&nbsp;<check:hasAuthority authorityID="1403060201">
						<a href="javascript:void(0)" class="handle pencil"
							onclick="edit('${var.id}');"
							title="${shopVo.wordNames['gmsg124']}"></a>
					</check:hasAuthority> <check:hasAuthority authorityID="1403060202">
						<a href="javascript:void(0)" class="handle del"
							onclick="delUser('${var.id}');"
							title="${shopVo.wordNames['gmsg125']}"></a>
					</check:hasAuthority></td>
			</tr>
		</c:forEach>
	
	<c:if test="${fn:length(pageModel.result)<=0}">
		<tr>
			<td colspan="5">${shopVo.wordNames['gmsg127']}</td>
		</tr>
	</c:if>

	<tr>
		<td colspan="5"><%@include file="/WEB-INF/jsp/common/page.jsp"%>
		</td>
	</tr>
</table>
