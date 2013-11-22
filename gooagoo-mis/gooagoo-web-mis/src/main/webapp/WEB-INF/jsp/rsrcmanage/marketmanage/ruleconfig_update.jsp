<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>规则配置修改页面</title>
</head>

<body>
	<div class="user_message">
		<form action="" method="post" id="addForm" name="addForm">
			<ul style="width: 500px;">
				<li><span style="width: 140px;"><code>*</code>商家名称：</span>
					<input type="hidden" name="id" value="${rule.id}"/>
					<input type="hidden" name="shopId" value="${rule.shopId}"/>
					${rule.shopName}
					<label class="wrong" id="lblShopId" style="float:none; display: none;">请输入商家编号！</label>
				</li>
				<li><span class="f_b_t behaveTypeSelect" style="width: 140px;">行为类型：</span>
					<c:forEach items="${behave_type }" var="item">
					    <c:if test="${item.englishName eq rule.behaveType}">${item.chineseName}</c:if>
					</c:forEach>
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
	var url = "ruleConfig.do?method=selectBehaveType";
	var data = "behaveType=${rule.behaveType}";
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
					"<option value=\"Y\">是</option>";
				if(val.englishName == "0"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowTimeScope}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "1"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowVipGrade}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "2"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowActionSource}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "3"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowTime}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "4"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowTotalTime}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "5"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowMarketingGoodsCategory}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "6"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowMarketingGoodsBrand}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "7"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowMarketingGoods}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "8"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowConsumeMoney}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "9"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowPosition}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "A"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowDuration}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "B"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowServerTools}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "C"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowMarketingAction}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "D"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowMarketingEvent}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "E"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowMarketingCoupon}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else if(val.englishName == "F"){
					cont += "<option value=\"N\"";
					if("N" == "${rule.isShowVb}"){
						cont += " selected=\"selected\"";
					}
					cont += ">否</option>";
				}else{
					"<option value=\"N\">否</option>";
				}
				cont += "</select></li>";
			});
			cont += "<li class=\"perMsg_commit\"><input type=\"button\" class=\"perMsg_btn\" value=\"保存设置\" onclick=\"saveDic()\" /></li>";
			$(".rule").html(cont);
		}
	}else{
		$(".rule").html("");
	}
})

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