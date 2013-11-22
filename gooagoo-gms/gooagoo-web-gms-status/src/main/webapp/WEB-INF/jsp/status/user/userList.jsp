<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<div id="relationTabs" class="file_nav">
<a  class="curr">${shopVo.wordNames['gmsb174']}</a>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable membeTable" id="membeTable">
	<tr>
		<th width="20%">${shopVo.wordNames['gmsb084']}</th>
		<th width="10%">${shopVo.wordNames['cpmf036']}</th>
		<th width="15%">${shopVo.wordNames['gmsb085']}</th>
		<th width="5%">${shopVo.wordNames['gmsb086']}</th>
		<th width="20%">${shopVo.wordNames['gmsb175']}</th>
		<th width="15%">${shopVo.wordNames['gmsb176']}</th>
		<th width="15%">${shopVo.wordNames['gmsb177']}</th>
	</tr>
	<c:forEach items="${pageModel.result}" var = "user">
		<tr>
			<td>${user.account}</td>
			<td>${user.accountType}</td>
			<td>${user.name}</td>
			<td>${user.sex eq 'M'?shopVo.wordNames['gmsb090']:user.sex eq 'F'?shopVo.wordNames['gmsb091']:shopVo.wordNames['gmsb178']}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday}" /></td>
			<td>${user.mac}</td>
			<td>${user.phone}</td>
			<%--<td><a
				href="${basePath}/userRecord.do?method=userRecord&accountId=${user.userId}&accountType=${user.userType}"
				class="detailMark"></a></td> 
			--%>
		</tr>
	</c:forEach>
	<c:if test="${empty pageModel.result}">
	  	<tr>
			<td colspan="7">${shopVo.wordNames['gmsb093']}</td>
		</tr>
	</c:if>
	<tr>
		<td colspan="7">
		 	<%@include file="/WEB-INF/jsp/common/page.jsp"%>	
		</td>
	</tr>
</table>
<a class="blueBtn savebtn fancybox" style="cursor: pointer;" href="${basePath}userList.do?method=toSavePeople" >${shopVo.wordNames['gmsb094']}</a>
<script type="text/javascript">
 	var token = "${token}";
 	$(document).ready(function(){
		initFancyBox("fancybox",300,175,false);
 	})
</script>