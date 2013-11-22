<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑活动内容</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<%@ include file="/WEB-INF/jsp/common/fancybox.jsp"%>

<script type='text/javascript' src='${imgPath}/common/js/kindeditor/kindeditor-min.js' charset='utf-8'></script>
<link rel="stylesheet" href="${imgPath}/common/js/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="${imgPath}/common/js/kindeditor/lang/zh_CN.js"></script>
<script src="${imgPath}/gms/common/js/popLB.js"></script>
<link href="${imgPath}/gms/common/css/add_actPop.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.mbType {font-size: 14px; line-height: 24px; padding-left: 15px;}
	.mbImg li {float: left; padding: 15px;}
	.mbImg li img {border: 1px solid #E2E2E2; cursor: pointer; height: 150px; width: 150px;}
</style>
<script type="text/javascript" src="${imgPath}/gms/common/js/popLB.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/template.js"></script>
<script type="text/javascript">
	$(function(){
		page(1);
	});
	//分页
	function page(index){
		var templateSource = $("input:radio[name='templateSource']:checked").val();
		var userType = $("input:radio[name='userType']:checked").val();
		if(templateSource=="A"){
			$("#createType").css("display","block");
		}else{
			$("#createType").css("display","none");
			$("#createType").find("#S").attr("checked",true);
		}
		if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		pIndex = index;
		var data = $("#conditionForm").serialize()+"&pageIndex="+index+"&pageSize=5";
		ajaxToPageByData("template.do?method=list","tableList",data);
	}
	//编辑模板
	function editTemplate(templateId){
		if(isEmpty(templateId)){
			templateId = "";
		}
 		$("#templateId").val(templateId);
 		
		var data = "&" + $("#conditionForm").serialize();
		parent.$("#fancyboxTemplateEdit").attr("href", "template.do?method=edit"+data).click();
//  		$("#conditionForm").attr("action","template.do?method=edit").submit();
	}
	//预览模板内容
	function previewTemplate(){
		var data = "&" + $("#conditionForm").serialize();
		window.open("template.do?method=preview"+data);
	}
	//加载模板
	function loadTemplate(templateId,obj){
		$("#templateId").val(templateId);
		$("#conditionForm").attr("action","template.do?method=edit").submit();
	}
</script>
</head>
<body>
	<div class="add_actPopBox">
		<div class="incidentContent">
		    <form action="" id="conditionForm" method="post">
		    	<input type="hidden" id="contId" name="contId" value="${contId}" />
		    	<input type="hidden" id="channelCode" name="channelCode" value="${channelCode}" />
		    	<input type="hidden" id="contentType" name="contentType" value="${contentType}" />
		    	<input type="hidden" id="templateId" name="templateId" value="" />
		      	<h2 class="title">${shopVo.wordNames['gmsc215']}</h2>
		        <div class="ICbottom" id="template_cont" style="min-height: 50px; margin-bottom: 20px; border: 0px;">
		        	<p style="font-size:14px;padding:30px;float:left;">点击【编辑】直接编辑模板内容，如要重新使用推荐模板内容，请选择下方的模板；点击【预览】可以查看现有模板内容发布后的效果。</p>
		        </div>
		        <div style="text-align:center">
			        <a href="javascript:void(0);" onclick="editTemplate();" style="display: inline-block; width: 150px;margin-right: 50px;" class="saveSet blueBtn" >编辑</a>
			        <a href="javascript:void(0);" onclick="previewTemplate();" style="display: inline-block; width: 150px;" class="saveSet blueBtn" >预览</a>
				</div>
		      	<h2 class="title">${shopVo.wordNames['gmsc214']}</h2>
		      	<div style="height: 60px;">
		      		<p class="mbType">
						<strong>模板类型</strong>：
						<label><input name="templateSource" type="radio" value="S" onclick="page(1);" />我的模板</label>
						<label><input name="templateSource" type="radio" value="A" onclick="page(1);" checked="checked"/>所有模板</label><br/>
					</p>
					<p class="mbType" id="createType" style="display: ${templateSource=='A' ? 'block' : 'none'};">
						<strong>创建者类型</strong>：
						<label><input name="userType" id="S" type="radio" value="S" onclick="page(1);" <c:if test="${userType=='S' || (empty userType)}">checked="checked"</c:if>/>商家</label>
						<label><input name="userType" id="M" type="radio" value="M" onclick="page(1);" <c:if test="${userType=='M'}">checked="checked"</c:if>/>购阿购</label>
						<label><input name="userType" id="P" type="radio" value="P" onclick="page(1);" <c:if test="${userType=='P'}">checked="checked"</c:if>/>个人</label>
					</p>
		      	</div>
				<div id="tableList" style="height: 250px;">
				</div>
			</form>
		</div>
	</div>
</body>
</html>













