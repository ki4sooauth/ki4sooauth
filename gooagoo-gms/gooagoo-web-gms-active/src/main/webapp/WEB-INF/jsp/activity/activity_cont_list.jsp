<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript">
	// 删除活动内容
	function deleteContent(contId, type){
		if(confirm("确定删除活动内容信息吗？")){
			var url = "";
			if(isEmpty(contId)){
				contId = "";
			}
			if(isEmpty(type)){
				type = "1";
			}
			var data = "&id="+contId;
			var url = "${basePath }activityCont.do?method=delete&channelCode="+type;
			
			pIndex=curSize==1 && pIndex!=1? --pIndex:pIndex;
			ajaxJsonTipByData(url,data,true);	
			page(pIndex);
		}
	}
	// 审核活动内容
	function formCheckCont(contId, type){
		if(isEmpty(contId)){
			contId = "";
		}
		if(isEmpty(type)){
			type = "1";
		}
		var url = "${basePath }activityCont.do?method=formCheck&id="+contId+"&channelCode="+type;
	
		$("#fancyboxCheck").attr("href",url).click();
	}
	// 发布活动内容
	function formReleaseCont(contId, channelCode, title){
		if(isEmpty(contId)){
			contId="";	
		}
		if(isEmpty(channelCode)){
			channelCode="";	
		}
		var activityId = $("input[name='activityId']").val();
		var activeStartTime = $("#nextPage input[name='activeStartTime']").val();
		var activeEndTime = $("#nextPage input[name='activeEndTime']").val();
		var data = "&contentId="+contId+"&activityId="+activityId+"&channelCode="+channelCode+"&activeStartTime="+activeStartTime+"&activeEndTime="+activeEndTime;
		var url = "${basePath}activityCont.do?method=pulishCondition";
		$("#nextPage input[name='title']").val(title);	
		$("#fancyboxForm").attr("href",url+data).click();
	}
	//查看详细
	function formDetailCont(id,channelCode){
		if(isEmpty(id)){
			id = "";
		}
		if(isEmpty(channelCode)){
			channelCode = "";
		}
		var url = "${basePath }activityCont.do?method=detail&contId="+id+"&channelCode="+channelCode;
		$("#fancyboxDetail").attr("href",url).click();
	}
	// 查看发布详情
	function releaseDetail(ruleId,title){
		if(isEmpty(ruleId)){
			ruleId = "";
			alert("数据查询失败！");
			return;
		}
		var url = "${basePath }rule.do?method=detail&ruleId="+ruleId+"&detailType=release";
		$("#nextPage input[name='title']").val(title);	
		$("#fancyboxDetail").attr("href",url).click();
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable" id="activeContTable">
	<tr>   
       	<th width="5%">${shopVo.wordNames['gmsc026']}</th>
       	<th width="40%">${shopVo.wordNames['gmsc216']}</th>
       	<th width="15%">${shopVo.wordNames['gmsc217']}</th>
       	<th width="15%">${shopVo.wordNames['gmsc218']}</th>
       	<th width="15%">${shopVo.wordNames['gmsc018']}</th>
	</tr>
	<c:if test="${not empty pm.result}">
		<c:forEach var="itemChild" items="${pm.result}" varStatus="i">
			<tr>
			    <td>${pm.pageSize*(pm.pageIndex-1)+i.index+1}</td>
                <td>
                	<span>
                		<c:if test="${not empty itemChild.contentUrl && itemChild.publishStatus=='P'}">
	                		<a href="javascript:void(0);" onclick="window.open('${itemChild.contentUrl}');" title="预览">${itemChild.title}</a>
                		</c:if>
                		<c:if test="${empty itemChild.contentUrl || itemChild.publishStatus!='P'}">
                			${itemChild.title}
                		</c:if>
                	</span>
                </td>
                <td>
	                <span>
                		<c:forEach var="channel" items="${channels}" varStatus="i">
		       				<c:if test="${itemChild.channelCode == channel.code}">${channel.name }</c:if>
		       			</c:forEach>
	                </span>
               	</td>
                <td>
                	<span>
	                	<c:forEach items="${publish_status}" var = "type">
		       				<c:if test="${itemChild.publishStatus==type.key}">${type.value }</c:if>
		       			</c:forEach>
                	</span>
	            </td>
                <td>
				    <c:if test="${flag!='detail'}">
		                <check:hasAuthority authorityID="120601">
		                	<c:if test="${itemChild.publishStatus=='W'||itemChild.publishStatus=='B'}">
			                	<a href="javascript:formCont('${itemChild.id}','${itemChild.channelCode}');" class="handle pencil" title="${shopVo.wordNames['gmsc013']}"></a>
			                </c:if>
		                </check:hasAuthority>
		                <check:hasAuthority authorityID="120603">
		                  	<c:if test="${itemChild.publishStatus=='W'}">
						       <a href="javascript:${imgPath}/gms/marketing/images/auditing.png" onclick="formCheckCont('${itemChild.id}','${itemChild.channelCode}');" class="handle book" title="${shopVo.wordNames['gmsc016']}"></a>
							</c:if>
						</check:hasAuthority>
		                <check:hasAuthority authorityID="1207">
		                  	<c:if test="${itemChild.publishStatus=='A'}">
		                    	<a href="javascript:formReleaseCont('${itemChild.id}','${itemChild.channelCode}','${itemChild.title}');" class="handle issue" title="${shopVo.wordNames['gmsc017']}" ></a>
		                   	</c:if>
						</check:hasAuthority>
		               	<a title="${shopVo.wordNames['gmsc015']}" class="detailMark" href="javascript:formDetailCont('${itemChild.id}','${itemChild.channelCode}');"></a>
						<c:if test="${itemChild.publishStatus=='P'}"><a href="javascript:releaseDetail('${itemChild.ruleId}','${itemChild.title}');" class="issueDetial" title="${shopVo.wordNames['gmsc219']}"></a></c:if>
		                <check:hasAuthority authorityID="120602">
		                	<a href="javascript:deleteContent('${itemChild.id}','${itemChild.channelCode}');" class="handle del" title="${shopVo.wordNames['gmsc014']}"></a>
		                </check:hasAuthority>
					</c:if>
					<c:if test="${flag=='detail'}">
						<c:if test="${itemChild.publishStatus=='P'}"><a href="javascript:releaseDetail('${itemChild.ruleId}');" class="issueDetial" title="${shopVo.wordNames['gmsc219']}"></a></c:if>
	               	</c:if>
               	</td>
			</tr>
		</c:forEach>
		<tr id="contentPage">
			<td colspan="8">
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