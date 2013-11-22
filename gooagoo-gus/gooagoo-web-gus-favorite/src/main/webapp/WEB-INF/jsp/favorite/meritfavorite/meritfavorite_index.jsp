<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/accumulate_point_shop.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/all_product_list2.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/accumulate_point_shop2.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen"></link>
<script src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="${imgPath}/gus/favorite/js/meritfavorite.js"></script>
<title>值得收藏</title>
</head>
<body>
<!--头部-->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!--内容-->
<input type="hidden" name="basePath" value="${basePath }" />
<input type="hidden" name="imgPath" value="${imgPath }" />
<div class="container">
	<div class="article">
		<h1>值得收藏</h1>
        <div class="acc_point_content">
			<div class="product_nav">
	        	<ul>
	        		<li><a href="javascript:void(0);" class="curr frist">精品收藏</a></li>
	               	<li><a href="javascript:void(0);">优惠收藏</a></li>
	               	<li><a href="javascript:void(0);">活动收藏</a></li>
               	</ul>
			</div>
			<div style="border:1px solid #e9e9e9;text-align:left;">
	            <span id="productCont1" style="display:inline-block">
	            	<ul class="product_list_box" id="goods_ul"></ul>
	               	<div class="ClickShow">
	               		<a href="javascript: void(0);" id="ClickShow_goods"  class="ClickShowA" onclick="getGoods_data();">查看更多内容</a>
	               	</div>
	            </span>
		        <span id="productCont2" style="display:none">
			        <ul class="product_list_box"  id="coupon_ul"></ul>
		            <div class="ClickShow">
	            		<a href="javascript: void(0);" id="ClickShow_coupon"  class="ClickShowA" onclick="getCoupon_data();">查看更多内容</a>
	               	</div>
		        </span>
		        <span id="productCont3" style="display:none">
		        	<ul class="product_list_box"  id="activity_ul"></ul>
		            <div class="ClickShow">
	               		<a href="javascript: void(0);" id="ClickShow_activity"  class="ClickShowA" onclick="getActivity_data();">查看更多内容</a>
	               	</div>
		        </span>
	        </div>
		</div>
	</div>
</div>
<!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>
</html>