<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<div class="rightTitle" style="margin-top: 24px">
<span class="peopleSpan"><strong class="peopleCount">0</strong>新增会员</span>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="1"
					class="fileTable membeTable" id="membeTable">

					<tr>
						<th width="20%">${shopVo.wordNames['cpmf025']}</th>
						<th width="10%">${shopVo.wordNames['cpmf026']}</th>
						<th width="10%">${shopVo.wordNames['cpmf027']}</th>
						<th width="20%">${shopVo.wordNames['cpmf060']}</th>
						<th width="20%">${shopVo.wordNames['cpmf061']}</th>
						<th width="20%">${shopVo.wordNames['cpmf120']}</th>
					</tr>
					<c:forEach items="${pageModel.result}" var = "user">
					<tr>
						<td>${user.account}</td>
						<td>${user.name}</td>
						<td>${user.sex eq 'M'?shopVo.wordNames['gmsb090']:user.sex eq 'F'?shopVo.wordNames['gmsb091']:shopVo.wordNames['gmsb092']}</td>
						<td>${user.phyNo}</td>
						<td>${user.scardNo}</td>
						<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
					</c:forEach>
					<c:if test="${empty pageModel.result}">
					  <tr>
						<td colspan="6">暂无记录</td>
					</tr>
					</c:if>
					<tr>
						<td colspan="6">
						 <%@include file="/WEB-INF/jsp/common/page.jsp"%>	
						</td>
					</tr>
				</table>
<c:if test="${not empty pageModel.count && pageModel.count ne 0}">			
<a class="blueBtn savebtn fancybox_save" style="cursor: pointer;" href="${basePath}userState.do?method=toSaveCrowdIndex">保存用户细分</a>	
</c:if>				
<script type="text/javascript">
<!--
$(".peopleCount").html(!isEmpty("${pageModel.count}")?"${pageModel.count}":0);
initFancyBox("fancybox_save",300,175,false);
//-->
</script>	