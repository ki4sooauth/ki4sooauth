<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width; initial-scale=1.0;minimum-scale=1.0, maximum-scale=1.0">
<title>积分商场</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<script type="text/javascript" src="${imgPath }/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath }/gus/merchant/mobile/js/iscroll.js"></script>
<script type="text/javascript" src="${imgPath }/gus/merchant/mobile/js/mall.js"></script>
<script type="text/javascript" src="${imgPath }/common/js/normalCheck.js"></script>
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/merchant/mobile/css/IntegralCard.css">
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/merchant/mobile/css/IntegralCard-media-queries.css">
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/merchant/mobile/css/IntegralFont.css">
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/merchant/mobile/css/pop.css">
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/merchant/mobile/css/pop-media-queries.css">
</head>
<body>
<input type="hidden" id="basePath" name="basePath" value="${basePath }" />
<input type="hidden" id="imgPath" name="imgPath" value="${imgPath }" />
<input type="hidden" id="shopId" name="shopId" value="${shopId }" />
<div id="wrapper">
	<div class="All">
		<div id="pullDown" style="display:none"><span class="pullDownIcon"></span><span class="pullDownLabel">Pull down to refresh...</span></div>
		<article>
			<div class="IntegralCard" id="Integral"><center><img src="${imgPath }/gus/merchant/mobile/images/indicator_circle_ball.gif">正在加载，请稍候...</center></div>
		</article>
		<div id="pullUp"><span class="pullUpIcon"></span><span class="pullUpLabel">上  拉  刷  新...</span></div>
	</div>
</div>
</body>
</html>