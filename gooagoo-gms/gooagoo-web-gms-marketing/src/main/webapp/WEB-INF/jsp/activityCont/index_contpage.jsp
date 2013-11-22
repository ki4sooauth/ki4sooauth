<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsc201']}</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<%@ include file="/WEB-INF/jsp/common/fancybox.jsp"%>
<script src="${imgPath}/gms/active/js/activeCont.js"></script>
<%
	request.setAttribute("topMenuCode", "13");
	request.setAttribute("leftMenuCode", "1305");
%>
<script type="text/javascript">

	var pIndex = '${page_cur}';
	var winWidth=window.screen.availWidth-100;
	$(function(){
 		page(pIndex);
		initFancyBox("fancybox_activityCont",327,200,true);//审核
		initFancyBox("fancybox_addCont",1030,970,true);  //弹出框（活动）
		initFancyBox("fancybox_detail",920,600,true);//查看活动内容详细
		initFancyBox("fancybox_relate",800,600,true);//活动列表
		initFancyBox("fancybox_preView", 1100, 1100, true);
		initFancyBox("fancybox_template_edit", winWidth, 1000, true);
	});
	function page(index){
		var activityId= $("#activityId").val();
		var channelCode=$("#channelCode").val();	
		var publishStatus=$("#status").val();
		var title=$("#title").val();
		if(isEmpty(activityId)){
			activityId="";
		}
		if(isEmpty(channelCode)){
			channelCode="";
		}
		if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		pIndex=index;
		var data = "&pageIndex="+index+"&channelCode="+channelCode+"&activityId="+activityId+"&publishStatus="+publishStatus+"&title="+title;
		ajaxToPageByData("${basePath }activityCont.do?method=pageList","fileCont1",data);
	}
	//清空模糊查询条件
	function clearArgs(){
		 $("#activityId").val("");
		 $("#activityName").val("点击此处选择活动");
		 $("#channelCode").val("");
		$("#status").val("");
		$("#title").val("");
		 page(1);
	}

	// 编辑活动内容
	function formActivityCont(id,channelCode){
		var activityId=$('#activityId').val();
		var mName="updateContform";
		if(isEmpty(id)&&isEmpty(activityId)){
			alert("请先选择活动");
			return;
		}
		if(isEmpty(id)){
			id="";
			mName="addContform";
		}
		if(isEmpty(channelCode)){
			channelCode="";
		}
		$("#channelCode").val("");
		var url="${basePath }activityCont.do?method="+mName+"&contId="+id+"&channelCode="+channelCode+"&activityId="+activityId;
		$("#addCont").attr("href",url).click();
	}
	// 删除活动内容
	function deleteContent(id,type){
		if(confirm("确定删除活动信息吗？")){
			var url = "";
			if(isEmpty(id)){
				id = "";
			}
			if(isEmpty(type)){
				type = "1";
			}
			var data = "&id="+id;
			var url = "${basePath }activityCont.do?method=delete&channelCode="+type;
	
			ajaxJsonTipByData(url,data,true);
			freshList();
		}
	}
	// 审核活动内容
	function formCheckActivityCont(id,type){
		if(isEmpty(id)){ 
			id = ""; 
		}
		if(isEmpty(type)){
			type = "1";
		}
		var url = "${basePath }activityCont.do?method=formCheck&id="+id+"&channelCode="+type;
		$("#activityContFancybox").attr("href",url).click();
	}
	// 关闭弹出层c审核
	function closeCheckFancyBox(flag){	
		closeFancyBox();
		if(flag=="Y"){
			$("#tab_list a").eq(3).click();
			freshList();
		}else if(flag=="N"){
			$("#tab_list a").eq(2).click();
			freshList();
		}else{
			freshList();
		}
	}
	// 点击查询按钮
	function freshList(){
		$("#select").click();
	}
	//弹出框（活动）
	function relateActive(){
		var url = "${basePath }relation.do?method=listRelation&&relateType=A";
		$("#relateFancybox").attr("href",url).click();
	}
	function dealRelations(relations){
		 $("#activityId").val(relations[0][1]);
		 $("#activityName").val(relations[0][2]);
		 $.fancybox.close();
		 freshList();
	}
	//查看详细
	function formDetailCont(id,channelCode){
	if(isEmpty(id)){ id=""; }
	
	if(isEmpty(channelCode)){ channelCode=""; }
	
	var url="${basePath }activityCont.do?method=detail&contId="+id+"&channelCode="+channelCode;
	
		$("#addCont").attr("href",url).click();
		
		
	}
	// 进入活动详情
	function goToActivityDetail(activityId){
		if(isEmpty(activityId)){
			activityId="";
		}
		var url = "${webLink}/gactive/activityCont.do?method=index&id="+activityId;
		window.location.href=url;
	}
	// 查看发布详情
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
	//预览发布后的活动内容（事件）
	function preView(url){
		if(isEmpty(url)){
			url = "";
		}
// 		$("#preView").attr("href", url).click();
		window.open(url);
	}
