<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<input type="hidden" name="success" value="true" />
<input type="hidden" name="m" value="aa" />
  			<div class="BandingBox">
            	<p class="title">手机绑定</p>
                    <div class="mobile">
                        <ul class="mobileInputBox">
                            <li class="mailNum"><strong>手  机:</strong><span id="mobilePhone">${mobile}</span></li>
                            <li class="mobileVerificationNum"><strong>短信验证码：</strong>
                            	<input class="mailVer" maxlength="6" id="messageCode" name="messageCode" type="text" value="输入短信验证码" onfocus="if(this.value=='输入短信验证码'){this.value='';this.style.color='#000000'}" onblur="checkMobileCode()"  />
                            	<a id="phoneYZ" href="javascript:void(0);">获取短信验证码</a>
                            	<samp id="code"></samp>
                            </li>
                        </ul>
                    <a href="javascript:void(0);" onclick="subMessageCode()" class="btn">下一步</a>
                    </div>               
            </div>
