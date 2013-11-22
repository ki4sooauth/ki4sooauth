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
		<ul>
			<li>
				<span><code>*</code>字典类型：</span>
				<input type="hidden" name="sysDictionaryId" value="${dic.sysDictionaryId }"/>
				<input type="text"  class="name_input" id="dictionaryType" name="dictionaryType" value="${dic.dictionaryType }"/>
				<label class="wrong" id="lblDicType" style="width: 105px;display: none;">请输入字典类型！</label>
			</li>
			<li>
				<span><code>*</code>字典类型名称：</span>
				<input type="text"  class="name_input" id="dictionaryName" name="dictionaryName" value="${dic.dictionaryName }" />
				<label class="wrong" id="lblDictionaryName" style="width: 105px;display: none;">请输入字典类型名称！</label>
			</li>
			<li>
				<span><code>*</code>英文名称：</span>
				<input type="text"  class="name_input" id="englishName" name="englishName" value="${dic.englishName }"/>
				<label class="wrong" id="lblEnglishName" style="width: 105px;display: none;">请输入英文名称！</label>
			</li>
			<li>
				<span><code>*</code>中文名称：</span>
				<input type="text"  class="name_input" id="chineseName" name="chineseName" value="${dic.chineseName }"/>
				<label class="wrong" id="lblChineseName" style="width: 105px;display: none;">请输入中文名称！</label>
			</li>
			<li>
				<span class="f_b_t">备注：</span>
				<textarea class="text_men" rows="" cols="" id="note" name="note"></textarea>
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
	initData();
})

// 初始化数据 
function initData(){
	$("#note").val('${dic.note}');
	$("#note").show();
}

// 非空校验 
function checkIsNull(){
	$("#dictionaryType").bind("blur", checkDicType);
	$("#dictionaryType").bind("focus", function(){$("#lblDicType").css({"display":"none"});});
	
	$("#dictionaryName").bind("blur", checkDictionaryName);
	$("#dictionaryName").bind("focus", function(){$("#lblDictionaryName").css({"display":"none"});});
	
	$("#englishName").bind("blur", checkEngName);
	$("#englishName").bind("focus", function(){$("#lblEnglishName").css({"display":"none"});});
	
	$("#chineseName").bind("blur", checkChineseName);
	$("#chineseName").bind("focus", function(){$("#lblChineseName").css({"display":"none"});});
}

// 校验字典类型 
function checkDicType() {
	if ($("#dictionaryType").val() == "") {
		$("#lblDicType").show();
		return false;
	} else {
		return true;
	}
}

//校验字典类型名称
function checkDictionaryName() {
	if ($("#dictionaryName").val() == "") {
		$("#lblDictionaryName").show();
		return false;
	} else {
		return true;
	}
}


// 校验英文名称 
function checkEngName() {
	if ($("#englishName").val() == "") {
		$("#lblEnglishName").show();
		return false;
	} else {
		return true;
	}
}

// 校验中文名称 
function checkChineseName() {
	if ($("#chineseName").val() == "") {
		$("#lblChineseName").show();
		return false;
	} else {
		return true;
	}
}

// 保存字典 
function saveDic(){
	if(checkDicType() && checkDictionaryName() && checkEngName() && checkChineseName()){
		var url = "sysdict.do?method=editDict";
		var data = $("#addForm").serialize();
		var ret = ajaxJsonVoByData(url,data);
		alert(ret);
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.page(1);
	}
}
</script>
</html>