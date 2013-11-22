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
<script type="text/javascript">
$(document).ready(function(){
	doPage(1);
}); 
</script>
</head>
<body>
<!--头部-->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<input type="hidden" name="imgPath" value="${imgPath }"/>
<input type="hidden" name="basePath" value="${basePath }"/>
<input type="hidden" id="currentTime" value="${currentTime }"/>
<!--内容-->
<div class="container">
    <div class="article">
      <h1>手工账单</h1>
         <div class="acc_point_content bill_content">
           <span id="productCont2">
           <div class="new_bill">
           <form action="" id="newMBill" name="newMBill">
            	<p class="title">新增账单</p>
                <ul>
                	<li>
	                    <span>单号：</span>
	                    <input type="text" id="newBillNo" name="billNo" maxlength="30"/>
	                    <span>类别：</span>
	                    <input type="text" id="newBillType" name="billType" maxlength="10"/>
	               		<span>金额：</span>
	                    <input type="text" id="newFee" name="fee" maxlength="11" onkeyup="validatePices(this);" onblur="validatePices(this);"/>
               		</li>
                	<li>
                    	<span>时间：</span>
                        <input class="date" type="text" name="requestTime" readonly="readonly" id="newBillTime"/>
                        <span>商家：</span>
                        <input type="text" id="newShopName" name="shopName" maxlength="30"/>
                    </li>
                    <li>
                        <span>备注：</span>
                        <input class="bz" type="text" name="note" maxlength="50"/>
                    </li>
                </ul>
                <p class="btn_box">
                	<a class="btn" href="javascript:addMBill()">提交</a><a class="btn" href="javascript:mreset()">重置</a>
                </p>
            </form>
            </div>
             <div class="bill-date">
               		账目清单
             </div>
             <div class="selectList">
               <input type="text" class="date" id="manumalDateStart" value="${billStart}"/>
               <input type="text" class="date" id="manumalDateEnd" value="${billEnd}"/>
             </div>
           <div class="manual_bill" id="manualBillShow"></div>
           <div class="Pagination" id="Pagination"></div>
          </span>
         </div>
          <div class="clear"></div>
    </div>
</div>
<!--底部-->
<c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"/>
</body>
</html>