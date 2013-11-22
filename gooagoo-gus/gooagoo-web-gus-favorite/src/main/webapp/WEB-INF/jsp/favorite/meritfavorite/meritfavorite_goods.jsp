<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${!empty data}">
	<c:forEach  items="${data}"  var="list" varStatus="var">
		<li class="content productC">
			<a href="${list.goodsUrl}" target="_blank"><img width="180" height="180" src="${list.goodsimg.middleImgUrl}"  style="display:block"></a>
			<p class="msg">${list.goodsName}</p>
			<p class="shopsCollection">来自<span   id="${var.count}"  title="${list.shopName}">${list.shopName}</span></p>
			<div class="addfav"><a onclick="favoriteGoods('${list.goodsId}','${list.shopId }','${list.goodsName }')" href="javascript:void(0)"><b></b>加入收藏</a></div> 
		</li>
	</c:forEach>
</c:if>
<c:if test="${empty data}">       
	<div class="sorryPrompt" id="activity_sorry">
		<samp>${message }</samp>
	</div>
</c:if>
       