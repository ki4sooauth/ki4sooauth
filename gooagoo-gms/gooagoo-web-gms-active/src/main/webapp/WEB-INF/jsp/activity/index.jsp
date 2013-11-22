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
<title>${shopVo.wordNames['gmsc027']}</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script>
	$(function(){
 		initCalendar(${fullCalendar});
 		//给日期控件中 "今天" 按钮加上单击事件（点击可查询今天的活动）
 		$('.fc-button-today').removeClass("fc-state-disabled");
	    $('.fc-button-today').click(function() {
	 		$('.fc-button-today').removeClass("fc-state-disabled");
	 		var d = new Date();
	 		var nowDate = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
			$("#activityTime").val(nowDate);
			page(1);
 		});
	    
		initFancyBox("fancybox_detail", 1000, "95%", true);
		initFancyBox("fancybox_check", 960, 620, true);
	    
		$(".file_nav").find("a").eq(0).click();
	});
	//刷新标签值
	function freshFlag(flag){
		$("#flag").val(flag);
		page(1);
	}
	//活动列表
	function page(index){
	 	var activityTime=$('#activityTime').val();
		var status = $("#flag").val();
		if(isEmpty(status)){
			status = "";
		}
	 	if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		pIndex = index;
		var data = "&pageIndex="+index+"&publishStatus="+status+"&activityTime="+activityTime;
		ajaxToPageByData("${basePath }activity.do?method=list","fileCont",data);
	}
	//活动编辑页
	function formActivity(activityId){
		if(isEmpty(activityId)){
			activityId = "";
			formName = "formA";
		}else{
			formName = "formU";
		}
		window.location.href = "${basePath }activity.do?method="+formName+"&id="+activityId;
	}
    //查看详细页
	function detailActivity(activityId){
		if(isEmpty(activityId)){
			activityId = "";
		}
		var url="${basePath }activity.do?method=detail&id="+activityId;
		$("#fancyboxDetail").attr("href", url).click();
	}
	//删除活动信息
	function deleteActivity(activityId){
		if(confirm("确定删除活动信息吗？")){
			//如果当前页只剩一条记录，删除操作时当前页改为上一页页码
			pIndex=curSize==1 && pIndex!=1? --pIndex:pIndex;
			var url = "${basePath }activity.do?method=delete";
			var data = "&id="+activityId;
			ajaxJsonTipByData(url,data,true);
			page(pIndex)
		}
	}
	//审核活动信息
	function checkActivity(activityId){
		if(isEmpty(activityId)){
			activityId = "";
		}
		var url = "${basePath}activity.do?method=formCheck&id="+activityId;
		$("#fancyboxCheck").attr("href",url).click();
	}
	//发布活动信息
	function publishActivity(activityId){
		if(confirm("确定发布活动信息吗？")){
			var url = "${basePath }activity.do?method=publish";
			var data = "&activityId="+activityId;
			ajaxJsonTipByData(url,data,true);
			page(pIndex)
		}
	}
	//清空查询条件
	function clearCondition(){
		$('#activityTime').val("");
		page(1);
	}

	function closeCheckFancyBox(){
		$.fancybox.close();
		location.reload();
	}
</script>
</head>
<body>
	<div style="display:none;">
		<a href="#" id="fancyboxDetail" class="fancybox_detail"></a><!-- 活动详细 -->
		<a href="#" id="fancyboxCheck" class="fancybox_check"></a><!-- 活动详细 -->
	</div>
   	<!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   	<!--内容-->
    <div class="container">
    	<div style="padding-bottom: 15px;">
			<%@ include file="/WEB-INF/jsp/activity/activity_calendar.jsp"%>
		</div>
      	<div class="article">
        	<div class="rightTitle_add">
	            <check:hasAuthority authorityID='1201'>
	            	<a href="javascript:formActivity('');">${shopVo.wordNames['gmsc034']}</a>
	            </check:hasAuthority>
	            <span style="float: left;">${shopVo.wordNames['gmsc033']}</span>
        	</div>
        	<div class="file_nav">
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('');" style="padding: 0 30px;" class="curr">${shopVo.wordNames['cpmd003']}</a>
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('W');" style="padding: 0 30px;">${shopVo.wordNames['cpmd004']}</a>
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('B');" style="padding: 0 30px;">${shopVo.wordNames['cpmd005']}</a>
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('A');" style="padding: 0 30px;">${shopVo.wordNames['cpmd006']}</a>
	            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('P');" style="padding: 0 30px;">${shopVo.wordNames['cpmd008']}</a>
	            <input id="flag" value="" type="hidden"/>
			</div>
			<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
				<tr>
					<td colspan="11" class="behaviorSearch">
					<span style="float: left; height: 20px; line-height: 24px; padding-left: 20px;">${shopVo.wordNames['gmsc035']}：&emsp;</span>
					<input type="text" id="activityTime" readonly="readonly" class="behaviorInput"  style="margin: 0px;" value="${activityTime}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
					<a href="javascript:void(0)" id="select" onclick="page(1)" class="search orangeBtn">${shopVo.wordNames['gmsc006']}</a>
					<a href="javascript:void(0)"  onclick="clearCondition();" class="search orangeBtn">${shopVo.wordNames['gmsc007']}</a>
					</td>
				</tr>
			</table>  
			<span id="fileCont"></span>
		</div>
	</div>
	<div style="height: 50px;"></div>
</body>
</html>
