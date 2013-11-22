<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/accumulate_point_shop.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/all_product_list2.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/accumulate_point_shop2.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen"></link>
<link href="${imgPath}/common/jquery-ui/datepicker/style/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.datepicker.min.js"></script>
<script type="text/javascript" src="${imgPath}/gus/favorite/js/favorite.js"></script>
<title>我的收藏</title>
</head>
<body>
	<input type="hidden" name="basePath" value="${basePath }" />
	<input type="hidden" name="imgPath" value="${imgPath }" />
	<input type="hidden" id="shopInfoGoods" value="${shopId}"/>
	<input type="hidden" id="shopInfoCoupon" value="${shopId}"/>
	<input type="hidden" id="shopInfoActive" value="${shopId}"/>
	<input type="hidden" id="shopTypeSelect" value=""/>
	<input type="hidden" id="recommendationGoodsList" value="${recommendationGoodsList}"/>
	<input type="hidden" id="recommendActivityResponseList" value="${recommendActivityResponseList}"/>
	<input type="hidden" id="recommendCouponResponseList" value="${RecommendCouponResponseList}"/>
	<!--头部-->
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<!--内容-->
	<div class="container">
		<div class="article">
			<h1>我的收藏</h1>
				<c:if test="${!empty recommendationGoodsList || !empty recommendActivityResponseList || !empty RecommendCouponResponseList}">
					<div class="acc_point_content">
						<div class="product_nav">
							<div class="hotMore">
								<div class="hotTitle">
									<a href="${usercenterdomain}/ufavorite/moreRecommend">>>更多推荐</a>
								</div>
							</div>
							<ul>
				          	  <li id="curr1"><a href="javascript:void(0);" class="curr frist">推荐商品</a></li>
				              <li id="curr2"><a href="javascript:void(0);">推荐活动</a></li>
				              <li id="curr3"><a href="javascript:void(0);">推荐优惠凭证</a></li>
							</ul>
						</div>
						<div style="border:1px solid #e9e9e9;text-align:left;">
						<span id="productCont1" style="display:inline-block">
							<ul class="product_list_box Boxauto">
								<c:if test="${!empty recommendationGoodsList }">
									<c:forEach items="${recommendationGoodsList}" var="list">
										<li class="content productC"><a href="${list.goodsVisitUrl}" target="_blank"><img src="${list.goodsImage.middleImgUrl}"width="180" height="180" style="display:block" /></a>
											<p class="msg">${list.goodsName}</p>
									   </li>
									</c:forEach>
								</c:if>
							
							</ul>
						</span> 
						<span id="productCont2" style="display: none">
							<ul class="product_list_box Boxauto">
								<c:if test="${!empty recommendActivityResponseList }">
									<c:forEach  items="${recommendActivityResponseList}" var ="list">
										<li class="content productC"><a href="${list.activeVisitUrl}" target="_blank"><img src="${list.activeImage.middleImgUrl}"  width="180" height="180" style="display:block"/></a>
											<p class="msg">${list.activeName}</p>
									   </li>
				                   </c:forEach>
			                   </c:if>
		                   <c:if test="${empty recommendActivityResponseList }">
								<div class="sorryPrompt">
									<samp>${messageA}</samp>
								</div> 
							</c:if>
							</ul>
						</span> 
						<span id="productCont3" style="display: none">
							<ul class="product_list_box Boxauto" >
								<c:if test="${!empty RecommendCouponResponseList }">
									<c:forEach  items="${RecommendCouponResponseList}"  var="list">
										<li class="content productC"><a href="${list.couponVisitUrl}" target="_blank"><img src="${list.couponImage.middleImgUrl}"  width="180" height="180"  style="display:block" /></a>
											<p class="msg">${list.couponName}</p>
									   </li>
				                    </c:forEach>
			                    </c:if>
		                    <c:if test="${empty RecommendCouponResponseList }">
								<div class="sorryPrompt">
									<samp>${messageC }</samp>
								</div> 
							</c:if>
							</ul>
						</span>
						</div>
					</div>
					  
				
				</c:if>
			<div class="clear"></div>
			<div class="collection_hot" id="shopping_hot" name="${shopId}">
				<div class="tab-arrow">
					<b></b>
				</div>
				<div class="hot1 curr">
					<div class="hotTitle">
						<span>商品收藏</span>
					</div>
					<div class="hotMain" id="goods_ul">
						<div class="shaixuan" id="gg" style="display: block">
							<div class="select_box">
								<p id="shopTypeNamef">商家类别</p>
								<dl id="shopType"></dl>
							</div>
							<div class="select_box">
								<p id="shopNameG">商家名称</p>
								<dl id="shopInfo"></dl>
							</div>
							<input type="text" id="startDate" readonly="readonly" class="dateBg" value="${start}"/>
							<input type="text" id="endDate" readonly="readonly" class="dateBg" value="${end}"/>
						</div>
						<div id="pageContent_goods"></div>
					</div>
				</div>
				<div class="hot2">
					<div class="hotTitle">
						<span>活动收藏</span>
					</div>
					<div class="hotMain" id="activity_ul">
						<div class="shaixuan" id="aa" style="display: block">
							<div class="select_box">
								<p id="shopTypeNamef">商家类别</p>
								<dl id="shopT"></dl>
							</div>
							<div class="select_box">
								<p id="shopNameA">商家名称</p>
								<dl id="shopI"></dl>
							</div>
							<input type="text" id="startD" readonly="readonly" class="dateBg" value="${start}"/>
							<input type="text" id="endD" readonly="readonly" class="dateBg" value="${end}"/>
						</div>
						<div id="pageContent_activity"></div>
					</div>
			   </div>
				<div class="hot3">
					<div class="hotTitle">
						<span>优惠凭证收藏</span>
					</div>
					<div class="hotMain" id="coupon_ul">
						<div class="shaixuan" id="cc" style="display: block">
							<div class="select_box">
								<p id="shopTypeNamef">商家类别</p>
								<dl id="shope"></dl>
							</div>
							<div class="select_box">
								<p id="shopNameC">商家名称</p>
								<dl id="shopo"></dl>
							</div>
							<input type="text" id="start" readonly="readonly" class="dateBg" value="${start}"/>
							<input type="text" id="end" readonly="readonly" class="dateBg" value="${end}"/>
						</div>
						<div id="pageContent_coupon"></div>
					</div>
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