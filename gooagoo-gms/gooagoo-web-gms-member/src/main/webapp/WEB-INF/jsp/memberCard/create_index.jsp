<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
	request.setAttribute("topMenuCode", "24");
	request.setAttribute("leftMenuCode", "2401");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['cpme001']}</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<script type="text/javascript">
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";
	
	var cardIdflag = "${cardId}";

	$(function(){
		initTab("${cardType2}","${cardId}");
		initFancyBox("fancybox_pic",950,"98%",true);
	});
	function initTab(cardType,id){
		var flag = "U";		
		if(isEmpty(cardType)){
			cardType = "0";
			$('.file_nav a').eq(0).attr("style","display:block;");
			$('.file_nav a').eq(1).attr("style","display:block;");
			$('.file_nav a').eq(2).attr("style","display:block;");
		}
		if(isEmpty(id)){
			id = "";
			flag = "A";
		}
		if (cardType == "0"){
			url = basePath + "memberCard.do?method=formAttention"+flag+"&cardId=" + id;
			if(id != ""){
				$('.file_nav a').eq(0).addClass("curr").attr("id","").siblings().attr("style","display:none;");
			}
		}
		else if (cardType == "1"){
			url = basePath + "memberCard.do?method=formBase"+flag+"&cardId=" + id;
			$('.file_nav a').eq(0).attr("style","display:none;");
			$('.file_nav a').eq(1).attr("class","curr");
			$('.file_nav a').eq(1).attr("id","");
			$('.file_nav a').eq(2).attr("style","display:none;");

		}
		else if (cardType == "2"){
			url = basePath + "memberCard.do?method=formAdvance"+flag+"&cardId=" + id;
			$('.file_nav a').eq(0).attr("style","display:none;");
			$('.file_nav a').eq(1).attr("style","display:none;");
			$('.file_nav a').eq(2).attr("class","curr");
			$('.file_nav a').eq(2).attr("id","");
		}else{
			return false;
		}
		$("#content").load(url);
	}
	//上传卡背景
	function uploadPic(imgUrl){
		var url = "cardUpload.do?method=toTrimImage";
		if(imgUrl=="" || imgUrl==null){
			var data = "&src=";
		}else{
			var data = "&src="+imgUrl;			
		}
		$("#fancybox_pic").attr("href",url+data).click();
	}
	function uploadDone(src){
		closeFancyBox();
		if(!isEmpty(src)){
		    $(".up").find("img").attr("src",getScaleUrl(src,"dh_top"));
			$(".dowm").find("img").attr("src",getScaleUrl(src,"dh_bottom"));
			$("input[name=cardUrl]").val(src);
		}
	}
	function getScaleUrl(url,name){
		var index = url.lastIndexOf(".");
		var start = url.substring(0,index);
		var end = url.substring(index);
		return start + "_" + name + end;
	}
	/*面板切换*/
	function changePanel(obj){
		$(obj).removeClass().addClass('curr').siblings().removeClass();
		var getUrl = $(obj).attr("id");
		$("#content").load(getUrl);
	}
</script>
</head>
<body>
	<div style="display:none;">
		<a href="jcroup.jsp" id="fancybox_pic" class="fancybox_pic"></a>
	</div>
   	<!--头部-->
 	<%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   	<!--内容-->
    <div class="container">
      	<div class="article">
 			<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
        	<div class="section">
	          	<div class="rightTitle_add">
		            <span>${shopVo.wordNames['cpme009']}</span>
	          	</div>
	          	<div class="file_nav">
		            <a href="javascript:void(0);" id="${basePath}memberCard.do?method=formAttentionA" onclick="changePanel(this);" class="curr">${shopVo.wordNames['cpme010']}</a>
		            <a href="javascript:void(0);" id="${basePath}memberCard.do?method=formBaseA" onclick="changePanel(this);">${shopVo.wordNames['cpme011']}</a>
		            <a href="javascript:void(0);" id="${basePath}memberCard.do?method=formAdvanceA" onclick="changePanel(this);">${shopVo.wordNames['cpme012']}</a>
	          	</div>
	          	<div id="content">
	          	
	          	</div>
           	</div>
        </div>
	</div>
    <!--用户状态-->
 	<%@ include file="/WEB-INF/jsp/common/right.jsp"%>
</body>
</html>
