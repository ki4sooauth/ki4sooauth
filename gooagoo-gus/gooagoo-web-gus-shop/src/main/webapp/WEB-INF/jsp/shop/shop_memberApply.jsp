<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/topBottom.css" />
<link rel="stylesheet" type="text/css" href="${imgPath}/gus/common/css/MyBusiness_poup.css" />
<link href="${imgPath}/common/jquery-ui/datepicker/style/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.datepicker.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath }/gus/shop/js/shop_memberapply.js"></script>
<body class="snow_bg"  STYLE='OVERFLOW:SCROLL;OVERFLOW-Y:HIDDEN;OVERFLOW-X:HIDDEN'>
<input type="hidden" name="basePath" value="${basePath }"/>
<input type="hidden" name="imgPath" value="${imgPath }"/>
<div class="club_card_pop">
<form id="form" name="form">
		<input type="hidden" name="currentTime" value="${currentTime}"/>
	    <input  name="shopId" value="${shopId}" type="hidden"/>
	    <input  name="shopName" value="${shopName}" type="hidden"/>
		<ul>
	    	<li class="fst">
	        	    <label>姓&#12288;名：</label><input type="text"  name="name" maxlength="10">
	        </li>
	        
	        <li class="sec">
	                <label>手机号码：</label><input type="text" name="mobile"  style="ime-mode:disabled;" onpaste="javascript: return false;" onkeyup="javascript: return ValidateNumber(this,value);" onblur="javascript: return ValidateNumber(this,value);" maxlength="11"> 
	        </li>
	        
	        <li class="sec">
	        	    <label>身份证号：</label><input class="mail_num" onblur="changeSexandBri()" type="text" name="idNo" maxlength="18">
	        </li>
	        
	        <li class="sec">
	        	    <label>性别：</label>
		            <div class="sexSelect">
			            <input type="radio" name="sex"  value="M" />男
			            <input type="radio"  name="sex"  value="F"/>女
		            </div>
	        </li>
	        
	        <li class="sec">
	                <label>出生日期：</label><input class="date" type="text"  id="startDate" name="birthday" readonly="true">
	        </li>
	        
	        <li>
	        	   <label>通讯地址：</label><input class="addr" type="text" name="address" style="width:300px" maxlength="32">
	        </li>
	        
	        <li class="last_li" style="width:580px">
	        	   <input class="btn" type="submit" value="提交" style="cursor:pointer;float:none;margin:0 auto;display:block;text-indent:0px;" />
	        </li>
    </ul>
</form>
<div class="clear"></div>
</div>
</body>
