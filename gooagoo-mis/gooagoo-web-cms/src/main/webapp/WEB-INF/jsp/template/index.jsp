<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑模板</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath }/cms/css/mb.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function(){
		page(1);
	});
	//分页
	function page(index){
		var type = $("input:radio[name='type']:checked").val();
		var userType = $("input:radio[name='userType']:checked").val();
		if(type=="N"){
			$("#createType").css("display","block");
		}else{
			$("#createType").css("display","none");
			userType = "${loginType}";
		}
		if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		if(isEmpty(userType)){
			userType = "${loginType}";
		}
		pIndex = index;
		
		var data = "&pageIndex="+index+"&pageSize=8&userType="+userType+"&type="+type+"&templateType=${channelType}";
		ajaxToPageByData("${basePath}template.do?method=page","tableList",data);
	}
	//编辑模板页
	function editTemplateForm(templateId){
		if(isEmpty(templateId)){
			templateId = "";
		}
 		var data = "&cmsContentId=${cmsContentId}&templateId="+templateId+"&templateType=${channelType}";
		parent.$("#fancybox_template").attr("href","${basePath}template.do?method=editForm"+data).click();
	}
	//预览模板页
	function preview(){
 		var data = "&cmsContentId=${cmsContentId}";
 		window.open("${basePath}template.do?method=preview"+data);
// 		parent.$("#fancybox_template").attr("href","${basePath}template.do?method=preview"+data).click();
	}
	//清空模板信息
	function clearTemplateForm(){
		var url = "${basePath}template.do?method=clearTemplateForm";
		var data = "&cmsContentId=${cmsContentId}&updateType=clearTemplate";
		ajaxJsonTipByData(url,data,true);
	}
</script>
</head>
<body>
	<div class="M_right">
		<div class="control_box">
			<div class="selectCard">
				<c:if test="${cmsContentType == 'C'}">
					<a class="curr" href="${basePath}cmsContent.do?method=getCmsContent&cmsContentType=C&cmsContentId=${cmsContentId}">栏目</a>
				</c:if>
				<c:if test="${cmsContentType == 'A'}">
					<a class="curr" href="${basePath}cmsContent.do?method=articleIndex&cmsContentType=A&parentCmsContentId=${parentCmsContentId}">文章</a>
				</c:if>
			</div>
		</div>
		<div class="content" style="padding-bottom: 15px;margin-bottom: 0px;">
			<div class="title">
				<i></i>位置：编辑模板
			</div>
			<div class="mbContent" style="padding-top: 10px;">
			<p class="mbTitle marginTop" style="margin-top: 15px;">编辑模板内容</p>
				<div class="tip" style="line-height: 20px; text-indent:2.5em">
					点击【编辑】直接编辑模板内容，如要重新使用推荐模板内容，请选择下方的模板；点击【预览】可以查看现有模板内容发布后的效果。
				</div>
				<div class="mbControl" style="padding-bottom: 20px;">
					<a href="#" onclick="editTemplateForm();">编&nbsp;辑</a>
					<a href="#" onclick="preview();">预&nbsp;览</a>
					<a href="#" onclick="clearTemplateForm();">清空模板内容</a>
					<c:if test="${cmsContentType == 'C'}">
						<a href="${basePath}cmsContent.do?method=getCmsContent&cmsContentType=C&cmsContentId=${cmsContentId}">查看栏目</a>
					</c:if>
					<c:if test="${cmsContentType == 'A'}">
						<a href="${basePath}cmsContent.do?method=articleIndex&cmsContentType=A&parentCmsContentId=${parentCmsContentId}">文章列表</a>
					</c:if>				
				</div>
				<p class="mbTitle">选择模板</p>
				<p class="mbType">
					模板类型：
					<label><input name="type" type="radio" value="Y" onclick="page(1);" />我的模板</label>
					<label><input name="type" type="radio" value="N" onclick="page(1);" checked="checked"/>所有模板</label><br/>
				</p>
				<p class="mbType" id="createType" style="display: none;">
					创建者类型：
					<label><input name="userType" type="radio" value="S" onclick="page(1);" <c:if test="${loginType=='S'}">checked="checked"</c:if>/>商家</label>
					<label><input name="userType" type="radio" value="M" onclick="page(1);" <c:if test="${loginType=='M'}">checked="checked"</c:if>/>购阿购</label>
					<label><input name="userType" type="radio" value="P" onclick="page(1);" <c:if test="${loginType=='P'}">checked="checked"</c:if>/>个人</label>
				</p>
				<div id="tableList">
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</body>
</html>
