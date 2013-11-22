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
	//添加页面
	function addForm(){
		var parentCmsContentId = "${cmsContent.cmsContentId }";
		var data = "&cmsContentType=C&parentCmsContentId=" + parentCmsContentId;
		window.location.href = "${basePath}cmsContent.do?method=formA" + data;
	}
	//修改栏目
	function updateForm(id){
		if(isEmpty(id)){
			id = "";
		}
		var data = "&cmsContentType=C&cmsContentId=" + id + "&parentCmsContentId="　+　id;
		window.location.href = "${basePath}cmsContent.do?method=formU" + data;
	
	}
	//删除栏目
	function deleteChannel(id){
		if(isEmpty(id)){
			id = "";
		}
		var treeObj = parent.$.fn.zTree.getZTreeObj("treeDemo");
		var sNodes = treeObj.getSelectedNodes();
		var level="";
		if (sNodes.length > 0) {
			level = sNodes[0].level;
		}
		if(level==0){
			alert("根栏目不能删除！");
			return;
		}
		if (confirm("\t\t    确定要删除吗？\n\n点击“确定”将删除当前信息及其所有子级cms内容信息！")){
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
		var url = "${basePath}cmsContent.do?method=checkForm&cmsContentId="+id+"&cmsContentType=C";
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
	//发布当前栏目及栏目下所以信息
	function releseAllChannel(id){
		if (confirm("确定要当前节点及节点下所有内容发布？")){
			var url = "${basePath}cmsContent.do?method=releseAll";
			var data = "&cmsContentId="+id;			
			ajaxJsonTipByData(url,data,true);
			window.location.reload(); 
		}
	}
	//模板列表页面
	function templateForm(id){
		var data = "&cmsContentId="+id+"&cmsContentType=C&channelType=${cmsContent.channelType}";
		window.location.href = "${basePath}template.do?method=index" + data;
	}
	//预览栏目内容
	function preView(id){
 		var data = "&cmsContentId="+id;
 		window.open("${basePath}template.do?method=preview"+data);
// 		parent.$("#fancybox_template").attr("href","${basePath}template.do?method=preview"+data).click();
	}
	//预览发布内容
// 	function preViewPublish(url){
// 		parent.$("#fancybox_template").attr("href",url).click();
// 	}
</script>
<div style="display: none">
	<a href="#" id="fancybox_check" class="fancybox_check"></a>
</div>
<div class="M_right" id="content" style="float:left">
	<div class="control_box">
		<div class="editMenu">
			<check:hasAuthority authorityID="C101">
				<a href="javascript:void(0);" onclick="addForm();">添加子栏目</a>
			</check:hasAuthority>
			<c:if test="${cmsContent.publishStatus == 'W' || cmsContent.publishStatus == 'B' || cmsContent.publishStatus == 'P'}">
				<check:hasAuthority authorityID="C102">
					<a href="javascript:void(0);" onclick="updateForm('${cmsContent.cmsContentId}');">编辑栏目</a>
				</check:hasAuthority>
				<check:hasAuthority authorityID="C102">
					<a href="javascript:void(0);" onclick="templateForm('${cmsContent.cmsContentId}');">编辑模板</a>
				</check:hasAuthority>
			</c:if>
			<c:if test="${cmsContent.publishStatus == 'W' }">
				<check:hasAuthority authorityID="C105">
					<a href="javascript:void(0);" onclick="checkForm('${cmsContent.cmsContentId}');">审核</a>
				</check:hasAuthority>
			</c:if>
			<c:if test="${cmsContent.publishStatus == 'A'}">
				<check:hasAuthority authorityID="C106">
					<a href="javascript:void(0);" onclick="releseChannel('${cmsContent.cmsContentId}');">发布</a>
				</check:hasAuthority>
				<check:hasAuthority authorityID="C107">
					<a href="javascript:void(0);" onclick="releseAllChannel('${cmsContent.cmsContentId}');">全部发布</a>
				</check:hasAuthority>
			</c:if>
			<c:if test="${cmsContent.publishStatus == 'P'}">
				<check:hasAuthority authorityID="C104">
					<a href="javascript:void(0);" onclick="window.open('${cmsContent.cmsContentUrl}');">预览发布内容</a>
				</check:hasAuthority>
			</c:if>
			<c:if test="${isAllowDel!=false }">
				<check:hasAuthority authorityID="C108">
					<a href="javascript:void(0);" onclick="deleteChannel('${cmsContent.cmsContentId}');">删除</a>
				</check:hasAuthority>
			</c:if>
		</div>
		<div class="selectCard">
			<a class="curr" href="#" onclick="changeContent('C','${cmsContent.cmsContentId}');">栏目</a>
			<a href="#" onclick="changeContent('A','${cmsContent.cmsContentId}');">文章</a>
			<input type="hidden" id="channelType" value="${cmsContent.channelType}"/>
		</div>
	</div>
	<div class="content">
		<div class="showBox">
       		栏目图标：
       		<c:if test="${empty cmsContent.cmsContentImg }"><img src="${imgPath}/gms/common/images/default1.jpg" height="100px;" width="100px;"/></c:if>
       		<c:if test="${ not empty cmsContent.cmsContentImg }"><img src="${cmsContent.cmsContentImg }" height="100px;" width="100px;"/></c:if><br/><br/>
           	栏目名称：${cmsContent.cmsContentName }<br/><br/>
			栏目描述：<span>
			<textarea name="cmsContentDes" style="width: 480px; height: 100px;background-color:#F8F7F7;font-size:14px; line-height:21px;resize: none; overflow-y:auto; padding: 5px;" readonly="readonly">${cmsContent.cmsContentDes }</textarea>
			</span><br/><br/>
			栏目状态：<c:forEach items="${publish_status}" var="type">
			<c:if test="${cmsContent.publishStatus==type.key}">${type.value}</c:if></c:forEach><br/><br/>
			发布时间：<c:if test="${cmsContent.publishStatus=='P'}">
				  		<fmt:formatDate value="${cmsContent.publishTime }" type="both" pattern="yyyy-MM-dd" />
				   </c:if><br/><br/>
			<check:hasAuthority authorityID="C104">
				栏目内容：<a href="javascript:void(0);" class="grayBtn" onclick="preView('${cmsContent.cmsContentId}');">预览模板内容</a><br/><br/>
			</check:hasAuthority>
			<textarea id="templateData" style="display: none;" rows="" cols="">${cmsContent.templateData }</textarea>
		</div>
	</div>
</div>