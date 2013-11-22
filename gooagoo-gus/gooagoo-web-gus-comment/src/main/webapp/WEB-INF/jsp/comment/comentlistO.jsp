<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${Commentlist != null && fn:length(Commentlist) > 0 }">
	<c:forEach items="${Commentlist}" var="Comment" varStatus="list">
	        <input type="hidden" name="userId" value="${Comment.userId}"/>
	        <dl class="discuss">
	          <dt>
	          <samp><strong>${Comment.goodsName}</strong><br />商家：<b>${Comment.shopName}</b></samp>
	          <label>
<%-- 	          	￥${Comment.price} --%>
	            <span class="money"></span><br />
	            评价等级：
	            <c:choose>
	            	<c:when test="${Comment.commentLevel==1}">
			            <span class="commentStar star1"></span>
	            	</c:when>
	            	<c:when test="${Comment.commentLevel==2}">
			            <span class="commentStar star2"></span>
	            	</c:when>
	            	<c:when test="${Comment.commentLevel==3}">
			            <span class="commentStar star3"></span>
	            	</c:when>
	            	<c:when test="${Comment.commentLevel==4}">
			            <span class="commentStar star4"></span>
	            	</c:when>
	            	<c:otherwise>
	            		<span class="commentStar star5"></span>
	            	</c:otherwise>
	            </c:choose>
	          </label>
	          </dt>
	          <dd>
	            <span class="squareBig"></span>
	            <span class="squareSmall"></span>
	            <p>${Comment.content}</p>
	           	<div class="time">发表时间：${Comment.commentTime}</div>
	          </dd>
	        </dl> 
	 </c:forEach>
 </c:if>
 <c:if test="${Commentlist == null || fn:length(Commentlist) <= 0 }">
 	<div>
		<div class="sorryPrompt" align="center">
            <samp>${message}</samp>
        </div>
    </div>
</c:if>
