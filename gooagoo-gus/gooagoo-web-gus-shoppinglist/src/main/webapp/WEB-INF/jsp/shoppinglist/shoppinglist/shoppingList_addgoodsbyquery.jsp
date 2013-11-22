<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>添加商品</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${imgPath}/gus/common/css/sppop.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/gus/shoppinglist/js/shoppinglist_goodsbyquery.js"></script>
</head>
<body>
<input type="hidden" name="basePath" value="${basePath }" />
<input type="hidden" name="imgPath" value="${imgPath }" />
<input type="hidden" name="shoppingListId" value="${shoppingListId }" />
<div class="popList">
	<div class="title">
    	<h2 class="titl">商品分类</h2><h2>商品选择(点击选择)</h2>
    </div>
    <div class="barL">
    	<ul id="category1"></ul>
    </div>
    <div class="barR">
    	<ul id="category2"></ul>
    </div>
    <div class="clear"></div>
</div>
<div class="selectedList">
	<h2 class="title">已选商品：</h2>
    <div class="listContent">
			<ul id="selectedcategory"></ul>
            <div class="clear"></div>
	</div>
    <div class="confirmBox"></div>
    <a id="sure" href="javascript: void(0);" class="confirmBoxBtn">确定</a>
</div>
</body>
</html>
