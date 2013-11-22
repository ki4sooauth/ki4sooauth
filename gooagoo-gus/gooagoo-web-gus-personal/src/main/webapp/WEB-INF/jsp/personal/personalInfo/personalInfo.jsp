<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
	<input type="hidden" name="imgPath" value="${imgPath}"/>
	<input type="hidden" name="basePath" value="${basePath}"/>
<script type="text/javascript">
	$(document).ready(function(){
		getProvince();
	});
</script>
      <input type="hidden" name="currentTime" value="${currentTime}"/>
      <div class="pim_wrap">
			<form id="signupForm" name="signupForm" method="post" action="">
                <input type="hidden" name="proId" id="proId" value="${pvalue}"/>
                <input type="hidden" name="cityId" id="cityId" value="${cvalue}"/>
                <input type="hidden" name="areaId" id="areaId" value="${avalue}"/>
                <input type="hidden" name="itype" id="itype" value="${loginuserkey.personalProfile.idType}"/>
                <input type="hidden" name="arId" id="arId" value="${loginuserkey.personalProfile.area}"/>
                <input type="hidden" id="pId" name="pId" value="${loginuserkey.personalProfile.province}"/>
                <input type="hidden" id="cId" name="cId" value="${loginuserkey.personalProfile.city}"/>
                <input type="hidden" id="headPic" name="headPic" value="${loginuserkey.personalProfile.headPic}"/>
            	<p class="title"><strong>个人信息</strong><span>（亲爱的用户，完善您的信息，将享受到更全面的商家服务）</span></p>
                <ul>
                    <li><strong>真实姓名：</strong><input type="text" id="realName" maxlength="20" name="realName" value="${loginuserkey.personalProfile.realName}"/></li>
                    
                    <li class="friend_sex"><strong>性&nbsp;&nbsp;别：</strong>
                    	<c:choose>
                    		<c:when test="${loginuserkey.personalProfile.sex eq 'M'}">
		                        <input type="radio" name="sex" checked="checked" value="M"/><span>男</span>
		                        <input type="radio" name="sex" value="F"/><span>女</span>
                    			<input type="radio" name="sex" value=""/><span>保密</span>
                    		</c:when>
                    		<c:when test="${loginuserkey.personalProfile.sex eq 'F'}">
								<input type="radio" name="sex" value="M"/><span>男</span>
								<input type="radio" name="sex" checked="checked" value="F"/><span>女</span>
                    			<input type="radio" name="sex" value=""/><span>保密</span>
                    		</c:when>
                    		<c:otherwise>
                    			<input type="radio" name="sex" value="M"/><span>男</span>
								<input type="radio" name="sex" value="F"/><span>女</span>
								<input type="radio" name="sex" checked="checked" value=""/><span>保密</span>
                    		</c:otherwise>
                    	</c:choose>
                    	<span class="red_span"></span>
                    </li>
                    <li><strong>出生年月：</strong><input style="background:url(${imgPath}/gus/common/images/date_bg.png) no-repeat right center;width:150px;" name="birthday" maxlength="10" readonly="readonly" id="birthday" type="text" class="date" value="<fmt:formatDate value="${loginuserkey.personalProfile.birthday}" pattern="yyyy-MM-dd" />"/>
                    <span class="red_span"></span><p id="birthdayMessage" style="display:none"></p></li>
                    <li class="address">
                    	<strong>证件类型：</strong>
                    	<div class="select_box" >
                        	<img src="${imgPath}/gus/common/images/select_btn.png" />
                       		<input type="hidden" id="idType" name="idType" value=""/>
                        	<p id="t"></p>
                            <dl id="idype" style="width: 157px">
                            	<dd><a href="javascript: void(0);" onclick="idtype('')">--请选择--</a></dd>
                            	<dd><a href="javascript: void(0);" onclick="idtype('00')">身份证</a></dd>
                            	<dd><a href="javascript: void(0);" onclick="idtype('01')">护照</a></dd>
                            	<dd><a href="javascript: void(0);" onclick="idtype('02')">军官证</a></dd>
                            	<dd><a href="javascript: void(0);" onclick="idtype('03')">其它</a></dd>
                            </dl>
                        </div>
                    </li>
                    <li><strong>证件号码：</strong><input type="text" onblur="onb()" maxlength="30" id="idNo" name="idNo" value="${loginuserkey.personalProfile.idNo}"/></li>
                    <li><strong>联系号码：</strong><input type="text" maxlength="18" id="telephone" name="telephone" value="${loginuserkey.personalProfile.telephone}"/></li>
                    <li class="address">
                    	<strong>所在地区：</strong>
                        <div class="select_box">
                        	<img src="${imgPath}/gus/common/images/select_btn.png" />
	                        <input type="hidden" id="province" name="province" value="${loginuserkey.personalProfile.province}"/>
                        	<p id="p"></p>
                            <dl id="pro" class="city">
