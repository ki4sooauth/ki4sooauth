<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>图片上传</title>

<style>
.firsd label a.way{background:url(${imgPath}/gms/marketing/images/after-01.png) no-repeat left top;}
</style>
<script>
$(function(){
	initFancyBox("fancybox_pic",950,"98%",true);
});
function uploadPic(){
	$("#fancybox_pic").attr("href","upload.do?method=toTrimImage&src="+${imgPath}+"/common/jcroup/demos/demo_files/sago.jpg&tsize=b_500_500&tsize=s_100_100").click();
}
function uploadDone(src){
	closeFancyBox();
	$("#pic_o").attr("src",src);
	$("#pic_b").attr("src",getScaleUrl(src,"b"));
	$("#pic_s").attr("src",getScaleUrl(src,"s"));
}
function getScaleUrl(url,name){
	var index = url.lastIndexOf(".");
	var start = url.substring(0,index);
	var end = url.substring(index);
	return start + "_" + name + end;
}
</script>
</head>
<body>
<div style="display:none;">
	<a href="jcroup.jsp" id="fancybox_pic" class="fancybox_pic"></a>
</div>
<div class="box">
	<div id="page_content">
	<input style="margin-left:60px;margin-top:20px;" type="button" onclick="uploadPic();" value="修改图片"/>
	</div>
	<img id="pic_o" src="" />
	<img id="pic_b" src=""/>
	<img id="pic_s" src=""/>
</div>
</body>
</html>

