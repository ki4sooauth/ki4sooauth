<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsc226']}</title>
<#include "script_common.ftl">
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/add_actPop.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="add_actPopBox" style="width:96%; margin: 0 auto; padding:15px 0 0 0;">
	    <div class="rightTitle">
	        <span>${shopVo.wordNames['gmsc232']}</span>
	    </div>
	    <div class="incidentContent">
	    	<div class="ICtop">
	            <input type="hidden" id="messageId" name="messageId" value="${message.messageId}" />
	            <input type="hidden" id="activityId" name="activityId" value="${activityId}"  />
	        	<ul>
	               	<li><span>${shopVo.wordNames['gmsc231']}</span>${message.messageTitle}</li>
	            </ul>
	        </div>  
	      	<h2 class="title">${shopVo.wordNames['gmsc230']}</h2>
			<div class="ICmiddle">
	        	<div class="textarea_Yh">
	        		<textarea id="content" readonly="readonly" name="content" style="width: 805px; height: 150px; padding:5px; resize: none; overflow-y:auto;">${message.content}</textarea>
	        	</div>
	            <br/>
	        </div>
		</div>
	</div>
</body>
</html>

