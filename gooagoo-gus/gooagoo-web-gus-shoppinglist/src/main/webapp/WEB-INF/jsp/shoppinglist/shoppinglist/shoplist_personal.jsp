<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>清单详情</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/accumulate_point_shop.css"/>
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/shopingList.css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/shoppingdetail.css"/>
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/gus/shoppinglist/js/shoppinglist.js"></script>
<script type="text/javascript" src="${imgPath}/gus/shoppinglist/js/shoppinglist_detail.js"></script>
</head>
<body>
<!--头部-->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<input type="hidden" name="basePath" value="${basePath }" />
<input type="hidden" name="imgPath" value="${imgPath }" />
<input type="hidden" id="shoppingListId" name="shoppingListId" value="${data.shoppingListId }"/>
<input type="hidden" id="preShoppingTime" name="preShoppingTime" value="<fmt:formatDate value='${data.preShoppingTime }'  pattern='yyyy-MM-dd' type='date' dateStyle='long'></fmt:formatDate>"/>
<input type="hidden" id="title" name="title" value="${data.title }"/>
<!--内容-->
<div class="container">
	<div class="article">
		<h1>清单详情</h1>
      	<div class="mainRight"></div>
	</div>
</div>
<!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>
</html>