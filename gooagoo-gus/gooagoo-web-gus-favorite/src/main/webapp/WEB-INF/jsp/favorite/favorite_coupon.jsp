<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include  file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${!empty data}"> 
	<input type="hidden" name="ccount" value="${count}"/>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="MycTable">
                  <tr>
                    <th width="7%"><input type="checkbox"  name="Allselect" id="chk_all_coupon" onclick="allSelect(id,'favoriteCoupon','Singleselect_coupon')"/><label>全选</label></th>
                    <th width="30%">名称</th>
                    <th width="20%">发行商家</th>
                    <th width="11%">额度</th>
                    <th width="10%">状态</th>
                    <th width="11%">有效时间</th>
                    <th width="11%">收藏时间</th>
                  </tr>
                  <c:forEach items="${data}" var="list">
                  <tr  id="favoriteCoupon"  class="favoriteCoupon_tr">
                    <td align="center"><input type="checkbox"  name="Singleselect_coupon"  value="${list.favoriteId}" onclick="parent.removeSelectAll('chk_all_coupon')"/></td>
                    <td>
                      <u><a href="${list.couponUrl}" target="_blank"><img src="${list.image.smallImgUrl}" width="66" height="66" style="display:block"></a></u>
                      <p align="center"  style="margin-top:25px">${list.couponName}</p>
                    </td>
                    <td align="center">${list.shopName}</td>
                    <td align="center"><strong>${list.couponValue}</strong></td>
                    <td align="center">${list.couponStatus}</td>
                    <td align="center"><fmt:formatDate value="${list.couponStartTime}" pattern="yyyy年MM月dd日"></fmt:formatDate><br/>至<br/><fmt:formatDate value="${list.couponEndTime}" pattern="yyyy年MM月dd日"></fmt:formatDate></td>
                    <td align="center"><fmt:formatDate value="${list.favoriteTime }" pattern="yyyy年MM月dd日"></fmt:formatDate></td>
                  </tr>
                  </c:forEach>
    </table>
    <a href="javascript:void(0);" class="btnOrange" onclick="del_coupon()">删除选中</a>
	<div class="section">
	 	<%@ include file="/WEB-INF/jsp/favorite/page/page_coupon.jsp"%>
	</div>  
</c:if>
<c:if test="${empty data}">       
	<div class="sorryPrompt" id="coupon_sorry">
		<samp>${message}</samp>
	</div>    
</c:if>
<c:if test="${!empty guess_recommendationCouponList }">
		<div class="guessLike">猜您喜欢</div>
		<ul class="guessBox">
			<c:forEach items="${guess_recommendationCouponList}" var="list">
				<li><a href="${list.couponVisitUrl}" target="_blank"><img src="${list.couponImage.middleImgUrl}" width="180" height="180" /></a>
					<p class="msg">${list.couponName}</p>
				</li>
			</c:forEach>
		</ul>
<!-- 	</div> -->
</c:if>






             