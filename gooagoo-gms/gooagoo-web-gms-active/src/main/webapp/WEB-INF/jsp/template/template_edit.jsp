<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模板内容</title>
<link href="${imgPath}/template/css/bootstrap-combined.min.css" rel="stylesheet">
<script type="text/javascript" src="${imgPath}/template/js/jquery.js"></script>
<script type="text/javascript" src="${imgPath}/template/js/templateJs.js"></script>
<script type="text/javascript" src="${imgPath}/template/js/ajax.js"></script>
<script type="text/javascript" src="${imgPath}/template/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript">
	var imgPath = "${imgPath}";
	var passport = "${passport}";
	var ajax = "${ajax}";

	$(document).ready(function() {
		//初始化工具
		loadHtml();
		//加载模板内容
		loadTemplateContent();
	});
	
	var timeOutId;
	function loadTemplateContent(){
		if($("#demo_div").attr("id") == "demo_div"){
			var templateId = "${templateId}";
			var templateData = $("#templateData").text();
			if(!isEmpty(templateId)){
				initTemplate(templateId);
			}else{
				initTemplateBycontent(templateData);
			}
			clearTimeout(timeOutId);
			//初始化查询条件（商品）
			initQuerys();
		}else{
			timeOutId = setTimeout("loadTemplateContent()",150);
		}
	}

	function saveTemplateHtml(){
		var contId = $("#contId").val();
		if(isEmpty(contId) || !freshMarketingInfo()){
			alert("页面数据不全");
			return false;
		}
		//获取纯内容的html（自适应宽度）
		var fluid = getfluidPage();
		$("#publish").text(fluid);
		//获取带编辑模式的html
		var edit = getEditMode();
		$("#edit").text(edit);
		
		var url = "template.do?method=saveContent";
		var data = $("#templateForm").serialize() ;
		$.ajax({
			type: "POST",
			async: false,
			url: url,
			data: data,
			dataType: "json",
			success: function(ret){
				if(!ret.success){
					alert(ret.message);
				}
				if(ret.success){
					parent.$("#tab_list a").eq(1).click();
					parent.$.fancybox.close();
				}
			}
		});
	}

	function freshMarketingInfo(){
		var marketingTypes = $("#loadHtml input[name=marketingLinkType]");
		var marketingIds = $("#loadHtml input[name=marketingLinkId]");
		$("#marketingDiv").html("");
		if(marketingTypes.size() != marketingIds.size()){
			return false;
		}
		for(var i=0;i<marketingTypes.size();i++){
			if(isEmpty(marketingIds.eq(i).val())){
				continue;
			}
			$("#marketingDiv").append("<input type='hidden' name='marketingLinkType' value='"+marketingTypes.eq(i).val()+"' />");
			$("#marketingDiv").append("<input type='hidden' name='marketingLinkId' value='"+marketingIds.eq(i).val()+"' />");
		}
		return true;
	}
	function goBack(){
		var channelCode = $("#channelCode").val();
		var contentType = $("#contentType").val();
		var contId = $("#contId").val();
		var tc="";
		if(channelCode=="4"){
			tc = "E";
		}else if(channelCode=="5"){
			tc = "Q";
		}else if(channelCode=="6"){
			tc = "M";
		}
		$("#templateChannel").val(tc);
		var data = "&contId=" + contId + "&contentType=" + contentType + "&channelCode=" + channelCode + "&templateChannel=" + tc;
		parent.$("#fancyboxForm").attr("href", "template.do?method=index"+data).click();
// 		$("#templateForm").attr("action","template.do?method=index").submit();
	}
</script>
</head>
<body style="min-height: 660px; cursor: auto;" class="edit">
<form action="" id="templateForm" method="post">
	<input name="contId" id="contId" value="${contId}" type="hidden"/>
	<input name="channelCode" id="channelCode" value="${channelCode}" type="hidden"/>
	<input name="contentType" id="contentType" value="${contentType}" type="hidden"/>
	<input name="templateId" id="templateId" value="${templateId}" type="hidden"/>
	<textarea id="templateData" name="templateData" rows="0" cols="0" style="display:none;">${templateData}</textarea>
	<textarea id="templateFullData" name="templateFullData" rows="0" cols="0" style="display:none;">${templateFullData}</textarea>
	<textarea id="edit" name="edit" rows="0" cols="0" style="display:none;"></textarea>
	<textarea id="publish" name="publish" rows="0" cols="0" style="display:none;"></textarea>
	<div id="marketingDiv" style="display:none;"></div>
</form>
	<!-- 头div s-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
			<!-- 页面缩小时的菜单键 -->
				<button data-target=".nav-collapse" data-toggle="collapse"
					class="btn btn-navbar" type="button">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div class="nav-collapse collapse">
					<ul class="nav" id="menu-layoutit">
						<li>
							<div class="btn-group" data-toggle="buttons-radio">
								<button type="button" class="btn btn-primary active" onclick="doEdit();">
									<i class="icon-edit icon-white"></i>编辑
								</button>
								<button type="button" class="btn btn-primary" onclick="doSourcepreview();">
									<i class="icon-eye-open icon-white"></i>预览
								</button>
								<button class="btn btn-primary" href="#" role="button" onclick="saveTemplateHtml();">
									<i class="icon-share icon-white"></i>保存
								</button>
								<button type="button" class="btn btn-primary" onclick="goBack();">
									<i style="background-position:-216px -24px" class="icon-home icon-white"></i>返回
								</button>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 头div e-->
	<input name="marketingId" id="marketingId" value="${contId}" type="hidden"/>
	<input name="templateType" id="templateType" value="${templateType}" type="hidden"/>
	<div class="container-fluid" id="loadHtml"></div>
</body>
</html>