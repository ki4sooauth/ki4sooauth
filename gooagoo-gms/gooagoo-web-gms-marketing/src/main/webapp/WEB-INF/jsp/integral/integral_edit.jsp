
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
request.setAttribute("topMenuCode", "13");
request.setAttribute("leftMenuCode", "1302");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>编辑积分兑换信息</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<%@ include file="/WEB-INF/jsp/common/fancybox.jsp"%>
<link href="${imgPath}/gms/common/css/pointBuild.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/My97DatePicker/WdatePicker.js"></script>
<style>
.bClass{
    color: #666666;
    float: left;
    font-weight: normal;
    line-height: 20px;
    padding-right: 5px;
    padding-left: 5px;
}
</style>
<script type="text/javascript">
$(function(){
	initFancyBox();	
	if(isEmpty("${integral.convertObjectId}")){clearData();};
});

// formUrlType 为1 表示创建，为0表示修改
function saveShopIntegral(formUrlType){
	$(".blueBtn").attr("disabled","disabled");
	
	var ctype = $("#shopIntegralForm input[name=convertType]").val();
	var cid = $("#shopIntegralForm input[name=convertObjectId]").val();
	var cvalue = $("#shopIntegralForm input[name=convertValue]").val();
	var cnum = $("#shopIntegralForm input[name=convertNums]").val();
	var cstarttime = $("#shopIntegralForm input[name=convertStartTime]").val();
	var cendtime = $("#shopIntegralForm input[name=convertEndTime]").val();
	

    if(isEmpty(cvalue)){
    	removeDisable();
    	alert("兑换所需要的积分不能为空");
    	return false;
    }
    if(!checkInt(cvalue)){
    	removeDisable();
    	alert("兑换所需要的积分应为正整数或0");
    	return false;
    }
    if(isEmpty(cnum)){
    	removeDisable();
    	alert("允许兑换次数不能为空");
    	return false;
    }
    if(!checkInt(cnum)||cnum<=0){
    	removeDisable();
    	alert("允许兑换次数格式不对，请输入正整数");
    	return false;
    }
    if(isEmpty(cstarttime)){
    	removeDisable();
    	alert("积分兑换生效日期不能为空");
    	return false;
    }

    if(isEmpty(cendtime)){
    	removeDisable();
    	alert("积分兑换截止日期不能为空");
    	return false;
    }
    if(Date.parse('${currentTime}')-Date.parse(cstarttime)>0){
    	removeDisable();
        alert("积分兑换生效日期不能小于当前日期");
        return false;
    }
    
    if(Date.parse(cstarttime)-Date.parse(cendtime)>0){
    	removeDisable();
        alert("积分兑换截止日期不能小于积分兑换生效日期");
        return false;
    }
    if(isEmpty(ctype) || isEmpty(cid)){
    	removeDisable();
    	alert("请选择积分兑换物");
    	return false;
    }
     
    var data=$("#shopIntegralForm").serialize();

    var url = "${basePath }integral.do?method=${empty integral.id ? 'create':'update'}";
    $.ajax({
    	async:false,
		type:"POST",
		url:url,
		data:data,
		dataType:"json",
		success: function(data) {
			removeDisable();
			if(data.success) {
				alert(data.message);
				location.replace("${basePath}/integral.do?method=index");
			} else {				
				alert(data.message);
			}
		}
    });
}
function checkInt(value){
	var reg2 = new RegExp("^[0-9]*$");
	return reg2.test(value);
}

function initFancyBox(){
	$(".fancybox_relate").fancybox({
		'width'				: 800,
		'height'			: 550,
		'padding'			: 0,
		'autoScale'			: true,
		'autoDimensions'    : true,
		'transitionIn'		: 'yes',
		'transitionOut'		: 'yes',
		'href'				: $(this).attr('href'),
		'type'				:'iframe',
		'hideOnOverlayClick': false,
		'showCloseButton':true
	});
}
function addRelate(){
	$("#relate_list").click();
}

