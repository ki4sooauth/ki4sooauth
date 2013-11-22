<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>规则配置页面</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul style="width: 500px;">
				<li><span style="width: 140px;"><code>*</code>商家名称：</span>
					<input type="hidden" id="shopId" name="shopId" value="${shopId }"/>
					${shopName }
				</li>
				<li><span class="f_b_t" style="width: 140px;">行为类型：</span>
					<select name="behaveType" class="behaveTypeSelect">
						<option value="">请选择</option>
						<c:forEach items="${behave_type }" var="item">
					    	<option value="${item.englishName}">${item.chineseName}</option>
					    </c:forEach>
					</select>
				</li>
			</ul>
			<ul style="width: 500px;" class="rule">
			</ul>
		</form>
	</div>
</body>
<script type="text/javascript">
$(function() {
	checkIsNull();
});
$(document).on('change','.behaveTypeSelect',function(){
	var url = "ruleConfig.do?method=selectBehaveType";
	var data = "behaveType=" + $(".behaveTypeSelect").val();
	var result = ajaxJsonMessageByData(url,data);
	if(!isEmpty(result)){
		var res = result["rule_config_vlaue"];
		var obj = eval(res);
		if(isEmpty(obj)){
			$(".rule").html("");
		}else{
			var cont = "";
			$(obj).each(function(index){
				var val = obj[index];
				cont += "<li><span class=\"f_b_t\" style=\"width: 140px;\">是否显示" + val.chineseName + "：</span>" +
					"<select name=\"" + val.englishName + "\">" +
					"<option value=\"Y\">是</option>" +
					"<option value=\"N\">否</option>" +
					"</select></li>";
			});
			cont += "<li class=\"perMsg_commit\"><input type=\"button\" class=\"perMsg_btn\" value=\"保存设置\" onclick=\"saveDic()\" /></li>";
			$(".rule").html(cont);
		}
	}else{
		$(".rule").html("");
	}
});

// 非空校验 
function checkIsNull() {
	$("#shopId").bind("blur", checkShopId);
	$("#shopId").bind("focus", function() {$("#lblShopId").css({"display" : "none"});});
}
	
// 商家编号
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
		var url = "ruleConfig.do?method=addRuleConfig";
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