<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
	request.setAttribute("topMenuCode", "12");
	request.setAttribute("leftMenuCode", "");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsc030']}</title><!-- 活动内容 -->
<style>
	.firsd label a.way{background:url(${imgPath}/gms/marketing/images/after-01.png) no-repeat left top;}
</style>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script src="${imgPath}/gms/active/js/activeCont.js"></script>
<script>
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";
	var pIndex = '${page_cur}';
	var curSize = '${fn:length(pm.result)}';
	$(function(){
		initFancyBox("fancybox_formRule", 1000, 970, true);
		initFancyBox("fancybox_ruleDetail", 920, 600, true);
		initFancyBox("fancybox_ruleCheck", 324, 200, true);
		initFancyBox("fancybox_formCont", 1000, 970, true);
		initFancyBox("fancybox_contRetail", 1020, 970, true);
		initFancyBox("fancybox_contCheck", 324, 200, true);
		initFancyBox("fancybox_formReleaseCont", 920, 600, true);
		initFancyBox("fancybox_pulishDetail", 920, 600, true);
		initFancyBox("fancybox_preViewActivity", 1000, 600, true);
		
		$('.tab-arrow .tab-arrowChild').each(function(){
			$(this).click(function(index){
				$("#fileCont").empty();
				var index = $('.tab-arrow .tab-arrowChild').index(this);
		        var num = index + 1;
				$(this).removeClass('selected').addClass('selected').siblings().removeClass('selected');
				$('#tab-arrowTab'+num).css({display:'block'}).siblings("div[id*='tab-arrowTab']").css({display:'none'});
				if(num == 2){
					$('#fileType').val("${basePath }activityCont.do?method=list");
				}else{
					$('#fileType').val("${basePath }rule.do?method=list&orderBy=c_time_stamp desc");
				}
				pIndex = 1;
				$("#tab_list a").eq(1).click();
			});
		});
				
		$("#tab_list a").eq(1).click();
		clearHiddImg();
	});
	function freshFlag(flag){
		$("#flag").val(flag);
		page(1);
	}
	function page(index){
		var status = $("#flag").val();
		var activityId = $("#activityId").val();
		if(isEmpty(activityId)){
			activityId = "";
		}
		if(isEmpty(status)){
			status = "";
		}
		if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		pIndex = index;
		var url = $("#fileType").val(); 
		var data = "&pageIndex="+index+"&pageSize=10&activityId="+activityId+"&publishStatus="+status;
		ajaxToPageByData(url, "fileCont", data);
	}
	/**********活动规则方法**********/
	//编辑规则
	function formRule(ruleId){
		if(isEmpty(ruleId)){
			ruleId = "";
			methodName = "formA";
		}else{
			methodName = "formU";
		}
		var activeStartTime = $("input[name='activeStartTime']").val(); 
		var activeEndTime = $("input[name='activeEndTime']").val();
		var data = "&ruleId=" + ruleId + "&activityId=${activity.activityId}&activeStartTime=" + activeStartTime + "&activeEndTime=" + activeEndTime;
		var url = "${basePath }rule.do?method=" + methodName + data;
		$("#formRule").attr("href",url).click();
	}

	/**********活动内容方法**********/
	// 编辑活动内容
	function formCont(contId, channelCode){
		var activityId = $("#activityId").val();
		var methodName = "updateContform";
		
		if(isEmpty(contId)){
			contId = "";
			methodName = "addContform";
		}
		if(isEmpty(channelCode)){
			channelCode　=　"";
		}
		var data = "&id=" + contId +"&contId=" + contId + "&channelCode=" + channelCode + "&activityId=" + activityId;
		var url = "${basePath }activityCont.do?method=" + methodName + data;
		$("#formCont").attr("href",url).click();
	}
	

	// 关闭弹出层c审核
	function closeCheckFancyBox(flag){	
		closeFancyBox();
		if(flag=="Y"){
			$("#tab_list a").eq(3).click();
		}else if(flag=="N"){
			$("#tab_list a").eq(2).click();
		}else{
			freshList();
		}
	}
	// 返回
	function freshList(){
		location.replace(location);	
	}
	// 清空隐藏input活动图片值 给出初始图片
	function clearHiddImg(){
	 	var imgUrl= $("#activityImg").attr("src");
	 	if(imgUrl=="" || imgUrl==null){
	 		$("#imgUrl").val("");
	 		$("#activityImg").attr("src","${imgPath}/gms/common/images/default1.jpg");
	 	}
	 }
	
	//查看详细
	function formDetailCont(id,channelCode){
		if(isEmpty(id)){
			id="";
		}
		if(isEmpty(channelCode)){
			channelCode="";
		}
		var url="${basePath }activityCont.do?method=detail&contId="+id+"&channelCode="+channelCode;
		$("#fancybox_contRetail").attr("href",url).click();
	}
	//预览活动
	function preViewActivity(url){
		if(isEmpty(url)){
			url = "";
		}
		$("#preViewActivity").attr("href", url).click();
	}
	//通过单选按钮发布
	function getRadioValue(){
	   	var New=document.getElementsByName("radio");
	   	var strs;
		for(var i=0;i<New.length;i++){
			if(New.item(i).checked){
		        strs=New.item(i).getAttribute("value");  
		        var str =strs.split('#');
		        pulish(str[0],str[1],str[2]);
		   		break;
		  	}else{
		  		continue;
	      	}
		}
		if(isEmpty(str)){
		   	alert("请选择一条活动内容");
	   	}
	}
