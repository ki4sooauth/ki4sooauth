<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${data != null && fn:length(data) > 0}">
	<script type="text/javascript" src="${imgPath }/gus/shop/js/shop_cardList.js"></script>
	<c:forEach  items="${data}" var="list"> 
     	<div class="card_box"  id="${list.shopId}">
     		<c:choose>
     			<c:when test="${!empty list.shopUrl}">
		            <a href="${list.shopUrl}" target="_blank">
		            	<div class="cardTopImg"><img src="${list.cardImg.bigImgUrl}"  width="210" height="42" /></div>
						<div class="cardBottomImg"><img src="${list.cardImg.middleImgUrl}" width="210" height="89" /></div>
		           	</a>
     			</c:when>
     			<c:otherwise>
		            <a href="javascript: void(0);">
		            	<div class="cardTopImg"><img src="${list.cardImg.bigImgUrl}"  width="210" height="42" /></div>
						<div class="cardBottomImg"><img src="${list.cardImg.middleImgUrl}" width="210" height="89" /></div>
		           	</a>
     			</c:otherwise>
     		</c:choose>
			<span class="introduce">${list.shopName}</span>
             <ul>
                 <li class="li_fst">
                 	<c:if test="${list.shopType==1}">上座率:<span>${list.popularity}%</span></c:if>
                 	<c:if test="${list.shopType!=1}">人气:<span>${list.popularity}</span></c:if>
                 	<a href="${usercenterdomain}/ucoupon/shop?shopId=${list.shopId}" target="_blank" style="margin-left:60px">本店优惠</a>
                 </li>
                 <li class="li_sec"><a href="${usercenterdomain}/ufavorite/shop?shopId=${list.shopId}" target="_blank">本店收藏</a></li>
                 <li class="li_trd"><a href="${usercenterdomain}/ubill/shop?shopId=${list.shopId}" target="_blank">本店账单</a></li>
                 <li class="li_four"><a href="#">卡 信 息</a>
                    <div class="hideMsg" >
                    	<i class="triangle"></i>
                     	<div class="font">
					                          卡号：${list.cardId}<br/>
					                          积分：
				            <c:choose>
				            	<c:when test="${list.useableIntegralNumber eq null}">
				            		0
				            	</c:when>
				            	<c:otherwise>
						            ${list.useableIntegralNumber}
				            	</c:otherwise>
				            </c:choose>
				            <a href="${usercenterdomain}/umall/shop?shopId=${list.shopId}" class="Exchange" target="_blank">兑换</a><br/>
                         	 等级：${list.cardName}
				     	</div>
     					<a class="fancybox_Infomation fill" href="${basePath}/shop.do?method=selectMemberInfomation&cardId=${list.cardId}&shopId=${list.shopId}">完善会员信息</a>
       				</div>
        		</li>
				<li class="li_five"><a href="${usercenterdomain}/unotice/shop?shopId=${list.shopId}" target="_blank">店家通知</a></li>
			</ul>
            <div class="add_member">
               	<c:if  test="${list.cardType=='0'}">
				<a href="${basePath}/shop.do?method=memberApply&shopId=${list.shopId}&shopName=${list.shopName }"  class="fancybox_memberApply">申请会员</a><a href="javascript:void(0)"  onclick="removeAttention('${list.shopId}')" class="${list.shopId}">取消关注</a><a href="${basePath}/shop.do?method=cardReturn&shopId=${list.shopId}&shopName=${list.shopName }"  class="fancybox">物理卡转换</a>
               	</c:if>
               	<c:if  test="${list.cardType!='0'}">
          		<a href="javascript:void(0)" onclick="removeMember('${list.shopId}')"  >删除会员</a>
               	</c:if>
			</div>
 		</div>
  	</c:forEach> 
</c:if>
<c:if test="${data == null || fn:length(data) <= 0  }">
	<div class="sorryPrompt" align="center">
	     <samp>${message }</samp>
	</div>
</c:if>
