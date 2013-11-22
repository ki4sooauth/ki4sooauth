<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath }/cms/css/edit.css" rel="stylesheet" type="text/css" />
<link href="${imgPath }/cms/css/showBox.css" rel="stylesheet" type="text/css" />
<link href="${imgPath }/cms/css/article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function(){
		initFancyBox2("fancybox_check", 324, 200,true);
		page(1);
	});
	function page(index){
		if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		
		pIndex = index;
		var data = "&pageIndex="+index+"&cmsContentType=A&parentCmsContentId=${parentCmsContentId}&publishStatus="+status;
		ajaxToPageByData("${basePath}cmsContent.do?method=page","tableList",data);
	}
	//添加页面
	function addForm(){
		var parentCmsContentId = "${parentCmsContentId}";
		var data = "&cmsContentType=A&parentCmsContentId=" + parentCmsContentId;
		window.location.href = "${basePath}cmsContent.do?method=formA" + data;
	}
	//修改页面
	function updateForm(){
		var parentCmsContentId = "${parentCmsContentId}";
		ids = getIds();
		statuses = getStatuses();
		
		if(isEmpty(ids)){
			alert("请选择要操作的记录！");
			return;
		}else if(ids.length>32){
			alert("只能选择一条记录进行修改操作！");
			return;
		}else if("A" == statuses){
			alert("信息已审核不能修改！");
			return;
		}
		var data = "&cmsContentType=A&cmsContentId=" + ids+ "&parentCmsContentId="+parentCmsContentId;
		window.location.href = "${basePath}cmsContent.do?method=formU" + data;
	}
	//删除文章
	function deleteArticle(){
		ids = getIds();
		if(isEmpty(ids)){
			alert("请选择要操作的记录！");
			return;
		}
		if (confirm("确定删除吗?")){
			var url = "${basePath}cmsContent.do?method=delete";
			var data = "&ids="+ids;			
			ajaxJsonTipByData(url,data,true);
			page(pIndex);
		}
		changeStyle();
	}
	//预览发布后的内容
	function preViewPublish(){
		ids = getIds();
		statuses = getStatuses();

		if(isEmpty(ids)){
			alert("请选择要操作的记录！");
			return;
		}else if(ids.length>32){
			alert(ids);
			alert("只能选择一条记录进行操作！");
			return;
		}else if("P" != statuses){
			alert("信息未发布不能预览！");
			return;
		}
		var cmsContentUrl = $(".articleTable").find("input:checked").closest("td").find("#cmsContentUrl").val();
// 		parent.$("#fancybox_template").attr("href",cmsContentUrl).click();
		window.open(cmsContentUrl);
	}
	//审核页面
	function checkForm(){
		changeStyle();
		ids = getIds();
		statuses = getStatuses();
		var templateData = $(".articleTable").find("input:checked").closest("td").find("#templateData").text();

		if(isEmpty(ids)){
			alert("请选择要操作的记录！");
			return;
		}else if(ids.length>32){
			alert("只能选择一条记录进行审核操作！");
			return;
		}else if(isEmpty($.trim(templateData))){
			alert("请先编辑模板内容！");
			return;
		}else if("A" == statuses){
			alert("信息已审核不能再审核！");
			return;
		}else if("B" == statuses){
			alert("请修改信息后再进行审核！");
			return;
		}else if("P" == statuses){
			alert("信息已发布不能进行审核！");
			return;
		}
		var url = "${basePath}cmsContent.do?method=checkForm&cmsContentId="+ids+"&cmsContentType=A";
		$("#fancybox_check").attr("href",url).click();
	}
	//发布文章
	function releseArticle(){
		changeStyle();
		ids = getIds();
		statuses = getStatuses();
		if(isEmpty(ids)){
			alert("请选择要操作的记录！");
			return;
		}else if(statuses.indexOf("W")!=-1 || statuses.indexOf("B")!=-1 || statuses.indexOf("P")!=-1 ){
			alert("请选择已审核通过的文章进行发布！");
			return;
		}
		if (confirm("确定要发布？")){
			var url = "${basePath}cmsContent.do?method=relese";
			var data = "&ids="+ids;			
			$.ajax({
				type: "POST",
				async: false,
				url: url,
				data: data,
				dataType: "json",
				success: function(ret){
					if(ret.success){
						alert(ret.message+" "+ret.extend+" 条信息！");
						page(pIndex);
					}else{
						alert(ret.message);
					}
				}
			});
		}
	}
	//模板列表页面
	function templateForm(){
		var ids = getIds();
		if(isEmpty(ids)){
			alert("请选择要操作的记录！");
			return;
		}else if(ids.length>32){
			alert("只能选择一条记录进行编辑模板操作！");
			return;
		}
		var id = $(".articleTable").find("input:checked").val();
		var channelType = $(".articleTable").find("input:checked").closest("td").find("#channelType").val();
		var parentCmsContentId = $(".articleTable").find("input:checked").closest("td").find("#parentCmsContentId").val();
		var data = "&cmsContentId="+id+"&parentCmsContentId="+parentCmsContentId+"&cmsContentType=A&channelType="+channelType;
		window.location.href = "${basePath}template.do?method=index" + data;
	}
	//预览
	function preView(){
		changeStyle();
		var ids = getIds();
		if(isEmpty(ids)){
			alert("请选择要操作的记录！");
			return;
		}else if(ids.length>32){
			alert("只能选择一条记录进行预览！");
			return;
		}
		
		var id = $(".articleTable").find("input:checked").val();
 		var data = "&cmsContentId="+id;
 		window.open("${basePath}template.do?method=preview"+data);
// 		parent.$("#fancybox_template").attr("href","${basePath}template.do?method=preview"+data).click();
	}
	//查看文章详细
	function getArticle(id){
		window.location.href = "${basePath}cmsContent.do?method=getCmsContent&cmsContentId=" + id + "&cmsContentType=A";
	}
	//获取id值
	function getIds(){
		var ids = "";
		$(".articleTable .num input[type='checkbox']").each(function(){
			if($(this).prop('checked')){
				ids　=　ids　+　$(this).val()　+　',';
			}
		})
		ids = ids.substring(0, ids.length-1);
		return ids;
	}
	//获取status值
	function getStatuses(){
		var statuses = "";
		$(".articleTable .num input[type='checkbox']").each(function(){
			if($(this).prop('checked')){
				statuses　=　statuses　+　$(this).next("input").val()　+　',';
			}
		})
		statuses = statuses.substring(0, statuses.length-1);
		return statuses;
	}
	function changeStyle(){
		$('.editMenu a').each(function(){
			$(this).click(function(){
				$(this).removeClass();
			});
		});
	}
