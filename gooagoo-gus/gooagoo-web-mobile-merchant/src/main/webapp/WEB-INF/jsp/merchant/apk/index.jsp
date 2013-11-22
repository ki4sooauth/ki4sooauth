<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width; initial-scale=1.0;minimum-scale=1.0, maximum-scale=1.0">
<title>下载APP</title>
</head>
<body>
<input type="hidden" id="basePath" name="basePath" value="${basePath }" />
<input type="hidden" id="imgPath" name="imgPath" value="${imgPath }" />
<a href="${downloadurl }">点击下载APP</a>
</body>
</html>