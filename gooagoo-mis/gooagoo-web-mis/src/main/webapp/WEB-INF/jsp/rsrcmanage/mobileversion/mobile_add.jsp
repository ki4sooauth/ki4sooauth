<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${imgPath}/mis/common/js/misAjaxSubmitFile.js"></script>
<title>设备类型</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul style="width: 500px;">
				<li><span style="width: 140px;"><code>*</code>APP识别码：</span>
					<input type="text" class="name_input" id="appCode" name="appCode" />
					<label class="wrong" id="lblAppCode" style="float:none; display: none;">请输入APP识别码！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>设备类型：</span>
					<select id="mobileType" name="mobileType">
						<c:forEach items="${mobile_type }" var="mobile">
							<option value="${mobile.englishName }">${mobile.chineseName }</option>
						</c:forEach>
					</select>
					<label class="wrong" id="lblMobileType" style="float:none; display: none;">请选择设备类型！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>版本名称：</span>
					<input type="text" class="name_input" id="versionName" name="versionName" />
					<label class="wrong" id="lblVersionName" style="float:none; display: none;">请输入版本名称！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>版本号：</span>
					<input type="text" class="name_input" id="version" name="version" />
					<label class="wrong" id="lblVersion" style="float:none; display: none;">请输入版本号！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>APK包链接地址：</span>
					<input type="text" class="name_input" id="link" name="link" readOnly="readonly" />
					<input id="btnLink" type="button" value="浏览" class="fileUpload btnOrange" style="width: 50px;"/>
					<label class="wrong" id="lblLink" style="float:none; display: none;">请上传APK包！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>所属商圈：</span>
					<select class="name_input" id="platform" name="platform">
						<c:forEach items="${tradeList }" var="trade">
							<option value="${trade.tradeAreaId }">${trade.tradeAreaName }</option>
						</c:forEach>
					</select>
					<label class="wrong" id="lblPlatform" style="float:none; display: none;">请选择所属商圈！</label>
				</li>
				<li>
					<span class="f_b_t" style="width: 130px;">备注：</span>
					<textarea  class="text_men" rows="" cols="" id="note" name="note"></textarea>
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
	initFileUpload("btnLink");
})

// 非空校验 
function checkIsNull() {
	$("#appCode").bind("blur", checkAppCode);
	$("#appCode").bind("focus", function() {$("#lblAppCode").css({"display" : "none"});});
	$("#mobileType").bind("blur", checkMobileType);
	$("#mobileType").bind("focus", function() {$("#lblMobileType").css({"display" : "none"});});
	$("#versionName").bind("blur", checkVersionName);
	$("#versionName").bind("focus", function() {$("#lblVersionName").css({"display" : "none"});});
	$("#version").bind("blur", checkVersion);
	$("#version").bind("focus", function() {$("#lblVersion").css({"display" : "none"});});
	$("#link").bind("blur", checkLink);
	$("#link").bind("focus", function() {$("#lblLink").css({"display" : "none"});});
	$("#platform").bind("blur", checkPlatform);
	$("#platform").bind("focus", function() {$("#lblPlatform").css({"display" : "none"});});
}

//APK包上传返回url
function initFileUpload(id) {
	$("#"+id).submitFile({
		action : "upload.do?method=uploadFile&type=mobile",
		zindex : 0,
		type : "text",
		success : function(url, obj) {
			$("#link").val(url);
			$("#lblLink").hide();
		}
	});
}

//APP识别码
function checkAppCode() {
	if ($("#appCode").val() == "") {
		$("#lblAppCode").show();
		return false;
	} else {
		return true;
	}
}
	
//设备类型
function checkMobileType() {
	if ($("#mobileType").val() == "") {
		$("#lblMobileType").show();
		return false;
	} else {
		return true;
	}
}

//版本名称
function checkVersionName() {
	if ($("#versionName").val() == "") {
		$("#lblVersionName").show();
		return false;
	} else {
		return true;
	}
}

//版本号
function checkVersion() {
	if ($("#version").val() == "") {
		$("#lblVersion").show();
		return false;
	} else {
		return true;
	}
}

//链接地址
function checkLink() {
	if ($("#link").val() == "") {
		$("#lblLink").show();
		return false;
	} else {
		return true;
	}
}

//所属商圈
function checkPlatform() {
	if ($("#platform").val() == "") {
		$("#lblPlatform").show();
		return false;
	} else {
		return true;
	}
}

// 保存
function saveDic() {
	if (checkAppCode() && checkMobileType() && checkVersionName() && checkVersion() && checkLink() && checkPlatform()) {
		var url = "mobileDevices.do?method=add";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url, data);
		alert(ret);
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.page(1);
	}
}
</script>
</html>