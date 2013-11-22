<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<input type="hidden" name="imgPath" value="${imgPath}" />
<input type="hidden" name="basePath" value="${basePath}" />
<form class="registerform" action="" name="passwordForm" id="passwordForm" method="post">
	<div class="changePW">
		<p class="title">修改密码</p>
		<ul class="PW">
			<li><span>当前密码：</span>
				<input type="password" value="" id="oldPassword" name="oldPassword" class="pwInput" maxlength="32"/>
				<span id="oldMessage"></span>
			</li>
			<li><span>新 密 码：</span> 
				<input type="password" value="" id="newPassword" onkeyup="testPassword()" name="newPassword" class="pwInput" maxlength="32"/><br />
				<samp>安全强度</samp><img id="strong" src="${imgPath}/gms/shopinfo/images/Account/niu.jpg" width="0" height="3.8" /> 
				<b id="stDes"></b>
			</li>
			<li><span>确认密码：</span> 
				<input type="password" value=""	id="newPasswordRe" name="newPasswordRe" class="pwInput" maxlength="32"/>
				<span id="reMessage"></span></li>
		</ul>
		<div class="PwButton">
			<a href="javascript:changePassword();" class="Button btn">提 交</a>
		</div>
	</div>
</form>
