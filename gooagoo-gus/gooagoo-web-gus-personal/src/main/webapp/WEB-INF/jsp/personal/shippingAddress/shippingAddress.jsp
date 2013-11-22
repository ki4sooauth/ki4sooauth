<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人信息收货地址</title>
</head>
<body>
<div class="addressBox">
	<p class="title">已保存的有效地址</p>
    <div class="addressTable" id="addressList"></div>
</div>
<div class="newAddressBox">
<form id="addAddressForm" name="addAddressForm" method="post" action="">
<input type="hidden" name="imgPath" value="${imgPath}" />
<input type="hidden" name="basePath" value="${basePath}" />
<input type="hidden" id="province" name="province" value=""/>
<div id="updateDiv"></div>
		<p class="title">收货地址</p>
        <div class="writeBox">
           	<ul class="userInformation">
               	  <li class="txtInput"><strong>收货人姓名：</strong><input type="text" id="consigneeName" name="consigneeName" maxlength="20" /><b>*</b></li>
                  <li>
	                   	<strong>所在地区：</strong>
	                   	<select name="province" id="provinceId" onchange="javascript: provinceChoose();">
	                   		<option value="" >--请选择省--</option>
                           	<c:forEach var="province" items="${provincelist}">
                           		<option value="${province.provinceId}">${province.provinceName}</option>
                           	</c:forEach>
	                   	</select>
                        <select name="city" id="cityId" onchange="javascript: cityChoose();">
                        	<option>--请选择市--</option>
                        </select>
                        <select name="area" id="areaId" onchange="javascript: city();">
                        	<option>--请选择区/县--</option>
                        </select>
	                    <b>*</b>   
                   </li>
                   <li class="street"><strong>详细地址：</strong>
                   		<textarea id="address" name="address" maxlength="100" ></textarea>
                   <span><b>*</b>需要重复填写省/市/区</span></li>
                   <li class="txtInput"><strong>邮政编码：</strong>
                   		<input type="text" id="postCode" name="postCode" maxlength="6"  style="ime-mode:disabled;" onkeyup="javascript: return ValidateNumbers(this,value);" onblur="javascript: return ValidateNumbers(this,value);" /><span><b>*</b>大陆以外地区可不填写</span></li>
                   <li class="txtInput"><strong>手机号码：</strong>
                   		<input type="text" id="phone" name="phone" maxlength="11" /><span><b>*</b> 电话号码、手机号码必填一项，优先选用手机号</span></li>
                   <li class="phoneNum"><strong>电话号码：</strong>
                   		<input type="text" id="telephone1" name="telephone1" maxlength="4" />
                   <samp>-</samp><input type="text" id="telephone2" name="telephone2" class="middle" maxlength="8" />
                   <samp>-</samp><input type="text" id="telephone3" name="telephone3" maxlength="4"/>
                   <span><b>*</b>区号-电话号码-分机</span></li>
                   <li class="defaultCheck"><strong>设为默认：</strong>
                   		<input type="checkbox" onclick="setAddress()" id="isDefault1" name="isDefault1" />
                   		<input type="hidden" value="N" id="isDefault" name="isDefault" />
                   </li>
               </ul>
               <a href="javascript:ensure();" class="confirmBtn">确定</a>
       </div>
</form>
</div>
</body>
</html>
