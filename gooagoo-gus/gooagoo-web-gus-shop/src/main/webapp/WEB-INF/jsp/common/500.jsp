<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link href="${imgPath}/gus/common/css/error404.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<title>我的商家</title>
</head>
<body>
<!--头部-->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!--内容-->
<div class="container">
	<div class="error404">
		<div class="errorFigure"><img src="${imgPath}/gus/common/images/500error_03.png"  /></div>
		<div class="errorFont">
			<span class="errorEnglish">500 ERROR PAGE</span><br />
			<span class="errorChinese">服务器错误，请稍后重试此请求。</span><br />
			<span class="errorLinks"><a href="javascript: void(0);" onclick="javascript: window.location.reload();" class="backRetry">重试</a><a href="${usercenterdomain}/ucryout/index" class="backFirst">返回首页</a></span>
	  	</div>
	</div>
</div>
<!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>
</html>