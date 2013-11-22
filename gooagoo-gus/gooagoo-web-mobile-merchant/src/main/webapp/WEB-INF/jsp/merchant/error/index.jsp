<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width; initial-scale=1.0;minimum-scale=1.0, maximum-scale=1.0">
<title>访问出错</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/merchant/mobile/css/error.css">
</head>
<body class="errorBg">
<div class="All">
	<div class="errorCon">
		<img src="${imgPath }/gus/merchant/mobile/images/erroX.png" /><br/>
		<c:choose>
		<c:when test="${message == null || fn:trim(message) == '' }">
		<font>抱歉，访问出错了！</font>
		</c:when>
		<c:otherwise>
		<font>${message }</font>
		</c:otherwise>
		</c:choose>
	</div>
</div>
</body>
</html>