<!--                             	<dd><a href="javascript: void(0);" onclick="pp()">--请选择--</a></dd> -->
<%--                             	<c:forEach var="province" items="${provincelist}"> --%>
<%--                             		<dd><a href="javascript: void(0);" onclick="Cityaaa('${province.cityId}')">${province.cityName}</a></dd> --%>
<%--                             	</c:forEach> --%>
                            </dl>
                        </div><span>省</span>
                        <div class="select_box">
                        	<img src="${imgPath}/gus/common/images/select_btn.png" />
                        	<input type="hidden" id="city" name="city" value="${loginuserkey.personalProfile.city}"/>
                        	<p id="c">
                        	</p>
                        	<dl id="cityvalue" class="city" >
                            </dl>
                        </div><span>市</span>
                        <div class="select_box" >
                        	<img src="${imgPath}/gus/common/images/select_btn.png" />
                       		<input type="hidden" id="area" name="area" value="${loginuserkey.personalProfile.area}"/>
                        	<p id="a">
                        	</p>
                            <dl id="areavalue" class="city">
                            </dl>
                        </div>
                        <span>区</span>
                    <span class="red_span"></span>
                    </li>
                    <li class="street"><strong>详细地址：</strong><input type="text" maxlength="100" id="address" name="address" value="${loginuserkey.personalProfile.address}"/></li>
                    <li class="postal_num"><strong>邮政编码：</strong><input type="text" id="postCode" maxlength="6"  style="ime-mode:disabled;" onpaste="javascript: return false;" onkeyup="javascript: return ValidateNumber(this,value);" onblur="javascript: return ValidateNumber(this,value);" name="postCode" value="${loginuserkey.personalProfile.postCode}"/></li>
                    <li class="friend_sex"><strong style="width:160px">允许别人加自己为逛伴：</strong>
                    	<c:choose>
                    		<c:when test="${loginuserkey.personalProfile.isAllowFriend eq 'Y'}">
		                        <input type="radio" id="isAllowFriend" name="isAllowFriend"checked="checked" value="Y"/><span>是</span>
							<input type="radio" id="isAllowFriend" name="isAllowFriend" value="N"/><span>否</span>
                    		</c:when>
                    		<c:when test="${loginuserkey.personalProfile.isAllowFriend eq 'N'}">
								<input type="radio" id="isAllowFriend" name="isAllowFriend" value="Y"/><span>是</span>
							<input type="radio" id="isAllowFriend" name="isAllowFriend" checked="checked" value="N"/><span>否</span>
                    		</c:when>
                    		<c:otherwise>
                    			<input type="radio" id="isAllowFriend" name="isAllowFriend"checked="checked" value="Y"/><span>是</span>
								<input type="radio" id="isAllowFriend" name="isAllowFriend" value="N"/><span>否</span>
                    		</c:otherwise>
                    	</c:choose>
                    </li>
                </ul>
                <div class="verification_box">
                	<strong>验证码：</strong>
                		<input type="text" id="verifyCode" name="verifyCode" style="ime-mode:disabled;" onpaste="javascript: return false;" maxlength="4" class="loginInputRondom"/>
             			<img id="verifyCodeImg" src="${basePath }/verifyCodeAction.do?method=image"/><a href="javascript:verifyCode()" id="ch" class="Rondom">换一张</a>
                </div>
                <div class="submit_btn">
                	<a class="loginBtnA btn" href="javascript:void(0);" id="subok">提&nbsp;交</a>
                </div>
                </form>
            </div>