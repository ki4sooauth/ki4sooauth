<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加接口</title>
</head>

<body>
	<div class="user_message">
     <form action="" method="post" id="addForm" name="addForm">
     <ul>
       <li>
         <span><code>*</code>接口编码：</span>
         <input type="text"  class="name_input" id="iCode" name="iCode" value=""/>
         <label class="wrong" id="lbliCode" style="width: 105px;display: none;">接口编码！</label>
       </li>
       <li>
         <span><code>*</code>接口名称：</span>
	        <input type="text"  class="name_input" id="iName" name="iName" value=""/>
	        <label class="wrong" id="lbliName" style="width: 105px;display: none;">接口名称！</label>
       </li>
       <li>
         <span><code>*</code>接口类型：</span>
	         <input type="text"  class="name_input" id="iType" name="iType" value=""/>
	         <label class="wrong" id="lbliType" style="width: 105px;display: none;">接口类型！</label>
       </li>
       <li>
         <span><code>*</code>功能分类：</span>
	        <input type="text"  class="name_input" id="iFunction" name="iFunction" value=""/>
	        <label class="wrong" id="lbiFunction" style="width: 105px;display: none;">功能分类！</label>
       </li>
       <li>
         <span><code>*</code>接口地址：</span>
           <input type="text"  class="name_input" id="iUrl" name="iUrl" value=""/>
           <label class="wrong" id="lbiUrl" style="width: 105px;display: none;">接口地址！</label>
       </li>
       <li>
         <span><code>*</code>报文示例(xml)：</span>  
           <input type="text"  class="name_input" id="dataXml" name="dataXml" value=""/>
           <label class="wrong" id="lbdataXml" style="width: 105px;display: none;">报文示例！</label>
       </li>
       <li>
        <span><code>*</code>报文示例(json)：</span>  
           <input type="text"  class="name_input" id="dataJson" name="dataJson" value=""/>
           <label class="wrong" id="lbdataJson" style="width: 105px;display: none;">报文示例！</label>
       </li>
       <li>
         <span>业务逻辑说明：</span>
	        <input type="text"  class="name_input" id="note" name="note" value=""/>
	        <label class="wrong" id="lblnote" style="width: 105px;display: none;">业务逻辑说明！</label>
       </li>
       <li>
         <span><code>*</code>接口状态：</span>  
         <input type="radio" name="isDel" class="other_add" value="Y" /><label class="other_add_txt">已删除</label>
         <input type="radio" name="isDel" class="other_add" value="N" checked="checked"/><label class="other_add_txt">未删除</label>
       </li>
       <li>
         <span><code>*</code>创建时间：</span>
	        <input type="text"  class="address" id="createTime" name="createTime" value=""/>
	        <label class="wrong" id="lblcreateTime" style="width: 105px;display: none;">创建时间！</label>
       </li>
       <li>
         <span><code>*</code>最后一次修改时间：</span>
	        <input type="text"  class="address" id="cTimeStamp" name="cTimeStamp" value=""/>
	        <label class="wrong" id="lblcTimeStamp" style="width: 105px;display: none;">最后一次修改时间！</label>
       </li>
       <li>
         <span><code>*</code>自动编号：</span>
	        <input type="text"  class="address" id="id" name="id" value=""/>
	        <label class="wrong" id="lblid" style="width: 105px;display: none;">自动编号！</label>
       </li>
       <li>
         <span><code>*</code>参数英文名称：</span>
	        <input type="text"  class="address" id="nameEn" name="nameEn" value=""/>
	        <label class="wrong" id="lblnameEn" style="width: 105px;display: none;">参数英文名称！</label>
       </li>
       <li>
         <span><code>*</code>参数中文名称：</span>
	        <input type="text"  class="address" id="nameCn" name="nameCn" value=""/>
	        <label class="wrong" id="lblnameCn" style="width: 105px;display: none;">参数中文名称！</label>
       </li>
       <li>
         <span><code>*</code>是否必填：</span>  
         <input type="radio" name="isDel" class="other_add" value="Y" checked="checked"/><label class="other_add_txt">必填</label>
         <input type="radio" name="isDel" class="other_add" value="N"/><label class="other_add_txt">非必填</label>
       </li>
       <li>
         <span class="f_b_t">备注：</span>
	        <input type="text"  class="address" id="note" name="note" value=""/>
	        <label class="wrong" id="lblnote" style="width: 105px;display: none;">请填写备注！</label>
       </li>
       <li class="perMsg_commit">
         <input type="button" class="perMsg_btn" value="添加接口" onclick="InterfaceBaseInfo();"/>
       </li>
     </ul>
     </form>
   </div>
