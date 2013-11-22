<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/all_product_list2.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/accumulate_point_shop3.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/common/jquery-ui/datepicker/style/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.datepicker.min.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/gus/favorite/js/shopfavorite.js"></script>
<title>本店收藏</title>
</head>
<body>
	<input type="hidden" name="basePath" value="${basePath }" />
	<input type="hidden" name="imgPath" value="${imgPath }" />
	<input type="hidden" id="shopInfoGoods" value="${shopId}"/>
	<input type="hidden" id="shopInfoCoupon" value="${shopId}"/>
	<input type="hidden" id="shopInfoActive" value="${shopId}"/>
	<!--头部-->
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<!--内容-->
	<div class="container">
		<div class="article">
			<h1>本店收藏</h1>
			<div class="clear"></div>
			<div class="collection_hot" id="shopping_hot" name="${shopId}">
				<div class="hot1 curr"  >
					<div class="hotTitle">
						<span class="frist">商品收藏</span>
					</div>
					<ul class="hotMain" id="goods_ul">
						<div class="shaixuan">
							<input type="text" id="startDate" readonly="readonly" class="dateBg" value="${start}"/>
							<input type="text" id="endDate" readonly="readonly" class="dateBg" value="${end}"/>
						</div>
						<div id="pageContent_goods"></div>
					</ul>
				</div>
				<div class="hot2">
					<div class="hotTitle">
						<span>活动收藏</span>
					</div>
					<ul class="hotMain" id="activity_ul">
						<div class="shaixuan">
							<input type="text" id="startD" readonly="readonly" class="dateBg" value="${start}"/>
							<input type="text" id="endD" readonly="readonly" class="dateBg" value="${end}"/>
						</div>
						<div id="pageContent_activity"></div>
					</ul>
			   </div>
				<div class="hot3">
					<div class="hotTitle">
						<span>优惠凭证收藏</span>
					</div>
					<ul class="hotMain" id="coupon_ul">
<!-- 						<span id="showPicc"></span> -->
						<div class="shaixuan">
							<input type="text" id="start" readonly="readonly" class="dateBg" value="${start}"/>
							<input type="text" id="end" readonly="readonly" class="dateBg" value="${end}"/>
						</div>
						<div id="pageContent_coupon"></div>
					</ul>
				</div>
				<div class="hotMore">
					<div class="hotTitle">
						<a href="${usercenterdomain}/ufavorite/meritfavorite">>>更多值得收藏</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--底部-->
	<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>
</html>