//弹出层返回数据
function dealRelations(relations){
	$("#convertName").val(relations[0][2]);
	$("#shopIntegralForm input[name=convertObjectId]").val(relations[0][1]);
	$("#shopIntegralForm input[name=convertType]").val(relations[0][0]);
	var url=relations[0][3];
	if(isEmpty(url)){
		$('#img').hide();
	}else{
		$('#img').attr("src",relations[0][3]);
		$('#img').show();
	}
	 $.fancybox.close();
}

//保存按钮从disable还原
function removeDisable(){
	$(".blueBtn").attr("disabled",false);
}

//添加也刷新后需清空原有数据
function clearData(){
	$("#convertName").val("");
	$("#shopIntegralForm input[name=convertObjectId]").val("");
	$("#shopIntegralForm input[name=convertType]").val("");
	$('#img').attr("src","${imgPath}/gms/common/images/default1.jpg");
}
</script>
</head>
<body>
<!-- 头部 -->
<%@ include file="/WEB-INF/jsp/common/head.jsp"%>  
<div style="display:none;">
	<a href="${basePath }relation.do?method=listRelation&selectType=&relateType=GC&dataType=CJ" id="relate_list" class="fancybox_relate"></a>
</div>
<!--内容-->
    <div class="container">
      <div class="article">
<%@ include file="/WEB-INF/jsp/common/left.jsp"%> 
        <div class="section">
    <div class="rightTitle"><span>${empty integral.id ? shopVo.wordNames['gmsd085']:shopVo.wordNames['gmsd086']}</span></div>
<div class="point_build"> 
      <iframe id="hiddenIframe" name="hiddenIframe" style="display:none;"></iframe>
      <form id="shopIntegralForm" name="shopIntegralForm" target="hiddenIframe" method="post">
        <input type="hidden" name="id" value="${integral.id}" />
        <input type="hidden" name="shopId" value="${shopId }" />
        <input type="hidden" name="convertObjectId" value="${integral.convertObjectId}" />
        <input type="hidden" name="convertType" value="${integral.convertType}" />
        <ul>
	       <li>
		       <span>${shopVo.wordNames['gmsd089']}</span>
		       <input class="big" type="text" name="convertValue" value="${integral.convertValue}" />
	       </li>
	        <li>
		       <span>允许兑换次数</span>
		       <input class="big" type="text" name="convertNums" value="${integral.convertNums}" />
	       </li>
	       <li class="uu">
		        <span>${shopVo.wordNames['gmsd090']}</span>
		        <input class="date" readonly="readonly"  type="text" class="input4" name="convertStartTime" value="<fmt:formatDate value="${integral.convertStartTime}" type="both" pattern="yyyy-MM-dd" />" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
		        <b class="bClass">${shopVo.wordNames['gmsd091']}</b> 
		        <input class="date" readonly="readonly"  type="text" class="input4" name="convertEndTime" value="<fmt:formatDate value="${integral.convertEndTime}" type="both" pattern="yyyy-MM-dd" />" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/> 
	        </li>
	        <li>
	            <span>${shopVo.wordNames['gmsd087']}</span><button onclick="addRelate();" class="blueBtn selectImgBtn">${shopVo.wordNames['gmsd088']}</button><br /><br />
	            <input type="text" class="textArea" readonly="readonly" style="min-height:0px;" name="convertObjectName" id="convertName" value="${integral.convertObjectName}"/>                
	            <img id="img" src="${integral.imgUrl}" alt="" class="textArea"/>
	        </li>  
	        <li class="commitBnt">
	            <a href="javascript:void(0);" onclick="saveShopIntegral(${empty integral.id ? 1 : 0});" name="save" class="submit blueBtn">${shopVo.wordNames['gmsd077']}</a>
	        </li>        
        </ul>
      </form>
    </div>
  </div>
</div>
</div>
</body>
</html>