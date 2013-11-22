<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>
</title>
<script type="text/javascript">
var parentWinow1 = (document.parentWindow || document.defaultView).parent;
//提交
function submitEditForm(){
	var shopUrlAddress = $("#shopUrlAddress1").val();
	if(isEmpty(shopUrlAddress)){
		alert("请输入商家域名!");
		$("#shopUrlAddress1").focus();
		return false;
	}
// 	else if(shopUrlAddress.indexOf(":/") != -1) {
// 		alert("不可输入http://");
// 		$("#shopUrlAddress1").focus();
// 		return false;
// 	}else if(shopUrlAddress.indexOf(".com") == -1){
// 		alert("目前仅支持.com的域名");
// 		$("#shopUrlAddress1").focus();
// 		return false;
// 	}
	
	var url = "interfshop.do?method=update";
	var data = "&id="+$("#id1").val()+"&iUrl="+$("#shopUrlAddress1").val().trim();
	var ret = ajaxJsonVoByData(url,data);
	alert(ret);
	parentWinow1.searchShopInterfList($("#shopId1").val());
}
</script>
</head>

<body>
<div class="user_message">
	<ul>
		<li>
			<span>接口名称：</span>
			<span style="width: 300px;">${vo.iName }</span>
		</li>
		<li>
			<span>接口编码：</span>
			<span style="width: 300px;">${vo.iCode }</span>
		</li>
		<li>
			<span>接口地址：</span>
			<input id="shopUrlAddress1" type="text" value="${vo.iUrl }" class="name_input" style="width: 300px;" maxlength="32" />
		</li>
		<li class="perMsg_commit">
			<input type="button" class="perMsg_btn" value="保存更改" onclick="submitEditForm()"/>
			<input id="id1" type="hidden" value="${vo.id}"/>
			<input id="shopId1" type="hidden" value="${vo.shopId}"/>
		</li>
	</ul>
</div>
</body>
</html>