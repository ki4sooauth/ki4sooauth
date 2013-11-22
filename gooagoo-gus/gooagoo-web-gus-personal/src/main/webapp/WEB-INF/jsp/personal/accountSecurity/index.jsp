<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
	<div class="bindingSuccess">
                	<P class="title">账户安全</P>
                    <div class="secureSet">
                    <div class="levelBox">
                    	<c:choose>
                    		<c:when test="${num >= 150}">
		                    	<div class="lvImg" style="background:url(${imgPath }/gus/common/images/5.png);"><fmt:formatNumber value="${num/200}" type="percent"/></div>
		                        <div class="lvTip">
		                        	<p class="point">账户安全评分：<span class="red">${num}</span></p>
		                            <p>恭喜您！账户安全防护等级很高，请放心使用。</p>
		                        </div>
                    		</c:when>
                    		<c:when test="${num >= 100}">
		                    	<div class="lvImg" style="background:url(${imgPath }/gus/common/images/4.png);"><fmt:formatNumber value="${num/200}" type="percent"/></div>
		                        <div class="lvTip">
		                        	<p class="point">账户安全评分：<span class="red">${num}</span></p>
		                            <p>恭喜您！账户安全防护等级高，请放心使用。</p>
		                        </div>
                    		</c:when>
                    		<c:when test="${num >= 70}">
		                    	<div class="lvImg" style="background:url(${imgPath }/gus/common/images/3.png);"><fmt:formatNumber value="${num/200}" type="percent"/></div>
		                        <div class="lvTip">
		                        	<p class="point">账户安全评分：<span class="red">${num}</span></p>
		                            <p>账户安全防护等级中。</p>
		                        </div>
                    		</c:when>
                    		<c:when test="${num > 30}">
		                    	<div class="lvImg" style="background:url(${imgPath }/gus/common/images/2.png);"><fmt:formatNumber value="${num/200}" type="percent"/></div>
		                        <div class="lvTip">
		                        	<p class="point">账户安全评分：<span class="red">${num}</span></p>
		                            <p>注意啦！账户安全防护等级低。</p>
		                        </div>
                    		</c:when>
                    		<c:otherwise>
                    			<div class="lvImg" style="background:url(${imgPath }/gus/common/images/1.png);"><fmt:formatNumber value="${num/200}" type="percent"/></div>
		                        <div class="lvTip">
		                        	<p class="point">账户安全评分：<span class="red">${num}</span></p>
		                            <p><span class="red">注意啦！账户安全防护等级很低。可能存在安全风险！</span></p>
	                        	</div>
                    		</c:otherwise>
                    	</c:choose>
                    </div>
						<ul class="setList">
                        	<li>
                        		<c:if test="${loginuserkey.personalInfo.account!=null && loginuserkey.personalInfo.account!=''}">
	                            	<span class="setBtn">已设置+10</span>
	                            	<strong><i class="dg"></i>设置用户名</strong>
	                                <span class="optionName">你设置的用户名： ${loginuserkey.personalInfo.account}</span>
                        		</c:if>
                        		<c:if test="${loginuserkey.personalInfo.account==null || loginuserkey.personalInfo.account==''}">
                        			<span class="setBtn setBtnRed"><a href="javascript:void(0);" onclick="setAccount()">设置</a>+10</span>
	                            	<strong><i></i>设置用户名</strong>
	                                <span class="optionName">用户名一经设定，不可更改。</span>
                        		</c:if>
                            </li>
                            <li>
                            	<c:if test="${isfalse eq 'false'}">
	                            	<span class="setBtn setBtnRed"><a href="javascript:void(0);" onclick="getPersoanl()">立即完善</a>+10</span>
	                                <strong><i></i>完善信息</strong>
	                                <span class="optionName">如需修改，<a href="javascript:void(0);" onclick="getPersoanl()">单击此处</a></span>
                            	</c:if>
                            	<c:if test="${istrue eq 'true'}">
	                            	<span class="setBtn"><a href="javascript:void(0);" onclick="getPersoanl()">已完善</a>+10</span>
	                                <strong><i class="dg"></i>完善信息</strong>
	                                <span class="optionName">如需修改，<a href="javascript:void(0);" onclick="getPersoanl()">单击此处</a></span>
                            	</c:if>
                            </li>
                            <li>
                            	<c:choose>
                        			<c:when test="${email!=null && mobile!=null }">
                        				<span class="setBtn"><a href="javascript:void(0);" onclick="getEmail()">修改</a>+20</span>
		                                <strong><i class="dg"></i>邮箱绑定</strong>
		                                <span class="optionName">您验证的邮箱： ${email }</span>
                        			</c:when>
                        			<c:when test="${email==null && mobile!=null}">
                        				<span class="setBtn setBtnRed"><a href="javascript:void(0);" onclick="getEmail()">立即绑定</a>+20</span>
                                		<strong><i></i>邮箱绑定</strong>
                                		<span class="optionName">验证后，可用于快速找回登录密码</span>
                        			</c:when>
                        			<c:otherwise>
                        				<span class="setBtn"></span>
                        				<strong><i class="dg"></i>邮箱绑定</strong>
                                		<span class="optionName">您验证的邮箱： ${email }</span>
                        			</c:otherwise>
                        		</c:choose>
                            </li>
                            <li>
                            	<c:choose>
                        			<c:when test="${email!=null  && mobile==null}">
		                        		<span class="setBtn setBtnRed"><a href="javascript:void(0);" onclick="getMobile()">立即绑定</a>+30</span>
		                            	<strong><i></i>手机绑定</strong>
		                                <span class="optionName">验证后，可用于快速找回登录密码</span>
                        			</c:when>
                        			<c:when test="${email!=null && mobile!=null}">
                        				<span class="setBtn"><a href="javascript:void(0);" onclick="getMobile()">修改</a>+30</span>
		                            	<strong><i class="dg"></i>手机绑定</strong>
		                                <span class="optionName">您的验证手机：${mobile}</span>
                        			</c:when>
                        			<c:otherwise>
                        				<span class="setBtn"></span>
                        				<strong><i class="dg"></i>手机绑定</strong>
		                                <span class="optionName">您的验证手机：${mobile}</span>
                        			</c:otherwise>
                        		</c:choose>
                            </li>
                            <li>
                            	<c:choose>
                            		<c:when test="${data != null && fn:length(data) > 0 }">
		                            	<c:forEach items="${data}" var="d">
			                            	<span class="setBtn"><a href="javascript:void(0);" onclick="updSecurityQuestion('${d.id}')">修改</a><a href="javascript:void(0);" onclick="delSecurityQuestion('${d.id}')">解除绑定</a>+50</span>
			                            	<strong><i class="dg"></i>设置密保</strong>
			                                <span class="optionName">您的密保问题：${d.content}</span>
		                            	</c:forEach>
                            		</c:when>
                            		<c:otherwise>
                            			<span class="setBtn setBtnRed"><a href="javascript:void(0);" onclick="getSecurityQuestion()">立即设置</a>+50</span>
		                            	<strong><i></i>设置密保</strong>
		                                <span class="optionName">互联网账号存在被盗风险，建议您设置密保以保护账户安全。</span>
                            		</c:otherwise>
                            	</c:choose>
                            </li>
                            <li class="last">
                            	<c:choose>
                            		<c:when test="${serialNum != null && fn:length(serialNum) > 0 }">
                            			<span class="setBtn"><a href="javascript:void(0);" onclick="delSecurityCard()">解除绑定</a>+80</span>
		                            	<strong><i class="dg"></i>绑定密保卡</strong>
		                                <span class="optionName">密保卡序列号：${serialNum}</span>
                            		</c:when>
                            		<c:otherwise>
                            			<span class="setBtn setBtnRed"><a href="javascript:void(0);" onclick="show()">绑定</a>+80</span>
                            			<span class="setBtn setBtnRed"><a href="${basePath }/securityCard.do?method=index">下载</a></span>
		                            	<strong><i></i>绑定密保卡</strong>
		                                <span class="optionName">设置后，账户更加安全</span>
                            		</c:otherwise>
                            	</c:choose>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="tip">
                	<span class="title">安全服务提示</span>
                    <p class="content">
						1.确认您登录的是购阿购网址<a href="#" class="mailAddress">${usercenterdomain}</a>，注意防范进入钓鱼网站，不要轻信各种即时通讯工具发送的商品或支付链接，谨防网购诈骗。<br />
						2.建议您安装杀毒软件，并定期更新操作系统等软件补丁，确保账户及交易安全。
                    </p>
                </div>
