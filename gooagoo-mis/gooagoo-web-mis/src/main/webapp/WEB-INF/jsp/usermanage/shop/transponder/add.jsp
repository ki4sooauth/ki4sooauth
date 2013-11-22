<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${imgPath}/mis/css/mis.css" type="text/css" rel="stylesheet">
<title>实体店Transc分配页面</title>
</head>

<body>
<form id="addForm" method="post">
	<div class="popMsg">
		<h2>商家转发器分配</h2>
		<br/>
		<ul>
		    <li>
		    	<span>实体店：</span>
				<select id="sel">
				    <c:forEach var="item" items="${mShopEntityInfoList }" varStatus="im" >
				    	<option value="${ item.shopEntityId};${ item.shopId}" >${item.shopEntityName }</option>
					</c:forEach>
				</select>  
		    </li>
		    <li>
			    <span >转发器MAC地址：</span>
			    <input type="text" value=""  id ="deviceMac" name="deviceMac" maxlength="32"/>
				<label class="wrong" id="lbMac" for="deviceMac"  style="color:red; width: 120px;float: none;display: none;">请输入转发器MAC地址！</label>
		    </li> 	       
		    <li>
			    <span >设备型号：</span>
	   		 	<select id="deviceType " name="deviceType">
						<option selected="selected" value="0">普通型</option>
						<option value="1">精简型</option>
				</select>
				<label class="wrong" id="lbTypeId" style="color:red; width: 120px;float: none;display: none;">请输入设备型号！</label>
		    </li>
	        <li>
			    <span >设备序列号：</span>
			    <input type="text" value=""  id ="deviceSn" name="deviceSn" maxlength="50"/>
			    <label class="wrong" id="lbSn" for="deviceSn" style="color:red; width: 120px;float: none;display: none;">请输入设备序列号！</label>
		    </li>
		    <li>
		    	<span>对应操作的系统：</span>
		    	<select id ="systemType" name="systemType">
		    		<option value="0">DOS</option>
		    		<option value="1" selected="selected">Windows</option>
		    		<option value="2">Linux</option>
		    	</select>
			    <label class="wrong" id="lbSystemType" for="systemType" style="color:red; width: 120px;float: none;display: none;">请输入对应操作的系统！</label>
		    </li>
		    <li>
		    	<span>对应的解析格式：</span>
		    	<select id =billParse name="billParse">
		    		<c:forEach items="${bill_parse }" var="bill">
		    			<option value="${bill.englishName }">${bill.chineseName }</option>
		    		</c:forEach>
		    	</select>
			    <label class="wrong" id="lbBillParse" for="billParse" style="color:red; width: 120px;float: none;display: none;">请输入对应的解析格式！</label>
		    </li>
		    <li>
		    	<span>对应的功能：</span>
		    	<select id =stService name="stService">
		    		<c:forEach items="${st_service }" var="st">
		    			<option value="${st.englishName }">${st.chineseName }</option>
		    		</c:forEach>
		    	</select>
			    <label class="wrong" id="lbStService" for="stService" style="color:red; width: 120px;float: none;display: none;">请输入对应的功能！</label>
		    </li>
			<li>
				<span >安装日期：</span>
			    <input id="installDate" name="installDate" class="Wdate" type="text" onfocus="WdatePicker()" value="" style="cursor: pointer;"/>
				<label class="wrong" id="lbinstallDate" for="installDate"  style="color:red; width: 120px;float: none;display: none;">请选择安装日期！</label>
		    </li>
			<li>
				<span >备注：</span>
				<textarea id ="note" name="note"></textarea>
				<label class="wrong" id="lbNote" style="color:red; width: 120px;float: none;display: none;">请输入备注！</label>
		    </li>
		</ul>
	</div>
	<div class="popBtn">
		<input type ="button" class="perMsg_btn" value="确定" onclick="javascript:save();"/>
		<input type ="button" class="perMsg_btn" value="取消" onclick="javascript:closefbox();"/>
	</div>
</form>
<script type="text/javascript">
//保存转发器数据
function save(){
	 if(checkNull('deviceMac','lbMac')  || checkNull('deviceSn','lbSn') || checkNull('installDate','lbinstallDate')){
		return false;
	} 
	 
	var data = $("#sel").val();
	var datas = data.split(";");
	if(datas[0]　!= null && "" != datas[0]){
		var url = "shopTranspc.do?method=addTranspc";
	    var data = $("#addForm").serialize()+"&shopEntityId="+datas[0]+"&shopId="+datas[1];
	    var result = ajaxJsonVoByData(url,data);
	    alert(result);
	    if(!"商家转发器的MAC地址已存在" == result){
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

//关闭窗口
function closefbox(){
	(document.parentWindow || document.defaultView).parent.closeFancyBox();
}
</script>
</body>
</html>