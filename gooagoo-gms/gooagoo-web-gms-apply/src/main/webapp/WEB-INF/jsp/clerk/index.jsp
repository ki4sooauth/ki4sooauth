<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%
	request.setAttribute("topMenuCode", "17");
	request.setAttribute("leftMenuCode", "1703");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单管理详细信息</title>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gms/apply/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/apply/js/public.js"></script>
<script type="text/javascript" src="${imgPath}/gms/apply/js/clerk.js"></script>
<script type="text/javascript">
	var basePath = '${basePath}';
	var accountId = '${accountId}';
	var accountType = '${accountType}';
	$(document).ready(function() {
		page(1);	
	});
</script>
<style>
	.desk-num-poup li .text {height:20px;line-height:20px;}
	.desk-num-poup li .select {height: 20px; line-height: 20px; width: 110px;}
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
					<span>店员服务情况</span>
				</div>
				<div class="file_nav">
					<a href="javascript:void(0);" onclick="switchTab(this);page(1);" class="curr" id="A">订单信息</a> 
					<a href="javascript:void(0);" onclick="switchTab(this);page(1);" id="B">发票信息</a>
					<a href="javascript:void(0);" onclick="switchTab(this);page(1);" id="C">结账申请</a> 
					<a href="javascript:void(0);" onclick="switchTab(this);page(1);" id="S">刷卡</a>
				</div>
				<span id="fileContent"> </span>
			</div>
		</div>
	</div>
	<!--用户状态-->
</body>
</html>
