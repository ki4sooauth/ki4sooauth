<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${imgPath}/mis/css/mis.css" type="text/css" rel="stylesheet">
<title>Wifisensor添加页面</title>
</head>

<body>
<form id="addForm" method="post">
<div class="popMsg">
<h2>Wifisensor添加</h2>
  	<br/>
    <ul>
	    <li>
			<span>请选择实体店：</span>
	        <select id="sel" >
		       <c:forEach var="item" items="${mShopEntityInfoList }" varStatus="im" >
					<option value="${ item.shopEntityId};${ item.shopId}">${item.shopEntityName }</option>
		       </c:forEach>
	        </select>
	    </li>
	    <li>
	    	<span>请输入MAC地址：</span>
			<input type="text" value=""  id ="deviceMac" name="deviceMac" maxlength="20" />
			<label class="wrong" id="lbDeviceMac" style="color:red; width: 120px;float: none;display: none;"">请输入MAC地址！</label>
	    </li>
	    <li>
	    	<span>请输入设备型号：</span>
	   		<!-- 0-普通型，1-精简型-->
   		 	<select id="deviceType " name="deviceType">
					<option selected="selected" value="0">普通型</option>
					<option value="1">精简型</option>
			</select>
	        <label class="wrong" id="lbDeviceType" style="width: 105px;display: none;">请选择设备型号！</label>
	    </li>
	    <li>
	    	<span>请输入设备序列号：</span>
	        <input type="text" value=""  id ="deviceSn" name="deviceSn" maxlength="50"/>
	        <label class="wrong" id="lbDeviceSn" style="color:red; width: 120px;float: none;display: none;">请输入设备序列号！</label>
	    </li>
	    <li>
			<span>请输入安装日期：</span>
	        <input id="installDate" name="installDate"  class="Wdate" type="text" onfocus="WdatePicker()" value="" style="cursor: pointer;" />
	        <label class="wrong" id="lbInstallDate" style="color:red; width: 120px;float: none;display: none;">请输入安装日期！</label>
	    </li>
		</ul>
</div>
<div class="popBtn">
	<input type ="button" class="perMsg_btn" value="确定" onclick="save();"/>
	<input type ="button" class="perMsg_btn" value="取消" onclick="closefbox();"/>
</div>
</form>
<script type="text/javascript">

function getUserId(){
	return "${userId}";
}
/* function save(){
	var shopEntityId = $("#sel").val();	
	if(shopEntityId　!= null && "" != shopEntityId){
		var url = "${basePath }/shopWifisensor.do?method=addWifisensor";
		var data = $("#addForm").serialize();
		ajaxJsonTipByData(url,data,true);
		closefbox();
		
	}else{
		alert("请选择实体店!");
		$("#sel").focus();
	}
} */
function save(){
	 if(checkNull('deviceMac','lbDeviceMac')  || checkNull('deviceSn','lbDeviceSn') || checkNull('installDate','lbInstallDate')){
		return false;
	} 
	 
	var data = $("#sel").val();
	var datas = data.split(";");
	if(datas[0]　!= null && "" != datas[0]){
		var url = "shopWifisensor.do?method=addWifisensor";
	    var data = $("#addForm").serialize()+"&shopEntityId="+datas[0]+"&shopId="+datas[1];
	    var result = ajaxJsonVoByData(url,data);
	    alert(result);
	    if(!"商家wifisensor的MAC地址已存在" == result){
	    	closefbox();
	    }
	}else{
		alert("请选择实体店!");
		$("#sel").focus();
	}
}

//判断空值
function checkNull(id,lbid){
	if("" == $("#"+id).val() || null == $("#"+id).val() || undefined == $("#"+id).val()){
		$("#"+lbid).css({"display":"inline"});
		return true;
	}else{
		return false;
	}
}
function closefbox(){
	(document.parentWindow || document.defaultView).parent.closeFancyBox();
}
</script>
</body>
</html>