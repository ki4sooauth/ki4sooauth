<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模板预览</title>
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
		delay();
	});
	function delay(){
		if($("#demo_div").attr("id") == "demo_div"){
			initTemplateContent()
			clearTimeout(timeOutId);
			doSourcepreview();
		}else{
			timeOutId = setTimeout("delay()",150);
		}
	}
	function initTemplateContent(){
		var templateData = $("#templateData").text();
		initTemplateBycontent(templateData);
	}
</script>
</head>
<body style="min-height: 660px; cursor: auto;" class="edit">
<textarea id="templateData" name="templateData" rows="0" cols="0" style="display:none;">${templateData}</textarea>
	<div class="container-fluid" id="loadHtml"></div>
	<textarea style="display: none;" id="templateData" rows="" cols="">${templateData}</textarea>
</body>
</html>