<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['cpmf052']}</title>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%
    request.setAttribute("topMenuCode", "21");
	request.setAttribute("leftMenuCode", "");
%>
<link href="${imgPath}/gms/member/css/BTopBottom.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/member/css/file.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/member/js/public.js"></script>
<script type="text/javascript"
	src="${imgPath}/gms/member/js/userRecord/userRecord.js"></script>
<script type="text/javascript">
	var basePath = '${basePath}';
	var accountId = '${accountId}';
	var accountType = '${accountType}';
	$(document).ready(function() {
	  page(1);	
	});
</script>
</head>
<body>
	<!--头部-->
	<%@ include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container">
		<div class="article">
			<%@ include file="/WEB-INF/jsp/common/left_for_user_record.jsp"%>
			<div class="section">
				<div class="rightTitle">
					<span>${shopVo.wordNames['cpmf052']}</span>
				</div>
				<div class="file_nav">
					<check:hasAuthority authorityID="21040101"><a href="javascript:void(0);" onclick="switchTab(this);page(1);" class="curr" id="A">${shopVo.wordNames['cpmf053']}</a></check:hasAuthority> 
					<check:hasAuthority authorityID="21040102"><a href="javascript:void(0);" onclick="switchTab(this);page(1);" id="B">${shopVo.wordNames['cpmf054']}</a> </check:hasAuthority>
					<check:hasAuthority authorityID="21040103"><a href="javascript:void(0);" onclick="switchTab(this);page(1);" id="C">${shopVo.wordNames['cpmf055']}</a> </check:hasAuthority>
					<check:hasAuthority authorityID="21040104"><a href="javascript:void(0);" onclick="switchTab(this);page(1);" id="S">${shopVo.wordNames['cpmf056']}</a></check:hasAuthority>
				</div>
				<span id="fileContent"> </span>
			</div>
		</div>
	</div>
	<!--用户状态-->
<%@ include file="/WEB-INF/jsp/common/right.jsp"%>
</body>
</html>
