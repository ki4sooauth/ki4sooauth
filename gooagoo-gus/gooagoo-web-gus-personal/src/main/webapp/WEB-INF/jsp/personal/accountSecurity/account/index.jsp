<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath }/gus/personal/js/account/account.js"></script>
	<form action="" name="accountForm" id="accountForm" method="post">
		<div class="bindingSuccess">
            <P class="title">设置用户名</P>
            <div class="content">
				设置用户名:<input class="userName" maxlength="20" name="account" id="account" type="text" />
                 <span id="yanz"><br /></span>
              	<span class="red2">*</span><span>用户名一经设定，不可更改。</span><br />
			<br />
			<br />
             <div class="centerD">
             	<a class="confirm" href="javascript:void(0);" id="acc">提交</a>
              </div>
          </div>
   		</div>
        <div class="tip">
              <span class="title">为什么要设置用户名？</span>
              <p class="content">
                  1. 为保障您的账户信息安全，方便您在忘记密码时通过密保找回，感谢您的理解和支持。<br />
				2. 验证身份遇到问题？请发送用户名、手机号、历史订单发票至<a href="#" class="mailAddress">gooagoo@gmail.com</a>，客服将尽快联系您。新型密保。
              </p>
        </div>
    </form>
