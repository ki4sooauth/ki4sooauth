<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>审核</title>
<style type="text/css">
.checktextarea{
	margin-left:2px;
	border-image: none;
	border-style: solid;
	border-width: 1px;
	border-color: #B2B2B2 #E2E2E2 #E2E2E2 #B2B2B2
}
</style>
<script type="text/javascript">
$(function(){
	$("#note1").focus();
});
var parentWinow1 = (document.parentWindow || document.defaultView).parent;
//提交审核
function submitCheckForm(id,status){
	var url = "shoptool.do?method=update";
	var data = "&id="+id+"&remark="+$("#remark1").val()+"&status="+status;
	var ret = ajaxJsonVoByData(url,data);
	alert(ret);
	parentWinow1.searchShopToolList($("#shopId1").val());
}
//关闭弹出层
function closeForm(){
	parentWindow1.closeFancyBox();
}
</script>
</head>

<!-- 隐藏域 -->
<input id="shopId1" type="hidden" value="${shopId}"  />
<div style="height:auto;">
	<div style="margin-top:10px;margin-bottom:8px">审核结果描述</div>
	<div>
		<label>
			<textarea id="remark1" name="note" class="checktextarea" cols="50" rows="6" ></textarea>
		</label>
		<div style="margin-top:8px; text-align:center;">
			<a href="#" onclick="submitCheckForm('${id}','B');" style="border: medium none;display:inline-block;background:url(${imgPath}/gms/marketing/images/guifanbutton-01.png) no-repeat;text-decoration:none;color:#fff;height:28px;line-height:28px;width:70px;">不通过</a>
			<span style="width:10px;">&nbsp;</span>
			<a href="#" onclick="submitCheckForm('${id}','A');"  style="border: medium none;display:inline-block;background:url(${imgPath}/gms/marketing/images/guifanbutton-01.png) no-repeat;text-decoration:none;color:#fff;height:28px;line-height:28px;width:70px;">通过</a>
		</div>
	</div>
</div>
</body>
</html>