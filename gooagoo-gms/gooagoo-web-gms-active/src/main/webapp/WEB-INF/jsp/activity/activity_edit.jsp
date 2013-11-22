<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
	request.setAttribute("topMenuCode", "12");
	request.setAttribute("leftMenuCode", "");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${empty shopVo.wordNames['gmsc047'] ? '编辑活动' : shopVo.wordNames['gmsc047']}</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script type="text/javascript" src="${imgPath}/common/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	//+图片上传
	$(function(){
		initFancyBox("fancybox_pic",950,"98%",true); 
	 	clearHiddImg();
	});
	function uploadPic(){
		var imgUrl= $("#activityImg").attr("src");
		$("#fancybox_pic").attr("href","upload.do?method=toTrimImage&src="+imgUrl+"&tsize=b_572_572&tsize=m_260_260&tsize=s_90_90").click();
	}
	function uploadDone(src){
		closeFancyBox();
		var width=$("#activityImg").width();
		var heigth=$("#activityImg").height();
		var tsize=[width,heigth];
		$("#imgUrl").val(src);
		$("#activityImg").attr("src",src);
		$("#activityImg").attr("tsize",tsize);
	}
	//清空隐藏input活动图片值 
	function clearHiddImg(){
	 	var imgUrl= $("#activityImg").attr("src");
	 	if(imgUrl=="" || imgUrl==null){
	 		$("#imgUrl").val("");
	 		$("#activityImg").attr("src","${imgPath}/gms/common/images/default1.jpg");
	 	}
	}
	//保存
	function saveActivity(){
		$(".savebtn").attr("disabled","disabled");
		if(checkValue()){
		    var url = "${basePath }activity.do?method=${empty activity.activityId ? 'create':'update'}";
		    var data = $("#activity").serialize();
		  	$.ajax({
		        type: "POST",
		        async: false,
		        url: url,
		        data: data,
		        dataType: "json",
		        success: function(ret){
	            	alert(ret.message);
		        	if(ret.success){
	        			window.location.href="${basePath}activity.do?method=index";
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
		var name = $("#activity input[name=activityName]");
		var title = $("#activity input[name=title]");
		var purpose = $("#activity textarea[name=purpose]");
		var content = $("#activity textarea[name=content]");
		var startTime = $("#activity input[name=startTime]");
		var endTime = $("#activity input[name=endTime]");
		var description = $("#activity textarea[name=description]");
		var imgUrl = $("#activity input[name=imgUrl]").val();
	
	    var currentTime = "${currentTime}";
	    currentTime = currentTime.replace(/-/g,"/");
	    var startTimeVal = startTime.val().replace(/-/g,"/");
	    var endTimeVal = endTime.val().replace(/-/g,"/");
		if(isEmpty($.trim(name.val()))){
	    	alert("活动名称不能为空！");
	    	name.focus();
	    	return false;
	    }
	    if(isEmpty($.trim(title.val()))){
	    	alert("活动标题不能为空！");
	    	title.focus();
	    	return false;
	    }
	    if(isEmpty($.trim(purpose.val()))){
	    	alert("活动目的不能为空！");
	    	purpose.focus();
	    	return false;
	    }
	    if(isEmpty($.trim(content.val()))){
	    	alert("活动内容不能为空！");
	    	content.focus();
	    	return false;
	    }
	    if(isEmpty(startTime.val())){
	    	alert("活动的开始时间不能为空！");
	    	startTime.focus();
	    	return false;
	    }else if(Date.parse(currentTime)-Date.parse(startTimeVal)>0){
	        alert("活动的开始时间不能小于当前时间！");
	        startTime.focus();
	        return false;
	    }
	    if(isEmpty(endTime.val())){
	    	alert("活动的结束时间不能为空！");
	    	endTime.focus();
	    	return false;
	    }else if(Date.parse(currentTime)-Date.parse(endTimeVal)>0){
	    	alert("活动的结束开始时间不能小于当前时间！");
	    	endTime.focus();
	    	return false;
	    }
	    if(isEmpty($.trim(description.val()))){
	    	alert("活动描述不能为空！");
	    	description.focus();
	    	return false;
	    }
	    if(isEmpty(imgUrl)){
	    	alert("请上传宣传图片！");
	    	return false;
	    }
	    return true;
	}
</script>
</head>
<body>
	<div style="display:none;">
		<a href="#" id="fancybox_pic" class="fancybox_pic"></a>
	</div>
   	<!--头部-->
	<%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   	<!--内容-->
    <div class="container">
      	<div class="article">
        	<div class="activityMsg">
            	<div class="rightTitle">
                	<span>${shopVo.wordNames['gmsc028']}</span>
            	</div>
              	<form id="activity" action="" method="post" enctype ="multipart/form-data" style="margin-top:10px;border-top:1px solid #b7b7b7">
	            	<div class="sectionMsg">
	            		<u>
              			<em style="width:380px;height:380px;"><img src="${activity.imgUrl}" id="activityImg" width="380" height="380" onclick="uploadPic();"/></em><br />
		              		<input id="imgUrl" name="imgUrl" type="hidden" value="${activity.imgUrl}" />
		              		<input type="hidden" name="activityId" id="activityId" value="${activity.activityId}" />
              				<a href="javascript:uploadPic();" class="uploadImg blueBtn">${shopVo.wordNames['gmsc044']}</a><br />
              			</u>
	              		<ul>
			                <li><span>${shopVo.wordNames['gmsc036']}</span><input type="text" class="inputStyle" name="activityName" value="${activity.activityName}" maxlength="32"/></li>
			                <li><span>${shopVo.wordNames['gmsc037']}</span><input type="text" class="inputStyle" name="title" value="${activity.title}" maxlength="32"/></li>
			                <li><span>${shopVo.wordNames['gmsc040']}</span><textarea style="resize: none; overflow-y:auto;" class="TextareaStyle" name="purpose" maxlength="255">${activity.purpose}</textarea></li>
			                <li><span>${shopVo.wordNames['gmsc041']}</span><textarea style="resize: none; overflow-y:auto;" class="TextareaStyle" name="content" maxlength="500">${activity.content}</textarea></li>
			                <fmt:formatDate var="startTime" value="${activity.startTime}" pattern="yyyy-MM-dd"/>
				   			<fmt:formatDate var="endTime" value="${activity.endTime}" pattern="yyyy-MM-dd"/>
			                <li>
			                	<span>${shopVo.wordNames['gmsc038']}</span>
			                	<input type="text" class="date" id="d1" name="startTime" value="${startTime}" readonly="readonly" 
			                		onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'${currentTime }',maxDate:'#F{$dp.$D(\'d2\')||\'${endTime}\'}'})"/>
			                </li>
			                <li>
			                	<span>${shopVo.wordNames['gmsc039']}</span>
			                	<input type="text" class="date" id="d2" name="endTime" value="${endTime}" readonly="readonly" 
			                		onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d1\')||\'${currentTime}\'}'})"/>
			                </li>
			                <li>
			                	<span>${shopVo.wordNames['gmsc042']}</span>
			                	<textarea style="resize: none; overflow-y:auto;" class="TextareaStyle describe" id="description" name="description" maxlength="255">${activity.description}</textarea>
			                </li>
	              		</ul>
	            		<div class="nextControl">
		            		<a href="javascript:saveActivity();" class="blueBtn savebtn">${shopVo.wordNames['gmsc002']}</a><!-- 保存 -->
	            		</div>
	            	</div>
	            </form>
			</div>
		</div>
	</div>
</body>
</html>
