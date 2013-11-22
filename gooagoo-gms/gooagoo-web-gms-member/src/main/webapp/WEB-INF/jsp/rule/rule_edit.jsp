<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
	request.setAttribute("topMenuCode", "23");
	request.setAttribute("leftMenuCode", "");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['cpmd011']}</title><!-- 编辑会员发展规则 -->
<%@ include file="/WEB-INF/jsp/common/top.jsp"%> 
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/active/js/ruleCondition.js" charset="UTF-8"></script>
<script type="text/javascript">
	var cbody = true;
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";
	var behaveMap;
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
	<!--内容-->
    <div class="container">
      	<div class="article">
      		<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
			<div class="section" id="page_content">
				<form action="" id="memberSearchForm" method="post" target="myframe">
					<c:set var="info" value="${rule.ruleInfo}"></c:set>
					<c:set var="result" value="${rule.ruleResult}"></c:set>
					<div class="rightTitle"><span>${shopVo.wordNames['cpmd009']}</span></div>
					<div class="conditions_content">
						<div class="title">${shopVo.wordNames['cpmd010']}</div>
					  	<div class="behavior_quality noborder">
					    	<dl>
					        	<dd><span>${shopVo.wordNames['gmsc052']}</span>
					        		<input type="text" name="ruleName" value="${info.ruleName}" width="200px"/>
					        	</dd>
					        	<dd><span>${shopVo.wordNames['gmsc065']}</span>
					        		<select id="card" name="ruleResultValue">
					        			<option value="">--${shopVo.wordNames['gmsc058']}--</option>
					        		</select>
					        	</dd>
					        	<dd class="bottom_box">
	                               	<span>规则描述</span>
	                                <textarea name="ruleDesc" style="width: 85%; height: 80px;padding:5px;resize: none; overflow-y:auto;" rows="" cols="" maxlength="500">${result.ruleDesc}</textarea>
                           		</dd>
					     	</dl>
						</div>
       					<input type="hidden" name="ruleId" id="ruleId" value="${isCopy =='Y' ? updateRuleId : info.ruleId}"/>
	        			<input type="hidden" name="objectId" value="${info.objectId}"/>
	        			<input type="hidden" name="ruleResultId" value="${result.ruleResultId}"/>
		        		<input type="hidden" name="ruleResultType" value="1"/>
						<input type="hidden" name="ruleType" value="7"/>
					</div>
					<div style="height: 35px;line-height:35px; padding-bottom: 5px;">
						<span style=" color: #666666; font-size: 14px; font-weight: bold; height: 35px; line-height: 35px;">复制人群细分信息：</span>
						<input onclick="listFancybox();" type="text" name="" value="点击进行选择" readonly="readonly" style="cursor: pointer; color:#a0a0a0; text-align: center;height: 18px; line-height: 18px;"/>
					</div>
					<div id="groupCondition">
						${ruleCondition}
					</div>
					<a href="javascript:void(0)" class="blueBtn savebtn" onclick="doSubmit();">${shopVo.wordNames['gmsc002']}</a>
				</form>
        	</div>
       	</div>
	</div>
	<script type="text/javascript">
		//初始化
		$(function() {
			initFancyBox("fancybox_list",800,600,true);//初始化已有信息列表弹层
			initFancyBox("fancybox_relaList",800,600,true);//初始化关联信息列表弹出层
			initFancyBox("fancybox_relaTree",240,450,true);//初始化关联信息树型弹出层
			initFancyBox("fancybox_userInfo",800,600,true);//初始化已选人群列表弹出层
			
			chooseActType();//历史行为点击添加行为弹出效果
			initVipGrade();//会员卡列表（规则结果——发卡）
			initShopActionList();//初始化商家下行为列表
			initNCVipGrade();//初始化“会员等级”显示问题
		});
		//会员卡列表（规则结果）
		function initVipGrade(){
			$.ajax({
				type  : "post",
				async : false,
				cache : false,
				url   : basePath + "rule.do?method=getCard",
				dataType:"json",
				success : function(msg) {
					$(msg).each(function(i) {
						if("${result.ruleResultValue}"==msg[i].cardId){
							$("#card").append('<option value="'+msg[i].cardId+'" selected="selected">'+msg[i].cardName+'</option>')
						}else{
							$("#card").append('<option value="'+msg[i].cardId+'">'+msg[i].cardName+'</option>')
						}
					});
				}
			});	
		}
		//更改实时条件中时间段可填范围
		function initCurrentTiemScope(actionType){
			$("input[name='C_"+actionType+"_dateStart']").attr("id", "cd"+actionType+"1");
			$("input[name='C_"+actionType+"_dateEnd']").attr("id", "cd"+actionType+"2");
			$("input[name='C_"+actionType+"_dateStart']").attr("onclick","WdatePicker({minDate:'${currentTime}',maxDate:'#F{$dp.$D(\\\'cd"+actionType+"2\\\')||\\\'${eTime}\\\'}'});")
			$("input[name='C_"+actionType+"_dateEnd']").attr("onclick","WdatePicker({minDate:'#F{$dp.$D(\\\'cd"+actionType+"1\\\')||\\\'${currentTime}\\\'}'});");
			$("input[name='C_"+actionType+"_timeStart']").attr("id", "ct"+actionType+"1");
			$("input[name='C_"+actionType+"_timeEnd']").attr("id", "ct"+actionType+"2");
			$("input[name='C_"+actionType+"_timeStart']").attr("onclick","WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\\\'ct"+actionType+"2\\\')}'});")
			$("input[name='C_"+actionType+"_timeEnd']").attr("onclick","WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\\\'ct"+actionType+"1\\\')||\\\'00:00\\\'}'});");
		}
		//更改历史行为中时间段可填范围
		function initHistoryTiemScope(actionType){
			$("input[name='H_"+actionType+"_dateStart']").attr("id", "hd"+actionType+"1");
			$("input[name='H_"+actionType+"_dateEnd']").attr("id", "hd"+actionType+"2");
			$("input[name='H_"+actionType+"_dateStart']").attr("onclick","WdatePicker({maxDate:'#F{$dp.$D(\\\'hd"+actionType+"2\\\')}'});");
			$("input[name='H_"+actionType+"_dateEnd']").attr("onclick","WdatePicker({minDate:'#F{$dp.$D(\\\'hd"+actionType+"1\\\')}'});");
		}
	
		//提交
		function doSubmit(){
			$(".savebtn").attr("disabled", true);
			if(isEmpty($("#ruleId").val())){
				var url = basePath + "rule.do?method=add";
			}else{
				var url = basePath + "rule.do?method=update";
			}
			if(checkHasValue()){
				$("#memberSearchForm").ajaxSubmit({
					url : url,
					type : "post",
					dataType : "html",
					success : function(msg) {
						msg = $.parseJSON(msg);
						alert(msg.message);
						if (msg.success) {
							window.location.href = basePath + "rule.do?method=index&ruleType=${ruleType}";
						}
					}
				});
			}else{
				$(".savebtn").attr("disabled", false);
			}
		}
		//校验
		function checkHasValue(){
			var ageStart = $("input[name='ageStart']");
			var ageEnd = $("input[name='ageEnd']");
			
			var isPublishImmediately = $("input:radio[name='isPublishImmediately']:checked");
			var expectPublishTime = $("input[name='expectPublishTime']");
			var ruleName = $("input[name='ruleName']");
			var ruleResultValue =$("select[name='ruleResultValue']");
			var ruleActiveType = $("select[name='ruleActiveType']");
			var startTime = $("input[name='startTime']");
			var endTime = $("input[name='endTime']");
			
			var currentTime = ("${currentTime}").replace(/-/g,"/");
			var currentDateTime = ("${currentDateTime}").replace(/-/g,"/");
			var expectPublishTimeVal = expectPublishTime.val().replace(/-/g,"/");
			var startTimeVal = startTime.val().replace(/-/g,"/");
			var	endTimeVal = endTime.val().replace(/-/g,"/");
			
			if(isEmpty(ruleName.val())){
				alert("规则名称不能为空！");
				return false;
			}
			if(isEmpty(ruleResultValue.val())){
				alert("发卡不能为空！");
				return false;
			}
			
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
				var action = boxs.eq(i).val();
				if(boxs.eq(i).attr("checked")=="checked"){
					var start = $("input[name='H_"+action+"_dateStart']");
					var end = $("input[name='H_"+action+"_dateEnd']");
					if(isEmpty(start.val()) != isEmpty(end.val())){
						if(isEmpty(start.val())){
							start.focus();
							alert("历史“"+getTypeName(action)+"”行为中日期段的开始时间不能为空！");
							return false;
						}
						if(isEmpty(end.val())){
							end.focus();
							alert("历史“"+getTypeName(action)+"”行为中日期段的结束时间不能为空！");
							return false;
						}
					}
					checkNum("H",action);
				}
			}
			if (!isEmpty($(".Rselect").val())){
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
				}else if(Date.parse(dateSVal)-Date.parse(currentTime)<0){
					dateS.focus();
					alert("实时“"+getTypeName($(".Rselect").val())+"”中日期段开始时间不能小于当前日期！");
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
