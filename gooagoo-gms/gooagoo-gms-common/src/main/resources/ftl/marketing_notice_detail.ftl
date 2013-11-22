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
	        <span>${shopVo.wordNames['gmsc229']}</span>
	    </div>
	    <div class="incidentContent">
			<div class="ICtop">
		     	<input type="hidden" id="noticeInfoId" name="noticeInfoId" value="${notice.noticeInfoId}" />
		     	<input type="hidden" id="activityId" name="activityId" value="${activityId}"  />
		     	<input type="hidden" id="marketingLinkId" name="marketingLinkId" value="${notice.marketingLinkId!}"/>
			 	<input type="hidden" id="marketingLinkType" name="marketingLinkType" value="${notice.marketingLinkType!}"/>
			 	<input type="hidden" id="img" name="img" value="${notice.img!}"/>
	 			<ul>
	     			<li><span>${shopVo.wordNames['gmsc228']}</span>${notice.noticeTitle}</li>
	       		</ul>
	   		</div>  
			<h2 class="title">${shopVo.wordNames['gmsc227']}</h2>
	      	<div class="ICmiddle2">
	        	<div class="textarea_Yh">
		        	<div id="textWeb" readonly="readonly" class="incidentContent" style="width: 815px; height: 150px; padding:5px; resize: none; overflow-y:auto;">${notice.noticeTextWeb}</div>            
	            </div>
	            <ul id="relateImgList" class="imgList" style="display:none;"></ul><br/>
	   		</div>
	    	<div id="relateImg" class="ICbottom" style="display: <#if notice.img??>block<#else>none</#if>;">        
	    		<span class="img_wrap">
	            	<img width="130" height="130" src="${notice.img!}" />
	            </span>
	        </div>
		</div>
	</div>
</body>
</html>
