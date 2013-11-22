<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<input type="hidden" name="isSuccess" value="true"/>
<input type="hidden" name="message" value="aa"/>
		<div class="bindingSuccess">
              <P class="title">设置密保</P>
              <div class="content">
                <span class="red">设置成功</span><br />
				<span>您可<a href="javascript:void(0);" onclick="account()">返回账户安全</a>查看安全评分。</span>
              </div>
        </div>
       <div class="tip">
             <span class="title">为什么要设置密保？</span>
             <p class="content">
                1. 为保障您的账户信息安全，方便您在忘记密码时通过密保找回，感谢您的理解和支持。<br />
				2. 验证身份遇到问题？请发送用户名、手机号、历史订单发票至<a href="#" class="mailAddress">gooagoo@gmail.com</a>，客服将尽快联系您。新型密保。
             </p>
       </div>