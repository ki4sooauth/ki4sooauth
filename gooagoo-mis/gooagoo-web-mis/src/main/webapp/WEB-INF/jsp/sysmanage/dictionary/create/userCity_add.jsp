<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>省份城市字典页面</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul>
				<li><span><code>*</code>省市编码：</span>
					<input type="text" class="name_input" id="cityId" name="cityId" />
					<label class="wrong" id="lblCityId" style="display: none;">请输入城市编码！</label>
				</li>
				<li><span><code>*</code>省市名称：</span>
					<input type="text" class="name_input" id="cityName" name="cityName" />
					<label class="wrong" id="lblCityName" style="display: none;">请输入城市名称！</label>
				</li>
				<li><span><code>*</code>上级编码：</span>
					<input type="text" class="name_input" id="parentCityId" name="parentCityId" />
					<label class="wrong" id="lblParentCityId" style="display: none;">请输入上级编码！</label>
				</li>
				<li><span>上级名称：</span>
					<input type="text" class="name_input" id="patentCityName" name="patentCityName" />
				</li>
				<li><span><code>*</code>省市级别：</span>
					<input type="text" class="name_input" id="levelCode" name="levelCode" />
					<label class="wrong" id="lblLevelCode" style="display: none;">请输入省市级别！</label>
				</li>
				<li><span><code>*</code>排序：</span>
					<input type="text" class="name_input" id="sortOrder" name="sortOrder" />
					<label class="wrong" id="lblSortOrder" style="display: none;">请输入排序！</label>
				</li>
				<li class="perMsg_commit">
					<input type="button" class="perMsg_btn" value="保存设置" onclick="saveDic()" />
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
	$("#cityId").bind("blur", checkCityId);
	$("#cityId").bind("focus", function() {$("#lblCityId").css({"display" : "none"});});

	$("#cityName").bind("blur", checkCityName);
	$("#cityName").bind("focus", function() {$("#lblCityName").css({"display" : "none"});});

	$("#parentCityId").bind("blur", checkParentCityId);
	$("#parentCityId").bind("focus", function() {$("#lblParentCityId").css({"display" : "none"});});

	$("#levelCode").bind("blur", checkLevelCode);
	$("#levelCode").bind("focus", function() {$("#lblLevelCode").css({"display" : "none"});});

	$("#sortOrder").bind("blur", checkSortOrder);
	$("#sortOrder").bind("focus", function() {$("#lblSortOrder").css({"display" : "none"});});
}
	
// 校验城市编码
function checkCityId() {
	if ($("#cityId").val() == "") {
		$("#lblCityId").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验城市名称
function checkCityName() {
	if ($("#cityName").val() == "") {
		$("#lblCityName").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验上级编码
function checkParentCityId() {
	if ($("#parentCityId").val() == "") {
		$("#lblParentCityId").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验省市级别
function checkLevelCode() {
	if ($("#levelCode").val() == "") {
		$("#lblLevelCode").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验排序号
function checkSortOrder() {
	if ($("#sortOrder").val() == "") {
		$("#lblSortOrder").show();
		return false;
	} else {
		return true;
	}
}
	
//保存字典 
function saveDic() {
	if (checkCityId() && checkCityName() && checkParentCityId() && checkLevelCode() && checkSortOrder()) {
		var url = "userCity.do?method=addDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url, data);
		alert(ret);
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.page(1);
	}
}
</script>
</html>