<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>活动规则编辑</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp" %>
<script type="text/javascript" src="${imgPath}/gms/active/js/ruleCondition.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/relate.js" charset="UTF-8"></script>
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css" />
<script type="text/javaScript">
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";
	var cbody = true;
</script>
</head>
<body>
	<div style="display:none;"><!-- 弹出层 -->
		<a href="#" id="listFancybox" class="fancybox_list"></a>
		<a href="#" id="relaListFancybox" class="fancybox_relaList"></a>
		<a href="#" id="relaTreeFancybox" class="fancybox_relaTree"></a>
		<a href="#" id="userInfoFancybox" class="fancybox_userInfo"></a>
	</div>
	<!--内容-->
    <div class="container">
      	<div class="article" style="width: 96%;">
      		<div class="memberPoup">
				<form action="" id="memberSearchForm" method="post" target="myframe">
					<c:set var="info" value="${rule.ruleInfo}"></c:set>
					<c:set var="result" value="${rule.ruleResult}"></c:set>
					<div class="rightTitle"><span>${shopVo.wordNames['gmsc074']}</span></div>
					<div class="conditions_content">
					 	<div class="title">${shopVo.wordNames['gmsc075']}</div>
					  	<div class="behavior_quality noborder">
					    	<dl>
					        	<dd><span>${shopVo.wordNames['gmsc052']}</span>
					        		<input type="text" name="ruleName" value="${info.ruleName}" maxlength="32" style="width: 200px;"/>
					        	</dd>
					        	<dd><span>${shopVo.wordNames['gmsc053']}</span>
					        		<select name="ruleType" onchange="getResultType();">
					        			<option value="">--${shopVo.wordNames['gmsc058']}--</option>
								        <c:forEach items="${rule_type}" var = "type">
									        <c:if test="${type.key ge '5' && (type.key le '7')}">
						        				<option value="${type.key}" <c:if test="${info.ruleType==type.key}">selected="selected"</c:if>>${type.value}</option>
									        </c:if>
								        </c:forEach>
					        		</select>
					        	</dd>
					        	<dd><span>${shopVo.wordNames['gmsc059']}</span>
					        		<select name="ruleResultType" onchange="changeResult();" <c:if test="${info.ruleType==5 || info.ruleType==7}">disabled="disabled"</c:if>>
					        			<option value="">--${shopVo.wordNames['gmsc058']}--</option>
					        			<c:forEach items="${rule_result_type}" var = "type">
							        		<option value="${type.key}" <c:if test="${result.ruleResultType==type.key}">selected="selected"</c:if>>${type.value}</option>
							            </c:forEach>
					        		</select>
					        	</dd>
					        	<dd id="addMoney" style="display: none;"><span>${shopVo.wordNames['gmsc118']}</span>
					        		<input type="text" name="addConsumeMoney" value="${result.ruleResultType=='4' ? result.addConsumeMoney : ''}" onkeyup="clearNoNum(this);" style="width: 200px;" maxlength="16"/><font>元</font>
   									<font style="color: gray; line-height: 20px;">（特别提示：只有当历史行或实时行为选择了“消费”时，该项数据才有效！）</font>
					        	</dd>
					        	<dd id="r0" style="display: none;"><span>${shopVo.wordNames['gmsc060']}</span>
					        		<input type="text" class="age" name="" value="${result.ruleResultType =='0' ? result.ruleResultValue : ''}" maxlength="10" style="width: 200px;"/><font>${shopVo.wordNames['gmsc066']}</font>
					        	</dd>
					        	<dd id="r1" style="display: none;"><span>${shopVo.wordNames['gmsc065']}</span>
					        		<select name="" id="card">
					        			<option>--${shopVo.wordNames['gmsc058']}--</option>
					        		</select>
					        	</dd>
					        	<dd id="r2" style="display: none;"><span>${shopVo.wordNames['gmsc061']}</span>
					        		<input type="text" name="" value="${result.ruleResultType =='2' ? result.ruleResultValue : ''}" onkeyup="clearNoNum(this);" style="width: 200px;" maxlength="16"/><font>${shopVo.wordNames['gmsc067']}</font>
					        	</dd>
					        	<dd id="r3" style="display: none;"><span>${shopVo.wordNames['gmsc062']}</span>
					        		<input type="text" name="" value="${result.ruleResultType =='3' ? result.ruleResultValue : ''}" onkeyup="clearNoNum(this);" style="width: 200px;" maxlength="6" /><font>${shopVo.wordNames['gmsc068']}</font>
					        	</dd>
					        	<dd class="bottom_box" id="r4" style="display: none;">
									<a href="javascript:void(0);" class="add" onclick="relateFancybox(this,'list','M','G');">${shopVo.wordNames['gmsc001']}</a>
	                               	<input type="hidden" name="ruleResultValue" value="${result.ruleResultType =='4' ? result.ruleResultValue : ''}"/>
	                                <span>${shopVo.wordNames['gmsc063']}</span>
	                                <ul class="tag">
		                                <c:if test="${result.ruleResultType =='4'}">
			                                <li>
												<span>${result.ruleResultName}<b onclick="deleteRela(this)">x</b>
												</span>
											</li>
										</c:if>
	                                </ul>
                           		</dd>
					        	<dd class="bottom_box" id="r5" style="display: none;">
									<a href="${basePath }relation.do?method=listRelation&relateType=C&dataType=C" class="add fancybox">添加</a>
	                               	<input type="hidden" name="ruleResultValue" value="${result.ruleResultType =='5' ? result.ruleResultValue : ''}"/>
	                               	<span>${shopVo.wordNames['gmsc064']}</span>
	                                <ul class="tag">
	                                	<c:if test="${result.ruleResultType =='5'}">
			                                <li>
												<span>${result.ruleResultName}<b onclick="deleteRela(this)">x</b></span>
											</li>
										</c:if>
	                                </ul>
                           		</dd>
					        	<dd class="bottom_box">
	                               	<span>规则描述</span>
	                                <textarea name="ruleDesc" style="width: 90%; height: 80px;padding:5px;resize: none; overflow-y:auto;" rows="" cols="" maxlength="500">${result.ruleDesc}</textarea>
                           		</dd>
					     	</dl>
						</div>
		        		<input type="hidden" name="ruleId" id="ruleId" value="${info.ruleId}"/>
						<input type="hidden" name="activityId" value="${not empty info.activityId ? info.activityId : activityId}"/>
	        			<input type="hidden" name="objectId" value="${info.objectId}"/>
	        			<input type="hidden" name="ruleResultId" value="${result.ruleResultId}"/>
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
		
		initTimeScope();//初始化时间段取值限制
		chooseActType();//历史行为点击添加行为弹出效果
		changeResult();//规则结果的显示
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
	//规则结果类型的显示
	function getResultType(){
		$("select[name='ruleResultType'] option[value='']").attr("style","display:block;");
		$("select[name='ruleResultType'] option[value='0']").attr("style","display:block;");
		$("select[name='ruleResultType'] option[value='1']").attr("style","display:block;");
		var ruleType　= $("select[name='ruleType'] option:selected").val();
		$("select[name='ruleResultType']").val("");
		if("5" == ruleType){
			$("select[name='ruleResultType']").attr("disabled","");
			$("select[name='ruleResultType'] option[value='0']").attr("selected","selected");
			$("select[name='ruleResultType']").attr("disabled","disabled");
		}else if("6" == ruleType){
			$("select[name='ruleResultType']").attr("disabled",false);
			$("select[name='ruleResultType'] option[value='2']").attr("selected","selected");
			$("select[name='ruleResultType'] option[value='']").attr("style","display:none;");
			$("select[name='ruleResultType'] option[value='0']").attr("style","display:none;");
			$("select[name='ruleResultType'] option[value='1']").attr("style","display:none;");
		}else if("7" == ruleType){
			$("select[name='ruleResultType']").attr("disabled",false);
			$("select[name='ruleResultType'] option[value='1']").attr("selected","selected");
			$("select[name='ruleResultType']").attr("disabled","disabled");
		}
		changeResult();
	}
	//规则结果的显示
	function changeResult(){
		var rflag = $("select[name='ruleResultType']");
		if(!isEmpty(rflag.val())){
			$("#r"+rflag.val()).attr("style", "display:block;");
			if(rflag.val() == 4){
				$("#r"+rflag.val()).find("a").next().attr("name", "ruleResultValue");
				$("#addMoney").attr("style","display:block;");
			}else if(rflag.val() == 5){
				$("#addMoney").attr("style","display:none;");
				$("#r"+rflag.val()).find("a").next().attr("name", "ruleResultValue");
			}else{
				$("#addMoney").attr("style","display:none;");
				$("#r"+rflag.val()).find("span").next().attr("name", "ruleResultValue");
			}
		}
		for(var i=0; i<rflag.find("option").length; i++){
			if(i != rflag.val()){
				$("#r"+i).attr("style", "display:none;");
				if(i==4 || i==5){
					$("#r"+i).find("a").next().attr("name", "");
					$("#r"+i).find(".tag").empty();
				}else{
					$("#r"+i).find("span").next().attr("name", "");
				}
			}
		}
	}
	//提交
	function doSubmit(){
		$(".savebtn").attr("disabled",true);
		
		//判断追加金额（addConsumeMoney）的值是否有效（若历史或实时行为选择了“消费”，则有效；若两者均未选择，则无效）　
		var behave1 = $("#curr_selectAction").val();
		var behave2 = $("#action_0").prop("checked");
		if(isEmpty(behave1) && behave2==false){
			$("input[name='addConsumeMoney']").val("");
		}
		
		$("select[name='ruleResultType']").attr("disabled",false);
		if(isEmpty("${info.activityId}")){
			var activityId ="${activityId}";
		}else{
			var activityId ="${info.activityId}";
		}
		if(isEmpty($("#ruleId").val())){
			var url = "${basePath }rule.do?method=add";
		}else{
			var url = "${basePath }rule.do?method=update";
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
						parent.$.fancybox.close();
						parent.$(".file_nav").find("a").eq(1).click();
					}
				}
			});
		}else{
			$(".savebtn").attr("disabled",false);
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
		var startTime = $("input[name='startTime']");
		var endTime = $("input[name='endTime']");
		var ruleResultType = $("select[name='ruleResultType']");
		var ruleActiveType = $("select[name='ruleActiveType']");

		if(ruleResultType.val()=="1"){
			var ruleResultValue =$("select[name='ruleResultValue']");
		}else {
			var ruleResultValue =$("input[name='ruleResultValue']");
		}
		
		var currentTime = ("${currentTime}").replace(/-/g,"/");
		var currentDateTime = ("${currentDateTime}").replace(/-/g,"/");
		var expectPublishTimeVal = expectPublishTime.val().replace(/-/g,"/");
		var startTimeVal = startTime.val().replace(/-/g,"/");
		var	endTimeVal = endTime.val().replace(/-/g,"/");
		var sTime = Date.parse(("${sTime}").replace(/-/g,"/"));
		var eTime = Date.parse(("${eTime}").replace(/-/g,"/"));
		
		if(isEmpty(ruleName.val())){
			alert("规则名称不能为空！");
			ruleName.focus();
			return false;
		}
		if(isEmpty(ruleResultType.val())){
			alert("请选择规则类型！");
			ruleResultType.focus();
			return false;
		}
		if(isEmpty(ruleResultValue.val())){
			alert("请填选规则结果值！");
			ruleResultValue.focus();
			return false;
		}else{
			if(ruleResultType.val()==3){
				var num = ruleResultValue.val();
				if(!checkDouble3(num)){
					alert("折扣率应该为大于0小于1的小数！");
					ruleResultValue.focus();
					return false;
				}
			}
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
