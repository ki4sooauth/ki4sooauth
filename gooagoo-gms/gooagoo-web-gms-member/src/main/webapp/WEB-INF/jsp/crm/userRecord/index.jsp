<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户档案</title>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "21");
request.setAttribute("leftMenuCode", "");
%>
<link href="${imgPath}/gms/member/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/member/css/file.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/shopBuild.css" rel="stylesheet" type="text/css" />
<%-- <script type="text/javascript" src="${imgPath}/common/hightCharts/highcharts.js"></script> --%>
<script type="text/javascript" src="${imgPath}/common/highstock/highstock.js"></script>
<script type="text/javascript" src="${imgPath}/common/highstock/modules/exporting.js"></script>
<%-- <script type="text/javascript" src="${imgPath}/common/hightCharts/modules/exporting.js"></script> --%>
<script type="text/javascript" src="${imgPath}/common/hightCharts/themes/grid2.js"></script>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/createChart.js"></script>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/userRecord.js"></script>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/customStatistics.js"></script>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/commonlyUserStatisStatistics.js"></script>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/userDeptDivis.js"></script>
<script type="text/javascript" src="${imgPath}/gms/active/js/ruleCondition.js"></script>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/memberFeature.js"></script>
<script type="text/javascript" src="${imgPath}/gms/member/js/jquery.PrintArea.js"></script>
<script type="text/javascript">
	var basePath = "${basePath}";
	var cbody=true;
	var sFlag="";
	$(document).ready(function() {
		toPage();
	});
</script>
</head>
<body>
	<!--头部-->
	<%@ include file="/WEB-INF/jsp/common/head.jsp"%>
	<div class="sub_nav_wrap">
		<div class="sub_nav_height">
			<ul class="sub_nav">
			    <check:hasAuthority authorityID="2101"><li><a href="#" class="curr" id="toSearchMemberStatistic" name="R">${shopVo.wordNames['cpmf005']}</a></li></check:hasAuthority>
				<check:hasAuthority authorityID="2102"><li><a href="#" id="toOverAllStatus" name="R">${shopVo.wordNames['cpmf006']}</a></li></check:hasAuthority>
<%-- 				<check:hasAuthority authorityID="2103"><li><a href="#" id="toUserStatus" name="R">${shopVo.wordNames['cpmf007']}</a></li></check:hasAuthority> --%>
				<check:hasAuthority authorityID="2104"><li><a href="#" id="toSearchMember" name="R">${shopVo.wordNames['cpmf008']}</a></li></check:hasAuthority>
				<check:hasAuthority authorityID="2105"><li><a href="#" id="toMemberFeature" name="R">${shopVo.wordNames['cpmf009']}</a></li></check:hasAuthority>
			</ul> 
		</div>
	</div>
	<!--内容-->
	<div class="container">
		<div class="article">
		  <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
	   <div class="section" style="overflow:visible;">
			<%-- <div class="file_nav">
	            <a href="javascript:void(0);" class="curr" id="toOverAllStatus" onclick="switchTab(this);toPage();">用户分类统计</a>
	            <a href="javascript:void(0);" id="toUserStatus" onclick="switchTab(this);toPage();">用户分类分析</a>
	            <a href="javascript:void(0);" id="toSearchMember" onclick="switchTab(this);toPage();">会员查询</a>
	         </div>--%>
             <span id="fileCont1">
             </span>
			</div>
		</div>
	</div>
	<!--用户状态-->
	<%@ include file="/WEB-INF/jsp/common/right.jsp"%>
</body>
</html>
