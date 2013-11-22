<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>广告位管理</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul style="width: 500px;">
				<li>
					<span style="width: 140px;"><code>*</code>广告位编码：</span>
					<input type="hidden" name="bidId" value="${adsManage.bidId }" />
					<input type="hidden" name="adCode" value="${adsManage.adCode }" />
					${adsManage.adCode }
				</li>
				<li><span style="width: 140px;"><code>*</code>起拍价：</span>
					<input type="text" class="name_input" id="startingPrice" name="startingPrice" value="${adsManage.startingPrice }" />
					<label class="wrong" id="lblStartingPrice" style="float:none; display: none;">请输入起拍价！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>涨幅：</span>
					<input type="text" class="name_input" id="increase" name="increase" value="${adsManage.increase }"/>
					<label class="wrong" id="lblIncrease" style="float:none; display: none;">请输入涨幅！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>竞价起始时间：</span>
					<input id="bidStartTime" name="bidStartTime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" style="cursor: pointer;" value="<fmt:formatDate value="${adsManage.bidStartTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />" />
					<label class="wrong" id="lblBidStartTime" style="float:none; display: none;">请选择竞价起始时间！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>竞价结束时间：</span>
					<input id="bidEndTime" name="bidEndTime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" style="cursor: pointer;" value="<fmt:formatDate value="${adsManage.bidEndTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />"/>
					<label class="wrong" id="lblBidEndTime" style="float:none; display: none;">请选择竞价结束时间！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>生效起始日期：</span>
					<input id="effectStartDate" name="effectStartDate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="cursor: pointer;" value="<fmt:formatDate value="${adsManage.effectStartDate}" type="both" pattern="yyyy-MM-dd" />"/>
					<label class="wrong" id="lblEffectStartDate" style="float:none; display: none;">请选择生效起始日期！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>生效结束日期：</span>
					<input id="effectEndDate" name="effectEndDate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="cursor: pointer;" value="<fmt:formatDate value="${adsManage.effectEndDate}" type="both" pattern="yyyy-MM-dd" />"/>
					<label class="wrong" id="lblEffectEndDate" style="float:none; display: none;">请选择生效结束日期！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>生效起始时间：</span>
					<input id="effectStartTime" name="effectStartTime" type="text" onfocus="WdatePicker({dateFmt:'HH:mm:ss'})" class="Wdate" style="cursor: pointer;" value="<fmt:formatDate value="${adsManage.effectStartTime}" type="both" pattern="HH:mm:ss" />"/>
					<label class="wrong" id="lblEffectStartTime" style="float:none; display: none;">请选择生效起始时间！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>生效结束时间：</span>
					<input id="effectEndTime" name="effectEndTime" type="text" onfocus="WdatePicker({dateFmt:'HH:mm:ss'})" class="Wdate" style="cursor: pointer;" value="<fmt:formatDate value="${adsManage.effectEndTime}" type="both" pattern="HH:mm:ss" />"/>
					<label class="wrong" id="lblEffectEndTime" style="float:none; display: none;">请选择生效结束时间！</label>
				</li>
				<li>
					<input type="button" class="perMsg_btn" value="保存设置" onclick="saveDic()"/>
				</li>
			</ul>
		</form>
	</div>
</body>
<script type="text/javascript">
$(function() {
	checkIsNull();
})

// 非空校验 
function checkIsNull() {
	$("#startingPrice").bind("blur", checkStartingPrice);
	$("#startingPrice").bind("change", function() {$("#lblStartingPrice").css({"display" : "none"});});
	$("#increase").bind("blur", checkIncrease);
	$("#increase").bind("focus", function() {$("#lblIncrease").css({"display" : "none"});});
	$("#bidStartTime").bind("blur", checkBidStartTime);
	$("#bidStartTime").bind("focus", function() {$("#lblBidStartTime").css({"display" : "none"});});
	$("#bidEndTime").bind("blur", checkBidEndTime);
	$("#bidEndTime").bind("focus", function() {$("#lblBidEndTime").css({"display" : "none"});});
	$("#effectStartDate").bind("blur", checkEffectStartDate);
	$("#effectStartDate").bind("focus", function() {$("#lblEffectStartDate").css({"display" : "none"});});
	$("#effectEndDate").bind("blur", checkEffectEndDate);
	$("#effectEndDate").bind("focus", function() {$("#lblEffectEndDate").css({"display" : "none"});});
	$("#effectStartTime").bind("blur", checkEffectStartTime);
	$("#effectStartTime").bind("focus", function() {$("#lblEffectStartTime").css({"display" : "none"});});
	$("#effectEndTime").bind("blur", checkEffectEndTime);
	$("#effectEndTime").bind("focus", function() {$("#lblEffectEndTime").css({"display" : "none"});});
}
	
//起拍价
function checkStartingPrice() {
	if ($("#startingPrice").val() == "") {
		$("#lblStartingPrice").show();
		return false;
	} else {
		return true;
	}
}

// 涨幅
function checkIncrease() {
	if ($("#increase").val() == "") {
		$("#lblIncrease").show();
		return false;
	} else {
		return true;
	}
}

// 竞价起始时间
function checkBidStartTime() {
	if ($("#bidStartTime").val() == "") {
		$("#lblBidStartTime").show();
		return false;
	} else {
		return true;
	}
}

// 竞价结束时间
function checkBidEndTime() {
	if ($("#bidEndTime").val() == "") {
		$("#lblBidEndTime").show();
		return false;
	} else {
		return true;
	}
}

// 生效起始日期
function checkEffectStartDate() {
	if ($("#effectStartDate").val() == "") {
		$("#lblEffectStartDate").show();
		return false;
	} else {
		return true;
	}
}

// 生效结束日期
function checkEffectEndDate() {
	if ($("#effectEndDate").val() == "") {
		$("#lblEffectEndDate").show();
		return false;
	} else {
		return true;
	}
}

//生效起始时间
function checkEffectStartTime() {
	if ($("#effectStartTime").val() == "") {
		$("#lblEffectStartTime").show();
		return false;
	} else {
		return true;
	}
}

// 生效结束时间
function checkEffectEndTime() {
	if ($("#effectEndTime").val() == "") {
		$("#lblEffectEndTime").show();
		return false;
	} else {
		return true;
	}
}

// 保存广告位管理
function saveDic() {
	if (checkStartingPrice() && checkIncrease() && checkBidStartTime() && checkBidEndTime() && checkEffectStartDate() && checkEffectEndDate() && checkEffectStartTime() && checkEffectEndTime()) {
		var url = "adManage.do?method=updateAdManage";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonMessageByData(url,data);
		if(ret.success){
			alert(ret.message);
			(document.parentWindow || document.defaultView).parent.closeFancyBox();
			(document.parentWindow || document.defaultView).parent.page(1);
		}else{
			alert(ret.message);
		}
	}
}
</script>
</html>