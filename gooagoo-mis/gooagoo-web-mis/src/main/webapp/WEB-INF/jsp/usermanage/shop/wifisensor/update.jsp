<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${imgPath}/mis/css/mis.css" type="text/css" rel="stylesheet">
<title>Wifisensor编辑页面</title>
</head>

<body>
<form id="addForm" method="post">
<div class="popMsg">
<h2>Wifisensor编辑</h2>
  	<br/>
    <ul>
    	<li>
		 	<span>商家：</span>
			<select id="shopId" name="shopId">
			    <c:forEach var="itemShop" items="${shopInfoList }" varStatus="imShop" >
			    	<option value="${itemShop.shopId}" <c:if test="${deviceWifisensor.shopId eq itemShop.shopId}">selected="selected"</c:if>>${itemShop.shopName }</option>
				</c:forEach>
			</select>
		</li>
		<li>
		    <span>实体店：</span>
			<select id="shopEntityId" name="shopEntityId">
				<c:forEach var="itemShopEntity" items="${mShopEntityInfoList }" varStatus="imShopEntity" >
					<option value="${itemShopEntity.shopEntityId}" <c:if test="${deviceWifisensor.shopEntityId eq itemShopEntity.shopEntityId}">selected="selected"</c:if>>${itemShopEntity.shopEntityName }</option>
				</c:forEach>
			</select>
			<label class="wrong" id="lbshopEntityId" for="shopEntityId" style="color:red; width: 120px;float: none;display: none;">请选择实体店！</label>
		</li>
	    <li>
	    	<span>MAC地址：</span>
	    	${deviceWifisensor.deviceMac}
	    </li>
	    <li>
	    	<span>设备型号：</span>
	    	<c:choose>
	    		<c:when test="${deviceWifisensor.deviceType eq '0'}">普通型</c:when>
	    		<c:when test="${deviceWifisensor.deviceType eq '1'}">精简型</c:when>
	    	</c:choose>
	    </li>
	    <li>
	    	<span>设备序列号：</span>
	    	${deviceWifisensor.deviceSn}
	    </li>
	    <li>
			<span>安装日期：</span>
	        <input id="installDate" name="installDate"  class="Wdate" type="text" onfocus="WdatePicker()" value="<fmt:formatDate value="${deviceWifisensor.installDate}" type="both" pattern="yyyy-MM-dd"/>" style="cursor: pointer;" />
	        <label class="wrong" id="lbinstallDate" style="color:red; width: 120px;float: none;display: none;">请输入安装日期！</label>
	    </li>
	    <li>
			<span >是否删除：</span>
			<input type="radio" name="isDel" class="other_add" value="N"/>未删除
         	<input type="radio" name="isDel" class="other_add" value="Y" checked="checked"/>已删除
		</li>
	</ul>
</div>
<div class="popBtn">
	<input type ="button" class="perMsg_btn" value="确定" onclick="save();"/>
	<input type ="button" class="perMsg_btn" value="取消" onclick="closefbox();"/>
	<input type="hidden" name="deviceWifisensorId" value="${deviceWifisensor.deviceWifisensorId}"/>
</div>
</form>
<script type="text/javascript">

$(function(){
	$("#shopId").bind("change", changeShop);
	var isDel = '${deviceWifisensor.isDel }';
	$(":radio[name='isDel'][value= " + isDel + "]").click();//是否删除 
	$("#shopEntityId").bind("change", checkshopEntityId);
	$("#installDate").bind("blur", changeinstallDate);
});

function checkshopEntityId(){
	if(!isEmpty($("#shopEntityId").val())){
		$("#lbshopEntityId").hide();
	}
}

function changeinstallDate(){
	if(!isEmpty($("#installDate").val())){
		$("#lbinstallDate").hide();
	}
}

//根据商家ID查询商家实体店集合
function changeShop(){
	var url = "shopWifisensor.do?method=selectShopEntityInfo";
	var data = "shopId=" + $("#shopId").val();
	var shopEntityList = ajaxJsonMessageByData(url,data);
	if(!isEmpty(shopEntityList)){
		var cont = "";
		$(shopEntityList).each(function(index){
			var val = shopEntityList[index];
			cont += "<option value=\"" + val.shopEntityId + "\"";
			if("${deviceWifisensor.shopEntityId}" == val.shopEntityId){
				cont += " selected=\"selected\" ";
			}
			cont += ">" + val.shopEntityName + "</option>";
		});
		$("#shopEntityId").html(cont);
	}else{
		$("#shopEntityId").html("<option value=\"\">--请选择--</option>");
	}
	$("#lbshopEntityId").hide();
}

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
	if(checkNull('shopEntityId','lbshopEntityId') || checkNull('installDate','lbinstallDate')){
		return false;
	}
	if(!isEmpty($("#shopId").val())){
		var url = "shopWifisensor.do?method=updateWifisensor";
	    var data = $("#addForm").serialize();
	    var result = ajaxJsonVoByData(url,data);
	    alert(result);
		closefbox();
	}else{
		alert("请选择商家!");
		$("#shopId").focus();
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
	(document.parentWindow || document.defaultView).parent.page(1);
}
</script>
</body>
</html>