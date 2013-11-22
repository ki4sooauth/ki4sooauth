<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>账单管理</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/accumulate_point_shop.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/Bill2.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/common/jquery-ui/datepicker/style/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.datepicker.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/gus/bill/js/bill.js"></script>
<script type="text/javascript" src="${imgPath}/gus/bill/js/star.js"></script>
<script type="text/javascript" src="${imgPath}/gus/bill/js/showbill.js"></script>
<script type="text/javascript" src="${imgPath}/gus/bill/js/billFunction.js"></script>
</head>
<body>
<!--头部-->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<input type="hidden" name="imgPath" value="${imgPath }"/>
<input type="hidden" name="basePath" value="${basePath }"/>
<input type="hidden" id="currentTime" value="${currentTime }"/>
<!--内容-->
<div class="container" style="overflow:visible;">
    <div class="article">
      <h1>电子账单</h1>
         <div class="acc_point_content bill_content">
            <span id="productCont1" class="test">
             <div class="selectList selectList_1">
               <div class="select_box">
                    <p id="shopTypeNamef">类别</p>
                    <input type="hidden" id="shopTypeSelect" value=""/>
                    <dl id="shopType">
                    </dl>
               </div>
               <div class="select_box">
                    <p id="shopNamef">商家名称</p>
                    <input type="hidden" id="shopInfoSelect" value="${shopId}"/>
                    <dl id="shopInfo">
                    </dl>
               </div>
               <input type="text" id="startDate" readonly="readonly" class="date" value="${billStart}"/>
               <input type="text" id="endDate" readonly="readonly" class="date" value="${billEnd}"/>
               <span class="Billsearch">
                 <input type="text" id="keyword" class="searchInput"/>
                 <a href="javascript:doSelect(1)" class="SearchBtn"></a>
               </span>
             </div>
             <span id="showPic"></span>
           	<ul id="eleBillShow" class="bill-business"></ul>
           </span>
         </div>
          <div class="clear"></div>
    </div>
</div>
<!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"/>
</body>
</html>