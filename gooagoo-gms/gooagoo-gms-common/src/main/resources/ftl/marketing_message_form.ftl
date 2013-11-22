<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑活动内容</title>
<#include "script_common.ftl">
<#include "script_fancybox.ftl">
<script type='text/javascript' src='${imgPath}/common/js/kindeditor/kindeditor-min.js' charset='utf-8'></script>
<link rel="stylesheet" href="${imgPath}/common/js/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="${imgPath}/common/js/kindeditor/lang/zh_CN.js"></script>
<script src="${imgPath}/gms/common/js/popLB.js"></script>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/add_actPop.css" rel="stylesheet" type="text/css" />
<script src="${imgPath}/gms/active/js/activeCont.js"></script>
<script type="text/javascript">
	$(function(){
		initFancyBox("fancybox_list",800,600,true);//初始化已有信息列表弹层
	});
	function saveMessage(){	
		$(".saveSet").attr("disabled", true);
		if(checkValue()){
		    var contId = $("#contId").val();
		    if(isEmpty(contId)){
		    	methodName="add";
		    }else{
		    	methodName="update";
		    	$("#messageId").val(contId);
		    }
		    var url = "${basePath }activityCont.do?method="+methodName;
		    var data = $("#message").serialize()+"&channelCode=3";
		    ajaxJsonTipByData(url,data,true,"");
		    parent.$("#tab_list a").eq(1).click();
		    parent.$.fancybox.close();
		}else{
			$(".saveSet").attr("disabled", false);
		}
	}
	function checkValue(){
		var title = $("#message input[name=messageTitle]").val();
		var content = $("#content").val();
		if(isEmpty($.trim(title))){
	    	alert("短信标题不能为空");
	    	return false;
	    }else if(title.length>32){
	    	alert("标题最多为32个字符！")
	    	return false;
	    }
	    if(isEmpty($.trim(content))){
	    	alert("短信内容不能为空");
	    	return false;
	    }
		return true;
	}
	//弹层——已有短信信息列表
	function listFancybox(){
		var url = "${basePath }activityCont.do?method=contList&channelCode=3&marketingId=${marketingId}";
 		$("#listFancybox").attr("href",url).click();
 	}
	//处理选择已有信息
	function selectOne(id, marketingId){
		var activityId=parent.$("#activityId").val();
		var data = "&id="+id+"&activityId="+activityId+"&channelCode=3&marketingId="+marketingId;
		var url = "${basePath }activityCont.do?method=updateContform";
		ajaxToPageByData(url,"waitRelateCont",data);
		$.fancybox.close();
	}
</script>
</head>
<body>
	<div class="add_actPopBox" style="width:96%; margin: 0 auto; padding:15px 0 0 0;">
		<#include "marketing_content_tab.ftl">
		<div style="display:none;">
			<a href="#" id="listFancybox" class="fancybox_list"></a>
		</div>
		<div>
			<form action="" id="message">
			    <div class="incidentContent">
			    	<div class="ICtop">
						<input type="hidden" id="messageId" name="messageId" value="${message.messageId}" />
			            <input type="hidden" id="activityId" name="activityId" value="${activityId}"  />
			            <input type="hidden" name="marketingId" id="marketingId" value="${marketingId}"/>
						<input type="hidden" name="contId" id="contId" value="${contId}"/>
						<input type="hidden" name="channelCode" id="channelCode" value="${channelCode}"/>
			            <!--<ul>-->
						<!--	<li>-->
						<!--		<span>复制已有信息</span>-->
						<!--		<input onclick="listFancybox();" type="text" name="" value="点击进行选择" readonly="readonly" style="cursor: pointer; color:#a0a0a0; text-align: center;"/>-->
						<!--	</li>-->
						<!--</ul>-->
			        	<ul>
			            	<li><span>${shopVo.wordNames['gmsc231']}</span>
			            	<input class="longInput" type="text" name="messageTitle" value="${message.messageTitle}" maxlength="32"/></li>
			            </ul>
			        </div>  
		      		<h2 class="title">${shopVo.wordNames['gmsc213']}</h2>
		           	<div class="ICmiddle">
		        		<div class="textarea_Yh">
		            		<textarea id="content" name="content" style="width: 880px; height: 150px; padding:5px; resize: none; overflow-y:auto;">${message.content}</textarea>
		            	</div>
		            	<br/>
		        	</div>
			    	<a href="javascript:void(0);" style="display: block;" class="saveSet blueBtn" onclick="saveMessage();" >${shopVo.wordNames['gmsc002']}</a>
		    	</div>
		    </form>
		</div>
	</div>
</body>
</html>

