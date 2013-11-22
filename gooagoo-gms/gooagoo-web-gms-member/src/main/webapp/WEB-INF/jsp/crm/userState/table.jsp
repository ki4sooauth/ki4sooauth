<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<div id="relationTabs" class="file_nav">
<a  class="curr">列表信息</a>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="1"
					class="fileTable membeTable" id="membeTable">
					<tr>
						<td style="text-align: left; padding-left: 10px;" colspan="6">
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
						<th width="5%">${shopVo.wordNames['cpmf027']}</th>
						<th width="15%">${shopVo.wordNames['cpmf028']}</th>
						<th width="20%">${shopVo.wordNames['cpmf029']}</th>
						<th width="10%">${shopVo.wordNames['cpmf031']}</th>
<!-- 						<th width="15%">到店时间</th> -->
<!-- 						<th width="15%">离店时间</th> -->
					</tr>
					<c:forEach items="${pageModel.result}" var = "user">
					<tr>
						<td>${user.account}</td>
						<td>${user.name}</td>
						<td>${user.sex eq 'M'?'男':user.sex eq 'F'?'女':'其他'}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday}" /></td>
						<td>${user.mac}</td>
						<td>${user.phone}</td>
<%-- 						<td>${user.arrival}</td> --%>
<%-- 						<td>${user.leave}</td> --%>
						<%--<td><a
							href="${basePath}userRecord.do?method=userRecord&accountId=${user.userId}&accountType=${user.userType}"
							class="detailMark"></a></td> 
						--%>
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
<a class="blueBtn savebtn fancybox" style="cursor: pointer;" href="${basePath}userState.do?method=toSaveCrowdIndex">保存用户细分</a>
<script type="text/javascript">
 var token = "${token}";
 $(document).ready(function(){
	initFancyBox("fancybox",300,175,false);
 })
</script>