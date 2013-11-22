<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>吆喝</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/common/css/topBottom.css" />
<link rel="stylesheet" type="text/css" href="${imgPath }/gus/common/css/home.css" />
<script type="text/javascript" src="${imgPath }/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath }/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath }/gus/cryout/js/cryout.js"></script>
<script type="text/javascript" src="${imgPath }/count/js/gc.js"></script>
</head>
<body>
<!--头部-->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!--内容-->
<input type="hidden" name="basePath" value="${basePath }" />
<input type="hidden" name="imgPath" value="${imgPath }" />
<form id="frmLoadCryout" action="">
<input type="hidden" name="loadType" value="" /> 
<input type="hidden" name="pageSize" value="" />
<input type="hidden" name="pageType" value="" />
<input type="hidden" name="pageId" value="" />
<div class="container">
	<div class="article">
		<h1><a href="${usercenterdomain}/ucryout/cryoutplaza"><strong>吆喝广场</strong></a><u class="arrowGif"></u>吆喝</h1>
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
			<div id="interestedshoplist"></div>
			<div id="10101" class="Advertising"></div>
	        <div id="10102" class="Advertising"></div>
	        <div id="10103" class="Advertising"></div>
		</div>
		<div class="section">
			<div class="banner_1">
				<a id="10201" style="display:block;" href="javascript: void(0);"></a>
				<a id="10202" href="javascript: void(0);"></a>
				<a id="10203" href="javascript: void(0);"></a>
			</div>
		</div>
		<div id="cryoutcount" class="moreYh"></div>
		<div id="cryoutlist" class="section"></div>
	</div>
</div>
</form>
<!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>
</html>