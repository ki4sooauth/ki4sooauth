<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
	<input type="hidden" name="isSuccess" value="true"/>
	<input type="hidden" name="message" value="aa"/>
		<div class="bindingSuccess">
                	<P class="title">设置密保</P>
                    <div class="content">
                    	<span class="red">解除密保设置成功！</span>目前是无密保状态，存在安全隐患。<br />
						<span>建议您<a href="javascript:void(0);" onclick="account()">返回账户安全</a>查看安全评分。</span>
                    </div>
                </div>
                <div class="tip">
                	<span class="title">密保卡停止绑定的影响</span>
                    <p class="content">
                    	第一种情况：您没有使用密保卡。那么密保卡下线对您不会产生任何影响。<br />
						第二种情况：您正打算开始使用密保卡。 您可以选择XXXX来代替。<br />
						第三种情况：您正在使用密保卡。您仍可以继续使用，但为了您的帐号安全，推荐您删除密保卡，使用新型密保。
                    </p>
                </div>