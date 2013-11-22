<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1401");
request.setAttribute("leftMenuCode", "140101");
%>
<html>
<head>
<title>${shopVo.wordNames['gmsg002']}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/normalCheck.js"></script>
<script type="text/javascript">

function sub(flag){
	var nickName = $("#nickName").val();
	var shopId = $("input[name='shopId']").val();
	if(nickName==null || nickName==""){
		alert("用户昵称不能为空");
		return false;
	}
	var shopName = $("input[name='shopName']").val();
	if(isEmpty(shopName)){
		alert("商家名称不能为空");
		return false;
	}
	var data="";
	var url="";
	if(flag=="L"){
		 data=$("#shopInfoForm").serialize();
		 url="${basePath}/shopInfo.do?method=updateShopInfos";
	}else{
		 data ={"shopId":shopId,"nickName":nickName};
		 url="${basePath}/shopInfo.do?method=updateShopInfo";
	}
	$.ajax({
		async:false,
		type:"POST",
		data:data,
		url: url,
		dataType:"json",
		success: function(data) {
	    	alert(data.message);
	    	if(data.success){
	    	  location.reload() ;
		      subShow();	
	    	}
		}
	});
}
function edit(flag){
	$("#divnickName").show();
	$("#txtnock").hide();
	$("#ebtn").hide();
	$("#sbtn").css("display","inline-block");
	
	if(flag=="L"){
		$("input[name='shopTypeLeaf']").hide();
		$('label').hide();
		shopInput();
	}
}
function shopInput(){
	$('input').show();
	$('select').show();
	$('textarea').show();
}
function subShow(){
	$("#ebtn").show();
	$("#sbtn").hide();
	$("#divnickName").hide();
	$("#txtnock").show();
}
function editShopStatus(){
	$.ajax({
		async:false,
		type:"POST",
		url: "${basePath}/shopInfo.do?method=updateBusiness",
		dataType:"json",
		success: function(data) {
	    	alert(data.message);
	    	 location.reload() ;
		}
	});
}
/**
 * 获取区域信息
 * 
 * @param obj
 */
