<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>积分兑换</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/common/css/topBottom.css" />
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/common/css/all_product_list.css" />
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/common/css/accumulate_point_shop.css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="${imgPath }/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="${imgPath }/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath }/gus/common/js/three_animate.js"></script>
<script type="text/javascript" src="${imgPath }/gus/mall/js/mall-shop.js"></script>
</head>
<body>
<!--头部-->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!--内容-->
<div class="container">
	<div class="article">
		<h1>积分兑换</h1>
		<div class="aside">
				<div class="inform_1">
				<div class="name">
					<c:choose>
			            <c:when test="${!empty loginuserkey.personalInfo.account }">
		            		您好，<span>${loginuserkey.personalInfo.account }</span>
			            </c:when>
			            <c:otherwise>
						    	您还没有名字?<br /><a class="empty" href="${usercenterdomain}/upersonal/setAccount">现在就起&nbsp;》</a>
			            </c:otherwise>
		            </c:choose> 
			    </div>
			    <div class="headPic">
			    	<c:choose>
		   				<c:when test="${loginuserkey.personalProfile.headPic == null || loginuserkey.personalProfile.headPic == '' }">
		   					<img width="110" height="110" src="${imgPath }/gus/common/images/userHeader.png" />
		   				</c:when>
		   				<c:otherwise>
							<img width="110" height="110" src="${loginuserheadpic}" />
						</c:otherwise>
		  			</c:choose>
			    </div>
				<div class="menu_1">
					<a href="${usercenterdomain}/upersonal/index">个人信息</a><span>|</span>
		         	<a href="${usercenterdomain}/ucomment/index">评论管理</a>
			    </div>
			    <div class="menu_2">
			    	<ul>
			        	<li><a href="javascript:void(0)" class="curr"><span>商品管理</span></a></li>
			            <li class="padding_short"><a href="${usercenterdomain}/ushoppinglist/index"><span>购物清单</span></a></li>
			            <li><a href="${usercenterdomain}/ushoppinglist/purchased"><span>已购商品</span></a></li>
			        </ul>
			    </div>
			</div>
		</div>
		<div class="section">
			<div class="acc_point_content">
				<!-- 
        		<div class="price_interval">
           		<h2>积分范围:</h2>
                <ul>
                	<li><a href="javascript:void(0);" class="curr" onclick="javascript: doSelectIntegralScope(null, null);">不限</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(0, 1000);">0-1000</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(1000, 2000);">1000-2000</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(2000, 3000);">2000-3000</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(3000, 4000);">3000-4000</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(4000, 5000);">4000-5000</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(5000, 6000);">5000-6000</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(6000, 7000);">6000-7000</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(7000, 8000);">7000-8000</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(8000, 9000);">8000-9000</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(9000, 10000);">9000-10000</a></li>
                    <li><a href="javascript:void(0);" onclick="javascript: doSelectIntegralScope(10000, null);">10000以上</a></li>
                </ul>
           	</div>
           	-->
				<div class="product_nav">
					<ul>
						<li><a href="javascript:void(0);" class="curr frist"
							onclick="javascript: doSelectConvertType('G');">商品</a></li>
						<li><a href="javascript:void(0);"
							onclick="javascript: doSelectConvertType('C');">优惠凭证</a></li>
					</ul>
				</div>
				<div style="border:1px solid #e9e9e9;text-align:left;">
				<span id="productCont1" style="display:inline-block">
					<div class="sort_box">
						<ul>
							<li class="default curr"
								onclick="javascript: doSelectOrderBy(this, 'c_time_stamp DESC');"><span>默
									认</span> <samp>默认排列</samp></li>
							<li
								onclick="javascript: doSelectOrderBy(this, 'convert_nums ASC');"><span>销量排行</span>
								<samp>降序排列</samp></li>
							<!-- 					        <li onclick="javascript: doSelectOrderBy(this, 'convert_nums ASC');"><span>销量排行</span><samp>升序排列</samp></li> -->
						</ul>
					</div> <span id="productCont11"></span>
					<div class="ClickShow" style="display: none;">
						<a href="javascript: void(0);" class="ClickShowA">查看更多内容</a>
					</div>
				</span> 
				<span id="productCont2" style="display: none">
					<div class="sort_box">
						<ul>
							<li class="default curr"
								onclick="javascript: doSelectOrderBy(this, 'c_time_stamp DESC');"><span>默
									认</span> <samp>默认排列</samp></li>
							<li
								onclick="javascript: doSelectOrderBy(this, 'convert_nums ASC');"><span>销量排行</span>
								<samp>降序排列</samp></li>
							<!-- 					        <li onclick="javascript: doSelectOrderBy(this, 'convert_nums ASC');"><span>销量排行</span><samp>升序排列</samp></li> -->
						</ul>
					</div> 
					<span id="productCont22"></span>
					<div class="ClickShow" style="display: none;">
						<a href="javascript: void(0);" class="ClickShowA">查看更多内容</a>
					</div>
				</span>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
<!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html"
	charEncoding="UTF-8"></c:import>
<!-- 基本数据 -->
<input type="hidden" name="basePath" value="${basePath }" />
<input type="hidden" name="imgPath" value="${imgPath }" />
<!-- 加载积分兑换物品列表参数 -->
<form id="frmLoadConvertThing" action="">
	<input type="hidden" name="loadType" value="" /> 
	<input type="hidden" name="type" value="" /> 
	<input type="hidden" name="shopId" value="${shopId }" /> 
	<input type="hidden" name="integralValueMin" value="" /> 
	<input type="hidden" name="integralValueMax" value="" />
	<input type="hidden" name="pageIndex" value="" /> 
	<input type="hidden" name="pageSize" value="" /> 
	<input type="hidden" name="orderBy" value="c_time_stamp DESC" />
</form>
<!-- 兑换参数 -->
<form id="frmConvertThing" action="">
	<input type="hidden" name="shopIntegralId" value="" /> 
	<input type="hidden" name="address" value="" /> 
	<input type="hidden" name="name" value="" /> 
	<input type="hidden" name="telephone" value="" /> 
	<input type="hidden" name="postcode" value="" />
</form>
</body>
</html>