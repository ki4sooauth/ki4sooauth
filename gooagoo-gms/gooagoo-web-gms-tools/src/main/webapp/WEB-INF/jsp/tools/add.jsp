<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
    request.setAttribute("topMenuCode", "16");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<title>${shopVo.wordNames['gmsf029']}</title>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/common/css/serveTool.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/common/css/goodsList.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/common/css/serveToolPoup.css"
	rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="${imgPath}/gms/common/css/markState.css" media="screen" />

<script type="text/javascript"
	src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/public.js"></script>
<style>
.inputA {
	width: 14px;
	height: 14px;
	margin: 0 5px 0 20px;
	vertical-align: middle;
}
</style>

<script>
$(function(){
	$.ajax({
		async:false ,
		url:basePath + '/tools.do?method=getToolContent',
		type:'post',
		dataType:  'json',
		success: function(data) {
			var showToolList = $("#showToolList").val() ;
			var addShopTool = $("#addShopTool").val() ;
			var delShopTool = $("#delShopTool").val() ;
			
			if(isEmpty(showToolList)) 
				return ;
			
			// added 
			var added = "" ;
			for(var i=0;i<data.added.length;i++) {
				var obj = data.added[i] ;
				added += "<li dragableBox='true' onMouseOver=min('" + obj.shopToolId ;
				added += "') onMouseOut=mout('" + obj.shopToolId + "')>"
				if(!isEmpty(delShopTool))
					added += "<a href=''><b class='cut' onclick=delToolInfo('" + obj.shopToolId + "')></b></a>" ;
				added += "<span class='gray'>" + obj.status + "</span>" ;
				added += "<table class='logo' border='0' cellspacing='0' cellpadding='0'>" ;
				added += "<tr valign='middle'>" ;
				added += "<td valign='middle' height='54'><img id='" + obj.shopToolId + "unfocus' src='" + obj.toolIcoUnfocus + "' width='140px' height='140px'/> " ;
				added += "<img id='" + obj.shopToolId + "focus' src='" + obj.toolIcoFocus + "' style='display: none;'  width='140px' height='140px'/></td>" ;
				added += "</tr> </table> <span class='Name'>" + obj.toolName + "</span> " ;
				added += "<input class='shopToolId_class' type='hidden' value='" + obj.shopToolId + "' /> </li>" ;
			}
			added += "<li class='clear' id='clear'></li>" ;
			$("#dragableElementsParentBox").html(added) ;
			// toadd
			var toadd = "" ;
			for(var i=0;i<data.toadd.length;i++) {
				var obj = data.toadd[i] ;
				toadd += "<li onMouseOver=min('" + obj.toolId + "') onMouseOut=mout('" + obj.toolId + "')>" ;
				if(!isEmpty(addShopTool))
					toadd += "<a href='javascript:void(0)'><b class='add' onclick=addToolInfo('" + obj.toolId + "')></b></a>" ;
				toadd += "<a href='" + obj.toolUrl + "' target='blank' class='orange'>${shopVo.wordNames['gmsf022']}</a>" ;
				toadd += "<table class='logo' border='0' cellspacing='0' cellpadding='0'> <tr valign='middle'>" ;
				toadd += "<td valign='middle' height='54'>" ;
				toadd += "<img id='" + obj.toolId + "unfocus' src='" + obj.toolIcoUnfocus + "' width='140px' height='140px' />" ;
				toadd += "<img id='" + obj.toolId + "focus' src='" + obj.toolIcoFocus + "' style='display: none;' width='140px' height='140px'  /></td>" ;
				toadd += "</tr> </table> <span class='Name'>" + obj.toolName + "</span></li>" ;
			}
			$("#toadd").html(toadd) ;
        }
	}) ;
		
});

//判断保存顺序列表按钮是否显示
function judge(){ 	
	var shopToolIdClass = $(".shopToolId_class");
	if(shopToolIdClass.size()>0){
		$("#saveBtn").show();
	}else{
		$("#saveBtn").hide();
	}
}

function addToolInfo(toolId) {
	var data = "&toolId=" + toolId ;
	$.ajax({
		async:false ,
		url:basePath + '/tools.do?method=addToolDo',
		type:'post',
		dataType:  'json',
		data:data,
		success: function(data) {
		     if(data.success) {
		    	 document.location.reload();
		     } else {
		    	 alert(data.message) ;
		     }
        }
	}) ;
}

function delToolInfo(shopToolId) {
	var data = "&shopToolId=" + shopToolId ;
	$.ajax({
		async:false ,
		url:basePath + '/tools.do?method=delToolDo',
		type:'post',
		dataType:  'json',
		data:data,
		success: function(data) {
		     if(data.success) {
		    	 document.location.reload();
		     } else {
		    	 alert(data.message) ;
		     }
        }
	}) ;
}

// 移入
function min(id) {
	$("#" + id + "focus").show();
	$("#" + id + "unfocus").hide();
}
// 移出
function mout(id) {
	$("#" + id + "focus").hide();
	$("#" + id + "unfocus").show();
}

// 服务工具点击方法
function menuClick(num) {
	window.location.href = "${basePath}/tools.do?method=index&num=" + num ;
}

function moveIn(obj) {
	$(obj).css("background-color","#0471C0") ;
}

function moveOut(obj) {
	$(obj).css("background-color","") ;
}

</script>
</head>

<body>
	<!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container">
		<div class="article">
			<div class="aside">
				<div class="serve_menu">
					<check:hasAuthority authorityID="1601">
						<a href="${basePath }/tools.do?method=addTools"><samp
								class="s1"></samp><span  style="background-color:#0471C0;" > ${shopVo.wordNames['gmsf001']}</span></a>
					</check:hasAuthority>
					
					</br>
					<a href="${basePath }/tools.do?method=getToolSortData">
					<samp class="s2"></samp><span  onMouseOver="moveIn(this)" onMouseOut="moveOut(this)">工具排序</span></a>
				</div>
				<ul class="left_menu left_menu_tip">
					<check:hasAuthority authorityID="1603">
						<c:forEach var="tool" items="${toolList }" varStatus="s">
							<li><a href="javascript:void(0)"
								onclick="menuClick('${s.index}');">${tool.toolName}</a><b>${tool.status}</b></li>
						</c:forEach>
					</check:hasAuthority>
				</ul>
			</div>

			<div  class="section">
				<div class="serveToolPoup">
					<div class="rightTitle_add">
						<span>${ shopVo.wordNames['gmsf008']} </span>
					</div>
					
					<check:hasAuthority authorityID="160103">
						<input type="hidden" id="showToolList" value="true"/>
					</check:hasAuthority>
					<check:hasAuthority authorityID="160101">
						<input type="hidden" id="addShopTool" value="true"/>
					</check:hasAuthority>
					<check:hasAuthority authorityID="160102">
						<input type="hidden" id="delShopTool" value="true" />
					</check:hasAuthority>

					
					<div class="title">${shopVo.wordNames['gmsf009']}</div>
					<ul id="dragableElementsParentBox">
					</ul>
					
				
<!-- 						onclick="affirm() ;" value="保存顺序列表" /> -->

					<div class="title">${ shopVo.wordNames['gmsf010']}</div>
					<ul id="toadd">
					</ul>
				</div>
				<div id="insertionMarker">
					<span id="insertionMarkerLine"></span>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
