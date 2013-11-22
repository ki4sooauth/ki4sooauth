<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>兑换记录</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/changeRecord.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/common/jquery-ui/datepicker/style/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.datepicker.min.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/gus/mall/js/exchange-record-index.js"></script>
</head>
<body>
<!--头部-->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!--内容-->
<input type="hidden" name="imgPath" value="${imgPath}" />
<input type="hidden" name="basePath" value="${basePath}" />
<input type="hidden" name="currentTime" value="${currentTime}" />
<div class="container">
	<div class="article">
		<h1>兑换记录</h1>
	<div>
	</div>
		<div class="changeRecord">
			<div class="selectList">
				<div class="select_box">
					<p>商家类型</p>
                    <dl id="shoptypelist"></dl>
               	</div>
               	<div class="select_box">
                	<p>商家名称</p>
                    <dl id="shoplist"></dl>
               	</div>
				<input style="background:url(${imgPath}/gus/common/images/date_bg.png) no-repeat right center;width:150px;" id="startDate" name="startDate"  maxlength="10" readonly="readonly"  type="text" class="date" />
               	<span class="red_span"></span><p id="dateMessage" style="display:none"></p>
               	<input style="background:url(${imgPath}/gus/common/images/date_bg.png) no-repeat right center;width:150px;" id="endDate" name="endDate"  maxlength="10" readonly="readonly"  type="text" class="date" />
               	<span class="red_span"></span><p id="date2Message" style="display:none"></p>
         		<span class="selectRight">
	            	<div class="select_box"> 
		               	<p id="type">商品</p> 
		                <dl> 
		                    <dd><a href="javascript: void(0);" onclick="javascript: doSelectType('G', '商品');">商品</a></dd>
		                    <dd><a href="javascript: void(0);" onclick="javascript: doSelectType('C', '优惠凭证');">优惠凭证</a></dd> 
		                </dl>
	           		</div> 
          		</span>
			</div>
			<ul id="recordProduct" class="recordProduct"></ul>
			<div class="ClickShow" style="display: none;">
				<a href="javascript: void(0);" class="ClickShowA" onclick="javascript: loadMoreConvertThingRequest();">查看更多内容</a>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
<!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>
</html>