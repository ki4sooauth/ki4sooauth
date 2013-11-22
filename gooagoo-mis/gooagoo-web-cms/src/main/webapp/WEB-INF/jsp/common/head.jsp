<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<link type="text/css" rel="stylesheet" href="${imgPath }/cms/css/public.css">
<div class="top_wrap">
	<div class="top">
		<div class="user_menu">
			欢迎您，${loginName }
			<c:if test="${loginType == 'S'}">
				<a href="${shop_logout}">【退出】</a>
				<span>·</span> <a href="javascript:void(0);">帮助中心</a><span></span>
				<a href="${marketing_url}">切换至营销管理系统>></a>
			</c:if>
			<c:if test="${loginType == 'M'}">
				<a href="${mis_logout}">【退出】</a>
				<span>·</span> <a href="javascript:void(0);">帮助中心</a><span></span>
				<a href="${mis_url}">切换至Mis管理系统>></a>
			</c:if>
		</div>
		<a href="#" class="logo"><img width="386" height="36" src="${imgPath }/cms/images/logo.png" /></a>
	</div>
</div>
