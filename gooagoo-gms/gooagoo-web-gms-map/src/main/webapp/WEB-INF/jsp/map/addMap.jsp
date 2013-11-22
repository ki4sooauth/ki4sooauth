<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
request.setAttribute("topMenuCode", "13");
request.setAttribute("leftMenuCode", "1304");
%>
<head>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/goodsList.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/shopBuild.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>

<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/demo.css" type="text/css"/>

<script type="text/javascript" src="${imgPath}/gms/gmap/js/ztree_shopEntity.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${shopVo.wordNames['gmsi023']}</title>
</head>
<script>
var flag = false ;
var entityId ;
var mapId ;

function saveMapInfo() {
	
	if(flag) {
		alert("地图数据已经保存，请创建svg文件。") ;
		return false ;
	}
	
	var mapname = $("input[name='mapname']").val() ;
	if(mapname.length == 0) {
		alert("请输入地图名称") ;
		return false ;
	}
	var ispark = $("select[name='ispark']").val() ;
	var shopEntityId = $("#shopEntityId").val() ;
	if(shopEntityId.length == 0) {
		alert("请选择实体店") ;
		return false ;
	}
	var ratio = $("input[name='ratio']").val() ;
	if(isNaN(ratio)){
		alert("图与现实:比例系数需要输入数字");
		return false ;
	}
	var offsetX = $("input[name='offsetX']").val() ;
	if(isNaN(offsetX)){
		alert("图与现实:x偏移量需要输入数字") ;
		return false ;
	}
	var offsetY = $("input[name='offsetY']").val() ;
	if(isNaN(offsetY)) {
		alert("图与现实:y偏移量需要输入数字") ;
		return false ;
	}
	var ratio2 = $("input[name='ratio2']").val() ;
	if(isNaN(ratio2)){
		alert("图与定位:比例系数需要输入数字");
		return false ;
	}
	var offsetX2 = $("input[name='offsetX2']").val() ;
	if(isNaN(offsetX2)){
		alert("图与定位:x偏移量需要输入数字") ;
		return false ;
	}
	var offsetY2 = $("input[name='offsetY2']").val() ;
	if(isNaN(offsetY2)) {
		alert("图与定位:y偏移量需要输入数字") ;
		return false ;
	}
	var data = "&mapName=" + mapname + "&isPark=" + ispark 
			  + "&shopEntityId=" + shopEntityId
			  + "&ratio=" + ratio
			  + "&offsetX=" + offsetX
			  + "&offsetY=" + offsetY 
			  + "&ratio2=" + ratio2
			  + "&offsetX2=" + offsetX2
			  + "&offsetY2=" + offsetY2 ;

	$.ajax({
		async:false,
		type:"POST",
		url:basePath + "/map.do?method=addMapDo",
		data:data ,
		dataType:"json",
		success: function(data) {
			if(data.success) {
				alert("添加成功")
				flag = true ;
				entityId = $("#shopEntityId").val() ;
				mapId = data.extend ;
				location.href = basePath + "/svg.do?method=addSvg&shopEntityId=" + entityId + "&mapId=" + mapId;
			} else {
				alert("添加失败") ;
			}
		}
	});
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
			<div class="rightTitle_add">
			<span>${shopVo.wordNames['gmsi009']}</span>
		</div>
            <div class="productBuild marketingMsg">
            	<ul>
                	<li><span>${shopVo.wordNames['gmsi011']}</span><input id="shop_entity" onclick="showEntityMenu('shop_entity','${shopId}')" class="borderStyle text" type="text" />
                	<input type="hidden" id="shopEntityId" name="shopEntityId"/></li>
                    <li><span>${ shopVo.wordNames['gmsi012']}</span><input name="mapname" class="borderStyle text" type="text" /></li>
                    <li><span>图与现实:比例系数</span><input name="ratio"  class="borderStyle text" type="text" /></li>
                    <li><span>图与现实:X偏移量</span><input name="offsetX"  class="borderStyle text" type="text" /></li>
                    <li><span>图与现实:Y偏移量</span><input name="offsetY"  class="borderStyle text" type="text" /></li>
                    <li><span>图与定位:比例系数</span><input name="ratio2"  class="borderStyle text" type="text" /></li>
                    <li><span>图与定位:X偏移量</span><input name="offsetX2"  class="borderStyle text" type="text" /></li>
                    <li><span>图与定位:Y偏移量</span><input name="offsetY2"  class="borderStyle text" type="text" /></li>
                    <li><span>${ shopVo.wordNames['gmsi017']}</span><select  class="borderStyle text" name="ispark"><option value="Y">${shopVo.wordNames['gmsi018']}</option><option value="N">${ shopVo.wordNames['gmsi019']}</option></select></li>
                </ul>
                <a href="javascript:void(0)" onclick="saveMapInfo();" class="savebtnS blueBtn">${ shopVo.wordNames['gmsi020']}</a>
            </div>
          </div>
	 </div>
   </div>
  
<!-- 实体店 --> 
<div id="shop_entity_Content" class="menuContent" style="display:none; position: absolute;">
	<ul id="shop_entity_ztree" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>
</body>
</html>