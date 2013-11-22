<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsc226']}</title>
<#include "script_common.ftl">
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/add_actPop.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	//预览模板内容
	function previewTemplate(id){
		var data = "&contId=" + id + "&contentType=E";
		window.open("template.do?method=preview"+data);
	}
</script>
</head>
<body>
<div class="add_actPopBox" style="width:96%; margin: 0 auto; padding:15px 0 0 0;">
 	<div class="rightTitle">
        <span>${channelName}详细信息</span>
    </div>
	<div class="incidentContent">
    	<div class="ICtop">
        	<ul>
               	<li><span>${shopVo.wordNames['gmsc237']}</span>${event.eventName}</li>
                <li><span>${shopVo.wordNames['gmsc238']}</span>${event.eventTarget}</li>
                <li>
                	<span>模板内容</span>
                	<div>
                		<a class="blueBtn savebtn" href="javascript:void(0);" onclick=previewTemplate('${event.eventId}'); style="height: 21px; line-height: 21px; width:150px;">预览模板内容</a>
                	</div>
                </li>
			</ul>
		</div>  
	</div>
</div>
</body>
</html>