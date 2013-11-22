<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<title>审核商家</title>
</head>
<style>
	.popBox{padding-left:85px;}
	.popBox input{margin-left:10px;}
	.popBox span{color:red;}
	.popBox textarea{width:400px;height:150px;resize:none;margin:15px 0;}
	.popMsg .popBtn{padding:0;}
</style>
<body>
<div class="popMsg">
	<div class="popBox">
 是否审核通过：<input type="radio" name="audit" class="other_add" value="Y" checked="checked"/><label class="other_add_txt">通过</label>
         <input type="radio" name="audit" class="other_add" value="N"/><label class="other_add_txt">不通过</label><br><br>
         <span>审核不通过理由（勾选不通过时填写）：</span><br>
			<textarea id="txtcontent" name="txtcontent"></textarea>
  	</div>
  <div class="popBtn">
    <input type="button" value="确定" class="left perMsg_btn" onclick="javascript:auditShop();"/>
    <input type="button" value="取消" class="perMsg_btn" onclick="javascript:closefbox();"/>
  </div>
</div>
<script type="text/javascript">
//获取商家Id 
function getShopId(){
	return "${shopId}";
}
//审核商家 
function auditShop(){
	if(checkOnly()){
		var rad = $("input[name='audit']:checked").val();
		var shopID = getShopId();
		if("N" == rad){
			var texvalue = $("#txtcontent").val();
			if("" == texvalue || texvalue == null){
				alert("请填写审核不通过理由");
				return;
			} else if(texvalue.length > 125){
				alert("审核不通过理由长度不能超过125个汉字");
				return;
			} else {
				//未通过审核 
				var url = "shop.do?method=auditShop";
				var data = "&type=N&shopId=" + shopID + "&reason=" + texvalue;
			}
		} else{
			//通过审核 
			var url = "shop.do?method=auditShop";
			var data = "&type=A&shopId=" + shopID;
		}
		var ret = ajaxJsonVoByData(url,data);
		alert(ret);
		if(ret){
			(document.parentWindow || document.defaultView).parent.closeFancyBox();
			(document.parentWindow || document.defaultView).parent.page(1);
		} else {
			$("#txtcontent").val() = ret;
		}
	}
}
//只选择一条进行编辑 
function checkOnly(){
	var arrayMemberId = null;
	if(ids != null){
		arrayMemberId = ids.split(",");
		if((arrayMemberId.length - 1) > 1){
			alert("只能选择一个商家进行操作！");
			page(1);
				return false;
		} return true;
	} return false;
}
function closefbox(){
	(document.parentWindow || document.defaultView).parent.closeFancyBox();
}
</script>
</body>
</html>