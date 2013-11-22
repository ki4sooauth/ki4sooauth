<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${!empty data}">
	<c:forEach  items="${data}"  var="list" varStatus="var">
		<li class="content productC">
			<a href="${list.couponUrl}" target="_blank"><img src="${list.couponimg.middleImgUrl}" width="180" height="180"  style="display:block" /></a>
			<p class="msg">${list.couponName}</p>
			<p class="shopsCollection">来自<span id="${var.count+5}" title="${list.shopName}">${list.shopName}</span></p>
			<div class="addfav"><a href="javascript:void(0)" onclick="favoriteCoupon('${list.couponId}','${list.shopId }','${list.couponName }')" ><b></b>加入收藏</a></div>
		</li>
	</c:forEach>
</c:if>
<c:if test="${empty data}">       
	<div class="sorryPrompt" id="activity_sorry">
		<samp>${message }</samp>
	</div>
</c:if>