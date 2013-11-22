<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人信息管理</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/banding.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/accountSafety.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/pim.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/changePw.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/newAddress.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<link rel="stylesheet" href="${imgPath}/common/jcroup/css/jquery.Jcrop.css" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js"></script>
<script src="${imgPath}/common/jcroup/js/jquery.Jcrop.js"></script>
<script type="text/javascript" src="${imgPath }/gus/personal/js/phone/personal.js"></script>
<script type="text/javascript" src="${imgPath }/gus/personal/js/email/checkEmail.js"></script>
<script type="text/javascript" src="${imgPath }/gus/personal/js/phone/checkPhone.js"></script>
<link href="${imgPath}/common/jquery-ui/datepicker/style/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.datepicker.min.js"></script>
</head>
<body>
	<input type="hidden" name="imgPath" value="${imgPath}" />
	<input type="hidden" name="basePath" value="${basePath}" />
	<input type="hidden" id="activeCode" value="${activeCode}" />
	<input type="hidden" id="mobile" value="${mobile}" />
	<input type="hidden" name="headpic" value="${loginuserkey.personalProfile.headPic}" />
	<!--头部-->
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<!--内容-->
	<div class="container">
		<div class="article">
			<h1>个人信息管理</h1>
			<div class="aside">
				<div class="inform_2">
					<div class="name">
						<c:choose>
				            <c:when test="${!empty loginuserkey.personalInfo.account }">
			            		您好，<span>${loginuserkey.personalInfo.account }</span>
				            </c:when>
				            <c:otherwise>
							    	您还没有名字?<br /><a class="empty" href="${usercenterdomain}/upersonal/setAccount">现在就起&nbsp;》</a>
				            </c:otherwise>
			            </c:choose> 
				    </div>
				    <div class="headPic">
				    	<c:choose>
			   				<c:when test="${loginuserkey.personalProfile.headPic == null || loginuserkey.personalProfile.headPic == '' }">
			   					<img class="HeaderImg" width="110" height="110" src="${imgPath }/gus/common/images/userHeader.png" />
			   				</c:when>
			   				<c:otherwise>
								<img class="HeaderImg" width="110" height="110" src="${loginuserheadpic}" />
							</c:otherwise>
			  			</c:choose>
				    </div>
				    <div class="menu_2">
				    	<ul>
				        	<li><a href="javascript:void(0)" id="mess" onclick="getPersoanl();"><span>个人信息</span></a></li>
				            <li><a href="javascript:void(0)" onclick="uploadPic();"><span>修改头像</span></a></li>
				            <li><a href="javascript:void(0)" onclick="password();"><span>修改密码</span></a></li>
				            <li><a href="javascript:void(0)" onclick="account();" class="curr"><span>账户安全</span></a></li>
				            <li><a href="javascript:void(0)" onclick="getAddress();"><span>收货地址</span></a></li>
				        </ul>
				    </div>
				</div>
			</div>
				<div id="showPic"></div>
				<div class="section" id="personallist">
					<div class="BandingBox">
		            	<p class="title">手机绑定</p>
		                    <div class="mobile">
		                        <ul class="mobileInputBox">
		                            <li class="mailNum"><strong>手  机:</strong><span id="mobilePhone">${mobile}</span></li>
		                            <li class="mobileVerificationNum"><strong>短信验证码：</strong>
		                            	<input class="mailVer" maxlength="6" id="messageCode" name="messageCode" type="text" value="输入短信验证码" onfocus="if(this.value=='输入短信验证码'){this.value='';this.style.color='#000000'}" onblur="checkMobileCode()"  />
		                            	<a id="phoneYZM" href="javascript:void(0);">获取短信验证码</a>
		                            	<samp id="code"></samp>
		                            </li>
		                        </ul>
		                    <a href="javascript:void(0);" id="messCode" class="btn">下一步</a>
		                   </div>               
		            </div>
				</div>
		</div>
	</div>
	<!--底部-->
	<c:import url="${imgPath}/gus/common/html/footer.html"
		charEncoding="UTF-8"></c:import>
</body>
</html>
