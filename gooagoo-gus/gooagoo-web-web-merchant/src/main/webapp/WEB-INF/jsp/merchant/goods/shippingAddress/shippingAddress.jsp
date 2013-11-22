<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>收货地址</title>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/newAddress.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/addNewAddress.js"></script>
<script type="text/javascript" src="${imgPath}/gus/merchant/web/js/merchant-shipping-address.js"></script>
</head>
<body>
<input type="hidden" name="imgPath" value="${imgPath}" />
<input type="hidden" name="basePath" value="${basePath}" />
	<div class="section" style="width:750px;padding:20px;">
		<div class="selectAddressBox">
			<p class="title">选择收货地址</p>
			<ul class="selectAddressList">
				<input type="hidden" name="consigee" value=""/>
				<c:choose>
					<c:when test="${isSuccess && data != null && fn:length(data) > 0 }">
						<c:forEach var="uConsigeeInfo" items="${data }">
							<li onclick="javascript: doSelectConsigee('${uConsigeeInfo.consigneeId }');">
				               	<p id="addre" class="name">${uConsigeeInfo.cityName }${uConsigeeInfo.areaName }&nbsp;（${uConsigeeInfo.consigneeName }&nbsp;收）</p>
				                <p id="tel" class="content"><c:choose><c:when test="${uConsigeeInfo.phone == null || uConsigeeInfo.phone == '' }">${uConsigeeInfo.telephone }</c:when><c:otherwise>${uConsigeeInfo.phone }</c:otherwise></c:choose></p>
				                <p id="addres" class="content">${uConsigeeInfo.address }</p>
				                <c:choose>
				                <c:when test="${uConsigeeInfo.isDefault == 'N' }">
				                <b></b>
				                </c:when>
				                <c:otherwise>
				                <b class="curr"></b>
				                </c:otherwise>
				                </c:choose>
			                </li>
			                </c:forEach>
						</c:when>
					<c:otherwise>
					<li class="empty">
						您还没有收货地址，请在下面新增收货地址，以完成兑换
	                </li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
		<form id="exchangeThing" action="">
        <div class="newAddressBtn">
        	<a href="javascript: void(0);" onclick="javascript: exchange();">兑换</a>
            <span>使用新地址</span>
        </div>
        </form>
		<div class="newAddressBox" style="display:none;">
			<form id="addAddressForm" name="addAddressForm" method="post" action="">
				<input type="hidden" name="shopIntegralId" value="${shopIntegralId }">
				<input type="hidden" name="shopId" value="${shopId }">
				<input type="hidden" name="integralTradeType" value="G">
				<c:choose>
					<c:when test="${isSuccess && data != null && fn:length(data) > 0 }">
							<c:forEach items="${data}" var="d">
								<c:if test="${d.isDefault == 'Y' }">
									<input type="hidden" name="consigneeId" value="${d.consigneeId }">
								</c:if>
							</c:forEach>
					</c:when>
					<c:otherwise>
						<input type="hidden" name="consigneeId" value="">
					</c:otherwise>
				</c:choose>
				<p class="title">新增收货地址</p>
	            <div class="writeBox">
	            	<ul class="userInformation">
	                	<li class="txtInput">
	                   		<strong>收货人姓名：</strong>
	                   		<input type="text" name="consigneeName" maxlength="20" /><b>*</b>
	                   	</li>
	                    <li>
	                       	<strong>所在地区：</strong>
	                    	<select name="province"></select>
		                    <select name="city">
		                    	<option>--请选择市 --</option>
		                    </select>
		                    <select name="area">
		                    	<option>--请选择区县--</option>
		                    </select>
		                    <b>*</b>   
	                     </li>
	                     <li>
	                     	<strong>详细地址：</strong>
	                        <textarea name="address" maxlength="50"></textarea><span><b>*</b>需要重复填写省/市/区</span>
	                     </li>
	                     <li class="txtInput">
	                     	<strong>邮政编码：</strong>
	                        <input type="text" name="postCode" maxlength="6" style="ime-mode:disabled;" onkeyup="javascript: return ValidateNumbers(this,value);" onblur="javascript: return ValidateNumbers(this,value);" />
	                        <span><b>*</b>大陆以外地区可不填写</span>
	                     </li>
	                     <li class="txtInput"><strong>手机号码：</strong>
	                     	<input type="text" name="phone" maxlength="11" />
	                        <span><b>*</b> 电话号码、手机号码必填一项，优先选用手机号</span>
	                     </li>
	                     <li class="phoneNum">
	                     	<input type="hidden" name="telephone" value=""/>
	                       	<strong>电话号码：</strong>
	                        	<input type="text" name="telephone1" maxlength="4" />
	                        <samp>-</samp>
	                        	<input type="text" name="telephone2" class="middle" maxlength="8" />
	                        <samp>-</samp>
	                        	<input type="text" name="telephone3" maxlength="4" />
	                        <span><b>*</b>区号-电话号码-分机</span>
	                     </li>
	                     <input type="hidden" name="isDefault" value="Y"/>
					</ul>
					<a href="javascript: ensure();" class="confirmBtn">确定</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>