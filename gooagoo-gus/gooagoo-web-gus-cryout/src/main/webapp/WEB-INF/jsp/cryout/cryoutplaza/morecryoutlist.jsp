<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:choose>
<c:when test="${isSuccess && data != null && data.cryoutList != null && fn:length(data.cryoutList) > 0 }">
<c:forEach items="${data.cryoutList }" var="cryout">
<input type="hidden" name="pageIds" value="${cryout.pageId }"/>
<ul class="new_yh_list">
	<li class="list">
		<c:choose>
		<c:when test="${cryout.headPic.smallImgUrl == null || cryout.headPic.smallImgUrl == '' }">
		<a href="${cryout.shopVisitUrl }" target="_blank" ><img class="use_logo" src="${imgPath }/gus/common/images/userHeader.png" height="60" width="60"/></a>
		</c:when>
		<c:otherwise>
		<a href="${cryout.shopVisitUrl }" target="_blank"><img class="use_logo" src="${cryout.headPic.smallImgUrl }" height="60" width="60"/></a>
		</c:otherwise>
		</c:choose>
		<div class="content">
   			<p class="title">${cryout.cryoutTitle }</p>
   			<p class="contented">${cryout.cryoutContent }</p>
   			<c:if test="${cryout.cryoutContentType == 'G' || cryout.cryoutContentType == 'C' || cryout.cryoutContentType == 'A' }">
       		<a href="${cryout.contentVisitUrl }" target="_blank"><img style="display: inline-block;" src="${cryout.cryoutImage.middleImgUrl }" width="160" height="160"/></a>
       		</c:if>
			<p class="foot_msg">
				<c:if test="${cryout.cryoutContentType == 'G' }">
					<a href="javascript:void(0);" class="addCar" onclick="javascript: addGoodsToShoppinglistRequest(this, '${cryout.shopId }', '${cryout.shopName }', '${cryout.cryoutContentTypeId }');">
						<b class="arrow"></b>加入购物清单
					</a>
				</c:if>
				<c:if test="${cryout.cryoutContentType == 'G' || cryout.cryoutContentType == 'C' || cryout.cryoutContentType == 'A' }">
					<a href="javascript:void(0);" class="col" onclick="javascript: favoriteRequest(this, '${cryout.cryoutContentType }', '${cryout.cryoutId }', '${cryout.cryoutContentTypeId }', '${cryout.shopId}');">
						<b class="arrow"></b>收藏
					</a>
				</c:if>
				<span><fmt:formatDate value="${cryout.cryoutTime }" pattern="yyyy年MM月dd日 HH:mm"></fmt:formatDate>&nbsp;&nbsp;来自</span>${cryout.shopName }
			</p>
		</div>
	</li>
</ul>
</c:forEach>
</c:when>
<c:otherwise>
<div class="section">
	<div class="sorryPrompt">
	    <samp>${message }</samp>
	</div>	
</div>
</c:otherwise>
</c:choose>