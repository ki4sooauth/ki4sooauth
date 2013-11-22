<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script type='text/javascript' src='${imgPath}/common/js/kindeditor/kindeditor-min.js' charset='utf-8'></script>
<link rel="stylesheet" href="${imgPath}/common/js/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="${imgPath}/common/js/kindeditor/lang/zh_CN.js"></script>
<script src="${imgPath}/gms/common/js/popLB.js"></script>
<link href="${imgPath}/gms/common/css/add_actPop.css" rel="stylesheet" type="text/css" />
<script src="${imgPath}/gms/active/js/activeCont.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/template.js"></script>
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script>
	$(function(){
		initTab('${contType}');
	});
	function initTab(type){
		var id = $("#contId").val();
		var activityId = $("#activityId").val();
		if(isEmpty(id)){
			id = "";
		}
		if(isEmpty(type)){
			type = "1";
		}
		$("#channelsUL a").attr("class","");
		$("#channel_"+type).attr("class","curr");
		
		var data = "&id="+id+"&activityId="+activityId+"&channelCode="+type;
		var url = "${basePath }activityCont.do?method=detailCont";
		ajaxToPageByData(url,"waitRelateCont",data);
	}
</script>
</head>
<body>
	<div class="add_actPopBox">
    	<input type="hidden" name="activityId" id="activityId" value="${activityId}"/>
    	<input type="hidden" name="contId" id="contId" value="${contId}"/>
	    <div id="waitRelateCont">
	        <!-- 内容 -->  
		</div>
	</div>
</body>
</html>
