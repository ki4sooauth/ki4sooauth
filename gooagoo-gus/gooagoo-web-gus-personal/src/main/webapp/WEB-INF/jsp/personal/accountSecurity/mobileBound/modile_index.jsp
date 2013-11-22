<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
	<input type="hidden" name="imgPath" value="${imgPath}" />
	<input type="hidden" name="basePath" value="${basePath}" />
	<input type="hidden" id="email" value="${loginuserkey.personalInfo.email}" />
  			<div class="BandingBox">
            	<p class="title">手机绑定</p>
                <div class="mobile">
                <ul class="mobileInputBox">
                	<li class="phoneNum"><strong>手&nbsp;机：</strong><input maxlength="11" type="text" name="phone" id="phone" onblur="cc()" value="输入需要绑定的手机" onfocus="if(this.value=='输入需要绑定的手机'){this.value='';this.style.color='#000000'}" /><samp id="message"></samp></li>
                    <li class="mailNum"><strong>已验证的邮箱:</strong><span>${email}</span></li>
                    <li class="verificationNum"><strong>验证码:</strong>
                    	<input type="text" id="verifyCode" onblur="checkCode()" name="verifyCode" style="ime-mode:disabled;" onpaste="javascript: return false;" maxlength="4" class="loginInputRondom"/>
             			<img id="verifyCodeImg" src="verifyCodeAction.do?method=image"/><a href="javascript:verifyCode()" id="ch" class="Rondom">换一张</a>
                    	<samp id="code"></samp>
                    </li>
                </ul>
                <a href="javascript:void(0)" id="goNext" class="btn">下一步</a>
                </div>
            </div>
