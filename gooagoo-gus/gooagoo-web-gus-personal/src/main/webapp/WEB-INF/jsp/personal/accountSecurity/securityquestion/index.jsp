<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath }/gus/personal/js/securityQuestion/setSecurityQuestion.js"></script>
<script>
$(document).ready(function(){
	$(".issueSet .radioBar li").click(function(){
		var i = $(".issueSet .radioBar li").index(this);
		$(this).removeClass("curr").siblings().addClass("curr");
		$(".issueSet .inputContent li").eq(i).removeClass("curr").siblings().addClass("curr");
		$(".issueSet .inputContent li").eq(i).find("input").removeAttr("disabled").end().siblings().find("input").attr("disabled",true);
		$(".issueSet .inputContent li").eq(i).find("select").removeAttr("disabled").end().siblings().find("select").attr("disabled",true);
		})
	})
</script>
	<input type="hidden" name="addSuccess" value="true"/>
	<input type="hidden" name="message" value="aa"/>
	<input type="hidden" name="id" value="" id="id"/>
	<form action="" name="pwdForm" id="pwdForm" method="post">
		<div class="bindingSuccess">
                	<P class="title">设置密保</P>
                    <div class="content">
                    	<span class="red">*</span>为了避免遗忘，请您填写真实信息，这将帮助您以后通过回答问题快速找回密码。
                        <div class="issueSet">
                        	<c:choose>
                            	<c:when test="${data != null && fn:length(data) > 0 }">
                            		<ul class="radioBar">
		                            	<li class="topLi"></li>
		                                <li class="curr"></li>
		                            </ul>
		                        </c:when>
		                        <c:otherwise>
		                        	<ul>
				                        <li class=""></li>
				                        <li class=""></li>
		                            </ul>
		                        </c:otherwise>
                            </c:choose>
                            <ul class="inputContent">
                            	<c:choose>
                            		<c:when test="${data != null && fn:length(data) > 0 }">
		                            	<li class="topLi">
		                                	<samp>系统问题:</samp><select name="scontent" id="content">
		                                		<c:forEach items="${data}" var="dd">
			                                    	<option value="${dd.sysId},${dd.content}">${dd.content}</option>
		                                		</c:forEach>
		                                    </select>
		                                    <p class="plineHight"></p>
		                                    <samp>答案:</samp><input name="answer" maxlength="100" type="text" id="sanswer"/>
		                                </li>
		                                <li class="curr">
		                                	<samp>自定义问题:</samp><input name="content" maxlength="100" disabled="disabled" type="text" /><p class="plineHight"></p>                          
		                                    <samp>答案:</samp><input name="answer" maxlength="100" disabled="disabled" type="text" />                            
		                                </li>
                            		</c:when>
                            		<c:otherwise>
		                                <li>
		                                	<samp>自定义问题:</samp><input name="content" maxlength="50" type="text" />
		                                	<p class="plineHight"></p>                          
		                                    <samp>答案:</samp><input name="answer" maxlength="50" type="text" />                            
		                                </li>
                            		</c:otherwise>
                            	</c:choose>
                            </ul>
                        </div>
                        <div class="centerD clear"><a class="confirm" href="javascript:setPwd();">确认</a></div>
                    </div> 
                </div>
                <div class="tip">
                	<span class="title">为什么要设置密保？</span>
                    <p class="content">
                    	1. 为保障您的账户信息安全，方便您在忘记密码时通过密保找回，感谢您的理解和支持。<br />
						2. 验证身份遇到问题？请发送用户名、手机号、历史订单发票至<a href="#" class="mailAddress">gooagoo@gmail.com</a>，客服将尽快联系您。新型密保。
                    </p>
                </div>
    </form>
