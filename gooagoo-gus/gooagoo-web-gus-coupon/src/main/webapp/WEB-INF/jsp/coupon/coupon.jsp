<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>本店优惠</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gus/common/css/accumulate_point_shop.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/all_product_list.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/gus/coupon/js/showCoupon.js"></script>
<script type="text/javascript" src="${imgPath}/count/js/gc.js"></script>
</head>
<body>
	<input type="hidden" name="basePath" value="${basePath }"/>
	<input type="hidden" name="imgPath" value="${imgPath }"/>
	<input type="hidden" name="pageIndex" value=""/>
	<input type="hidden" name="shopId" value="${shopId}"/>
	<input type="hidden" name="couponType" value=""/>
   <!--头部-->
   <%@ include file="/WEB-INF/jsp/common/header.jsp"%>
  <div class="container">
    <div class="article">
      <h1>本店优惠</h1>
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
      <div class="section" >
         <div class="acc_point_content">
         	<div class="banner_1" >
				<a id="30101" style="display:block;" href="javascript: void(0);"></a>
            	<a id="30102" href="javascript: void(0);"></a>
            	<a id="30103" href="javascript: void(0);"></a>
			</div>
         	<div class="good_car" style="width:100px;position:fixed;right:10px;bottom:10px;z-index:10;background:#d51112;line-height:30px;color:#fff;padding:0 10px;">已加入购物车<code>0</code>个</div>
            <div class="screen_main">
             <div class="child-li">
	             <span class="caption_name">类　　别:</span>
	             <span class="name_links">
	                 <a href="javascript:void(0);" onclick="javascript: onType('', this);" class="selected">不　限</a>
	                 <a href="javascript:void(0);" onclick="javascript: onType('D', this);">折扣劵</a>
	                 <a href="javascript:void(0);" onclick="javascript: onType('C', this);">代金劵</a>
	             </span>
            </div>
            </div>
            <span id="showPic"></span>
            <div id="shoplist"></div>
            <div id="imgSlide"></div>
            <ul class="fav_box" id="couponlist"></ul>
            <div class="ClickShow" style="display: none;"><a href="javascript: void(0);" class="ClickShowA" onclick="javascript: moreCoupon();">查看更多内容</a></div>
        </div>
      </div>
        <div class="clear"></div>
    </div>
  </div>
  <!--底部-->
 <c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>
</html>
