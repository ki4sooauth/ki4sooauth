<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>字典修改页面</title>
</head>

<body>
<div class="user_message">
	<form action="" method="post" id="addForm" name="addForm">
		<ul style="width: 500px;">
			<li>
				<span><code>*</code>商品类型名称：</span>
				<input type="hidden" name="goodsTypeId" value="${shopping.goodsTypeId }"/>
				<input type="text"  class="name_input" id="goodsTypeName" name="goodsTypeName" value="${shopping.goodsTypeName }"/>
				<label class="wrong" id="lblGoodsTypeName" style="float: none; display: none;">请输入商品类型名称！</label>
			</li>
			<li>
				<span><code>*</code>上级类型编号：</span>
				<input type="text"  class="name_input" id="parentGoodsTypeId" name="parentGoodsTypeId" value="${shopping.parentGoodsTypeId }"/>
				<label class="wrong" id="lblParentGoodsTypeId" style="float: none; display: none;">请输入上级类型编号！</label>
			</li>
			<li>
				<span><code>*</code>点击前图片：</span>
				<input type="text"  class="name_input" id="frontPic" name="frontPic" value="${shopping.frontPic }" readOnly="readonly"/>
				<input id="btnFrontPic" type="button" value="浏览" class="fileUpload btnOrange" style="width: 50px;"/>
				<label class="wrong" id="lblFrontPic" style="float: none; display: none;">请上传点击前图片！</label>
			</li>
			<li>
				<span><code>*</code>点击后图片：</span>
				<input type="text"  class="name_input" id="backPic" name="backPic" value="${shopping.backPic }" readOnly="readonly"/>
				<input id="btnBackPic" type="button" value="浏览" class="fileUpload btnOrange" style="width: 50px;"/>
				<label class="wrong" id="lblBackPic" style="float: none; display: none;">请上传点击后图片！</label>
			</li>
			<li>
				<span><code>*</code>排序号：</span>
				<input type="text"  class="name_input" id="sortOrder" name="sortOrder" value="${shopping.sortOrder }"/>
				<label class="wrong" id="lblSortOrder" style="float: none; display: none;">请输入排序号！</label>
			</li>
			<li class="perMsg_commit">
				<input type="button" class="perMsg_btn" value="保存设置" onclick="saveDic()"/>
			</li>
		</ul>
	</form>
</div>
</body>
<script type="text/javascript">
$(function(){
	checkIsNull();
	initFileUpload("btnFrontPic");
	initFileUpload("btnBackPic");
})

// 非空校验 
function checkIsNull(){
	$("#goodsTypeName").bind("blur", checkGoodsTypeName);
	$("#goodsTypeName").bind("focus", function() {$("#lblGoodsTypeName").css({"display" : "none"});});

	$("#parentGoodsTypeId").bind("blur", checkParentGoodsTypeId);
	$("#parentGoodsTypeId").bind("focus", function() {$("#lblParentGoodsTypeId").css({"display" : "none"});});

	$("#frontPic").bind("blur", checkFrontPic);
	$("#frontPic").bind("focus", function() {$("#lblFrontPic").css({"display" : "none"});});

	$("#backPic").bind("blur", checkBackPic);
	$("#backPic").bind("focus", function() {$("#lblBackPic").css({"display" : "none"});});

	$("#sortOrder").bind("blur", checkSortOrder);
	$("#sortOrder").bind("focus", function() {$("#lblSortOrder").css({"display" : "none"});});
}

//图片上传返回url
function initFileUpload(id) {
	$("#"+id).submitFile({
		action : "upload.do?method=uploadFile",
		zindex : 0,
		type : "text",
		success : function(url, obj) {
			if(id == 'btnFrontPic'){
				$("#frontPic").val(url);
				$("#lblFrontPic").hide();
			} else if(id == 'btnBackPic'){
				$("#backPic").val(url);
				$("#lblBackPic").hide();
			}
		}
	});
}
	
// 校验商品类型名称
function checkGoodsTypeName() {
	if ($("#goodsTypeName").val() == "") {
		$("#lblGoodsTypeName").show();
		return false;
	} else {
		return true;
	}
}
	
// 校验上级类型编号
function checkParentGoodsTypeId() {
	if ($("#parentGoodsTypeId").val() == "") {
		$("#lblParentGoodsTypeId").show();
		return false;
	} else {
		return true;
	}
}

//校验点击前图片
function checkFrontPic() {
	if ($("#frontPic").val() == "") {
		$("#lblFrontPic").show();
		return false;
	} else {
		return true;
	}
}

//校验点击后图片
function checkBackPic() {
	if ($("#backPic").val() == "") {
		$("#lblBackPic").show();
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
	if (checkGoodsTypeName() && checkParentGoodsTypeId() && checkFrontPic() && checkBackPic() && checkSortOrder()) {
		var url = "shopp.do?method=editDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url,data);
		alert(ret);
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.page(1);
	}
}
</script>
</html>