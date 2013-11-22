<%@page import="javax.swing.border.Border"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/serveTool.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/goodsList.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${imgPath}/gms/common/css/markState.css" media="screen" />

<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/public.js"></script>
<script type="text/javascript" src="${imgPath}/common/hightCharts/highcharts.js"></script>
<script type="text/javascript" src="${imgPath}/common/hightCharts/modules/exporting.js"></script>
<script type="text/javascript" src="${imgPath}/common/hightCharts/themes/grid2.js"></script>

<script>
	 toolId = "";
	 stId = "";

	$(function() {
		
		var num = '${num }';
		$(".left_menu li a").eq(num).addClass("curr");
		$(".left_menu li a").click(function() {
			$(".left_menu li a").removeClass("curr");
			$(this).addClass("curr");
		})
		toolId = '${toolList[num].toolId}';		
		getToolsStatus(toolId);
		menuClick('${toolList[num].shopToolId}', toolId, '${toolList[num].status}','${toolList[num].toolUrl}');

		$(".histogram_nav a").click(function() {
			$(".histogram_nav a").removeClass("curr");
			$(this).addClass("curr");
			getToolsStatus(toolId);
		});
	});

	cbody = true;
	//左侧已有服务工具点击 
	function menuClick(shopToolId, id, status,toolUrl) {
		$("#toolUrl").attr("src",toolUrl);

		$("#div_auth").hide();
		if (status == "已发布") {
			$("#obj").html("");
			getToolsStatus(toolId);
			stId = shopToolId;
		}
		else {
			$("#obj").html("无统计数据") ;
			stId = "";
		}
		if (stId.length > 0) {
			$
					.ajax({
						type : "post",
						url : basePath + "/tools.do?method=getAuth&id="
								+ stId,
						dataType : 'json',
						success : function(data) {

							var str = "";
							for ( var i = 0; i < data.length; i++) {
								str += "<input class='inputA' type='checkbox' onclick='checkBoxSelect(this)' name='checkbox2' value='";
								str += data[i].cardId + "'";
								if (data[i].flag)
									str += "checked";
								str += " />" + data[i].cardName;
							}

							$("#auth_check").html(str);
						}
					})
			$("#div_auth").show();
			$("#div_auth_text").hide();
		} else {
			$("#div_auth_text").show();
			$("#div_auth").hide();
		}

		$("#first_tab").addClass("curr");
		$("#second_tab").removeClass("curr");
		$("#fileCont1").css('display', 'block');
		$("#fileCont2").hide();
	}

	//全选和反全选
	function checkBoxSelect(obj) {
		var checkBoxs = document.getElementsByName("checkbox2");
		if (obj.value == 0) {
			for ( var i = 0; i < checkBoxs.length; i++) {
				checkBoxs[i].checked = obj.checked;
			}
		}
	}
	//保存权限 
	function saveAuthority() {

		var memberIds = "";//会员卡类别编号 

		$("input[name='checkbox2']:checkbox:checked").each(function() {
			var checkboxValue = $(this).val();
			if (checkboxValue != 0) {
				memberIds += $(this).val() + ",";
			}
		});

		$.ajax({
			type : "POST",
			async : false,
			url : "tools.do?method=saveAuth&id=" + stId + "&authority="
					+ memberIds,
			success : function(html) {
				var json = eval('(' + html + ')')["success"];
				if (json == true) {
					alert("保存成功");
				}
			}
		});
	}

	/**
	 * 服务工具
	 */
	function getToolsStatus(id) {
		
		var toolId = id;		
		var shopId = '${shopId }';
		var timeType= "D";
		var data="method=graph&type=tools&content="+ shopId + "^" + toolId + "^" + timeType;
// 		$.ajax({
// 			async : false,
// 			type : "POST",
// 			data:data,
// 			url : basePath + "/statistics.do",
// 			success : function(data) {
// 					alert(data);
// 				// createGraph(id,data);
// 				 //createGraph("1",data) ;
// 			}
// 		})
	}
	
	// 生成 图
	function createGraph(idStr,data) {
		var obj = $("#hightCharts").clone().attr("id","hightCharts"+idStr).css('display','block');
		$("#obj").append(obj);
		eval("$('#hightCharts'+idStr).highcharts(data)");
	}
	
	function moveIn(obj) {
		$(obj).css("background-color","#0471C0") ;
	}
	
	function moveOut(obj) {
		$(obj).css("background-color","") ;
	}
</script>
<style>
.inputA {
	width: 14px;
	height: 14px;
	margin: 0 5px 0 20px;
	vertical-align: middle;
}
</style>
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
						<a href="${basePath }/tools.do?method=addTools">
						<samp class="s1"></samp><span  onmouseover="moveIn(this)"  onmouseout="moveOut(this)">${shopVo.wordNames['gmsf001']}</span></a>
					</check:hasAuthority>
					<br />
					<a href="${basePath }/tools.do?method=getToolSortData">
					<samp class="s2"></samp><span  onMouseOver="moveIn(this)" onMouseOut="moveOut(this)">工具排序</span></a>
				</div>
				<ul class="left_menu left_menu_tip">
					<check:hasAuthority authorityID="1603">
						<c:forEach var="tool" items="${toolList }">
							<li><a href="javascript:void(0)"
								onclick="menuClick('${tool.shopToolId }','${tool.toolId}','${tool.status }','${tool.toolUrl}');">${tool.toolName}</a><b>${tool.status}</b></li>
						</c:forEach>
					</check:hasAuthority>
				</ul>
			</div>

			<div class="section">
				<div class="rightTitle_add">
					<span>${shopVo.wordNames['gmsf002']}</span>
				</div>
				<check:hasAuthority authorityID="1603">
					<check:hasAuthority authorityID="160303">
				<div id="pic" style="background-image:url(${toolPic})"></div>					
						<iframe	id="toolUrl"  width="100%" height="480px" allowTransparency="true"  frameborder="0" scrolling="no" src="">
						</iframe>												
						<div class="file_nav">
							<a id="first_tab" href="javascript:void(0);" class="curr">
								${shopVo.wordNames['gmsf003']} </a> <a id="second_tab"
								href="javascript:void(0);"> ${shopVo.wordNames['gmsf004']} </a>
						</div>
		<span id="fileCont1" style="border: 1px solid #ccc; background: #fff; display: block; color: #666666; line-height: 50px; font-size: 14px; font-weight: bold; text-align: center">
							<br/>
							<div id="obj"></div>
							<div id="hightCharts" style="display: none;"></div>
						</span>
						<span id="fileCont2" style="display: none; border: 1px solid #ccc; background: #fff;">
							<check:hasAuthority authorityID="160302">
								<div id="div_auth"
									style="clear: both; text-align: center; padding: 30px 0; line-height: 30px; font-size: 14px; height: 140px;">
									<div style="text-align: left; text-indent: 30px; font-size: 14px; font-weight: bold; color: #8B0000;">${shopVo.wordNames['gmsf023']}</div>
									<div id="auth_check"></div>
									<input class="blueBtn"
										style="cursor: pointer; margin-left: 508px; margin-top: 25px; border: none 0; width: 200px; height: 24px; line-height: 24px;"
										type="button" value="${shopVo.wordNames['gmsf024']}"
										onclick="saveAuthority();" />
								</div>
			<div id="div_auth_text" style="height: 200px; line-height: 200px; display: block; color: #666666; font-size: 14px; font-weight: bold; text-align: center">
									${shopVo.wordNames['gmsf036']}</div>
							</check:hasAuthority>
						</span>
					</check:hasAuthority>
				</check:hasAuthority>
			</div>
		</div>
	</div>
</body>
</html>
