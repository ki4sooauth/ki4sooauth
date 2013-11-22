<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul style="width: 500px;">
				<li><span style="width: 140px;"><code>*</code>小平台名称：</span>
					<select name="platformId">
					    <c:forEach items="${platList }" var="plat">
					    	<option value="${plat.platformId }" <c:if test="${plat.platformId eq trade.platformId}"></c:if>>${plat.platformName }</option>
					    </c:forEach>
					</select>
				</li>
				<li><span style="width: 140px;"><code>*</code>商圈名称：</span>
					<input type="text" class="name_input" id="tradeAreaName" name="tradeAreaName" value="${trade.tradeAreaName }"/>
					<label class="wrong" id="lblTradeAreaName" style="float:none; display: none;">请输入商圈名称！</label>
				</li>
				<li><span class="f_b_t" style="width: 130px;">描述：</span>
					<input type="text" class="name_input" id="description" name="description" value="${trade.description }"/>
				</li>
				<li><span class="f_b_t" style="width: 130px;">备注：</span>
					<textarea class="text_men" rows="" cols="" id="note" name="note"></textarea>
				</li>
				<li class="perMsg_commit">
					<input type="button" class="perMsg_btn" value="保存设置" onclick="saveTra()" />
					<input type="hidden" name="tradeAreaId" value="${trade.tradeAreaId }"/>
				</li>
			</ul>
		</form>
	</div>
</body>
<script type="text/javascript">
$(function() {
	checkIsNull();
	initData();
});

// 初始化数据 
function initData(){
	$("#note").val('${trade.note}');
}
// 非空校验 
function checkIsNull() {
	$("#tradeAreaName").bind("blur", checkTradeAreaName);
	$("#tradeAreaName").bind("focus", function() {$("#lblTradeAreaName").css({"display" : "none"});});
}
	
// 商圈名称
function checkTradeAreaName() {
	if ($("#tradeAreaName").val() == "") {
		$("#lblTradeAreaName").show();
		return false;
	} else {
		return true;
	}
}

// 保存商圈
function saveTra() {
	if (checkTradeAreaName()) {
		var url = "tradeArea.do?method=updateTradeArea";
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