function getShopType() {
	var url = '${basePath}/shopInfo.do?method=getShopType';
	var data = "&parentId=" + $("#shoptypeId").val();
	var select = $("select[name='shopTypeLeaf']");
	
	$.ajax({
		type : "POST",
		async : false,
		url : url,
		data : data,
		dataType : 'json',
		success : function(data) {
			if (!isEmpty(data)) {
				$(select).empty();
				$(select).append("<option value=''>--请选择--</option>");
				$.each(data, function() {
					select.append("<option value='" + this.id + "'>"
							+ this.name + "</option>");
				});
			 }
			
		},
		error : function() {
			alert("系统繁忙，请稍后再试");
		}
	});

}
</script>
<style type="text/css">
.txtr {
    height: 18px;line-height: 18px;width: 200px;
}
</style>
</head>
<body>
   <!--头部-->
   <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">
      <div class="article">
         <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
         <div class="section">
          <div class="rightTitle_add">
            <span>${shopVo.wordNames['gmsg002']}</span>
          </div>
          <form action="" id="shopInfoForm">
        <table class="Basic_information" width="100%" border="0" cellspacing="1" cellpadding="0">
            <tr>
                <th width="127">${shopVo.wordNames['gmsg034']}</th><td><input type="text" class="borderStyle text" style="height: 18px;line-height: 18px;width: 200px;display: none;" name="shopName" value="${shopInfo.shopName}"/><label>${shopInfo.shopName}</label></td>
            </tr>
            <tr>
                <th>${shopVo.wordNames['gmsg035']}</th><td>
                <label>${shopInfo.shopTypeLeafCh}</label>
                <select id="shoptypeId" onchange="getShopType();" class="borderStyle text" name="shopTypeRoot" style="width: 100px;display: none">
                <c:forEach items="${shopType}" var="s">
                <option  ${shopInfo.shopTypeRoot eq s.id?"selected='selected'":""} value="${s.id}">${s.name}</option>
                </c:forEach>
                </select>
                
                <select  name="shopTypeLeaf" class="borderStyle text" style="width: 100px;display: none">
                <c:forEach items="${shopTypeLeaf}" var="v">
                <option ${shopInfo.shopTypeLeaf eq v.id?"selected='selected'":""} value="${v.id}">${v.name}</option>
                </c:forEach>
                </select>
                </td>
            </tr>
            <tr>
                <th>${shopVo.wordNames['gmsg036']}</th><td><textarea  cols="50" rows="5" style="display: none;" name="scope">${shopInfo.scope}</textarea><label>${shopInfo.scope}</label></td>
            </tr>
            <tr>
                <th>${shopVo.wordNames['gmsg037']}</th><td>${shopInfo.email}</td>
            </tr>
            <tr>
                <th>${shopVo.wordNames['gmsg038']}</th><td><label><c:if test="${shopInfo.isChain eq 'Y'}">是</c:if><c:if test="${shopInfo.isChain eq 'N'}">否</c:if></label>
                <select style="width: 100px;display: none" class="borderStyle text" name="isChain">
                <option value="Y" ${shopInfo.isChain eq 'Y'?"selected='selected'":""}>是</option>
                <option value="N" ${shopInfo.isChain eq 'N'?"selected='selected'":""}>否</option>
                </select>
                </td>
            </tr>
            <tr>
                <th>${shopVo.wordNames['gmsg039']}</th><td> <label>${shopInfo.serviceStyleCh}</label>
                <select style="width: 100px;display: none" class="borderStyle text"  name="serviceStyle">
                <option value="A" ${shopInfo.serviceStyle eq 'A'?"selected='selected'":""}>平台代理模式</option>
                <option value="S" ${shopInfo.serviceStyle eq 'S'?"selected='selected'":""}>商家独立模式</option>
                </select>
                </td>
            </tr>
            <tr>
                <th>${shopVo.wordNames['gmsg040']}</th><td>${shopInfo.note}</td>
            </tr>
                        <tr>
                <th>${shopVo.wordNames['gmsd055']}</th><td>${shopInfo.shopStatusch}</td>
            </tr>
            <tr>
                <th>${shopVo.wordNames['gmsg041']}</th><td><input type="hidden" class="borderStyle text" name="shopId" value="${shopInfo.shopId}"/> 
                <div style="display: none;" id="divnickName">
                <input type="text" id="nickName" name="nickName" class="borderStyle text" style="height: 18px;line-height: 18px;width: 200px;"    value="${shopInfo.nickName}" maxlength="50" />
            	</div>
            	<div style="display:block;" id="txtnock">${shopInfo.nickName}</div>
				</td>
            </tr>
                        <tr>
				<td colspan="2" align="center">
				
					<check:hasAuthority authorityID="14010102"> 
				    ${shopInfo.shopStatus eq 'P'?'<a href="javascript:void(0)" class="blueBtn" style="display:inline-block;width: 150px;" onclick="editShopStatus();">正常营业</a>':''}
				</check:hasAuthority>
				
				<check:hasAuthority authorityID="14010101">
					<span style="padding-left: 7px;" id="ebtn"><a href="javascript:void(0)" style="display: inline-block;width: 150px;"  class="blueBtn" onclick="edit('${shopInfo.shopStatus}');">${empty shopVo.wordNames['gmsg042'] ? '编辑' : shopVo.wordNames['gmsg042']}</a></span>
					<a href="javascript:void(0)" style="display:none;width: 150px;" id="sbtn" class="blueBtn" onclick="sub('${shopInfo.shopStatus}');">${empty shopVo.wordNames['gmsg043'] ? '保存' : shopVo.wordNames['gmsg043']}</a>
				    </check:hasAuthority>
				</td>
            </tr>

        </table>
        </form>
</div>
<div style="display: none;">
  <a class="fancybox_em" id="emFancybox"></a>
</div>
</div>
</div> 
</body>
</html>