</script>
</head>
<body>
	<div style="display: none">
		<a href="#" id="fancybox_check" class="fancybox_check"></a>
		<a href="#" id="fancybox_pre" class="fancybox_pre"></a>
	</div>
	<!-- 头部 -->
	<div class="M_right">
		<div class="control_box">
			<div class="editMenu">
				<a href="javascript:void(0);" onclick="addForm();">添加文章</a>
				<a href="javascript:void(0);" onclick="updateForm();">编辑文章</a>
				<a href="javascript:void(0);" onclick="templateForm();">编辑模板</a>
				<a href="javascript:void(0);" onclick="preViewPublish()">预览发布内容</a>
				<a href="javascript:void(0);" onclick="checkForm();">审核</a>
				<a href="javascript:void(0);" onclick="releseArticle();">发布</a>
				<a href="javascript:void(0);" onclick="deleteArticle();">删除</a>
			</div>
			<div class="selectCard">
				<a href="#" onclick="changeContent('C','${parentCmsContentId}');">栏目</a>
				<a class="curr" href="#" onclick="changeContent('A','${parentCmsContentId}');">文章</a>
			</div>
		</div>
		<div class="articleList" style="height: 31px;">
			<span  class="num">序号</span>
			<span class="articleTitle">文章标题</span>
			<span class="time">发布时间</span>
			<span class="status">状态</span>
		</div>
		<!-- 文章列表 -->
		<div id="tableList">
		</div>
	</div>
</body>
</html>