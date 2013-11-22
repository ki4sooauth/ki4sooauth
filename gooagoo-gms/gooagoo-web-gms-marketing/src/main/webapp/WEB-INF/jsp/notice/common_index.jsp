<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsd105']}</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script type='text/javascript' src='${imgPath}/common/js/kindeditor/kindeditor-min.js' charset='utf-8'></script>
<link rel="stylesheet" href="${imgPath}/common/js/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="${imgPath}/common/js/kindeditor/lang/zh_CN.js"></script>
<script src="${imgPath}/gms/common/js/popLB.js"></script>
<link href="${imgPath}/gms/common/css/add_actPop.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/template.js"></script>
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script >
$(document).ready(function(){
	var uri=$('#img').val();
	if(!isEmpty(uri)){
		listImg(uri);
	}
	pageEdit("${id}");
	intFancybox2();
});

function pageEdit(id){
	var method="editform";
	if(isEmpty(id)){
		id="";
		method="addform";
	}
	ajaxToPageByData("${basePath}/notice.do?method="+method+"&id="+id,"waitRelateCont","");
}

function intFancybox2(){
	$(".fancybox_relate").fancybox({
		'width'				: 810,
		'height'			: 570,
		'padding'			: 0,
		'autoScale'			: false,
		'autoDimensions'    : true,
		'transitionIn'		: 'yes',
		'transitionOut'		: 'yes',
		'href'				: $(this).attr('href'),
		'type'				:'iframe',
		'hideOnOverlayClick': false,
		'showCloseButton'	:true,
		'changeSpeed'		:200,
		'onStart'			:function(){if(!checkIsOnly()){return false;}}
	});
}
function checkIsOnly(){
	if($("#textWeb").val().indexOf("<a id=\"marketingLink\"")!=-1){
		alert("只能添加一条信息！");
		return false;
	}else{
		return true;
	}
}
function saveNotice(bj){
	$("#btn").attr("disabled","disabled");
	var cont = $("#textWeb").val().replace(/<.+?>/gim,'').replace(/&nbsp;/ig,'').replace(/(^\s+)|(\s+$)/g,"")
	var title = $("#notice input[name=noticeTitle]").val();
	var activityName=$("#notice input[name=activityName]").val();
	var activeStartTime=$("#notice input[name=activeStartTime]").val();
	var activeEndTime=$("#notice input[name=activeEndTime]").val();
	var activityId=$("#notice input[name=activityId]").val();
	var marketingId=$("#marketingId").val();
	if(title==null || title==""){
    	$("#btn").attr("disabled",false);
    	alert("通知标题不能为空");
    	return false;
    }
    if (isEmpty(cont)) {
    	$("#btn").attr("disabled",false);
		alert("请添加通知内容！");
		return false;
	}
    var url = "${basePath }notice.do?method=${empty marketingId ?'update':'add'}";
    var data = $("#notice").serialize()+"&marketingId="+marketingId;
	   $.ajax({
			type: "POST",
			async: false,
			url: url,
			data: data,
			dataType: "json",
			success: function(ret){
				
				if(ret.success){			
					var id=ret.extend;
					if(!isEmpty(id)){
						if(!isEmpty(id)){
							if(!isEmpty("${id}")){
								id=$("#noticeInfoId").val();
							}	
							}
						if(bj=='release'){
							formReleaseCont(id,title,activityName,activeStartTime,activeEndTime);
						}else{
							alert(ret.message);	
							 window.location.href="${basePath}/notice.do?method=index";
						}	
					 }
				 }				
		    }									
	});
}



// 发布通知页
function formReleaseCont(id,title,activityName,activeStartTime,activeEndTime){
   	if(isEmpty(id)){
   		id="";	
   	}
	if(isEmpty(title)){
		title="";	
	}
	if(isEmpty(activityName)){
		activityName="";	
	}
	if(isEmpty(activeStartTime)){
		activeStartTime="";	
	}
	if(isEmpty(activeEndTime)){
		activeEndTime="";	
	}
   	var data = "&contentId="+id+"&channelCode=2&noticeTitle="+title+"&activityName="+activityName+"&activeStartTime="+activeStartTime+"&activeEndTime="+activeEndTime;
   	var url = "${basePath}/notice.do?method=pulishCondition";
   	window.location.href =url+data;
	
}
 function relateFancyBox(type){
	 var url = "";
	 if(type=="Goods"){
		 url = "${basePath }relation.do?method=listRelation&selectType=&relateType=G&marketingId=${marketingId}";
	 }else if(type=="Coupon"){
		 url = "${basePath }relation.do?method=listRelation&selectType=&relateType=C&dataType=C&marketingId=${marketingId}";
	 }else if(type=="Activity"){
		 url = "${basePath }relation.do?method=listRelation&selectType=&relateType=A&marketingId=${marketingId}";
	 }
	$("#relateFancybox").attr("href",url).click();
 }
 function dealRelations(relations){
	 $("#marketingLinkType").val(relations[0][0]);
	 $("#marketingLinkId").val(relations[0][1]);
	 var url = "#";
	 if(relations[0][0]=='A'){
		 url = relations[0][7];
	 }else{
		 url = relations[0][9];
	 }
	 var cont = " <a id='marketingLink' href='"+url+"' class='marketingLink'>"+relations[0][2]+"</a> ";
	 editor.insertHtml(cont);
	 
	 listImg(relations[0][3]);
	 $.fancybox.close();
}
function listImg(url){
	if(isEmpty(url)){
		return;
	}
	var urls = url.split(",");
	var imgList = $("#relateImgList");
	imgList.html("");
	for(var i=0;i<urls.length;i++){
		var cont = "<li><a href='javascript:void(0);'><img onclick='selectImg(this.src)' src='"+urls[i]+"' width='130' height='130' /></a></li>";
		imgList.append(cont);
	}
	imgList.css("display","");
	$("#relateImg").css("display","");
	//$("#imgTip").css("display","");
	$("#img").val(urls[0]);
	$("#relateImg").find("img").attr("src",urls[0]);
}
function selectImg(url){
	alert(url);
	$("#img").val(url);
	alert($("#img").val());
	$("#relateImg").find("img").attr("src",url);
}
</script>
</head>
<body>

  <!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
    <input type="hidden" name="marketingId" id="marketingId" value="${marketingId}"/>
   <div class="container"> 
   <div class="article"> 
	<div class="add_actPopBox">
        <!-- 内容 -->  
	    <div  id="waitRelateCont" >
		</div>
	</div>
	</div>
	</div>
</body>
</html>
