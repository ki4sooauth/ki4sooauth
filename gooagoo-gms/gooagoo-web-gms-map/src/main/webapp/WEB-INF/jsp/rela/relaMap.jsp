<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
request.setAttribute("basePath", request.getContextPath());//relative 
 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<script type="text/javascript" src="${imgPath}/gms/gmap/js/ztree_position.js"></script>
<title>SVG显示</title>
</head>

<style>
.notDisplay{display:none}
</style>

<script> 
// 区域数据数组
var arr = new Array() ;
// 单个区域数据
var areaInfo ;
// 上一次点击的svgId
var sId ;

$(function(){
	var list = eval('${list}') ;
	for(var a=0;a<list.length;a++) {
		var temp = createObject(list[a].areaId,list[a].svgTagId, list[a].positionId,list[a].positionName) ;
		arr[a] = temp ;
	}
	
	//红色显示可关联最小区域
	$("rect[id^='area_']").clone(true).attr({"stroke-width":2,"stroke":"#ff0000","stroke-opacity":1}).insertAfter($("g[id='main']"));
	$("rect[id^='position_']").clone(true).attr({"stroke-width":2,"stroke":"#ff0000","stroke-opacity":1}).insertAfter($("g[id='main']"));
	$("polygon[id^='position_']").clone(true).attr({"stroke-width":2,"stroke":"#ff0000","stroke-opacity":1}).insertAfter($("g[id='main']"));
	$("polygon[id^='out_']").clone(true).attr({"stroke-width":2,"stroke":"#ff0000","stroke-opacity":1}).insertAfter($("g[id='main']"));
	$("rect[id^='position_']").clone(true).attr({"stroke-width":2,"stroke":"#ff0000","stroke-opacity":1}).insertAfter($("g[id='main']"));
}) 

function hideElementsOfClass(className) {
	var tagArr = document.getElementsByClassName(className) ;
	for(var i=0;i<tagArr.length;i++){
		tagArr[i].style.display= "none" ;
	}
};

function showTip(evt) {
	var obj = evt.target ;
	var idStr = obj.getAttribute("id") ;
	var area = getObject(idStr) ;
	
	var target = document.getElementById("rela") ;
	// 区域切换
	if(idStr != sId) {
		target.style.display = "none" ;
	}
	sId = idStr ;
	
	if(target.style.display == "block") {
		target.style.display = "none" ;
	} else {
		var Left = evt.pageX;
	    var Top = evt.pageY;
	    target.style.left= (Left+10) + "px";
	    target.style.top = (Top-30) + "px";
	    target.style.display= "block" ;
	}
	
	if(area != null) {
		areaInfo = area ;
		if(area.positionId != undefined )  {
			 $("input[name='positionId']").val(area.positionId) ;
			 $("input[name='positionName']").val(area.positionName) ;
		} else {
			$("input[name='positionId']").val("") ;
			$("input[name='positionName']").val("");
		}
	} else {
		$("input[name='positionId']").val("") ;
		$("input[name='positionName']").val("");
	}
};

// 保存区域商家关联数据
function saveArea() {
	var positionId = $("input[name='positionId']").val() ;
	var positionName = $("input[name='positionName']").val() ;
	
	var data = "areaId=" + areaInfo.areaId  
			 + "&positionId=" + positionId ;
	$.ajax({
		async:false,
		type:"POST",
		url:basePath + "/rela.do?method=updateDo",
		data:data,
		dataType:"json",
		success: function(data) {
			if(data.success) {
				var area = getObject(areaInfo.svgId) ;
				area.positionId = positionId ;
				area.positionName = positionName ;
				areaInfo = null ;
				alert("保存成功") ;
				document.getElementById("rela").style.display = "none" ;
			}
		}
	});
}

// 取得对象
function getObject(svgId) {
	var obj = null ;
	for(var a=0;a<arr.length;a++) {
	   if(arr[a].svgId == svgId) {
		   obj = arr[a] ;
		   break;
	   }	
	}
	return obj ;
}


//区域位置对象
function createObject(areaId, svgId, positionId, positionName) {
	var obj = new Object() ;
	obj.areaId = areaId ;
	obj.svgId = svgId ;
	obj.positionId = positionId ;
	obj.positionName = positionName ;
	
	return obj ;
}

// 发布地图
function release() {
	var data = "mapId=${mapId}"  ;
	var flag = false ;
	$.ajax({
		async:false,
		type:"POST",
		url:basePath + "/map.do?method=initMap",
		data:data,
		dataType:"json",
		success: function(data) {
			flag = data.success ;
		}
	});
	if(flag) {
		if(confirm("初始化成功，是否发布？")) {
			$.ajax({
				async:false,
				type:"POST",
				url:basePath + "/map.do?method=release",
				data:data,
				dataType:"json",
				success: function(data) {
					
					if(data.success) {
						alert("发布成功") ;
						location.href = "${basePath}/map.do?method=index";
					}
				}
			});
		}
	} else {
		alert("初始化失败") ;
	}
}
</script>

<body>
<br/>
<div id="id_svg">
${svg}
</div>
<div class="big_div">
${divContent }
</div>

<div id="rela" style="position:absolute;display:none;background: #fff; box-shadow: 1px 1px 4px;">
	<div class="productBuild marketingMsg">
		<ul>
	        <li><span>${ shopVo.wordNames['gmsi013']}</span>
	        <input id="position" name="positionName" class="borderStyle text" type="text"  onclick="showPositionMenu('position','${shopId }');"  />
	        <input id="positionId" name="positionId" class="borderStyle text" type="hidden" />
	        </li>
	    </ul>
	    <table align="center">
	    	<tr>
	    		<td><a href="javascript:void(0)" onclick="saveArea();" style="display:block;width:80px;height:25px;line-height:25px;text-align:center;color:#fff;background:#0873B9;margin:0 auto">${ shopVo.wordNames['gmsi020']}</a></td>
	    		<td>&nbsp;&nbsp;</td>
	    		<td><a href="javascript:void(0)" onclick="document.getElementById('rela').style.display='none';" style="display:block;width:80px;height:25px;line-height:25px;text-align:center;color:#fff;background:#0873B9;margin:0 auto">${ shopVo.wordNames['gmsg345']}</a></td>
	    	</tr>
	    </table>
	</div>
</div>

<div id="position_Content" class="menuContent" style="display:none; position: absolute;">
	<ul id="position_ztree" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>
<input type="hidden" id="shopEntityId" value="${shopEntityId }" />
<input type="button" onclick="release();"  class="savebtnS blueBtn" value="初始化" />
</body>
</html>