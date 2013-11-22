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
<script type="text/javascript" src="${imgPath }/gus/personal/js/account/account.js"></script>
<script type="text/javascript" src="${imgPath }/gus/personal/js/email/checkEmail.js"></script>
<script type="text/javascript" src="${imgPath }/gus/personal/js/phone/checkPhone.js"></script>
<link href="${imgPath}/common/jquery-ui/datepicker/style/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.datepicker.min.js"></script>
</head>
<body>
	<input type="hidden" name="imgPath" value="${imgPath}" />
	<input type="hidden" name="basePath" value="${basePath}" />
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
				</div>
		</div>
	</div>
	<!--底部-->
	<c:import url="${imgPath}/gus/common/html/footer.html"
		charEncoding="UTF-8"></c:import>
</body>
</html>

