<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/date_table.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gus/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/date_table.js"></script>
<script type="text/javascript">
	usercenterdomain = "${usercenterdomain }";
</script>
<div class="header_container">
	<div class="user_header">
		<div class="user_control">
			<a href="${usercenterdomain}" class="bookmark_us" rel="sidebar" onclick="javascript: addfavorite(); return false;">
				<span class="arrow"></span>
           		收藏购阿购
          	</a>
			<ul class="login_header">
	            <li><a href="${passportdomain}/personalLogout">退出</a></li>
	            <li class="Comment"><a href="${usertempdomain}/template/index" target="_blank">进入模板系统</a></li>
	            <li class="Comment"><a href="${usercenterdomain}/ucomment/index">评论管理</a></li>
	            <li><a href="${usercenterdomain}/unotice/index">商家通知</a></li>
	            <li class="msg_user"><a href="${usercenterdomain}/upersonal/index">个人信息管理</a></li>
	            <c:choose>
		            <c:when test="${!empty loginuserkey.personalInfo.account }">
		            	<li>您好！${loginuserkey.personalInfo.account } </li>
		            </c:when>
		            <c:otherwise>
		            	<li>您还没有名字，<a href="${usercenterdomain}/upersonal/setAccount" style="text-decoration: underline;">起一个名字吧？</a></li>
		            </c:otherwise>
	            </c:choose>
          	</ul>
		</div>
	</div>
	<div class="Logo">
		<span class="logoImg"><a href=""><img src="${imgPath}/gus/common/images/logo.png" /></a></span>
        <a class="product_control curr" href="${usercenterdomain}/calendar/index" title="消费日历">${fn: substring(currentTime, 8, 10) }</a>
	</div>
	<div class="top_menu">
		<div class="top_nav">
			<ul>
		          <li><a href="${usercenterdomain}/ucryout/index">首    页</a></li>
		          <li><a href="${usercenterdomain}/ushop/index">我的商家</a></li>
		          <li class="subNav"><a href="javascript:void(0);">账单管理</a>
		          		<dl>
		                	<dd><a href="${usercenterdomain}/ubill/index">电子账单</a></dd>
		                    <dd><a href="${usercenterdomain}/ubill/manual">手工账单</a></dd>
		                </dl>
		          </li>
		          <li class="subNav"><a href="javascript:void(0);">积分商城</a>
		          		<dl>
		                	<dd><a href="${usercenterdomain}/umall/index">积分兑换</a></dd>
		                    <dd><a href="${usercenterdomain}/umall/exchangerecord">兑换记录</a></dd>
		                </dl>
		          </li>
		          <li><a href="${usercenterdomain}/ucoupon/index">优惠凭证</a></li>
		          <li><a href="${usercenterdomain}/ufavorite/index">我的收藏</a></li>
		          <li class="subNav"><a href="javascript:void(0);">商品管理</a>
		          		<dl>
		                	<dd><a href="${usercenterdomain}/ushoppinglist/index">购物清单</a></dd>
		                    <dd><a href="${usercenterdomain}/ushoppinglist/purchased">已购商品</a></dd>
		                </dl>
		          </li>
	          </ul>
		</div>
	</div>
</div>
