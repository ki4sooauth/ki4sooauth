<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<div class="rightTitle" style="margin-top: 24px">
 <span class="peopleSpan"><strong class="peopleCount">0</strong>${shopVo.wordNames['cpmb059']}</span>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable membeTable" id="membeTable">

					<tr>
						<th width="25%">${shopVo.wordNames['cpmf025']}</th>
						<th width="20%">${shopVo.wordNames['cpmf036']}</th>
						<th width="15%">${shopVo.wordNames['cpmb062']}</th>
						<th width="20%">${shopVo.wordNames['cpmf071']}</th>
						<th width="10%">${shopVo.wordNames['cpmf037']}</th>
					</tr>
					<c:forEach items="${pageModel.result}" var = "user">
					<tr>
						<td>${user.account}</td>
						<td>
						 <c:forEach items="${userTypes}" var ="type">
                          <c:if test="${user.accountType eq type.key}">${type.value}</c:if>						
						 </c:forEach>					
						</td>
						<td>${user.name}</td>
						<td>${user.telephone}</td>
						<td><check:hasAuthority authorityID="210401"><a
							href="javascript:toNextPage('${basePath}userRecord.do', '_blank',['method','accountId','accountType'],['userRecord','${user.account}','${user.accountType}']);"
							class="detailMark"></a></check:hasAuthority></td>
					</tr>
					</c:forEach>
					<c:if test="${empty pageModel.result}">
					  <tr>
						<td colspan="5">暂无记录</td>
					</tr>
					</c:if>
					<tr>
						<td colspan="5">
						 <%@include file="/WEB-INF/jsp/common/page.jsp"%>	
						</td>
					</tr>
				</table>
<script type="text/javascript">
<!--
$(".peopleCount").html(!isEmpty("${pageModel.count}")?"${pageModel.count}":0);
//-->
</script>				