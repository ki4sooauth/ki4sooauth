<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script>
function addSpecial(){
	var featureCode = $("select[name='featureCode']").val() ;
	var featureName = $("select[name='featureCode']").find("option:selected").text();;
	var featureValue= $("select[name='" + featureCode + "']").val() ;
	
	var data = "&featureCode=" + featureCode
			+ "&featureName=" + featureName 
			+ "&featureValue=" + featureValue;
	(document.parentWindow || document.defaultView).parent.saveSpecials(data);
}

function changeSelect() {
	var code = $("select[name='featureCode']").val() ;
	$(".featureValue").hide() ;
	$("#"+code).show() ;
}
</script>
<style>
*{margin:0;padding:0;font-size:12px;}
ul {padding-top:10px;}
ul li{list-style-type:none;height:35px;}
ul li span{font-size:14px;color:#666;font-weight:bold;display:inline-block;width:90px;text-align:center;height:24px;line-height:24px; vertical-align:middle;}
ul li input{width:160px;border:1px solid #ccc;line-height:22px;height:22px; vertical-align:middle;}
.blueBtn{display:block;font-size:14px;font-weight:bold;color:#fff;height:26px;width:110px;line-height:26px;text-align:center;background:#0471C0;text-decoration:none;margin:10px auto;}
.title{font-size:16px;color:#0873B9;font-weight:bold;line-height:35px;border-bottom:1px solid #0873B9;}
</style>
<div style="padding:20px;">
<div class="title">${shopVo.wordNames['gmse075']}</div>
<ul>
	<li><span>${shopVo.wordNames['gmse039']}</span>
		<select class="borderStyle text" name="featureCode" onchange="changeSelect()">
			<option>请选择</option>
			<c:forEach items="${features }" var="item">
				<option value="${item.code }">${item.name }</option>
			</c:forEach>
		</select>
	</li>
	<c:forEach items="${features }" var="item">
		<li style="display:none" class="featureValue" id="${item.code }"><span>${shopVo.wordNames['gmse040']}</span>
			<select name="${item.code }">
				<c:forEach items="${item.values }" var="i">
					<option value="${i }">${i }</option>
				</c:forEach>
			</select>
		</li>
	</c:forEach>
	<check:hasAuthority authorityID="15010102">
	<li><a href="#" class="addImgbtn blueBtn" onclick="addSpecial();">${shopVo.wordNames['gmse036']}</a></li>
	</check:hasAuthority>
</ul>
</div>