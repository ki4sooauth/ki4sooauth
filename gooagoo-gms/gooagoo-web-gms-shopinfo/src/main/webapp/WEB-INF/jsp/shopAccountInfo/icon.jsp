<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<html>
<head>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1401");
request.setAttribute("leftMenuCode", "140103");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsg006']}</title>

<link href="${imgPath}/gms/common/css/image_alter.css" rel="stylesheet" type="text/css" />

<%-- <script type="text/javascript" src="${imgPath}/gms/shopinfo/js/logo.js"></script> --%>
</head>
<script type="text/javascript">
$(document).ready(function(){
	  initFancyBox("fancybox_pic",950,"98%",true);
})
function page(){
// 	var data ={"pageIndex":pageIndex,"pageSize":10};
	var url="${basePath}/headAction.do?method=getHeadPic";
	ajaxToPageByData(url, "icon1", "");
}
var imgflag="0";
function flagValue(f){
	imgflag=f;

}
function uploadPic(f){
	var url = "upload.do?method=toTrimImage";
	var src="&src="+f;
	if(imgflag=="Y"){
		var data= "&w=300&h=210&tsize=b_118_118&tsize=s_60_60";
	}else{
		var data= "&w=300&h=210&tsize=s_134_64";
	}
	$("#fancybox_pic").attr("href",url+src+data).click();
// 	$("#fancybox_pic").attr("href","upload.do?method=toTrimImage&src=http://img.gooagoo.com/common/jcroup/demos/demo_files/sago.jpg&tsize=b_500_500&tsize=s_100_100").click();
}

function uploadDone(src){
	closeFancyBox();
	if(imgflag=="Y"){
		$("#imgOld").val(src);
		$("#imgpic").attr("src",src);
		$("#pic_o").attr("src",src);
// 		$("#pic_b").attr("src",getScaleUrl(src,"b"));
		$("#pic_s").attr("src",getScaleUrl(src,"s"));
	}else{
		$("#imgOld1").val(src);
		$("#imgpic1").attr("src",src);
		$("#pic_o1").attr("src",src);
// 		$("#pic_b1").attr("src",getScaleUrl(src,"b"));
		$("#pic_s1").attr("src",getScaleUrl(src,"s"));
	}
	
}
function getScaleUrl(url,name){
	var index = url.lastIndexOf(".");
	var start = url.substring(0,index);
	var end = url.substring(index);
	return start + "_" + name + end;
}
function saveImg(){	//保存处理(保存原图)
	if(imgflag=="Y"){
		var img =$("#imgOld").val();
		var url="${basePath}/headAction.do?method=updateUPic";
		var data={"shImg":img};
	}else{
		
		var img =$("#imgOld1").val();
		var url="${basePath}/headAction.do?method=updateSPic";
		var data={"suImg":img};
	}
	if(img==null || img==""){
		alert('请选择需要上传的图片');
		return false;
	} else {
		
		$.ajax({
			type : "POST",
			async : false,
			url : url,
			data:data,
			dataType : 'json',
			success : function(data) {
				if(data.success){
					  alert(data.message);
				}else{
					alert(data.message);
					return false;
				}
			}
			  
		});
	}
	if(imgflag=="N"){
		location.reload() ;
	}
}
</script>
<body>
   <!--头部-->
   <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">
      <div class="article">
                 <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
        <div class="section">
        <div class="rightTitle_add">
            <span>${shopVo.wordNames['gmsg006']}</span>
          </div>
          <div class="alter_box">
          	<div class="alterBoxTop">
          	<input type="hidden" id="imgOld" value="${headPic.suImg}">
          	<a href="javascript:void(0);" class="blueBtn fancybox_pic"  onclick="flagValue('Y');uploadPic($('#imgOld').val());">${shopVo.wordNames['gmsg048']}</a>
            ${shopVo.wordNames['gmsg049']}
            </div>
            <div class="alterBoxLeft">
            	<u><img src="<c:if test='${empty headPic.suImg}'>${imgPath}/gms/shopinfo/images/qs.jpg</c:if><c:if test='${not empty headPic.suImg}'>${headPic.suImg}</c:if>" width="250" height="250" id="imgpic"/></u><br /><br />
<!--                 <p> -->
<%--                 ${shopVo.wordNames['gmsg051']} --%>
<!--                 </p> -->
            </div>
         <div class="alterBoxRight">
            	<dl>
                	<dt>${shopVo.wordNames['gmsg050']}</dt>
                    <dd>
                    	<img width="60" height="60" id="pic_o" src="${headPic.suImg }" />
                        <p>60*60</p>
                    </dd>
                    <dd>
                    	<img width="118" height="118" id="pic_s" src="${headPic.suSmallImg }" />
                        <p>118*118</p>
                    </dd>
                </dl>
            </div>
             <a href="#" class="confirm_btn blueBtn" onclick="flagValue('Y');saveImg();">${shopVo.wordNames['gmsg053']}</a>
          </div>
        <div class="alter_box">
          	<div class="alterBoxTop">
          	<input type="hidden" id="imgOld1" value="${headPic.shImg}">
            	<a href="javascript:void(0);" onclick="flagValue('N');uploadPic($('#imgOld1').val());" class="blueBtn">${shopVo.wordNames['gmsg052']}</a>
                ${shopVo.wordNames['gmsg049']}                               
            </div>
            <div class="alterBoxLeft">
            	<img width="461" height="200" id="imgpic1" src="${headPic.shImg }" />
<!--                 <p> -->
<%--                     ${shopVo.wordNames['gmsg051']} --%>
<!--                 </p> -->
            </div>
   			<div class="alterBoxRight">
            	<dl>
                	<dt>${shopVo.wordNames['gmsg050']}</dt>
                    <dd>
                    	<img width="134" height="64" id="pic_s1" src="${headPic.shSmallImg }" />
                        <p>134*64</p>
                    </dd>
                </dl>
            </div>
             <a href="#" class="confirm_btn blueBtn" onclick="flagValue('N');saveImg();">${shopVo.wordNames['gmsg053']}</a>
          </div>
      </div>
  </div>
  <div style="display: none;">
  <a id="fancybox_pic" class="fancybox_pic"></a>
  </div>
</body>
</html>
