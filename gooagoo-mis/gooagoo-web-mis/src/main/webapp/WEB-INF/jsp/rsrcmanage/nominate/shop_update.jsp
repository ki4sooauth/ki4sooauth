<%@page import="com.gooagoo.common.utils.TimeUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<%
	request.setAttribute("currentTime", TimeUtils.getCurrentDateTime());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${imgPath}/mis/js/color.js" type="text/javascript"></script>
<link href="${imgPath}/mis/css/mis.css" type="text/css" rel="stylesheet">
<title>修改推荐商家</title>
</head>

<body>
	<form id="addForm" method="post">
		<div id="shopbg1" style="background-color:${shop.color};overflow: hidden; width: 100%; height: 60px; line-height: 59px; margin:58px auto 15px;text-align:center;">
			<span style="display:inline-block;vertical-align:middle"><img width="60" height="60" src="${shop.logo}"></img></span><span style="display:inline-block;vertical-align:middle;color:#FFF;">${shop.shopName }</span>
		</div>
		<table style="margin: 31px 0px 20px 340px;">
			<tr>
				<td>
					<div style="background-color: #DC3C14; width: 40px;height:20px;cursor:pointer;"  onclick="changeColor(this)">&nbsp;</div>
				</td>
				<td>
					<div style="background-color: #FF5E00; width: 40px;height:20px;cursor:pointer;" onclick="changeColor(this)">&nbsp;</div>
				</td>
				<td>
					<div style="background-color: #00A0E9; width: 40px;height:20px;cursor:pointer;" onclick="changeColor(this)">&nbsp;</div>
				</td>
				<td>
					<div style="background-color: #96647D; width: 40px;height:20px;cursor:pointer;" onclick="changeColor(this)">&nbsp;</div>
				</td>
				<td>
					<div style="background-color: #00BE5A; width: 40px;height:20px;cursor:pointer;" onclick="changeColor(this)">&nbsp;</div>
				</td>
				<td>
					<div style="background-color: #00D2B4; width: 40px;height:20px;cursor:pointer;" onclick="changeColor(this)">&nbsp;</div>
				</td>
				<td>
					<div style="background-color: #FF5A78; width: 40px;height:20px;cursor:pointer;" onclick="changeColor(this)">&nbsp;</div>
				</td>
				<td>
					<div style="background-color: #646464; width: 40px;height:20px;cursor:pointer;" onclick="changeColor(this)">&nbsp;</div>
				</td>
			</tr>
		</table>
		<p>
		<div style="padding:0 0 0 413px">起始时间： 
			<input id="startTime" name="startTime" type="text" value="<fmt:formatDate value="${shop.startTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'${currentTime}'})" class="Wdate" style="cursor: pointer;" /> 
			<label class="wrong" id="lblstartTime" style="display: none;">请选择起始时间！</label>
		</div>
		<br>
		<div style="padding:0 0 0 413px">结束时间： 
			<input id="endTime" name="endTime" type="text" value="<fmt:formatDate value="${shop.endTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'${currentTime}'})" style="cursor: pointer;" /> 
			<label class="wrong" id="lblendTime" style="display:none;">请选择结束时间！</label>
		</div>
		<div style="padding:41px 0 0 480px">
			<input style="width:70px;height:24px;" id="save" type="button" value="保存" onclick="enter()" />
		</div>
		<input name="id" type="hidden" value="${shop.id }" /> 
		<input name="shopId" type="hidden" value="${shop.shopId }" /> 
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			checkIsNull();
		});
		//非空校验
		function checkIsNull() {
			$("#startTime").bind("blur", checkStartTime);
			$("#startTime").bind("focus", function() {$("#lblstartTime").css({"display" : "none"});});

			$("#endTime").bind("blur", checkEndTime);
			$("#endTime").bind("focus", function() {$("#lblendTime").css({"display" : "none"});});
		}
		// 校验时间 
		function checkStartTime() {
			if ($("#startTime").val() == "") {
				$("#lblstartTime").show();
				return false;
			} else {
				return true;
			}
		}
		function checkEndTime() {
			if ($("#endTime").val() == "") {
				$("#lblendTime").show();
				return false;
			} else {
				return true;
			}
		}
		//验证form
		function checkForm() {
			if (!checkStartTime() || !checkEndTime()) {
				return false;
			} else {
				return true;
			}
		}
		//保存
		function enter() {
			$("#save").attr("disabled",true);
			if (checkForm()) {
				var color = $("#shopbg1").css("background-color");
				color = rgb2hex(color).toUpperCase();
				var url = "nominateS.do?method=updateNominateShop";
				var data = $("#addForm").serialize() + "&color=" + color;
				var result = ajaxJsonMessageByData(url,data);
				if(result.success == true){
					alert(result.message);
					closefbox();
				}else if(result.success == false){
					alert(result.message);
					$("#save").attr("disabled",false);
				}else{
					alert(result);
					closefbox();
				}
			}
		}
		//改变背景颜色
		function changeColor(e) {
			var color = $(e).css("background-color");
			$("#shopbg1").css("background-color", color);
		}
		function closefbox() {
			(document.parentWindow || document.defaultView).parent.closeFancyBox();
			(document.parentWindow || document.defaultView).parent.page(1);
		}
	</script>
</body>
</html>