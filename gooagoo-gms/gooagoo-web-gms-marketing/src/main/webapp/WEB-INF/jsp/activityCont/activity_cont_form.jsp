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
<script type="text/javascript" src="${imgPath}/common/js/template.js"></script>
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script>
	$(function(){
		initTab('${contType}');
		judge();			
	});
	//判断是添加还是编辑
	function judge(){
		var id = $("#contId").val();
		if(isEmpty(id)){
			$('.li').click(function(){
			    var code = $(this).children("input").val();
			   	initTab(code);
			});
		}
	}
	function initTab(type){
		var id = $("#contId").val();
		var activityId = $("#activityId").val();
		if(isEmpty(id)){
			id = "";
		}
		if(isEmpty(type)){
			type = $("#channelsUL").find("li").first().find("input").val();
		}
		judgeCode(type);
		$("#channelsUL a").attr("class","");
		$("#channel_"+type).attr("class","curr");
		var data = "&id="+id+"&activityId="+activityId+"&channelCode="+type;
		var url = "${basePath }activityCont.do?method=${empty contId ? 'addContform':'updateContform'}";
		ajaxToPageByData(url,"waitRelateCont",data);
	}
	//判断是那种渠道
	function judgeCode(type){
		var inHtml="";
		if(type=="1"){
			inHtml="吆喝";
		}else if(type=='2'){
			inHtml="通知";
		}else if(type=='3'){
			inHtml="短信";
		}else if(type=='4'){
			inHtml="邮件";
		}else if(type=='5'){
			inHtml="购好奇";
		}else if(type=='6'){
			inHtml="手机服务";
		}else if(type=='7'){
			inHtml="手机虚拟商家"
		}else if(type=='8'){
			inHtml="网站虚拟商家";
		}else if(type=='9'){
			inHtml="自定义服务工具";
		}
		$("#contType").html(inHtml+"内容");	
	}
</script>
</head>
<body>
	<div class="add_actPopBox">
	    <div class="rightTitle">
	        <span>${shopVo.wordNames['gmsc209']}</span>
	    </div>
	    <div class="top_menu">
	    	<input type="hidden" name="activityId" id="activityId" value="${activityId}"/>
	    	<input type="hidden" name="contId" id="contId" value="${contId}"/>
	    	<ul id="channelsUL">
		    	<c:forEach var="itemChild" items="${channels}" varStatus="xh">           
			    		<li class="li">
			    			<input type="hidden" class="lih" value="${itemChild.code}"></input>
			    			<a id="channel_${itemChild.code}" href="javascript:void(0);" >${itemChild.name}</a>
			    		</li>
		    	</c:forEach>
	        </ul>
	    </div>
		<div class="rightTitle">
        	<span id="contType"></span>
		</div>
        <!-- 内容 -->  
	    <div id="waitRelateCont">
		</div>
	</div>
</body>
</html>
