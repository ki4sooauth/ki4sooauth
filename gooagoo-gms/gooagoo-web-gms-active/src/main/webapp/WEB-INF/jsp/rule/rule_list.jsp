<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script>
	var pIndex = '${page_cur}';
	var curSize = '${fn:length(pm.result)}';

	//删除活动规则
	function deleteRule(ruleId){
		if(confirm("确定删除规则信息？")){
			//如果当前页只剩一条记录，删除操作时当前页改为上一页页码
			pIndex=curSize==1 && pIndex!=1? --pIndex:pIndex;
			var url = "${basePath }rule.do?method=delete";
			var data = "&ruleId=" + ruleId;
			ajaxJsonTipByData(url, data, true);
			page(pIndex);
		}
	}
	//查看活动规则详细
	function ruleDetail(ruleId){
		if(isEmpty(ruleId)){
			ruleId = "";
		}
		var data = "&ruleId="+ruleId;
		var url = "${basePath }rule.do?method=detail&ruleId="+ruleId+"&detailType=ruleDetail";
		$("#fancyboxDetail").attr("href",url).click();
	}
	// 审核活动规则页面
	function formCheckRule(ruleId){
		if(isEmpty(ruleId)){
			ruleId = "";
		}
		var url = "${basePath}rule.do?method=checkForm&ruleId="+ruleId;
		$("#fancyboxCheck").attr("href",url).click();
	}
	//发布活动规则
	function publishRule(ruleId){
		if(confirm("确定发布规则信息？")){
			var url = "${basePath }rule.do?method=publish";
			var data = "&ruleId=" + ruleId;
			ajaxJsonTipByData(url, data, true);
			parent.$(".file_nav").find("a").eq(5).click();
		}
	}
</script>
<!--内容-->
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
	    <th width="5%">${shopVo.wordNames['gmsc026']}</th><!-- 序号 -->
	    <th width="25%">${shopVo.wordNames['gmsc052']}</th><!-- 规则名称 -->
	    <th width="15%">${shopVo.wordNames['gmsc053']}</th><!-- 规则类型 -->
	    <th width="15%">${shopVo.wordNames['gmsc054']}</th><!-- 规则状态 -->
		<th width="15%">${shopVo.wordNames['gmsc055']}</th><!-- 发布计划 -->
	    <th width="15%">${shopVo.wordNames['gmsc018']}</th><!-- 操作 -->
  	</tr>
  	<c:if test="${not empty pm.result}">
	  	<c:forEach var="ruleInfo" items="${pm.result}" varStatus="i">
 			<fmt:formatDate value="${ruleInfo.endTime}" type="both" pattern="yyyy-MM-dd" var="eTime"/>
			<tr >
			    <td>${pm.pageSize*(pm.pageIndex-1)+i.index+1}</td>
                <td>${ruleInfo.ruleName}</td>
                <td><span>${ruleInfo.ruleType=="5" ? "积分" : (ruleInfo.ruleType=="6" ? "优惠" : (ruleInfo.ruleType=="7" ? "会员卡" : ""))}</span>
			    <td>
			    	<span>
    					<c:forEach items="${publish_status}" var = "type">
	       					<c:if test="${ruleInfo.publishStatus==type.key}">${type.value }</c:if>
	       				</c:forEach>
						<c:if test="${myToday gt eTime }"><font color="red">（已过期）</font></c:if>
			    	</span>
			    </td>
  				<c:if test="${ruleInfo.isPublishImmediately=='N'}">
			    	<td><fmt:formatDate value="${ruleInfo.expectPublishTime}" pattern="yyyy-MM-dd hh:mm" /></td>
			    </c:if>
				<c:if test="${ruleInfo.isPublishImmediately=='Y'}">
			    	<td>实时发布</td>
			    </c:if>
			    <td>
				    <c:if test="${flag!='detail'}">
						<check:hasAuthority authorityID="120401">
						    <c:if test="${(ruleInfo.publishStatus=='W' || ruleInfo.publishStatus=='B') && myToday le eTime}">
							    <a href="javascript:void(0);" onclick="formRule('${ruleInfo.ruleId}');" class="handle pencil" title="${shopVo.wordNames['gmsc013']}"></a>
						    </c:if>
						</check:hasAuthority>
						<check:hasAuthority authorityID="120403">
						    <c:if test="${ruleInfo.publishStatus=='W' && myToday le eTime}">
						    	<a href="javascript:void(0);" onclick="formCheckRule('${ruleInfo.ruleId}');" class="handle book" title="${shopVo.wordNames['gmsc016']}"></a>
						    </c:if>
						</check:hasAuthority>
			         	
			         	<check:hasAuthority authorityID="120404">
					    	<c:if test="${ruleInfo.publishStatus=='A' && myToday le eTime}">
							   <a href="javascript:void(0);" onclick="publishRule('${ruleInfo.ruleId}');" class="handle issue" title="${shopVo.wordNames['gmsc017']}"></a>
						    </c:if>
					    </check:hasAuthority>
					    <check:hasAuthority authorityID="120405">
					    	<a href="javascript:ruleDetail('${ruleInfo.ruleId}');" class="detailMark" title="${shopVo.wordNames['gmsc015']}" style="padding-top: 5px;"></a>
					    </check:hasAuthority>
						<check:hasAuthority authorityID="120402">
					    	<a href="javascript:void(0);" onclick="deleteRule('${ruleInfo.ruleId}');" class="handle del" title="${shopVo.wordNames['gmsc014']}"></a>
						</check:hasAuthority>
				    </c:if>
				    <c:if test="${flag=='detail' }">
			         	<check:hasAuthority authorityID="120405">
					    	<a href="javascript:ruleDetail('${ruleInfo.ruleId}');" class="detailMark" title="${shopVo.wordNames['gmsc015']}" style="padding-top: 5px;"></a>
					    </check:hasAuthority>
				    </c:if>
			    </td>
			</tr>
		</c:forEach>
		<tr id="rulePage">
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
 