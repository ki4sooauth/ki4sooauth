<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
	<input type="hidden" name="imgPath" value="${imgPath}" />
	<input type="hidden" name="basePath" value="${basePath}" />
	<input type="hidden" id="telephone" value="${loginuserkey.personalInfo.mobile}" />
  			<div class="BandingBox">
            	<p class="title">邮箱绑定</p>
            	<form id="emailForm"  name="emailForm" action="" method="post">
                    <div class="mobile">
                        <ul class="mobileInputBox">
                        <li class="phoneNum"><strong>邮&nbsp;箱：</strong><input type="text" maxlength="50" id="emailName" name="emailName" value="输入需要绑定的邮箱" onblur="cc()" onfocus="if(this.value=='输入需要绑定的邮箱'){this.value='';this.style.color='#000000'}" /><samp id="message"></samp></li>
                            <li class="mailNum"><strong>已验证的手机号：</strong><span>${mobile}</span></li>
                            <li class="mobileVerificationNum"><strong>短信验证码：</strong>
                            	<input class="mailVer" maxlength="6" id="messageCode" name="messageCode" type="text" value="输入短信验证码" onfocus="if(this.value=='输入短信验证码'){this.value='';this.style.color='#000000'}" onblur="checkCode()"  />
                            	<a id="phoneYZ" href="javascript:void(0);">获取短信验证码</a>
                            	<samp id="code"></samp>
                            </li>
                        </ul>
                    	<a href="javascript:void(0);" id="goNext" class="btn">下一步</a>
                    </div>    
                 </form>           
            </div>
