<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>我的商家</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/topBottom.css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/MyBusiness_inform.css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/MyBusiness_end.css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/MyBusiness_poup.css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/poup.css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen"/>
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/three_animate.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="${imgPath }/gus/shop/js/shop.js"></script>
<script type="text/javascript" src="${imgPath }/gus/shop/js/shop_index.js"></script>
<script type="text/javascript" src="${imgPath }/count/js/gc.js"></script>
</head>
<body>
<!--头部-->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!--内容-->
<input type="hidden" name="basePath" value="${basePath }"/>
<input type="hidden" name="imgPath" value="${imgPath }"/>
<div class="container">
	<div class="article">
      <h1>我的商家</h1>
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
		<div class="clear"></div>
        <div id="20101" class="Advertising"></div>
        <div id="20102" class="Advertising"></div>
        <div id="20103" class="Advertising"></div>
      </div>
      <div class="section">
      <div id="recommendlist"></div>
        <div class="sreach_box">
       		<div class="right">
            	<label for="sreach" id="forSreach">输入关键字</label>
            	<input type="text" name="shopName"  value="" /><a href="javascript:void(0)"  onclick="javascript: getShopCard(true);"></a>
            </div>	
            <select name="cardType" onchange="javascript: getShopCard(true);">
            	<option value="">全部</option>
               	<option value="1,2">会员商家</option>
                <option value="0">关注商家</option>
            </select > 
               <select class="Two" name="shopType" onchange="javascript: getShopCard(true);" >
               <option value="">全部</option>
               <c:forEach items="${simpleShopTypeList}" var ="list">
            	<option value="${list.shopTypeId}">${list.shopTypeName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="sort_box"  id="">
        	<ul>
            	<li class="default curr"  onclick="javascript: search_order('');"><span>默　　认</span><samp>默认排列</samp></li>
                <li onclick="javascript: search_order('stroll_time')" ><span >最近逛过</span><samp >降序排列</samp></li>
                <li onclick="javascript: search_order('shopping_time')"><span >最近购过</span><samp  >降序排列</samp></li>
            </ul>
        </div>
	        <span id="showPic1">
		        <div class="content_card_box" id="div_box"></div>
	        </span>
        </div>
      <div class="ClickShow"  style="display:none">
      <a href="javascript: void(0);" class="ClickShowA" onclick="javascript: getShop();">查看更多内容</a>
      </div>
      </div>
</div>
<!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>

</html>