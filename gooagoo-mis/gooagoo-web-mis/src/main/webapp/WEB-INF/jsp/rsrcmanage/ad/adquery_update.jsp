<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>广告位</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul style="width: 500px;">
				<li><span style="width: 140px;"><code>*</code>广告位编码：</span>
					${ad.adCode }
					<input type="hidden" name="adCode" value="${ad.adCode }" />
				</li>
				<li><span style="width: 140px;"><code>*</code>广告位类型：</span>
					<select name="adType">
						<option value="">请选择</option>
						<c:forEach items="${ad_type }" var="item">
					    	<option value="${item.englishName}" <c:if test="${ad.adType eq item.englishName }">selected=selected</c:if>>${item.chineseName}</option>
					    </c:forEach>
					</select>
					<label class="wrong" id="lblAdType" style="float:none; display: none;">请选择广告位类型！</label>
				</li>
				<li><span style="width: 140px;"><code>*</code>广告位名称：</span>
					<input type="text" class="name_input" id="adName" name="adName" value="${ad.adName }" />
					<label class="wrong" id="lblAdName" style="float:none; display: none;">请输入广告位名称！</label>
				</li>
				<li><span class="f_b_t" style="width: 140px;">广告位介绍url：</span>
					<input type="text" class="name_input" id="adUrl" name="adUrl" value="${ad.adUrl }"/>
				</li>
				<li><span class="f_b_t" style="width: 140px;">广告位描述：</span>
					<textarea class="text_men" rows="" cols="" id="adDescription" name="adDescription"></textarea>
				</li>
				<li class="perMsg_commit">
				<input type="button" class="perMsg_btn" value="保存设置" onclick="saveDic()"/>
			</li>
			</ul>
		</form>
	</div>
</body>
<script type="text/javascript">
$(function() {
	checkIsNull();
	initData();
})

// 初始化数据 
function initData(){
	$("#adDescription").val('${ad.adDescription}');
	$("#adDescription").show();
}

// 非空校验 
function checkIsNull() {
	$("#shopId").bind("blur", checkShopId);
	$("#shopId").bind("focus", function() {$("#lblShopId").css({"display" : "none"});});
}
	
//商家编号
function checkShopId() {
	if ($("#shopId").val() == "") {
		$("#lblShopId").show();
		return false;
	} else {
		return true;
	}
}

// 保存规则配置 
function saveDic() {
	if (checkShopId()) {
		var url = "ruleConfig.do?method=updateRuleConfig";
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