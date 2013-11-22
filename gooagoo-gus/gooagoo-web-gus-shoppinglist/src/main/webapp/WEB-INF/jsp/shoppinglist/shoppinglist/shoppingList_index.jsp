<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>购物清单</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%> 
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/shopList.css"/>
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/accumulate_point_shop.css"/>
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/shopingList.css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/shopingListEffect.js"></script>
<script type="text/javascript" src="${imgPath}/gus/shoppinglist/js/shoppinglist.js"></script>
<script type="text/javascript" src="${imgPath}/gus/shoppinglist/js/shoppinglist_index.js"></script>
<script type="text/javascript" src="${imgPath}/count/js/gc.js"></script>
</head>
<body>
<!--头部-->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!--内容-->
<input type="hidden" name="basePath" value="${basePath }" />
<input type="hidden" name="imgPath" value="${imgPath }" />
<div class="wrap">
	<h1 class="title">购物清单</h1>
    <div class="main">
    	<div class="mainRight">
			<div class="shopping_section_main">
				<ul class="shopping_scrollImg" id="featured">
		            <li id="image_1">
		              	<a id="40101" href="javascript: void(0);"></a>
		            </li>
				</ul>
				<ul class="shopping_scrollImgSmall" id="thumbs">
	                <li>
	                  <a id="40102" href="javascript: void(0);" id="thumb_1"></a>
	                </li>
	                <li>
	                  <a id="40103" href="javascript: void(0);" id="thumb_2"></a>
	                </li>
	                <li>
	                  <a id="40104" href="javascript: void(0);" id="thumb_3"></a>
	                </li>
	                <li>
	                  <a id="40105" href="javascript: void(0);" id="thumb_4"></a>
	                </li>
				</ul>
			</div>
			<div class="shopping_hot" id="shopping_hot">
				<div class="tab-arrow">
					<b></b>
				</div>	
				<div class="hot1 curr">
					<div class="hotTitle">
						<span>热卖商品</span>
		        	</div>
		        	<ul class="hotMain" id="hotSale"></ul>
				</div>
				<div class="hot2">
					<div class="hotTitle">
						<span>热评商品</span>
					</div>
					<ul class="hotMain"  id="testimonials"></ul>
				</div>   
				<div class="hot3">
					<div class="hotTitle">
						<span>最新上架</span>
					</div>
					<ul class="hotMain" id="newest"></ul>
				</div>
				<div class="hot4">
					<div class="hotTitle">
						<span>猜您喜欢</span>
					</div>
					<ul class="hotMain" id="guesslike"></ul>
				</div>
			</div>
        </div>
        <div class="mainLeft">
        	<div class="tit_1">
                <a href="${basePath}/shoppingList.do?method=addShoppingList" class="fancybox">新增清单</a>
            </div>
            <div class="listMenu">
                <div class="tit_2">清单列表</div>
            	<b class="prev" id="shopping_OrderUp" title="上一组"></b>
                <b class="next" id="shopping_OrderDown" title="下一组"></b>
                <ul id="shopping_Theme"></ul>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>
</html>