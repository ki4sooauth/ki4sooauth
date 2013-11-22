<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ page import="com.gooagoo.common.gms.utils.Head" %>
<div class="aside">
          <div class="brand">
            <div class="logo"><img src="${menu.headImg}" width="180" height="180"></div>
            <div class="welcomeUser" <c:if test="${accountType eq '0'}">style="height:130px;"</c:if><c:if test="${accountType eq '3'}">style="height:50px;"</c:if>>
              <p>
                 <span class="square2"></span>
                 <c:if test="${accountType eq '0'}">
	               <strong>账号：</strong><br/>${menu.account}<br/>
	               <strong>姓名：</strong>${menu.name}<br/>
	               <strong>积分：</strong>${menu.integral}<br/>
	               <strong>等级：</strong>${menu.memberLevel}
                 </c:if>
                 <c:if test="${accountType eq '7'}">
	               <strong>物理卡号：</strong>${menu.phyNo}<br/>
	               <strong>等级：</strong>${menu.memberLevel}<br/>
	               <strong>姓名：</strong>${menu.name}<br/>
	               <strong>邮箱：</strong>${menu.email}
                 </c:if>
                 <c:if test="${accountType eq '3'}">
	               <strong>mac地址：</strong>${menu.mac}<br>
                 </c:if>
                </p>
            </div>
          </div>
          <div class="fast_channel">
            <h2>快捷通道</h2>
            <ul class="enter">
              <a href="${basePath}cardApprove"><li class="First" onclick="window.location.href='${basePath}cardApprove'"><p>审批管理</p></li></a>
              <a href="${basePath}rule"><li class="Second" onclick="window.location.href='${basePath}rule'"><p>会员激励</p></li></a>
            </ul>
          </div>
        </div>