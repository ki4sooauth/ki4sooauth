<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script>
function updateSpecials(){
	var data = "&featureCode=" + $("input[name='featureCode']").val() 
			+ "&featureName=" + $("input[name='featureName']").val() 
			+ "&featureValue=" + $("select[name='featureValue']").val() 
			+ "&id=" + $("input[name='id']").val();
	(document.parentWindow || document.defaultView).parent.updateSpecials(data);
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
<div class="title">${shopVo.wordNames['gmse076']}</div>
<ul>
	<li><span>${shopVo.wordNames['gmse038']}</span><input  style="background:#CECECE;" readonly  class="borderStyle text" name="featureCode" type="text" value="${special.featureCode }"/></li>
	<li><span>${shopVo.wordNames['gmse039']}</span><input  style="background:#CECECE;" readonly  class="borderStyle text" name="featureName" type="text"  value="${special.featureName }"/></li>
	<li><span>${shopVo.wordNames['gmse040']}</span>
	<select name="featureValue" class="borderStyle text">
		<c:forEach items="${feature.values }" var="item">
			<option <c:if test="${item==special.featureValue }">selected</c:if> value="${item }">${item }</option>
		</c:forEach>
	</select>
	<input type="hidden" name="id" value="${special.id }"/>
	</li>
	<check:hasAuthority authorityID="1501020102">
	<li><a href="" class="addImgbtn blueBtn" onclick="updateSpecials();">${shopVo.wordNames['gmse055']}</a></li>
	</check:hasAuthority>
</ul>