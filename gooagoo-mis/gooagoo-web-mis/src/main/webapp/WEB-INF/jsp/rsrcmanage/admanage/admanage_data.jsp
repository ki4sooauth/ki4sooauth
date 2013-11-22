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
					<span style="width: 140px;"><code>*</code>广告位名称：</span>
					<input type="hidden" name="bidId" value="${adsManage.bidId }" />
					${adsManage.adName }
				</li>
				<li><span style="width: 140px;"><code>*</code>图片地址：</span>
					<input type="text" class="name_input" id="imgUrl" name="imgUrl" readonly="readonly" value="${adsManage.imgUrl }"/>
					<input id="btnFrontPic" type="button" value="浏览" class="fileUpload btnOrange" style="width: 50px;"/>
					<label class="wrong" id="lblImgUrl" style="float:none; display: none;">请上传图片！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>链接地址：</span>
					<input type="text" class="name_input" id="linkUrl" name="linkUrl" value="${adsManage.linkUrl }"/>
					<label class="wrong" id="lblLinkUrl" style="float:none; display: none;">请输入链接地址！</label>
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
	initFileUpload("btnFrontPic");
})

// 非空校验 
function checkIsNull() {
	$("#imgUrl").bind("blur", checkImgUrl);
	$("#imgUrl").bind("focus", function() {$("#lblImgUrl").css({"display" : "none"});});
	$("#linkUrl").bind("blur", checkLinkUrl);
	$("#linkUrl").bind("change", function() {$("#lblLinkUrl").css({"display" : "none"});});
}

// 图片上传返回url
function initFileUpload(id) {
	$("#"+id).submitFile({
		action : "upload.do?method=uploadFile",
		zindex : 0,
		type : "text",
		success : function(url, obj) {
			if(id == 'btnFrontPic'){
				$("#imgUrl").val(url);
				$("#lblFrontPic").hide();
			}
		}
	});
}
	
// 图片地址
function checkImgUrl() {
	if ($("#imgUrl").val() == "") {
		$("#lblImgUrl").show();
		return false;
	} else {
		return true;
	}
}

// 链接地址
function checkLinkUrl() {
	if ($("#linkUrl").val() == "") {
		$("#lblLinkUrl").show();
		return false;
	} else {
		return true;
	}
}

// 保存广告位
function saveDic() {
	if (checkImgUrl() && checkLinkUrl()) {
		var url = "adManage.do?method=submitDatas";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonMessageByData(url, data);
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