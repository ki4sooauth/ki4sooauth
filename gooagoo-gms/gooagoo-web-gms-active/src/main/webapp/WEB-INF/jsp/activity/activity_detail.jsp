<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>活动详细</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<style type="text/css">
	.myStyle{background-color: #FFFFFF;}
	.activityContentTable td .area1{width: 480px; height: 34px;resize: none; overflow-y:auto;border:0px; background-color: white; color:#666666;}
	.activityContentTable td .area2{width: 480px; height: 65px;resize: none; overflow-y:auto;border:0px; background-color: white; color:#666666;}
</style>
<script type="text/javascript">
	var pIndex = '${page_cur}';
	var curSize = '${fn:length(pm.result)}';
	$(function(){
		clearHiddImg();
		//初始化弹出层
		initFancyBox("fancybox_detail", 920, 600, true);
		
		page(1);
	});
	// 清空隐藏input活动图片值 给出初始图片
	function clearHiddImg(){
	 	var imgUrl= $("#activityImg").attr("src");
	 	if(imgUrl=="" || imgUrl==null){
	 		$("#imgUrl").val("");
	 		$("#activityImg").attr("src","${imgPath}/gms/common/images/default1.jpg");
	 	}
	 }
	//分页
	function page(index,　obj){
		var flagId = $(obj).closest("tr").attr("id");
		var activityId=$("#activityId").val();
		
	 	if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		pIndex = index;
		var data = "&pageIndex="+index+"&pageSize=3&flag=detail"+"&activityId="+activityId;
		
		if(flagId == "rulePage"){
			ajaxToPageByData("${basePath }rule.do?method=list","fileCont2",data);
		}else if(flagId == "contentPage"){
			ajaxToPageByData("${basePath }activityCont.do?method=list","fileCont1",data);		
		}else{
			ajaxToPageByData("${basePath }activityCont.do?method=list","fileCont1",data);		
			ajaxToPageByData("${basePath }rule.do?method=list","fileCont2",data);
		}
	}
	// 查看活动内容发布详情
	function searchDetail(ruleId){
		if(isEmpty(ruleId)){
			ruleId = "";
			alert("数据查询失败！");
			return;
		}
		var data = "&ruleId="+ruleId;
		var url="${basePath }rule.do?method=detail&ruleId="+ruleId;
		$("#detail").attr("href",url).click();
	}
</script>
</head>
<body>
	<div style="display:none;">
		<a href="#" id="fancyboxDetail" class="fancybox_detail"></a>
	</div>
   	<!--内容-->
    <div class="container">
    	<div class="article" style="width: 96%;">
        	<div class="activityMsg">
	            <div class="rightTitle">
                	<span>${shopVo.wordNames['gmsc028']}</span><!-- 活动信息 -->
	            </div>
            	<div class="activityContent">
	               	<u>
		               	<em style="width:300px;height:300px;">
		              		<img src='${activity.imgUrl}' id='activityImg' width="300" height="300"/>
		              	</em>
	              		<input id="imgUrl" name="imgUrl" type="hidden" value="${activity.imgUrl}" />
	              	</u>
	              	<fmt:formatDate value="${activity.endTime}" type="both" pattern="yyyy-MM-dd" var="eTime"/>
              		<table border="0" cellpadding="0" cellspacing="1" bgcolor="#b7b7b7" class="activityContentTable">
	              		<tr>
		                	<th width="110">${shopVo.wordNames['gmsc036']}</th>
		               	 	<td style="width:460px; padding: 3px 10px;">${activity.activityName}</td>
		              	</tr>
	              		<tr>
	                		<th>${shopVo.wordNames['gmsc037']}</th>
	                		<td style="width:460px; padding: 3px 10px;">${activity.title}</td>
	              		</tr>
	              		<tr>
		               		<th>${shopVo.wordNames['gmsc045']}</th>
		                	<td style="width:460px; padding: 3px 10px;">
		                		<fmt:formatDate value="${activity.startTime}" type="both" pattern="yyyy年MM月dd日" /> - <fmt:formatDate value="${activity.endTime}" type="both" pattern="yyyy年MM月dd日" />
		                	</td>
	             		</tr>
		              	<tr>
			                <th>${shopVo.wordNames['gmsc040']}</th>
			                <td style="padding: 3px 10px;">
			                 	<textarea class="area1" readonly="readonly">${activity.purpose}</textarea>
							</td>
		              	</tr>
		              	<tr>
			                <th>${shopVo.wordNames['gmsc041']}</th>
			                <td style="padding: 3px 10px;">
								<textarea class="area2" readonly="readonly">${activity.content}</textarea>
							</td>
		              	</tr>
		              	<tr>
			                <th>${shopVo.wordNames['gmsc042']}</th>
			                <td style="padding: 3px 10px;">
								<textarea class="area2" readonly="readonly">${activity.description}</textarea>
			                </td>
	             	 	</tr>
	             	 	<tr>
			                <th>${shopVo.wordNames['gmsc043']}</th>
			                <td style="padding: 3px 10px;">
			                	<c:forEach items="${publish_status}" var="type">
				       				<c:if test="${activity.publishStatus==type.key}">${type.value }</c:if>
				       			</c:forEach>
				       			<c:if test="${myToday gt eTime }"><font color="red">（已过期）</font></c:if>
				       		</td>
	             	 	</tr>
	            	</table>
				</div>
			</div>
			<!-- 规则列表 -->
	        <div class="activityContent">
	            <div class="rightTitle">
	        		<span>${shopVo.wordNames['gmsc050']}</span>
	            </div>
	        </div>
			<span id="fileCont2" style="display:block;">&nbsp;</span>
			<!-- 活动内容 -->
        	<div class="activityContent">
	            <div class="rightTitle">
	            	<span>${shopVo.wordNames['gmsc205']}</span>
	            </div>
        	</div>
			<span id="fileCont1" style="display:block;">&nbsp;</span>
			<div class="file_nav" id="tab_list"></div>
	        <form action="" id="nextPage" method="post" style="display:none;">
	        	<input type="hidden" name="title" />
	        	<input type="hidden" name="contentId" />
	        	<input type="hidden" name="contentType" />
	            <input id="activityId" name="activityId" type="hidden" value="${activity.activityId}"/>
	        	<input type="hidden" name="activityName" value="${activity.activityName}"/>
	            <input name="activeStartTime" type="hidden" value='<fmt:formatDate value="${activity.startTime}" type="both" pattern="yyyy-MM-dd" />'/>
	            <input name="activeEndTime" type="hidden" value='<fmt:formatDate value="${activity.endTime}" type="both" pattern="yyyy-MM-dd" />'/>
	        </form>
		</div>
	</div>
</body>
</html>