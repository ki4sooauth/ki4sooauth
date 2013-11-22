<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<title>编辑网格</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${imgPath}/gms/gmap/css/imgareaselect-default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/gmap/js/jquery-designerGrid-1.7.5.js"></script>
<script type="text/javascript" src="${imgPath}/gms/gmap/js/jquery.imgareaselect.js"></script>
<style type="text/css">
#rectDiv{
	z-index: 11; 
	opacity: 0.8
}
.rectDivBtn{
	position: relative;
	float:right;
	padding:2px;
	cursor: pointer;
	z-index:999
}
#svgFrame{
	z-index: -11; 
	border: 0
}
#svgDiv{
	z-index: -11; 
	border: 0
}
.area_grid{
	width : ${gridWidth}px;
	height : ${gridHeight}px;
	left: 0.5px; 
	top: 0.5px; 
	position: absolute; 
	border: 1px solid #999999;
	overflow: hidden
}
.area_div{
	position: absolute; 
	border: 1px solid #999;
	background-color:rgba(203, 212, 214,.5);
	overflow: hidden;
	text-align:right;
	line-height:21px;
}
.area_div spane{padding-right:20px;color:#363636;} 


*{margin:0;padding:0;font-size:12px;}
a{text-decoration:none;}
#contextMenuDiv{
	background:#2dacbf;
	background:linear-gradient(top bottom, #3bbcd1 0%, #2dacbf 100%);
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0%,#3bbcd1), color-stop(100%,#2dacbf));/* Chrome,Safari4+ */
	background:-webkit-linear-gradient(center top, #3bbcd1 0%,#2dacbf 100%); /* Chrome10+,Safari5.1+ */
	background:-moz-linear-gradient(center top , #3bbcd1 0%, #2dacbf 100%); /* FF3.6+ */
	background: -ms-linear-gradient(center top,  #3bbcd1 0%,#2dacbf 100%); /* IE10+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3bbcd1', endColorstr='#2dacbf',GradientType=0 );
	z-index: 999; 
	opacity: 0.9;
	height:24px;
	position:fixed;
	top:0px;
	left:50%;
	border-radius:3px;
	overflow:hidden;
}
#contextMenuDiv a{color:#fff;font-family:"microsoft yahei";display:block;float:left;padding:0 15px 0 5px;line-height:24px;}
#contextMenuDiv a:hover{background:#188d9f;}
#contextMenuDiv a.curr{background:#188d9f;}
#contextMenuDiv a.dis{background:#cfcfcf;color:#9e9e9e;cursor: default;}
#contextMenuDiv a b{background:url(${imgPath}/gms/gmap/images/b_1.png) no-repeat;display:block;float:left;width:12px;height:12px;margin:5px 5px 0 0}
#contextMenuDiv #saveBtn b{background-position:0px 0px;}
#contextMenuDiv #editGridBtn b{background-position:-1px -17px;}
#contextMenuDiv #unSelectBtn b{background-position:1px -36px;}
#contextMenuDiv #saveBtn.dis b{background-position:-21px 0px;}
#contextMenuDiv #editGridBtn.dis b{background-position:-21px -17px;}
#contextMenuDiv #unSelectBtn.dis b{background-position:-21px -36px;}
#contextMenuDiv #slide{float:right;display:block;height:100%;width:11px;position:relative;background:#339bac;cursor:pointer;}
#contextMenuDiv #slide b{background:url(${imgPath}/gms/gmap/images/slider_1.png) no-repeat left 1px;display:block;height:8px;width:10px;position:absolute;right:-1px;bottom:2px;}
</style>
</head>
<script>
var minUnit = ${gridUnit};
var areaSelect = null;
var gridWidth = ${gridWidth};
var gridHeight = ${gridHeight};
$(function(){
	initContextMenuDiv();
	initDesignerGrid();
	initAreaSelection();
	initSvgBackground();
	initFancyBox("fancybox_grid",550,550,true);
	initSelectedArea();
});
function initContextMenuDiv(){
	var conW = $("#contextMenuDiv").width()/2;
	$("#contextMenuDiv").css("margin-left",-conW+"px");
	$("#contextMenuDiv").mouseenter(function(){
		$("#contextMenuDiv").animate({top:0});
	});
	$("#slide").click(function(){
		  $("#contextMenuDiv").animate({top:-22});
		  return false;
	});
	disableSaveBtn(false);
	switchContextMenuDiv(false);
}
function initDesignerGrid(){
	$("#rectDiv").designerGrid({
		docWidth : gridWidth,
		docHeight : gridHeight,
        colColor : '#aaa',
        opacity : 0.8,
        colCount : 0,
		colHeight : 10,
        colWidth : 10,
		col_Z_index : 10,
		grid_Z_index : 10,
        centred  : false,
		marginLeft : 0,
		marginTop : 0,
        gutter    : 0,
        unit:minUnit
    });
}
function initAreaSelection(){
	areaSelect = $('#rectDiv').imgAreaSelect({
        handles: true,
		instance: true,
		onSelectEnd: function (img, selection) {
			reSizeArea(selection);
		}
    });
}
function initSvgBackground(){
	$("#svgDiv").children("svg").eq(0).css("width",gridWidth).css("height",gridHeight);
}
function initSelectedArea(){
	var areas = ${gridInfo};
	for(var i=0;i<areas.length;i++){
		var area = areas[i].split("_");
		var gridPropertyName = "室内";
		if(area[5]=="1"){
			gridPropertyName = "室外";
		}
		var des = area[6]+"/"+gridPropertyName;
		var rect = $("<div class='area_div'></div>");
		var id = area[0]+"_"+area[1]+"_"+area[2]+"_"+area[3];
		rect.attr("id",id);
		rect.attr("title",des);
		var w = area[2]-area[0];
		var h = area[3]-area[1];
		rect.css("left",area[0]+"px").css("top",area[1]+"px").css("width",w+"px").css("height",h+"px");
		var closeBtn =  $("<img src='${imgPath}/gms/common/images/productBuild-del.png' class='rectDivBtn' onclick='removeRect(this);'/>");
		rect.append("<input type='hidden' name='grid_info' value='"+areas[i]+"'/>");
		rect.append(closeBtn);
		rect.append("<spane>"+des+"</span>");

		$("#rectDiv").append(rect);
	}
}
function reSetPosition(v){
	var r = parseInt(v/minUnit);
	return r*minUnit;
}
function reSizeArea(selection){
	var isOk = fitSelection(selection);
	if(isOk){
		switchContextMenuDiv(true);
		areaSelect.update();
	}else{
		switchContextMenuDiv(false);
	}
}
function fitSelection(selection){
	var x1 = reSetPosition(selection.x1);
	var y1 = reSetPosition(selection.y1);
	var x2 = reSetPosition(selection.x2);
	var y2 = reSetPosition(selection.y2);
	
	var hasArea = (x2-x1>0 && y2-y1 > 0);
	if(hasArea){
		areaSelect.setSelection(x1, y1, x2,y2, true);
		return true;
	}
	return false;
}
function switchContextMenuDiv(show){
	if(show){
		$("#editGridBtn").removeClass("dis");
		$("#editGridBtn").bind("click",function (){editRect();});
		$("#unSelectBtn").removeClass("dis");
		$("#unSelectBtn").bind("click",function (){cancelSelection();});
	}else{
		$("#editGridBtn").addClass("dis");
		$("#editGridBtn").unbind("click");
		$("#unSelectBtn").addClass("dis");
		$("#unSelectBtn").unbind("click");
	}
}
function disableSaveBtn(disable){
	if(disable){
		$("#saveBtn").addClass("dis");
		$("#saveBtn").unbind("click");
	}else{
		$("#saveBtn").removeClass("dis");
		$("#saveBtn").bind("click",function (){save();});
	}
}
function editRect(){
	var selection = areaSelect.getSelection();
	var isOk = fitSelection(selection);
	if(isOk){
		switchContextMenuDiv(true);
		$("#fancybox_grid").attr("href","${basePath}grid.do?method=formGrid&shopEntityId=${shopEntityId}&positionId=${positionId}").click();
	}else{
		alert("请先选择网格");
		switchContextMenuDiv(false);
	}
}
function freshGridProperty(positionId,gridProperty,positionName,gridPropertyName){
	drawRect(positionId,gridProperty,positionName,gridPropertyName);
	$.fancybox.close();
}

function drawRect(positionId,gridProperty,positionName,gridPropertyName){
	var selection = areaSelect.getSelection();
	var des = positionName+"/"+gridPropertyName;
	var rect = $("<div class='area_div'></div>");
	var id = selection.x1+"_"+selection.y1+"_"+selection.x2+"_"+selection.y2;
	rect.attr("id",id);
	rect.attr("title",des);
	rect.css("left",selection.x1).css("top",selection.y1).css("width",selection.width).css("height",selection.height);
	var closeBtn =  $("<img src='${imgPath}/gms/gmap/images/close_1.png' class='rectDivBtn' onclick='removeRect(this);'/>");
	rect.append("<input type='hidden' name='grid_info' value='"+id+"_"+positionId+"_"+gridProperty+"_"+positionName+"'/>");
	rect.append(closeBtn);
	rect.append("<spane>"+des+"</span>");

	$("#rectDiv").append(rect);
	cancelSelection();
}
function cancelSelection(){
	areaSelect.cancelSelection();
	switchContextMenuDiv(false);
}
function removeRect(obj){
	$(obj).parent().remove();
}
function save(){
	disableSaveBtn(true);
	var paras = $("#rectForm").serialize();
	if(!checkGridParas(paras)){
		return;
	}
	$.ajax({
		async:false,
		type:"POST",
		url:"${basePath}grid.do?method=save",
		data:paras,
		dataType:"json",
		success: function(ret) {
			if(ret.success){
    			window.location.href="${basePath}";
            }else{
        		alert(ret.message);
            }
			disableSaveBtn(false);
		}
	});
}
function checkGridParas(paras){
	var grids = $("#rectForm input[name='grid_info']");
	if(grids.size()<1){
		alert("请先编辑网格信息");
		return false;
	}
	return true;
}
</script>
<body>
<div style="display:none;">
	<a href="#" id="fancybox_grid" class="fancybox_grid"></a>
</div>
<div id="contextMenuDiv">
	<span id="slide"><b></b></span>
<!--         <a id="td" href="javascript:void(0)" style="cursor:move">拖动</a> -->
	<a id="saveBtn" href="javascript:void(0);"><b></b>保存网格信息</a>
	<a id="editGridBtn" href="javascript:void(0);" class="dis"><b></b>编辑网格信息</a>
	<a id="unSelectBtn" href="javascript:void(0);" class="dis"><b></b>取消选择</a>
</div>
<form id="rectForm" action="" method="post">
	<input type="hidden" name="mapId" value="${mapId }"/>
	<input type="hidden" name="xGridNum" value="${xGridNum }"/>
	<input type="hidden" name="yGridNum" value="${yGridNum }"/>
	<input type="hidden" name="filePath" value="${filePath }"/>
	<div id="rectDiv" class="area_grid"></div>
</form>
<div id="svgDiv" class="area_grid">${svgContent}</div>
</body>
</html>