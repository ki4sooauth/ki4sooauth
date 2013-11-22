<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<div style="width: 800px;margin-left: 20px;">
<div id="relationTabs" class="file_nav">
		<a  class="curr">${shopVo.wordNames['gmsb182']}</a>
	</div>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable membeTable" id="membeTable">

	<tr>
		<th width="15%">${shopVo.wordNames['gmsb183']}</th>
		<th width="10%">${shopVo.wordNames['gmsb184']}</th>
		<th width="5%">${shopVo.wordNames['gmsb185']}</th>
		<th width="10%">${shopVo.wordNames['gmsb186']}</th>
		<th width="30%">${shopVo.wordNames['gmsb187']}</th>
		<th width="10%">${shopVo.wordNames['gmsb188']}</th>
		<th width="20%">${shopVo.wordNames['gmsb189']}</th>
	</tr>
	<c:forEach items="${pageModel.result}" var="user" varStatus="index">
		<tr>
			<td>${user.email}</td>
			<td>${user.name}</td>
			<td>${user.sex eq 'M'?shopVo.wordNames['gmsb190']:user.sex eq 'F'?shopVo.wordNames['gmsb191']:shopVo.wordNames['gmsb192']}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday}" /></td>
			<td>${user.idNo}</td>
			<td>${random[index.index]}</td>
			<td>${user.mobile}</td>
		</tr>
	</c:forEach>
	<c:if test="${empty pageModel.result}">
		<tr>
			<td colspan="7">${shopVo.wordNames['gmsb193']}</td>
		</tr>
	</c:if>
	<tr>
		<td colspan="7"><%@include file="/WEB-INF/jsp/common/page.jsp"%>
		</td>
	</tr>
</table>
</div>
<a class="blueBtn savebtn" style="cursor: pointer;" href="javascript:parent.$.fancybox.close();">${shopVo.wordNames['gmsb194']}</a>
