<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/topBottom.css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/poup.css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/normalCheck.js"></script>
<!-- 表单校验 -->
<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate-extend.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath }/gus/shop/js/shop_cardReturn.js"></script>
<body class="snow_bg"  STYLE='OVERFLOW:SCROLL;OVERFLOW-Y:HIDDEN;OVERFLOW-X:HIDDEN'>
<input type="hidden" name="basePath" value="${basePath }"/>
<input type="hidden" name="imgPath" value="${imgPath }"/>
<div class="choice_goods">
	<form id="form"  name="form" >
    <input type="hidden" value="${shopId}" name="shopId"/>
    <input type="hidden" value="${shopName}" name="shopName"/>
	<div class="new_product_add">
    	<label>物理卡号：</label><br/>
            <input style="width:250px"  name="cardId" maxlength="32"/>&nbsp&nbsp<br/>
        <label>身份证号：</label><br/>
            <input style="width:250px"  name="idNo" maxlength="18"/>&nbsp&nbsp<br/>
    	<label>手机号码：</label><br/>
            <input style="width:250px"  name="mobile" maxlength="11"/>&nbsp&nbsp
    </div>
    <div class="control">
    	<input type="submit" class="btn"  style="margin-left:-200px" value="确定">
    </div>
     </form>
</div>
</body>