<script type="text/javascript">
$(document).ready(function(){
	checkIsNull();
});

function checkIsNull(){
	$("#iCode").bind("blur", checkICode);
	$("#iCode").bind("focus", function(){$("#lbliCode").css({"display":"none"});});
	
	$("#iName").bind("blur", checkIName);
	$("#iName").bind("focus", function(){$("#lbliName").css({"display":"none"});});
	
	$("#iType").bind("blur", checkIType);
	$("#iType").bind("focus", function(){$("#lbliType").css({"display":"none"});});
	
	$("#iFunction").bind("blur", checkIFunction);
	$("#iFunction").bind("focus", function(){$("#lbiFunction").css({"display":"none"});});
	
	$("#iUrl").bind("blur", checkIUrl);
	$("#iUrl").bind("focus", function(){$("#lbiUrl").css({"display":"none"});});
	
	$("#dataXml").bind("blur", checkDataXml);
	$("#dataXml").bind("focus", function(){$("#lbdataXml").css({"display":"none"});});
	
	$("#dataJson").bind("blur", checkDataJson);
	$("#dataJson").bind("focus", function(){$("#lbdataJson").css({"display":"none"});});
	
	$("#note").bind("blur", checkNote);
	$("#note").bind("focus", function(){$("#lblnote").css({"display":"none"});});
	
	$("#createTime").bind("blur", checkCreateTime);
	$("#createTime").bind("focus", function(){$("#lblcreateTime").css({"display":"none"});});
	
	$("#cTimeStamp").bind("blur", checkCTimeStamp);
	$("#cTimeStamp").bind("focus", function(){$("#lblcTimeStamp").css({"display":"none"});});
	
	$("#id").bind("blur", checkId);
	$("#id").bind("focus", function(){$("#lblid").css({"display":"none"});});
	
	$("#nameEn").bind("blur", checkNameEn);
	$("#nameEn").bind("focus", function(){$("#lblnameEn").css({"display":"none"});});
	
	$("#nameCn").bind("blur", checkNameCn);
	$("#nameCn").bind("focus", function(){$("#lblnameCn").css({"display":"none"});});
	
	
}

function checkICode() {
	if ($("#iCode").val() == "") {
		$("#lbliCode").show();
		return false;
	} else {
		return true;
	}
}

function checkIName() {
	if ($("#iName").val() == "") {
		$("#lbliName").show();
		return false;
	} else {
		return true;
	}
}

function checkIType() {
	if ($("#iType").val() == "") {
		$("#lbliType").show();
		return false;
	} else {
		return true;
	}
}

function checkIFunction() {
	if ($("#iFunction").val() == "") {
		$("#lbiFunction").show();
		return false;
	} else {
		return true;
	}
}

function checkIUrl() {
	if ($("#iUrl").val() == "") {
		$("#lbiUrl").show();
		return false;
	} else {
		return true;
	}
}

function checkDataXml() {
	if ($("#dataXml").val() == "") {
		$("#lbdataXml").show();
		return false;
	} else {
		return true;
	}
}

function checkDataJson() {
	if ($("#dataJson").val() == "") {
		$("#lbdataJson").show();
		return false;
	} else {
		return true;
	}
}

function checkNote() {
	if ($("#note").val() == "") {
		$("#lblnote").show();
		return false;
	} else {
		return true;
	}
}

function checkCreateTime() {
	if ($("#createTime").val() == "") {
		$("#lblcreateTime").show();
		return false;
	} else {
		return true;
	}
}

function checkCTimeStamp() {
	if ($("#cTimeStamp").val() == "") {
		$("#lblcTimeStamp").show();
		return false;
	} else {
		return true;
	}
}

function checkId() {
	if ($("#id").val() == "") {
		$("#lblid").show();
		return false;
	} else {
		return true;
	}
}

function checkNameEn() {
	if ($("#nameEn").val() == "") {
		$("#lblnameEn").show();
		return false;
	} else {
		return true;
	}
}

function checkNameCn() {
	if ($("#nameCn").val() == "") {
		$("#lblnameCn").show();
		return false;
	} else {
		return true;
	}
}

function checkForm(){
	if(!checkICode() || !checkIName() || !checkIType()|| !checkIFunction() || !checkIUrl() || !checkDataXml() || !checkDataJson() || !checkNote() || !checkCreateTime() || !checkCTimeStamp() || !checkId() || !checkNameEn() || !checkNameCn()){
		return false;
	}
	return true;
}

function saveInterfaceInfo(){
	if(checkForm()){
		$.post("interface.do?method=addInterface",$("#addForm").serialize(),function(json){
			document.getElementById("addForm").reset();
		},"json")
	}
}
</script>
</body>
</html>