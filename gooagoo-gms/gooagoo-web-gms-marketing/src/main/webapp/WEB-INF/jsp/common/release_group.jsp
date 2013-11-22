<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsc031']}</title>
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/normalCheck.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common-check.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>

<!-- 日期控件 -->
<script src="${imgPath}/common/My97DatePicker/WdatePicker.js"></script>

<!-- 弹出层 -->
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.pack.js"></script>

<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/add_actPop.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${imgPath}/gms/member/js/public.js"></script>

<link href="${imgPath}/gms/common/css/member_FBRQ.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${imgPath}/gms/active/js/ruleCondition.js" charset="UTF-8"></script>
<script type="text/javaScript">
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";
	var cbody = true;
	$(function(){
		initFancyBox("fancybox_list",800,600,true);//初始化已有信息列表弹层
		initFancyBox("fancybox_relaList",800,600,true);//初始化关联信息列表弹出层
		initFancyBox("fancybox_relaTree",240,450,true);//初始化关联信息树型弹出层
		initFancyBox("fancybox_userInfo",800,600,true);//初始化已选人群列表弹出层

		initTimeScope();//初始化时间段取值限制
		chooseActType();//历史行为点击添加行为弹出效果		
	});

</script>
</head>
<body>
	<div style="display:none;"><!-- 弹出层 -->
		<a href="#" id="listFancybox" class="fancybox_list"></a>
		<a href="#" id="relaListFancybox" class="fancybox_relaList"></a>
		<a href="#" id="relaTreeFancybox" class="fancybox_relaTree"></a>
		<a href="#" id="userInfoFancybox" class="fancybox_userInfo"></a>
	</div>
	<!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <div class="container"> 
         <div class="article">
	<div class="section_pop" style="width: 96%;padding-top: 20px;">
       	<form action="" id="memberSearchForm" method="post">
		<div class="rightTitle"><span>${shopVo.wordNames['gmsc250']}</span></div>
			<div class="conditions_content">
				<div class="title">${shopVo.wordNames['gmsc250']}</div>
			  	<div class="plan_box">
			  		<p class="top_p" id="conName" style="display:${empty activityName?'none':'block'}">
				      	<span><font style="color: #5B5F60;font-weight: bold;">所属活动：</font></span>${activityName}
			      	</p>
			      	<p class="top_p" id="conName">
				      	<span><font style="color: #5B5F60;font-weight: bold;">${shopVo.wordNames['gmsc252']}：</font></span>${title}
			      	</p>
		      	</div>
			</div>
			<div style="height: 35px;line-height:35px; padding-bottom: 5px;">
				<span style=" color: #666666; font-size: 14px; font-weight: bold; height: 35px; line-height: 35px;">复制人群细分信息：</span>
				<input onclick="listFancybox();" type="text" name="" value="点击进行选择" readonly="readonly" style="cursor: pointer; color:#a0a0a0; text-align: center;height: 18px; line-height: 18px;"/>
			</div>
			<div id="groupCondition">
			${ruleCondition}
			</div>
			<input type="hidden" name="contentId" value="${contentId}"/>
			<input type="hidden" name="activityId" value="${activityId}"/>
			<input type="hidden" name="channelCode" value="${channelCode}"/>
		</form>		
		<a href="javascript:void(0);" onclick="doSubmit();" class="blueBtn savebtn">${shopVo.wordNames['gmsc005']}</a>
	</div>
	</div>
	</div>
	<script type="text/javaScript">

	$(function() {
		initShopActionList();
		//初始化实时条件（发布渠道为6-手机服务，实时条件只能为“使用服务工具”）
		var obj = $(".Rselect");
		var type = "${channelCode}"
		var channelRoot = "${eventView.event.channelRoot}";
		var channelLeaf = "${eventView.event.channelLeaf}";
		var channelLeafName = "${eventView.event.channelLeafName}";
		if(type==6){
			$("#curr_selectAction option[value!='A']").remove();
			$("#curr_selectAction option[value='"+obj.val()+"']").attr("selected", true); 
			obj.attr("name","actionType");
			appendBehavior('C','');
		}
		
		var actionType = $("#curr_selectAction").val();
		//初始化实时条件中时间段的取值范围
		initCurrentTiemScope(actionType);
	});
	//更改实时行为中时间段可填范围
	function initCurrentTiemScope(actionType){
		$("input[name='C_"+actionType+"_dateStart']").attr("id", "cd"+actionType+"1");
		$("input[name='C_"+actionType+"_dateEnd']").attr("id", "cd"+actionType+"2");
		$("input[name='C_"+actionType+"_dateStart']").attr("value", "${not empty startTime ? startTime : (currentTime ge sTime ? currentTime : sTime)}");
		$("input[name='C_"+actionType+"_dateEnd']").attr("value", "${not empty endTime ? endTime : (eTime)}");
		$("input[name='C_"+actionType+"_dateStart']").attr("onclick","WdatePicker({minDate:'${currentTime ge sTime ? currentTime : sTime}',maxDate:'#F{$dp.$D(\\\'cd"+actionType+"2\\\')||\\\'${eTime}\\\'}'});")
		$("input[name='C_"+actionType+"_dateEnd']").attr("onclick","WdatePicker({minDate:'#F{$dp.$D(\\\'cd"+actionType+"1\\\')||\\\'${currentTime ge sTime ? currentTime : sTime}\\\'}',maxDate:'${eTime}'});");
		$("input[name='C_"+actionType+"_timeStart']").attr("id", "ct"+actionType+"1");
		$("input[name='C_"+actionType+"_timeEnd']").attr("id", "ct"+actionType+"2");
		$("input[name='C_"+actionType+"_timeStart']").attr("onclick","WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\\\'ct"+actionType+"2\\\')}'});")
		$("input[name='C_"+actionType+"_timeEnd']").attr("onclick","WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\\\'ct"+actionType+"1\\\')||\\\'00:00\\\'}'});");
	}
	//更改历史行为中时间段可填范围
	function initHistoryTiemScope(actionType){
		$("input[name='H_"+actionType+"_dateStart']").attr("id", "hd"+actionType+"1");
		$("input[name='H_"+actionType+"_dateEnd']").attr("id", "hd"+actionType+"2");
		$("input[name='H_"+actionType+"_dateStart']").attr("onclick","WdatePicker({maxDate:'#F{$dp.$D(\\\'hd"+actionType+"2\\\')}'});")
		$("input[name='H_"+actionType+"_dateEnd']").attr("onclick","WdatePicker({minDate:'#F{$dp.$D(\\\'hd"+actionType+"1\\\')}'});");
	}
	function doSubmit(){
		$(".savebtn").attr("disabled",true);
		var channelCode="${channelCode}";	
		var status="${status}";
		if(checkHasValue()){
			var actionName="cryout";
			if(channelCode=="2"){
				actionName="notice";
			}
			var url="${basePath}"+actionName+".do?method=checkAndrelease";
			if(status=="A"){
			 url="${basePath}"+actionName+".do?method=release";	
			}
			
			var data = $("#memberSearchForm").serialize()+"&id=${contentId}&status=Y";
			
			$.ajax({
				type: "POST",
				async: false,
				url: url,
				data: data,
				dataType: "json",
				success: function(ret){
					
					if(ret.success){
						alert(ret.message);
						window.location.href = "${basePath}"+actionName+".do?method=index";
					}else{
						alert(ret.message);
					}								
				}
			});
			
		}else{
	 		$(".savebtn").attr("disabled",false);
		}
	}
	
	
	function checkHasValue(){
		var ageStart = $("input[name='ageStart']");
		var ageEnd = $("input[name='ageEnd']");
		
		var isPublishImmediately = $("input:radio[name='isPublishImmediately']:checked");
		var expectPublishTime = $("input[name='expectPublishTime']");
		var startTime = $("input[name='startTime']");
		var endTime = $("input[name='endTime']");
		var ruleActiveType = $("select[name='ruleActiveType']");

		var currentTime = ("${currentTime}").replace(/-/g,"/");
		var currentDateTime = ("${currentDateTime}").replace(/-/g,"/");
		var expectPublishTimeVal = expectPublishTime.val().replace(/-/g,"/");
		var startTimeVal = startTime.val().replace(/-/g,"/");
		var	endTimeVal = endTime.val().replace(/-/g,"/");
		var sTime = Date.parse(("${sTime}").replace(/-/g,"/"));
		var eTime = Date.parse(("${eTime}").replace(/-/g,"/"));

		if(isEmpty(ageStart.val()) != isEmpty(ageEnd.val())){
			if(isEmpty(ageStart.val())){
				ageStart.focus();
				alert("自然属性中年龄的开始值不能为空！");
				return false;
			}
			if(isEmpty(ageEnd.val())){
				ageEnd.focus();
				alert("自然属性中年龄的结束值不能为空！");
				return false;
			}
		}
		
		var boxs = $("#position_add").find("input[type='checkbox']");
		for(var i=0; i<boxs.length; i++){
			if(boxs.eq(i).attr("checked")=="checked"){
				var start = $("input[name='H_"+boxs.eq(i).val()+"_dateStart']");
				var end = $("input[name='H_"+boxs.eq(i).val()+"_dateEnd']");
				if(isEmpty(start.val()) != isEmpty(end.val())){
					if(isEmpty(start.val())){
						start.focus();
						alert("历史“"+getTypeName(boxs.eq(i).val())+"”行为中日期段的开始时间不能为空！");
						return false;
					}
					if(isEmpty(end.val())){
						end.focus();
						alert("历史“"+getTypeName(boxs.eq(i).val())+"”行为中日期段的结束时间不能为空！");
						return false;
					}
				}
				checkNum("H",boxs.eq(i).val());
			}
		}
		
		if(!isEmpty($(".Rselect").val())){
			var dateS = $("input[name='C_"+$(".Rselect").val()+"_dateStart']");
			var dateE = $("input[name='C_"+$(".Rselect").val()+"_dateEnd']");
			var serverTools = $("input[name='C_"+$(".Rselect").val()+"_serverTools']");
			
			var dateSVal = dateS.val().replace(/-/g,"/");
			var dateEVal = dateE.val().replace(/-/g,"/");
			
			var timeS = $("input[name='C_"+$(".Rselect").val()+"_timeStart']");
			var timeE = $("input[name='C_"+$(".Rselect").val()+"_timeEnd']");
			
			if(isEmpty(dateS.val())){
				alert("实时“"+getTypeName($(".Rselect").val())+"”中日期段开始时间不能为空！");
				dateS.focus();
				return false;
			}
			if(isEmpty(dateE.val())){
				alert("实时“"+getTypeName($(".Rselect").val())+"”中日期段结束时间不能为空！");
				dateE.focus();
				return false;
			}
			if(isEmpty(timeS.val()) != isEmpty(timeE.val())){
				if(isEmpty(timeS.val())){
					timeS.focus();
					alert("实时“"+getTypeName($(".Rselect").val())+"”行为中时间段的开始时间不能为空！");
					return false;
				}
				if(isEmpty(timeE.val())){
					timeE.focus();
					alert("实时“"+getTypeName($(".Rselect").val())+"”行为中时间段的结束时间不能为空！");
					return false;
				}
			}
			checkNum("C",$(".Rselect").val());
			if($(".Rselect").val()=="A"){
				if(isEmpty(serverTools.val())){
					alert("实时条件中服务工具不能为空！");
					serverTools.focus();
			        return false;
				}
			}
		}
		if(isEmpty(isPublishImmediately.val())){
			alert("请选择立即发放或延时发放！");
			return false;
		}else if(isPublishImmediately.val()=="N"){
			if(isEmpty(expectPublishTime.val())){
				alert("延时发布时间不能为空！");
				expectPublishTime.focus();
				return false;
			}else{
				if((dateAdd(currentDateTime ,'n', 30)-Date.parse(expectPublishTimeVal))>0){
					alert("延时发布时间应至少大于当前时间30分钟！");
					expectPublishTime.focus();
					return false;
				}else if((dateAdd(StringToDate(currentDateTime) ,'y', 1)-Date.parse(expectPublishTimeVal))<0){
					alert("延时发布时间不能超过当前时间一年！");
					expectPublishTime.focus();
					return false;
				}
			}
		}
		if(isEmpty(ruleActiveType.val())){
			alert("请选择触发生效类型！");
			ruleActiveType.focus();
			return false;
		}
		if(isEmpty(startTime.val())){
			alert("生效时间不能为空！");
			startTime.focus();
			return false;
		}else{
			if ((!isEmpty($(".Rselect").val())) && (Date.parse(startTimeVal)-Date.parse(dateSVal)>0)){
		        alert("生效日期不能大于实时条件中日期段开始时间"+dateS.val()+"!");
		        startTime.focus();
		        return false;
			}
			if(Date.parse(startTimeVal)-Date.parse(currentTime)<0){
				startTime.focus();
				alert("生效日期不能小于当前日期！");
				return false;
			}
		}
		if(isEmpty(endTime.val())){
			alert("失效时间不能为空！");
			endTime.focus();
			return false;
		}else　if(!isEmpty($(".Rselect").val())){
			if(Date.parse(endTimeVal)-Date.parse(dateEVal)<0){
		        alert("失效日期不能小于实时条件中日期段结束时间"+dateE.val()+"!");
		        endTime.focus();
		        return false;
		    }
		}

		return true;
	}
	function checkNum(pre,action){
		var consumeMoneyMin = $("input[name='"+pre+"_"+action+"_consumeMoneyMin']");
		var consumeMoneyMax = $("input[name='"+pre+"_"+action+"_consumeMoneyMax']");
		if(isEmpty(consumeMoneyMin.val()) != isEmpty(consumeMoneyMax.val())){
			if(isEmpty(consumeMoneyMin.val())){
				consumeMoneyMin.focus();
				alert((pre=="H" ? "历史" :"实时" )+"“"+getTypeName(action)+"”行为中金额的开始值不能为空！");
				return false;
			}
			if(isEmpty(consumeMoneyMax.val())){
				consumeMoneyMax.focus();
				alert((pre=="H" ? "历史" :"实时" )+"“"+getTypeName(action)+"”行为中金额的结束值不能为空！");
				return false;
			}
		}
		return true;
	}
</script>
</body>
</html>