</script>
</head>
<body>
	<div style="display:none;">
		<a href="#" id="formRule" class="fancybox_formRule"></a><!-- 编辑规则 -->
		<a href="#" id="fancybox_ruleCheck" class="fancybox_ruleCheck"></a><!-- 审核规则 -->
		<a href="#" id="fancybox_ruleDetail" class="fancybox_ruleDetail"></a><!-- 规则详细 -->
		<a href="#" id="formCont" class="fancybox_formCont"></a><!-- 编辑活动内容 -->
		<a href="#" id="fancybox_contRetail" class="fancybox_contRetail"></a><!-- 内容详细 -->
		<a href="#" id="fancybox_contCheck" class="fancybox_contCheck"></a><!-- 内容详细 -->
		<a href="#" id="fancybox_formReleaseCont" class="fancybox_formReleaseCont"></a><!-- 内容详细 -->
		<a href="#" id="fancybox_pulishDetail" class="fancybox_pulishDetail"></a><!-- 内容详细 -->
		<a href="#" id="preViewActivity" class="fancybox_preViewActivity"></a><!-- 预览活动 -->
	</div>
   	<!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   	<!--内容-->
    <div class="container">
    	<div class="article">
        	<div class="activityMsg">
	            <div class="rightTitle">
                	<span>${shopVo.wordNames['gmsc028']}</span><!-- 活动信息 -->
	            </div>
            	<div class="activityContent">
	               	<u>
		               	<em style="width:319px;height:319px;">
		              		<img src='${activity.imgUrl}' id='activityImg' width="319" height="319"/>
		              	</em>
	              		<input id="imgUrl" name="imgUrl" type="hidden" value="${activity.imgUrl}" />
	              	</u>
              		<table border="0" cellpadding="0" cellspacing="1" bgcolor="#b7b7b7" class="activityContentTable">
	              		<tr>
		                	<th width="110" height="40">${shopVo.wordNames['gmsc036']}</th>
		               	 	<td width="514">
		               	 	   	<c:if test="${activity.publishStatus!='P'}">${itemChild.activityName}</c:if>
			            		<c:if test="${activity.publishStatus=='P'}">
			            			<a href="javascript:void(0);" onclick="preViewActivity('${activity.webVisitUrl}');" title="预览">${activity.activityName}</a>
			            		</c:if>
		               	 	</td>
		              	</tr>
	              		<tr>
	                		<th>${shopVo.wordNames['gmsc037']}</th>
	                		<td>${activity.title}</td>
	              		</tr>
	              		<tr>
		               		<th>${shopVo.wordNames['gmsc045']}</th>
		                	<td>
		                		<fmt:formatDate value="${activity.startTime}" type="both" pattern="yyyy年MM月dd日" /> - <fmt:formatDate value="${activity.endTime}" type="both" pattern="yyyy年MM月dd日" />
		                	</td>
	             		</tr>
		              	<tr>
			                <th>${shopVo.wordNames['gmsc040']}</th>
			                <td>${activity.purpose}</td>
		              	</tr>
		              	<tr>
			                <th>${shopVo.wordNames['gmsc041']}</th>
			                <td>${activity.content}</td>
		              	</tr>
		              	<tr>
			                <th>${shopVo.wordNames['gmsc042']}</th>
			                <td>${activity.description}</td>
	             	 	</tr>
		              	<tr>
			                <th>${shopVo.wordNames['gmsc043']}</th>
			                <td>
			                	<c:forEach items="${publish_status}" var="type">
				       				<c:if test="${activity.publishStatus == type.key}">${type.value }</c:if>
				       			</c:forEach>
			                </td>
	             	 	</tr>
	            	</table>
				</div>
			</div>
			<!-- 活动内容 -->
           	<div class="tab-arrow">
           		<div class="rightTitle" style="margin-bottom: 0;">
                	<span>发布内容</span><!-- 发布内容 -->
	            </div>
	           	<div class="tab-arrowChild selected">${shopVo.wordNames['gmsc050']}<div class="arrowDiv"><b></b></div></div>
	           	<div class="tab-arrowChild">${shopVo.wordNames['gmsc205']}<div class="arrowDiv"><b></b></div></div>
           	</div>
	        <div class="file_nav" id="tab_list">
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('');" style="padding: 0 30px;">${shopVo.wordNames['gmsc019']}</a>
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('W');" style="padding: 0 30px;">${shopVo.wordNames['gmsc020']}</a>
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('B');" style="padding: 0 30px;">${shopVo.wordNames['gmsc021']}</a>
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('A');" style="padding: 0 30px;">${shopVo.wordNames['gmsc022']}</a>
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('D');" style="padding: 0 30px;">${shopVo.wordNames['gmsc023']}</a>
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('P');" style="padding: 0 30px;">${shopVo.wordNames['gmsc024']}</a>
	            <input id="flag" value="W" type="hidden"/>
	           	<input type="hidden" value="${basePath }rule.do?method=list&orderBy=c_time_stamp desc" id="fileType"/>
	            <check:hasAuthority authorityID="1203">
			        <div id="tab-arrowTab1">
			            <button class="activity_nav" onclick="formRule('');">${shopVo.wordNames['gmsc051']}</button><!-- 添加规则 -->
		           	</div>
	        	</check:hasAuthority>
	        	<check:hasAuthority authorityID="1205">
		           	<div id="tab-arrowTab2" style="display:none;">
			            <button class="activity_nav" onclick="formCont('');">${shopVo.wordNames['gmsc206']}</button><!-- 添加内容 -->
					</div>
	        	</check:hasAuthority>
          	</div>
          	<div id="fileCont">
          	</div>
	        <form action="" id="nextPage" method="post" style="display:none;">
	        	<input type="hidden" name="title" />
	        	<input type="hidden" name="contentId" />
	        	<input type="hidden" name="contentType" />
	            <input type="hidden" name="activityId" value="${activity.activityId}" id="activityId"/>
	        	<input type="hidden" name="activityName" value="${activity.activityName}"/>
	            <input name="activeStartTime" type="hidden" value='<fmt:formatDate value="${activity.startTime}" type="both" pattern="yyyy-MM-dd" />'/>
	            <input name="activeEndTime" type="hidden" value='<fmt:formatDate value="${activity.endTime}" type="both" pattern="yyyy-MM-dd" />'/>
	        </form>
        </div>
	</div>
	<div class="nextControl" style="height: 30px;">
		<a href="javascript:window.location.href='${basePath}activity.do?method=index'" class="blueBtn savebtn">返回活动列表</a>
	</div>
</body>
</html>
