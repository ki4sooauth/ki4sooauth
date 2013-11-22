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
	function relateTool(){
		var dataType = $("#dataType").val();
		if(dataType!="TS" && dataType!="TD"){
			return ;
		}
		var url = "${basePath }relation.do?method=treeRelation&selectType=S&relateType=F&callback=getTool&dataType="+dataType;
		$("#relateFancybox").attr("href",url).click();
	}
	function getTool(relations){
		 $("#channelLeaf").val(relations[0][1]);
		 $("#channelLeafName").val(relations[0][2]);
		 $.fancybox.close();
	}
	function checkValue(){
		var eventName = $("#event input[name=eventName]").val();
		var eventTarget = $("#event input[name=eventTarget]").val();
		var channelCode = $("#event input[name=channelCode]").val();
		var templateId = $("#event input[name=templateId]").val();
// 		var channelLeaf = $("#event input[name=channelLeaf]").val();
		
	    if(isEmpty($.trim(eventName))){
	    	alert("请填写主题");
	    	return false;
	    }
	    if(isEmpty($.trim(eventTarget))){
	    	removeDisable();
	    	alert("请填写目的");
	    	return false;
	    }
	    return true;
	}
	function saveEvent(){
		$(".blueBtn").attr("disabled", true);
		if(checkValue()){
		 	var contId = $("#contId").val();
		    if(isEmpty(contId)){
		    	methodName="add";
		    	$("#eventId").val("${marketingId}");
		    }else{
		    	methodName="update";
		    	$("#eventId").val(contId);
		    }
		    var url = "${basePath }activityCont.do?method="+methodName;
		    var data = $("#event").serialize()+"&channelCode=";
		    
			$.ajax({
				type: "POST",
				async: false,
				url: url,
				data: data,
				dataType: "json",
				success: function(ret){
					if(!ret.success){
						alert(ret.message);
					}
					if(ret.success){
						toTemplateList(ret.extend);
					}
				}
			});
// 		    parent.$.fancybox.close();
		}else{
			$(".blueBtn").attr("disabled", false);
		}
	}
	function toTemplateList(eventId){
		var tc = "";
		var channelCode = $("#channelCode").val();
		if(channelCode=="4"){
			tc = "E";
		}else if(channelCode=="5"){
			tc = "Q";
		}else if(channelCode=="6"){
			tc = "M";
		}
		$("#templateChannel").val(tc);
		$("#contId").val(eventId);
	    $("#event").attr("action","template.do?method=index").submit();
	}
	//保存按钮从disable还原
	function removeDisable(){
		$(".blueBtn").attr("disabled",false);
	}
	//弹层——已有通知信息列表
	function listFancybox(){
		var channelCode = $("#channelCode").val();
		var url = "${basePath }activityCont.do?method=contList&pageIndex=1&channelCode="+channelCode+"&marketingId=${marketingId}";
 		$("#listFancybox").attr("href",url).click();
 	}
	//处理选择已有通知信息
	function selectOne(id, marketingId){
		var channelCode = $("#channelCode").val();
		var activityId=parent.$("#activityId").val();
		var data = "&id="+id+"&activityId="+activityId+"&channelCode="+channelCode+"&marketingId="+marketingId;
		alert(data);
		var url = "${basePath }activityCont.do?method=updateContform";
		ajaxToPageByData(url,"waitRelateCont",data);
		$.fancybox.close();
	}
</script>
	<div class="add_actPopBox" style="width:96%; margin: 0 auto; padding:15px 0 0 0;">
		<#include "marketing_content_tab.ftl">
		<div style="display:none;">
			<a href="#" id="relateFancybox" class="fancybox_relate"></a>
			<a href="#" id="listFancybox" class="fancybox_list"></a>
		</div>
		<div class="incidentContent">
		    <form action="" id="event" method="post">
		    	<!--<input type="hidden" id="contentId" name="contentId" value="" />-->
		    	<input type="hidden" id="contentType" name="contentType" value="E" />
		    	<input type="hidden" id="templateChannel" name="templateChannel" value="" />
		    	<input type="hidden" id="eventId" name="eventId" value="${event.eventId}" />
		    	<input type="hidden" id="templateId" name="templateId" value="${event.templateId}" />
		    	<textarea rows="1" cols="1" style="display:none;" id="templateData" name="templateData" >${event.templateData}</textarea>
		    	<input type="hidden" id="channelCode" name="channelCode" value="${channelCode}" />
		        <input type="hidden" id="activityId" name="activityId" value="${activityId}"  />
		        <input type="hidden" id="dataType" value="" />
				<input type="hidden" name="marketingId" id="marketingId" value="${marketingId}"/>
				<input type="hidden" name="contId" id="contId" value="${contId}"/>
				<input type="hidden" name="channelCode" id="channelCode" value="${channelCode}"/>
		    	<div class="ICtop">
		            <ul>
						<!--<li>-->
						<!--	<span>复制已有信息</span>-->
						<!--	<input onclick="listFancybox();" type="text" name="" value="点击进行选择" readonly="readonly" style="cursor: pointer; color:#a0a0a0; text-align: center;"/>-->
						<!--</li>-->
		               	<li><span>${shopVo.wordNames['gmsc237']}</span><input id="eventName" name="eventName" class="longInput" type="text" value="${event.eventName}" /></li>
		                <li><span>${shopVo.wordNames['gmsc238']}</span><input id="eventTarget" name="eventTarget" class="longInput" type="text" value="${event.eventTarget}" /></li>
					</ul>
				</div>  
				<div style="text-align:center; padding: 120px 0px;">
					<a class="saveSet blueBtn" href="javascript:void(0);" onclick="saveEvent();" style="display: inline-block;" >${shopVo.wordNames['gmsc002']}</a>
				</div>
		    </form>
		</div>
	</div>
</body>
</html>

