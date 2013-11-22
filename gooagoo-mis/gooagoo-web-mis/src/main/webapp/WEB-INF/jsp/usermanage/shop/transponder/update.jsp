<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${imgPath}/mis/css/mis.css" type="text/css" rel="stylesheet">
<title>实体店Transc编辑页面</title>
</head>

<body>
<form id="addForm" method="post">
	<div class="popMsg">
		<h2>商家转发器编辑</h2>
		<br/>
		<ul>
			<li>
		    	<span>商家：</span>
				<select id="shopId" name="shopId">
				    <c:forEach var="itemShop" items="${shopInfoList }" varStatus="imShop" >
				    	<option value="${itemShop.shopId}" <c:if test="${mtrans.shopId eq itemShop.shopId}">selected="selected"</c:if>>${itemShop.shopName }</option>
					</c:forEach>
				</select>
		    </li>
		    <li>
		    	<span>实体店：</span>
				<select id="shopEntityId" name="shopEntityId">
				    <c:forEach var="itemShopEntity" items="${mShopEntityInfoList }" varStatus="imShopEntity" >
				    	<option value="${itemShopEntity.shopEntityId}" <c:if test="${mtrans.shopEntityId eq itemShopEntity.shopEntityId}">selected="selected"</c:if>>${itemShopEntity.shopEntityName }</option>
					</c:forEach>
				</select>
				<label class="wrong" id="lbshopEntityId" for="shopEntityId" style="color:red; width: 120px;float: none;display: none;">请选择实体店！</label>
		    </li>
		    <li>
			    <span>转发器MAC地址：</span>
			    ${mtrans.deviceMac}
		    </li> 	       
		    <li>
			    <span>设备型号：</span>
			    <select name="deviceType">
			    	<option value="0" <c:if test="${mtrans.deviceType eq '0'}">selected="selected"</c:if>>普通型</option>
			    	<option value="1" <c:if test="${mtrans.deviceType eq '1'}">selected="selected"</c:if>>精简型</option>
			    </select>
		    </li>
	        <li>
			    <span>设备序列号：</span>
			    <input type="text" value="${mtrans.deviceSn}" id ="deviceSn" name="deviceSn" maxlength="50"/>
			    <label class="wrong" id="lbSn" for="deviceSn" style="color:red; width: 120px;float: none;display: none;">请输入设备序列号！</label>
		    </li>
		    <li>
		    	<span>对应操作的系统：</span>
		    	<select name="systemType">
		    		<option value="0" <c:if test="${mtrans.systemType eq '0'}">selected="selected"</c:if>>DOS</option>
		    		<option value="1" <c:if test="${mtrans.systemType eq '1'}">selected="selected"</c:if>>Windows</option>
		    		<option value="2" <c:if test="${mtrans.systemType eq '2'}">selected="selected"</c:if>>Linux</option>
		    	</select>
		    </li>
		    <li>
		    	<span>对应的解析格式：</span>
		    	<select name="billParse">
			    	<c:forEach items="${bill_parse }" var="bill">
			    		<option value="${bill.englishName }" <c:if test="${mtrans.billParse eq bill.englishName}">selected="selected"</c:if>>${bill.chineseName }</option>
			    	</c:forEach>
		    	</select>
		    </li>
		    <li>
		    	<span>对应的功能：</span>
		    	<select name="stService">
			    	<c:forEach items="${st_service }" var="st">
			    		<option value="${st.englishName }" <c:if test="${mtrans.stService eq st.englishName}">selected="selected"</c:if>>${st.chineseName }</option>
			    	</c:forEach>
		    	</select>
		    </li>
			<li>
				<span >请安装日期：</span>
			    <input id="installDate" name="installDate" class="Wdate" type="text" onfocus="WdatePicker()" value="<fmt:formatDate value="${mtrans.installDate}" type="both" pattern="yyyy-MM-dd"/>" style="cursor: pointer;"/>
				<label class="wrong" id="lbinstallDate" for="installDate"  style="color:red; width: 120px;float: none;display: none;">请选择安装日期！</label>
		    </li>
		    <li>
				<span >是否删除：</span>
				<input type="radio" name="isDel" class="other_add" value="N"/>未删除
         		<input type="radio" name="isDel" class="other_add" value="Y" checked="checked"/>已删除
		    </li>
			<li>
				<span >备注：</span>
				<textarea id ="note" name="note"></textarea>
				<label class="wrong" id="lbNote" style="color:red; width: 120px;float: none;display: none;">请输入备注！</label>
		    </li>
		</ul>
	</div>
	<div class="popBtn">
		<input type="button" class="perMsg_btn" value="确定" onclick="javascript:save();"/>
		<input type="button" class="perMsg_btn" value="取消" onclick="javascript:closefbox();"/>
		<input type="hidden" name="deviceTransponderId" value="${mtrans.deviceTransponderId}"/>
	</div>
</form>
<script type="text/javascript">
$(function() {
	$("#note").val('${mtrans.note}');
	$("#shopId").bind("change", changeShop);
	var isDel = '${mtrans.isDel }';
	$(":radio[name='isDel'][value= " + isDel + "]").click();//是否删除 
	$("#shopEntityId").bind("change", checkshopEntityId);
	$("#installDate").bind("blur", changeinstallDate);
	$("#deviceSn").bind("blur", changedeviceSn);
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

function changedeviceSn(){
	if(!isEmpty($("#deviceSn").val())){
		$("#lbSn").hide();
	}
}

//根据商家ID查询商家实体店集合
function changeShop(){
	var url = "shopTranspc.do?method=selectShopEntityInfo";
	var data = "shopId=" + $("#shopId").val();
	var shopEntityList = ajaxJsonMessageByData(url,data);
	if(!isEmpty(shopEntityList)){
		var cont = "";
		$(shopEntityList).each(function(index){
			var val = shopEntityList[index];
			cont += "<option value=\"" + val.shopEntityId + "\"";
			if("${mtrans.shopEntityId}" == val.shopEntityId){
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

//保存转发器数据
function save(){
	if(checkNull('installDate','lbinstallDate') || checkNull('shopEntityId','lbshopEntityId') || checkNull('deviceSn','lbSn')){
		return false;
	} 
	if(!isEmpty($("#shopId").val())){
		var url = "shopTranspc.do?method=updateTranspc";
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

//关闭窗口
function closefbox(){
	(document.parentWindow || document.defaultView).parent.closeFancyBox();
	(document.parentWindow || document.defaultView).parent.page(1);
}
</script>
</body>
</html>