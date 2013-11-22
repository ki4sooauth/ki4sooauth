<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath }/cms/css/showBox.css" rel="stylesheet" type="text/css" />
<link href="${imgPath }/cms/css/edit.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function(){
		initFancyBox2("fancybox_check", 324, 200,true); 
	});
	//修改文章
	function updateForm(id){
		if(isEmpty(id)){
			id = "";
		}
		var data = "&cmsContentType=A&cmsContentId=" + id + "&parentCmsContentId=${cmsContent.parentCmsContentId}";
		window.location.href = "${basePath}cmsContent.do?method=formU" + data;
	
	}
	//删除栏目
	function deleteChannel(id){
		if(isEmpty(id)){
			id = "";
		}
		if (confirm("确认删除该文章信息？")){
			var url = "${basePath}cmsContent.do?method=delete";
			var data = "&ids="+id;			
			ajaxJsonTipByData(url,data,true);
    		parent.window.location.href = "${basePath}cmsContent.do?method=index";
		}
	}
	//审核页面
	function checkForm(id){
		var templateData = $("#templateData").text()
		if(isEmpty(id)){
			id = "";
		}
		if(isEmpty($.trim(templateData))){
			alert("请先编辑模板内容！");
			return;
		}
		var url = "${basePath}cmsContent.do?method=checkForm&cmsContentId="+id+"&cmsContentType=A";
		$("#fancybox_check").attr("href",url).click();
	}
	//发布当前栏目
	function releseChannel(id){
		if(isEmpty(id)){
			id = "";
		}
		if (confirm("确定要发布？")){
			var url = "${basePath}cmsContent.do?method=relese";
			var data = "&ids="+id;			
			ajaxJsonTipByData(url,data,true);
			window.location.reload(); 
		}
	}
	//模板列表页面
	function templateForm(id){
		var data = "&cmsContentId=${cmsContent.cmsContentId}&parentCmsContentId=${cmsContent.parentCmsContentId}&cmsContentType=A&channelType=${cmsContent.channelType}";
		window.location.href = "${basePath}template.do?method=index" + data;
	}
	//预览栏目内容
	function preView(id){
 		var data = "&cmsContentId="+id;
 		window.open("${basePath}template.do?method=preview"+data);
// 		parent.$("#fancybox_template").attr("href","${basePath}template.do?method=preview"+data).click();
	}
	//预览发布内容
	function preViewPublish(url){
		parent.$("#fancybox_template").attr("href",url).click();
	}
</script>
<div style="display: none">
	<a href="#" id="fancybox_check" class="fancybox_check"></a>
</div>
<div class="M_right" id="content" style="float:left">
	<div class="control_box">
<!-- 		<div class="editMenu"> -->
<%-- 			<c:if test="${cmsContent.publishStatus == 'W' || cmsContent.publishStatus == 'B' || cmsContent.publishStatus == 'P'}"> --%>
<%-- 				<check:hasAuthority authorityID="C102"> --%>
<%-- 					<a href="javascript:void(0);" onclick="updateForm('${cmsContent.cmsContentId}');">编辑文章</a> --%>
<%-- 				</check:hasAuthority> --%>
<%-- 				<check:hasAuthority authorityID="C102"> --%>
<%-- 					<a href="javascript:void(0);" onclick="templateForm('${cmsContent.cmsContentId}');">编辑模板</a> --%>
<%-- 				</check:hasAuthority> --%>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${cmsContent.publishStatus == 'W' }"> --%>
<%-- 				<check:hasAuthority authorityID="C105"> --%>
<%-- 					<a href="javascript:void(0);" onclick="checkForm('${cmsContent.cmsContentId}');">审核</a> --%>
<%-- 				</check:hasAuthority> --%>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${cmsContent.publishStatus == 'A'}"> --%>
<%-- 				<check:hasAuthority authorityID="C106"> --%>
<%-- 					<a href="javascript:void(0);" onclick="releseChannel('${cmsContent.cmsContentId}');">发布</a> --%>
<%-- 				</check:hasAuthority> --%>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${cmsContent.publishStatus == 'P'}"> --%>
<%-- 				<check:hasAuthority authorityID="C104"> --%>
<%-- 					<a href="javascript:void(0);" onclick="preViewPublish('${cmsContent.cmsContentUrl}');">预览发布内容</a> --%>
<%-- 				</check:hasAuthority> --%>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${isAllowDel!=false }"> --%>
<%-- 				<check:hasAuthority authorityID="C108"> --%>
<%-- 					<a href="javascript:void(0);" onclick="deleteChannel('${cmsContent.cmsContentId}');">删除</a> --%>
<%-- 				</check:hasAuthority> --%>
<%-- 			</c:if> --%>
<!-- 		</div> -->
		<div class="selectCard">
			<a href="#" onclick="changeContent('C','${cmsContent.parentCmsContentId}');">栏目</a>
			<a class="curr" href="#" onclick="changeContent('A','${cmsContent.parentCmsContentId}');">文章</a>
			<input type="hidden" id="channelType" value="${cmsContent.channelType}"/>
		</div>
	</div>
	<div class="content">
		<div class="showBox">
       		文章图标：
       		<c:if test="${empty cmsContent.cmsContentImg }"><img src="${imgPath}/gms/common/images/default1.jpg" height="100px;" width="100px;"/></c:if>
       		<c:if test="${ not empty cmsContent.cmsContentImg }"><img src="${cmsContent.cmsContentImg }" height="100px;" width="100px;"/></c:if><br/><br/>
           	文章名称：${cmsContent.cmsContentName }<br/><br/>
			文章描述：<span>
			<textarea name="cmsContentDes" style="width: 480px; height: 100px;background-color:#F8F7F7;font-size:14px; line-height:21px;resize: none; overflow-y:auto; padding: 5px;" readonly="readonly">${cmsContent.cmsContentDes }</textarea>
			</span><br/><br/>
			文章状态：<c:forEach items="${publish_status}" var="type">
			<c:if test="${cmsContent.publishStatus==type.key}">${type.value}</c:if></c:forEach><br/><br/>
			是否置顶：<c:if test="${cmsContent.isTop=='Y'}">是</c:if><c:if test="${cmsContent.isTop=='N'}">否</c:if><br/><br/>
			发布时间：<c:if test="${cmsContent.publishStatus=='P'}">
				  		<fmt:formatDate value="${cmsContent.publishTime }" type="both" pattern="yyyy-MM-dd" />
				   </c:if><br/><br/>
			<check:hasAuthority authorityID="C104">
				文章内容：<a href="javascript:void(0);" class="grayBtn" onclick="preView('${cmsContent.cmsContentId}');">预览模板内容</a><br/><br/>
			</check:hasAuthority>
			<textarea id="templateData" style="display: none;" rows="" cols="">${cmsContent.templateData }</textarea>
			<div style="padding-left: 180px;">
				<a href="${basePath}cmsContent.do?method=articleIndex&parentCmsContentId=${cmsContent.parentCmsContentId}" class="grayBtn" style="background:#42748B;">返回文章列表</a>
			</div>
		</div>
	</div>
</div>