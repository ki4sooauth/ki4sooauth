<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript">
<!--
    var dbTime = ${dbTime};
    var dateMap = ${adBidTime};
    var time_diff=new Date().getTime()-dbTime;
	$(document).ready(function() {
		show_time();
		var adDesc = $(".col_right").find(".subNav").find(".cur").attr("title");
		$(".actbox").find(".act_1").find(".adName").html(adDesc);
	})
//-->
</script>
<c:choose>
	<c:when test="${fn:length(adBidInfoList)>0}">
		<c:forEach items="${adBidInfoList}" var="bidInfo">
		  <div class="patch"></div>
			<div class="actbox" id="${bidInfo.bidId}">
				<ul class="act_1">
					<li class="first adName"></li>
					<li>${shopVo.wordNames['gmsj11']}：${bidInfo.startingPrice}元</li>
					<li value="shopName">${shopVo.wordNames['gmsj12']}：${bidInfo.shopName}</li>
					<li>${shopVo.wordNames['gmsj13']}：<fmt:formatDate value="${bidInfo.bidStartTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></li>
					<li>${shopVo.wordNames['gmsj14']}：<fmt:formatDate value="${bidInfo.bidEndTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></li>
					<li>${shopVo.wordNames['gmsj15']}：<fmt:formatDate
							value="${bidInfo.effectStartDate}" pattern="yyyy-MM-dd" />${shopVo.wordNames['gmsj17']}<fmt:formatDate
							value="${bidInfo.effectEndDate}" pattern="yyyy-MM-dd" /></li>
					<li>${shopVo.wordNames['gmsj16']}：${bidInfo.effectStartTime}${shopVo.wordNames['gmsj17']}${bidInfo.effectEndTime}</li>
				</ul>
				<ul class="act_2">
					<li>${shopVo.wordNames['gmsj18']}：<span class="red">${bidInfo.maxBidAmount}${shopVo.wordNames['gmsj21']}</span></li>
					<li>${shopVo.wordNames['gmsj19']}：<span class="increase">${bidInfo.increase}</span>${shopVo.wordNames['gmsj21']}
					</li>
					<li><div class="operate">
							${shopVo.wordNames['gmsj20']}：<span class="cur" onclick="reduceAmount(this);">-</span><input
								value="${bidInfo.maxBidAmount eq 0? bidInfo.startingPrice:bidInfo.maxBidAmount+bidInfo.increase}" readonly="readonly"/><span
								onclick="plusAmount(this);">+</span><br /> <a class="confirm"
								href="javascript:void(0)" ><i></i>${shopVo.wordNames['gmsj22']}</a>
							<samp>${shopVo.wordNames['gmsj21']}${shopVo.wordNames['gmsj23']}</samp>
						</div></li>
				</ul>
				<div class="clear"></div>
			</div>
		</c:forEach>
	</c:when>
	<c:otherwise>
	  <div class="patch"></div>
		<div class="actbox">
			<ul class="act_1">
			    <li class="first adName"></li>
				<li class="first">${shopVo.wordNames['gmsj07']}</li>
			</ul>
			<div class="clear"></div>
		</div>
	</c:otherwise>
</c:choose>
<div class="patch"></div>
