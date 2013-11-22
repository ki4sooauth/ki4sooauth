<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%
	request.setAttribute("topMenuCode", "17");
	request.setAttribute("leftMenuCode", "1702");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>账单信息管理</title>
<link href="${imgPath}/gms/apply/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/apply/css/file.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/apply/js/public.js"></script>
<script type="text/javascript" src="${imgPath}/gms/apply/js/billDetail.js"></script>
<script type="text/javascript">
	var basePath = '${basePath}';
	var accountId = '${accountId}';
	var accountType = '${accountType}';
	$(document).ready(function() {
		pageDetail(1,"${orderid}");	
	});
</script>
</head>
<body>
	<!--头部-->
	<%@ include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container">
		<div class="article">
			<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
			<div class="section">
			<div class="rightTitle">
                <span>账单</span>
              </div>
				<div class="file_nav">
					<a href="javascript:void(0);" onclick="switchTab(this);pageDetail(1,'${orderid}');" class="curr" id="A">账单信息</a> 
					<a href="javascript:void(0);" onclick="switchTab(this);pageDetail(1,'${orderid}');" id="B">账单商品详细信息</a>
<%-- 					<a href="javascript:void(0);" onclick="switchTab(this);pageDetail(1,'${orderid}');" id="C">${shopVo.wordNames['cpmf055']}</a>  --%>
<%-- 					<a href="javascript:void(0);" onclick="switchTab(this);pageDetail(1,'${orderid}');" id="S">${shopVo.wordNames['cpmf056']}</a> --%>
				</div>
				<span id="fileContent"> </span>
			</div>
		</div>
	</div>
	<!--用户状态-->
</body>
</html>
