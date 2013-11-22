<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
	<c:if test="${data != null && fn:length(data) > 0 }">
			<div class="titleL"><a href="#" class="more"></a><span>猜您需要</span></div>	
	         <div class="may_like_show">
	         	<span class="prev" onmouseup="ISL_StopDown_1()" onmousedown="ISL_GoDown_1()" onmouseout="ISL_StopDown_1()"><</span>
	        	<div class="MayLikeshow_warp" id="ISL_Cont_1">
			    <span id="showPic"></span>
	            <div class="ScrCont">
	             	<div id="List1_1">
	            		<div class="may_like_content">
	            			<c:forEach  items="${data}" var="list" varStatus="status"> 
								<div class="card_box">
									<c:choose>
						     			<c:when test="${list.shopUrl != null && fn:trim(list.shopUrl) != '' }">
											<a href="${list.shopUrl}" target="_blank">
												<div class="cardTopImg"><img src="${list.attentionCardUrl.bigImgUrl}"  width="210" height="42" /></div>
												<div class="cardBottomImg"><img src="${list.attentionCardUrl.middleImgUrl}" width="210" height="89" /></div>
											</a>
						     			</c:when>
						     			<c:otherwise>
											<a href="javascript:void(0);">
												<div class="cardTopImg"><img src="${list.attentionCardUrl.bigImgUrl}"  width="210" height="42" /></div>
												<div class="cardBottomImg"><img src="${list.attentionCardUrl.middleImgUrl}" width="210" height="89" /></div>
											</a>
						     			</c:otherwise>
						     		</c:choose>
									<span class="introduce">${list.shopName}</span>
										<ul>
											<li class="li_fst">
										     	<c:choose>
										     	<c:when test="${list.fullRate eq '' || list.fullRate eq null}">
										     		人气:<span>${list.memberNum+list.attentionNum}</span>
										     	</c:when>
										     	<c:otherwise>
										     		上座率:<span>${list.fullRate}%</span>
										     	</c:otherwise>
										     	</c:choose>
										  		<a href="${usercenterdomain}/ucoupon/shop?shopId=${list.shopId}" target="_blank">本店优惠</a>
											</li>
											<li class="li_sec"><a href="${usercenterdomain}/ufavorite/shop?shopId=${list.shopId}" target="_blank">本店收藏</a></li>
									        <li class="li_trd"><a href="${usercenterdomain}/ubill/shop?shopId=${list.shopId}" target="_blank">本店账单</a></li>
									        <li class="li_five"><a href="${usercenterdomain}/unotice/shop?shopId=${list.shopId}" target="_blank">店家通知</a></li>
										</ul>
									<div class="add_member">
									     <a href="${basePath}/shop.do?method=memberApply&shopId=${list.shopId}&shopName=${list.shopName }"  class="fancybox_memberApply">申请会员</a><a href="javascript:void(0)"  onclick="attention('${list.shopId}','${list.shopName }')" class="${list.shopId}">添加关注</a><a href="${basePath}/shop.do?method=cardReturn&shopId=${list.shopId}&shopName=${list.shopName }"  class="fancybox">物理卡转换</a>
									</div>
								</div>
								</c:forEach> 
	            		</div>
	            	</div>
	            	<div id=List2_1>
	            		<div class="may_like_content">
	            			<c:forEach  items="${data}" var="list" varStatus="status"> 
								<c:if test="${status.count <= 4 }">
								<div class="card_box">
									<a href="${list.shopUrl}" target="_blank"><div class="cardTopImg"><img src="${list.attentionCardUrl.bigImgUrl}"  width="210" height="42" /></div>
										<div class="cardBottomImg"><img src="${list.attentionCardUrl.middleImgUrl}" width="210" height="89" /></div>
									</a>
									<span class="introduce">${list.shopName}</span>
										<ul>
											<li class="li_fst">
										     	<c:choose>
										     	<c:when test="${list.fullRate eq '' || list.fullRate eq null}">
										     		人气:<span>${list.memberNum+list.attentionNum}</span>
										     	</c:when>
										     	<c:otherwise>
										     		上座率:<span>${list.fullRate}%</span>
										     	</c:otherwise>
										     	</c:choose>
										  		<a href="${usercenterdomain}/ucoupon/shop?shopId=${list.shopId}" target="_blank">本店优惠</a>
											</li>
											<li class="li_sec"><a href="${usercenterdomain}/ufavorite/shop?shopId=${list.shopId}" target="_blank">本店收藏</a></li>
									        <li class="li_trd"><a href="${usercenterdomain}/ubill/shop?shopId=${list.shopId}" target="_blank">本店账单</a></li>
									        <li class="li_five"><a href="${usercenterdomain}/unotice/shop?shopId=${list.shopId}" target="_blank">店家通知</a></li>
										</ul>
									<div class="add_member">
									     <a href="${basePath}/shop.do?method=memberApply&shopId=${list.shopId}&shopName=${list.shopName }"  class="fancybox_memberApply">
									   		  申请会员
									     </a><a href="javascript:void(0)" onclick="attention('${list.shopId}','${list.shopName }')" class="${list.shopId}">
									  		   添加关注
									     </a><a href="${basePath}/shop.do?method=cardReturn&shopId=${list.shopId}&shopName=${list.shopName }"  class="fancybox">
									   		  物理卡转换
									     </a>
									</div>
								</div>
								</c:if>
							</c:forEach> 
	            		</div>
	            	</div>
	           </div>
	            </div>
	            <span class="next" onmouseup="ISL_StopUp_1()" onmousedown="ISL_GoUp_1()" onmouseout="ISL_StopUp_1()">></span>
	       </div>
	</c:if>
