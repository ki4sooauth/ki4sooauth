<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目编辑页面</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath }/cms/css/edit.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="display:none;">
		<a href="#" id="fancybox_pic" class="fancybox_pic"></a>
		<a href="#" id="fancybox_channelContent" class="fancybox_pic"></a>
	</div>
	<div class="M_right">
		<div class="control_box">
			<div class="selectCard">
				<a class="curr" href="#" onclick="changeContent('C','${empty cmsContent.cmsContentId ? parentCmsContentId : cmsContent.cmsContentId}');">栏目</a>
				<a href="#" onclick="changeContent('A','${empty cmsContent.cmsContentId ? parentCmsContentId : cmsContent.cmsContentId}');">文章</a>
			</div>
		</div>
		<div class="content">
			<form id="cmsContentValues" action="" method="post" enctype ="multipart/form-data">
				<div class="title">
					<i></i>位置：编辑
				</div>
				<div class="editContent">
					<div class="imgbox">
						<c:if test="${empty cmsContent.cmsContentImg }">
							<img width="100" height="100" id="cmsContentImg" src="${imgPath}/gms/common/images/default1.jpg" onclick="uploadPic();" style="cursor: pointer;">
							<input type="hidden" name="cmsContentImg" value="${imgPath}/gms/common/images/default1.jpg" />
						</c:if>
						<c:if test="${not empty cmsContent.cmsContentImg }">
							<img width="100" height="100" id="cmsContentImg" src="${cmsContent.cmsContentImg }" onclick="uploadPic();" style="cursor: pointer;"/> 
							<input type="hidden" name="cmsContentImg" value="${cmsContent.cmsContentImg }" />
						</c:if>
						<input type="hidden" id="imgUrl" value="${imgPath}/gms/common/images/default1.jpg" />
						<a href="#" class="change" onclick="uploadPic();" >上传图片</a>
					</div>
					栏目名称：
					<input type="text" name="cmsContentName" value="${cmsContent.cmsContentName }" maxlength="50" <c:if test="${cmsContent.parentCmsContentId == '-1'}">disabled="disabled"</c:if>/><br/><br/>
					排序编号：
					<input type="text" class="age" name="orderNo" value="${empty cmsContent.orderNo ? '1' : cmsContent.orderNo}" <c:if test="${cmsContent.parentCmsContentId == '-1'}">disabled="disabled"</c:if>/><br/><br/> 
					栏目介绍：
					<textarea name="cmsContentDes" style="width: 415px; height: 100px;resize: none; overflow-y:auto; padding: 5px;" rows="" cols="" maxlength="250"
	            		onkeydown='countChar("cmsContentDes","counter");' onkeyup='countChar("cmsContentDes","counter");' onfocus='countChar("cmsContentDes","counter");'>${cmsContent.cmsContentDes}</textarea>
	            	<span style="display: block;width:500px;"><font style="float: right; color: gray;">可以输入<span id="counter">250</span>字</font><br/></span>
					<input type="hidden" name="cmsContentId" value="${cmsContent.cmsContentId }" />
					<input type="hidden" name="cmsContentType" value="C" />
					<input type="hidden" name="parentCmsContentId" value="${empty cmsContent.parentCmsContentId ? parentCmsContentId : cmsContent.parentCmsContentId}" />
					<input type="hidden" name="isTop" value="N" />
					<a href="#" class="save" onclick="doSubmit();">保存</a>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		//+图片上传
		$(function(){
			initFancyBox2("fancybox_pic",745,"50%",true); 
			initFancyBox2("fancybox_channelContent",950,"98%",true); 
			bindIntLimited("age");
		 	clearHiddImg();
		});
		function uploadPic(){
			var imgUrl= $("#cmsContentImg").attr("src");
			$("#fancybox_pic").attr("href","${basePath}upload.do?method=toTrimImage&src="+imgUrl+"&tsize=s_60_60").click();
		}
		function uploadDone(src){
			closeFancyBox();
			var width = $("#cmsContentImg").width();
			var heigth = $("#cmsContentImg").height();
			var tsize = [width, heigth];
			$("#imgUrl").val(src);
			$("input[name='cmsContentImg']").val(src);
			$("#cmsContentImg").attr("src",src);
			$("#cmsContentImg").attr("tsize",tsize);
		}
		//清空隐藏input活动图片值 
		function clearHiddImg(){
		 	var imgUrl = $("#cmsContentImg").attr("src");
		 	if(imgUrl == "" || imgUrl == null){
		 		$("#imgUrl").val("");
		 		$("#cmsContentImg").attr("src","${imgPath}/gms/common/images/default1.jpg");
		 	}
		}
		//编辑栏目内容
		function updateChannelContent(){
			$("#fancybox_pic").attr("href","upadate").click();
		}
		//保存
		function doSubmit(){
			$(".savebtn").attr("disabled","disabled");
			
			if(checkValue()){
			    var url = "${basePath}cmsContent.do?method=${empty cmsContent.cmsContentId ? 'add':'update'}";
			    var data = $("#cmsContentValues").serialize();
			    var id = "${cmsContent.cmsContentId}";
			  	$.ajax({
			        type: "POST",
			        async: false,
			        url: url,
			        data: data,
			        dataType: "json",
			        success: function(ret){
		            	alert(ret.message);
			        	if(ret.success){
			        		if(isEmpty(id)){
			        			id = ret.extend;
			        		}
			        		parent.window.location.href = "${basePath}cmsContent.do?method=index&cmsContentType=C&initCode="+id;
			            }else{
			        		$(".savebtn").attr("disabled",false);
			            }
			        }
			  	});
			}else{
				$(".savebtn").attr("disabled",false);
			}
		}
		//校验
		function checkValue(){
			var cmsContentName = $("input[name=cmsContentName]");
			var orderNo = $("input[name=orderNo]");

			if(isEmpty($.trim(cmsContentName.val()))){
		    	alert("栏目名称不能为空！");
		    	cmsContentName.focus();
		    	return false;
		    }
			if(isEmpty($.trim(orderNo.val()))){
		    	alert("排列序号不能为空！");
		    	orderNo.focus();
		    	return false;
		    }
			return true;
		}
		//统计文本框输入的文字个数
		function countChar(textareaName,spanName)
		{ 
			$("#"+spanName).html(250 - $("textarea[name='"+textareaName+"']").val().length);
		} 
	</script>
</body>
</html>