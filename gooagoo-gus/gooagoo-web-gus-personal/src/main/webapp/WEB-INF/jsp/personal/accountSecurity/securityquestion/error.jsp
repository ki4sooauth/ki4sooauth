<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath }/gus/personal/js/securityQuestion/securityQuestion.js"></script>
<input type="hidden" name="eSuccess" value="false"/>
<input type="hidden" name="mess" value="aaa"/>
		<form action="" name="passwordForm" id="passwordForm" method="post">
			<input type="hidden" name="type" value="${type}"/>
			<input type="hidden" name="id" value="${id}"/>
			<input type="hidden" name="sysId" value="${sysId}"/>
			<input type="hidden" name="content" value="${content}"/>
			<input type="hidden" name="answer" value="${answer}"/>
			<div class="bindingSuccess">
	             <P class="title">设置密保</P>
	             <div class="content">
	                	密码验证：<input class="userName userNameFalse" name="password" maxlength="32" type="password" />
	                	<a class="confirm" href="javascript:void(0);" id="password">确认</a><br />
	                	<span style="padding-right:60px"></span><span id="ss"></span><br />
	                	<span class="red">*</span><span>密保问题采用静态密码，易引起安全风险，如果您不在常用地登录，可   能无法通过它修改密保因子。 </span>
	              </div>
	       </div>
       </form>
       <div class="tip">
             <span class="title">为什么要验证密码？</span>
             <p class="content">
                1. 为保障您的账户信息安全，方便您在忘记密码时通过密保找回，感谢您的理解和支持。<br />
				2. 验证身份遇到问题？请发送用户名、手机号、历史订单发票至<a href="#" class="mailAddress">gooagoo@gmail.com</a>，客服将尽快联系您。新型密保。
             </p>
       </div>