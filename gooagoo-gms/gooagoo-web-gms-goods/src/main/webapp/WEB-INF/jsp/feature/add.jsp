<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
    request.setAttribute("topMenuCode", "15");
    request.setAttribute("leftMenuCode", "1504");
%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmse112']}</title>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/common/css/shopBuild.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/public.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
</head>
<script>
function saveFeature() {
	var goodsSerial = $("input[name='goodsSerial']").val() ;
	var featureCode = $("input[name='featureCode']").val() ;
	var featureName = $("input[name='featureName']").val() ;
	var isDisplay = $("select[name='isDisplay']").val() ;
	
	var values = $(".content");
	var featureValue = "[" ;
	for(var a=0;a<values.size();a++) {
		featureValue += "'" + values[a].value + "'" ;
		if(a != values.size() - 1)
			featureValue += "," ;
	}
	featureValue += "]" ;
	
	var data = "&typeCode=" + featureCode 
			 + "&typeName=" + featureName
			 + "&enumValue=" + featureValue 
			 + "&goodsSerial=" + goodsSerial
			 + "&isDisplay=" + isDisplay;

	$.ajax({
		async : false,
		type : "POST",
		url : basePath + "/feature.do?method=addDo",
		dataType : "json",
		data:data,
		success : function(data) { 
			if(data.success) {
				alert(data.message)
				window.location.href= basePath + "/feature.do?method=index" ;
			} else {
		    	alert(data.message) ;
		    }
		}
	}) ;
}

function add() {
	var timestamp=new Date().getTime();
    var str = "" ;
    str += "<div id='"  + timestamp + "'><div style='padding-left:85px'>" ;
    str += "<input type='text' class='content borderStyle text' style='margin-right:0;'>" ;
    str += "<i onclick='del(" + timestamp + ")' style='font-style:normal;display:inline-block;width:20px;height:20px;line-height:20px;font-weight:bold;color:#fff;background:#A5ACB2;text-align:center;cursor:pointer;'>×</i></div><br/></div>" ;
	var obj = $("#append") ;
	obj.append(str) ;
}

function del(str) {
	var obj = $("#" + str) ;
	obj.remove() ;
}
</script>
<body>
	<!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container">
		<div class="article">
			<%@include file="/WEB-INF/jsp/common/left.jsp"%>
			<div class="section">
				<div class="rightTitle">
					<span>${shopVo.wordNames['gmse084']}</span>
				</div>
				<div class="conditions_content">
					<div class="productBuild">
						<ul>
							<li><span>${shopVo.wordNames['gmse085']}</span><input class="borderStyle text"
								type="text" name="goodsSerial" /></li>
							<li><span>${shopVo.wordNames['gmse086']}</span><input class="borderStyle text"
								type="text" name="featureCode" /></li>
							<li><span>${shopVo.wordNames['gmse087']}</span><input class="borderStyle text"
								type="text" name="featureName"/></li>
							<li><span>${shopVo.wordNames['gmse088']}</span>
								<select name="isDisplay"  class="borderStyle text">
									<option value="Y">是</option>
									<option value="N">否</option>
								</select></li>
							<li><span>${shopVo.wordNames['gmse089']}</span><input class="content borderStyle text"
								type="text" name="featureValue" /><a style="line-height:20px;color:#666;font-weight:bold;text-decoration:underline;letter-spacing:1px" href="javascript:void(0)" onclick="add();">${shopVo.wordNames['gmse090']}</a></li>
							<li id="append">
							</li>
						</ul>
						<check:hasAuthority authorityID="150401">
							<input id="feature_save" onclick="saveFeature();" class="savebtnS blueBtn" type="submit"
								value="${shopVo.wordNames['gmse055']}" />
						</check:hasAuthority>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
