<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<style>
	.selected{border: 1px solid #F1A73E;color: #F1A73E; display: inline-block; height: 24px;line-height: 24px; text-align: center;width: 56px;}
	.fileTable td{height: 35px;}
</style>
<script>
	var pIndex = '${page_cur}';
	var curSize = '${fn:length(pm.result)}';
	function page(index){
		if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		pIndex = index;
		$("#searchPage").attr("action","${basePath }rule.do?method=ruleList&pageIndex="+index).submit();
	}
	//清空查询条件
	function clearRulePage(){
		$("input[name='ruleName']").val('');
		page(1);
	}
	//查看活动规则详细
	function ruleDetail(ruleId){
		if(isEmpty(ruleId)){
			ruleId = "";
		}
		var data = "&ruleId="+ruleId;
		var url="${basePath }rule.do?method=detail&ruleId="+ruleId;
		$("#fancybox_ruleDetail").attr("href",url).click();
	}
</script>
<!--内容-->
<div style="background-color: #F8F7F7; padding: 5px 20px 10px 20px;">
	<div id="relationTabs" class="file_nav">
		<a id="tab_D" class="curr" href="javascript:void(0);">${shopVo.wordNames['gmsc050']}</a>
	</div>
	<form id="searchPage" action="" method="post">
		<table style="width: 100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
			<tr>
				<td colspan="5" style="text-align: left; padding: 10px;">
					<span>${shopVo.wordNames['gmsc052']}:</span>
					<input type="text" style="height:20px;width:315px; padding-left: 5px;" name="ruleName" value="${ruleName }">
					<div style="float: right; padding-right: 50px;">
						<input type="button" onclick="page(1)" value="${shopVo.wordNames['gmsc006']}"/>				
						<input type="button" onclick="clearRulePage();" value="${shopVo.wordNames['gmsc007']}"/>
					</div>
				</td>
		  	</tr>
			<tr>
			    <th width="5%">${shopVo.wordNames['gmsc026']}</th><!-- 序号 -->
			    <th width="40%">${shopVo.wordNames['gmsc052']}</th><!-- 规则名称 -->
			    <th width="15%">${shopVo.wordNames['gmsc054']}</th><!-- 规则状态 -->
				<th width="15%">${shopVo.wordNames['gmsc055']}</th><!-- 发布计划 -->
			    <th width="15%">${shopVo.wordNames['gmsc018']}</th><!-- 操作 -->
		  	</tr>
		  	<c:if test="${not empty pm.result}">
			  	<c:forEach var="ruleInfo" items="${pm.result}" varStatus="i">
					<tr >
					    <td>${pm.pageSize*(pm.pageIndex-1)+i.index+1}</td>
		                <td>${ruleInfo.ruleName}</td>
					    <td>
						    <span>
			       				<c:forEach items="${publish_status}" var = "type">
					        		<c:if test="${ruleInfo.publishStatus==type.key}">${type.value}</c:if>
					            </c:forEach>
				            </span>
			            </td>
		  				<c:if test="${ruleInfo.isPublishImmediately=='N'}">
					    	<td><fmt:formatDate value="${ruleInfo.expectPublishTime}" pattern="yyyy-MM-dd" /></td>
					    </c:if>
						<c:if test="${ruleInfo.isPublishImmediately=='Y'}">
					    	<td>${shopVo.wordNames['gmsc056']}</td><!-- 实时发布 -->
					    </c:if>
					    <td>
							<a href="javascript:void(0);" onclick="parent.dealInfo('${ruleInfo.ruleId}');" class="selected">${shopVo.wordNames['gmsc208']}</a>
					    </td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="9">
					 	<%@include file="/WEB-INF/jsp/common/page.jsp"%>	
					</td>
				</tr>
			</c:if>
			<c:if test="${empty pm.result}">
				<tr style="height: 30px;">
					<td colspan="9"><strong>${shopVo.wordNames['gmsc008']}</strong></td>
				</tr>
			</c:if>
		</table>
	</form>
</div>
 
 