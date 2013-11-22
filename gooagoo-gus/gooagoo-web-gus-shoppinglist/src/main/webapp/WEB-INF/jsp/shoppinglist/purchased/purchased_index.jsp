<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/accumulate_point_shop.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/common/jquery-ui/datepicker/style/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/gus/shoppinglist/js/purchased.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.datepicker.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>已购商品</title>
</head>
<body>
<input type="hidden" id="shopInfoSelect" value=""/>
<input type="hidden" id="shopTypeSelect" value=""/>
<input type="hidden" name="basePath" value="${basePath }"/>
<input type="hidden" name="imgPath" value="${imgPath }"/>
   <!--头部-->
   <%@ include file="/WEB-INF/jsp/common/header.jsp"%>
    <!--内容-->
  <div class="container">
  <input type="hidden" id="222" value="222"/>
  <input type="hidden" id="num" value=""/>
    <div class="article" >
    <div style="min-height:600px;">
            <h1>已购商品</h1>
        <div class="shoppingED_select">
         <div class="searchB"><input type="text" id="conent" class="search"/><span class="searchBg" onclick="loadGoods(true)"></span></div>
         <div class="select_box">
            <p id="shopTypeNamef">类别</p>
            <dl id="shopType"></dl>
          </div>
          <div class="select_box">
          	<p id="shopNamef">商家名称</p>
            <dl id="shopInfo"></dl>
          </div>
          <span class="caption_name"></span>
          <input type="text" id="startDate" readonly="readonly" class="dateBg" value="${start}"/>
          <input type="text" id="endDate" readonly="readonly" class="dateBg" value="${end}"/>
         </div>
         <div id="table" style="padding-top:20px;">
	    </div>
         <div class="clear"></div>
	    <div class="ClickShow" style="display: none;"><a href="javascript: void(0);" class="ClickShowA" onclick="javascript: loadComment(false);">查看更多内容</a></div>
  </div>
  </div>
  </div>
  <!--底部-->
 <c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>
</html>