<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include  file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${!empty data}">
    	<input type="hidden" name="count" value="${count}"/>
    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="MycTable">
                  <tr>
                    <th width="7%"><input type="checkbox"  name="Allselect" id="chk_all_goods" onclick="allSelect(id,'favoriteGoods','Singleselect_goods')"/><label>全选</label></th>
                    <th width="30%">名称</th>
                    <th width="20%">商家</th>
                    <th width="13%">价格</th>
                    <th width="15%">收藏时间</th>
                  </tr>
                  <c:forEach items="${data}" var="list">
                  <tr id="favoriteGoods"  class="favoriteGoods_tr" >
                    <td align="center"><input type="checkbox"  name="Singleselect_goods"  value="${list.favoriteId}"  onclick="parent.removeSelectAll('chk_all_goods')"/></td>
                    <td>
                      <u><a href="${list.goodsUrl}" target="_blank"><img src="${list.image.smallImgUrl}" width="66" height="66" style="display:block"></a></u>
                      <p  align="center" style="margin-top:25px">${list.goodsName}</p>
                   </td>
                    <td align="center">${list.shopName}</td>
                    <td align="center"><strong>¥ ${list.goodsPrice}</strong></td>
                    <td align="center"><fmt:formatDate value="${list.favoriteTime }" pattern="yyyy年MM月dd日"></fmt:formatDate></td>
                  </tr>
                  </c:forEach>
        </table>
        <a href="javascript:void(0);" class="btnOrange"  onclick="del_goods()">删除选中</a>
		<div class="section">
		 	<%@ include file="/WEB-INF/jsp/favorite/page/page_goods.jsp"%>
		</div>
</c:if>
<c:if test="${empty data}">       
	<div class="sorryPrompt" id="goods_sorry">
		<samp>${message }</samp>
	</div>    
</c:if>
<c:if test="${!empty guess_recommendationGoodsList }">
		<div class="guessLike">猜您喜欢</div>
		<ul class="guessBox">
			<c:forEach items="${guess_recommendationGoodsList}" var="list">
				<li><a href="${list.goodsVisitUrl}" target="_blank"><img src="${list.goodsImage.middleImgUrl}" width="180" height="180" /></a>
					<p class="msg">${list.goodsName}</p>
				</li>
			</c:forEach>
		</ul>
<!-- 	</div> -->
</c:if>



