</script>
</head>
<body>
	<div style="display:none;">
	    <a href="#" id="activityContFancybox" class="fancybox_activityCont"></a>
		<a href="#" id="addCont" class="fancybox_addCont"></a>
		<a href="#" id="detail" class="fancybox_detail"></a>
		<a href="#" id="relateFancybox" class="fancybox_relate"></a>
		<a href="#" id="preView" class="fancybox_preView"></a><!-- 活动详细 -->
		<a href="#" id="fancyboxTemplateEdit" class="fancybox_template_edit"></a><!-- 模版编辑页 -->
	</div>
    <!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   	<!--内容-->
    <div class="container">       
      	<div class="article">
	 		<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
  			<div class="section">
		        <div class="rightTitle_add file_nav">        
		            <span>${shopVo.wordNames['gmsc202']}</span>
		            <check:hasAuthority authorityID="130502">
				        <button class="activity_nav" onclick="formActivityCont();">${shopVo.wordNames['gmsc206']}</button>
		            </check:hasAuthority>
		        </div>
				<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable" style="background-color:#F8F7F7; ">
					<tr>
						<td colspan="8" style="padding-top: 20px;">
						<div class="behaviorSearch"  style="float:left; height:35px;">
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 10px;">${shopVo.wordNames['gmsc203']}：</span>
							<input type="hidden" id="activityId"/>
	                        <input type="text" id="activityName" class="behaviorInput" onclick="relateActive();" style="cursor:pointer; color:#a0a0a0; margin-left: 0px;" value=" ${shopVo.wordNames['gmsc207']}"/>	
								<span style="float: left; height: 20px; line-height: 24px; padding-left: 20px;">${shopVo.wordNames['gmsc204']}：</span>
								<select class="behaviorInput" id="channelCode" style="width:120px;margin-left: 0px;">			
									<option value="">-${shopVo.wordNames['gmsd088']}-</option>
									<c:forEach var="itemChild" items="${channels}" varStatus="xh">
									<option value="${itemChild.code}">${itemChild.name}</option>
									</c:forEach>				
								</select>
							</div>
							<div class="behaviorSearch"  style="float:left; height:40px;">
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 10px;">${shopVo.wordNames['gmsc216']}：</span>
							<input type="text" id="title" class="behaviorInput"  style="margin-left: 0px;" />
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 20px;">${shopVo.wordNames['gmsc218']}：</span>
								<select  class="behaviorInput" id="status" style="width:120px;margin-left: 0px;">			
									<option value="">-${shopVo.wordNames['gmsd088']}-</option>
									<option value="W">待审核</option>
									<option value="A">通过</option>
									<option value="B">未通过</option>
									<option value="P">已发布</option>			
								</select>
								<a href="javascript:void(0)" style="margin-left: 35px ;margin-top:-6px;" id="select" onclick="page(1)" class="search orangeBtn" style="margin-left: 35px;">${shopVo.wordNames['gmsc006']}</a>
								<a href="javascript:void(0)" style="margin-top:-6px;" onclick="clearArgs();" class="search orangeBtn">${shopVo.wordNames['gmsc007']}</a>												
							</div>
						</td>
	             	</tr>
				</table>   
	          	<span id="fileCont1">&nbsp;</span>
        	</div>
       	</div>
	</div>
</body>
</html>