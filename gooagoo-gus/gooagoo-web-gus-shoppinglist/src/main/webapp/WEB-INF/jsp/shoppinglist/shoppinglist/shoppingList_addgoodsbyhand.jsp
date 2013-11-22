<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>手动添加</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/topBottom.css"/>
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/poup.css"/>
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/gus/shoppinglist/js/shoppinglist_goodsbyhand.js"></script>
</head>
<body class="snow_bg" STYLE='OVERFLOW:SCROLL;OVERFLOW-Y:HIDDEN;OVERFLOW-X:HIDDEN'>
<input type="hidden" name="basePath" value="${basePath }" />
<input type="hidden" name="imgPath" value="${imgPath }" />
<div class="choice_goods">
	<p class="title">新增商品</p>
	<div class="new_product_add">
    	<label></label><br />
		<input name="goodsName" maxlength="32"/>
		<input name="shoppingListId" value="${shoppingListId}" type="hidden"/>
    </div>
    <div class="control">
    	<a href="javascript:void(0)" class="btn" id="sure">确认</a><a href="#" class="btn" onclick="javascript:parent.$.fancybox.close();">取消</a>
    </div>
</div>
</body>
</html>