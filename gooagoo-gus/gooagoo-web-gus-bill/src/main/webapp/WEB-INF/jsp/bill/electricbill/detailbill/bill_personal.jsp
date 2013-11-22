<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>账单详情</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/accumulate_point_shop.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/Bill2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gus/bill/js/billPersonal.js"></script>
</head>
<body>
   <!--头部-->
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<input type="hidden" name="billId" value="${billId}"/>
	<input type="hidden" name="imgPath" value="${imgPath }"/>
	<input type="hidden" name="basePath" value="${basePath }"/>
    <!--内容-->
  <div class="container">
    <div class="article">
      <h1>账单详情</h1>
      	<span id="showPic"></span>           
    	<span id="productCont1" class="test">   
        </span>
    </div>
   	<div class="clear"></div>
  </div>
  <!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"/>
</body>
</html>