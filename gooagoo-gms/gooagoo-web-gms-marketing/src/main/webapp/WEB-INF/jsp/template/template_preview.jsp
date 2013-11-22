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
$(document).ready(function() {
	//初始化工具
	loadHtml();
	//加载模板内容
	loadTemplateContent();
	//预览模板内容
	doSourcepreview();
});
var timeOutId;
function loadTemplateContent(){
	if($("#demo_div").attr("id") == "demo_div"){
		var templateData = $("#templateData").text();
		initTemplateBycontent(templateData);
		clearTimeout(timeOutId);
	}else{
		timeOutId = setTimeout("loadTemplateContent()",150);
	}
}
</script>
</head>
<body style="min-height: 660px; cursor: auto;" class="edit">
	<textarea id="templateData" name="templateData" rows="0" cols="0" style="display:none;">${templateData}</textarea>
	<div class="container-fluid" id="loadHtml"></div>
</body>
</html>