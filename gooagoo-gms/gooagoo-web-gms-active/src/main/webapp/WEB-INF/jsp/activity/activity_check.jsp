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
<title>审核活动</title><!-- 审核活动 -->
<style>
	.firsd label a.way{background:url(${imgPath}/gms/marketing/images/after-01.png) no-repeat left top;}
	.activityContentTable td .area1{width: 460px; height: 34px;resize: none; overflow-y:auto;border:0px; background-color: white; color:#666666;}
	.activityContentTable td .area2{width: 460px; height: 64px;resize: none; overflow-y:auto;border:0px; background-color: white; color:#666666;}
</style>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script>
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";

	//审核活动
	function checkActivity(id,status){
		$(".blueBtn").attr("disabled","disabled");
		
		var auditNote = $("textarea[name='auditNote']").val();
		
	    var url = "${basePath }activity.do?method=check";
		var data = "&activityId="+id + "&publishStatus="+status+"&auditNote="+auditNote;
		
		ajaxJsonTipByData(url,data,true);
		(document.parentWindow || document.defaultView).parent.closeCheckFancyBox(status);
	}
	//统计文本框输入的文字个数
	function countChar(textareaName,spanName)
	{ 
		$("#"+spanName).html(250 - $("textarea[name='"+textareaName+"']").val().length);
	} 
</script>
</head>
<body>
   	<!--内容-->
    <div class="container">
    	<div class="article" style="width: 900px;">
        	<div class="activityMsg">
	            <div class="rightTitle">
                	<span>${shopVo.wordNames['gmsc028']}</span><!-- 活动信息 -->
	            </div>
            	<div class="activityContent">
	               	<u>
		               	<em style="width:300px;height:300px;">
		              		<img src='${activity.imgUrl}' id='activityImg' width="300" height="300"/>
		              	</em>
	              		<input id="imgUrl" name="imgUrl" type="hidden" value="${activity.imgUrl}" />
	              	</u>
              		<table border="0" cellpadding="0" cellspacing="1" bgcolor="#b7b7b7" class="activityContentTable">
	              		<tr>
		                	<th style="width:100px;">${shopVo.wordNames['gmsc036']}</th>
		               	 	<td style="width:460px; padding: 3px 10px;">${activity.activityName}</td>
		              	</tr>
	              		<tr>
	                		<th>${shopVo.wordNames['gmsc037']}</th>
	                		<td style="width:460px; padding: 3px 10px;">${activity.title}</td>
	              		</tr>
	              		<tr>
		               		<th>${shopVo.wordNames['gmsc045']}</th>
		                	<td style="width:460px; padding: 3px 10px;">
		                		<fmt:formatDate value="${activity.startTime}" type="both" pattern="yyyy年MM月dd日" /> - <fmt:formatDate value="${activity.endTime}" type="both" pattern="yyyy年MM月dd日" />
		                	</td>
	             		</tr>
		              	<tr>
			                <th>${shopVo.wordNames['gmsc040']}</th>
			                <td style="width:460px; padding: 3px 10px;">
			                 	<textarea class="area1">${activity.purpose}</textarea>
		                	</td>
		              	</tr>
		              	<tr>
			                <th>${shopVo.wordNames['gmsc041']}</th>
			                <td style="width:460px; padding: 3px 10px;">
         			            <textarea class="area2">${activity.content}</textarea>
			                </td>
		              	</tr>
		              	<tr>
			                <th>${shopVo.wordNames['gmsc042']}</th>
			                <td style="width:460px; padding: 3px 10px;">
         			            <textarea class="area2">${activity.description}</textarea>
			                </td>
	             	 	</tr>
	             	 	<tr>
			                <th>${shopVo.wordNames['gmsc043']}</th>
			                <td style="width:460px;padding: 3px 10px;">
			                	<c:forEach items="${publish_status}" var = "type">
				       				<c:if test="${type.key == activity.publishStatus}">${type.value }</c:if>
				       			</c:forEach>
			                </td>
	             	 	</tr>
	            	</table>
				</div>
			</div>
        	<div class="activityContent">
	            <div class="activityMsg" id="tab_list">
	            	<h2 style=" border-bottom: 1px solid #9EB3D3; color: #0873B9; font-size: 14px;
					    font-weight: bold; line-height: 33px; margin-bottom: 15px;  text-indent: 10px;">审核描述</h2>
	            	<textarea name="auditNote" style="width: 99%; height: 90px;resize: none; overflow-y:auto; padding: 5px;" rows="" cols="" 
	            		onkeydown='countChar("auditNote","counter");' onkeyup='countChar("auditNote","counter");' maxlength="250"></textarea>
					<font style="float: right; color: gray;">可以输入<span id="counter">250</span>字</font><br/>
	          	</div>
	            <input id="activityId" name="activityId" type="hidden" value="${activity.activityId}"/>
        	</div>
        </div>
	</div>
	<div class="nextControl">
		<a class="blueBtn savebtn" href="#" onclick="checkActivity('${activity.activityId}','Y');"><strong>${shopVo.wordNames['gmsc011']}</strong></a>
		<a class="blueBtn savebtn" href="#" onclick="checkActivity('${activity.activityId}','N');"><strong>${shopVo.wordNames['gmsc012']}</strong></a>
	</div>
</body>
</html>




