<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/userList.js"></script>
<div style="width: 800px;margin-left: 20px;">
<div id="relationTabs" class="file_nav">
		<a  class="curr">${shopVo.wordNames['cpmf091']}</a>
	</div>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable membeTable" id="membeTable">
    <tr>
		<td style="text-align: left; padding-left: 10px;" colspan="7">
			<span>mac地址：</span>
			<input id="mac_id" value="" name="mac" style="height:20px;width:315px;">
			<div style="float: right; padding-right: 50px;">
				<input type="button" value="查询" onclick="page(1);">				
				<input type="button" value="清空条件" onclick="$('#mac_id').val('');">
			</div>
		</td>
	</tr>
	<tr>
		<th width="10%">${shopVo.wordNames['cpmf025']}</th>
		<th width="10%">${shopVo.wordNames['cpmf026']}</th>
		<th width="10%">${shopVo.wordNames['cpmf027']}</th>
		<th width="15%">${shopVo.wordNames['cpmf028']}</th>
		<th width="15%">${shopVo.wordNames['cpmf029']}</th>
		<th width="20%">${shopVo.wordNames['cpmf030']}</th>
		<th width="20%">${shopVo.wordNames['cpmf031']}</th>
	</tr>
	<c:forEach items="${pageModel.result}" var="user">
		<tr>
			<td>${not empty user.email?user.email:user.mobile}</td>
			<td>${user.name}</td>
			<td>${user.sex}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday}" /></td>
			<td>${user.mac}</td>
			<td>${user.idNo}</td>
			<td>${user.mobile}</td>
		</tr>
	</c:forEach>
	<c:if test="${empty pageModel.result}">
		<tr>
			<td colspan="7">暂无记录</td>
		</tr>
	</c:if>
	<tr>
		<td colspan="7"><%@include file="/WEB-INF/jsp/common/page.jsp"%>
		</td>
	</tr>
</table>
</div>
<a class="blueBtn savebtn fancybox_save_user" style="cursor: pointer;" href="${basePath}statistical.do?method=toSaveCrowdIndex">保存用户细分</a>
<script type="text/javascript">
 var token = "${token}";
 $(document).ready(function(){
	initFancyBox("fancybox_save_user",300,175,false);
 })
</script>
