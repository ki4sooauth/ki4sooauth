<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑模板</title>
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
		//获取纯内容的html（自适应宽度）
		var fluid = getfluidPage();
		//获取带编辑模式的html
		var edit = getEditMode().replace(/\%/g,'%25');
		var cmsContentId = $("#cmsContentId").val();
		var templateId = "${templateId}";
		if(isEmpty(cmsContentId)){
			return false;
		}
		if(isEmpty(templateId)){
			templateId="";
		}

		var url = "${basePath}template.do?method=save";
		var data = "&cmsContentId=${cmsContentId}&templateId="+templateId+"&edit="+edit+"&fluid="+fluid;
		ajaxJsonTipByData(url,data,true);
		parent.$.fancybox.close();
	}
</script>
</head>
<body style="min-height: 660px; cursor: auto;" class="edit">
<form action="" id="templateForm">
	<input type="hidden" name="cmsContentId" id="cmsContentId" value="${cmsContentId}"/>
	<textarea id="templateData" name="templateData" rows="0" cols="0" style="display:none;">${templateData}</textarea>
	<textarea id="edit" name="edit" rows="0" cols="0" style="display:none;"></textarea>
	<textarea id="publish" name="publish" rows="0" cols="0" style="display:none;"></textarea>
</form>
	<!-- 头div s-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
			<!-- 页面缩小时的菜单键 -->
				<button data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar" type="button">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
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
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 头div e-->
	<input name="marketingId" id="marketingId" value="${cmsContentId}" type="hidden"/>
	<input name="templateType" id="templateType" value="${templateType}" type="hidden"/>
	<div class="container-fluid" id="loadHtml"></div>
</body>
</html>