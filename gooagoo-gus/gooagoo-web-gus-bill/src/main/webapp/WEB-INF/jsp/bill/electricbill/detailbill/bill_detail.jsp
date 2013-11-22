<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath}/gus/bill/js/bill.js"></script>
<script type="text/javascript" src="${imgPath}/gus/bill/js/star.js"></script>
<script type="text/javascript" src="${imgPath}/gus/bill/js/billFunction.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/billgeren.js"></script>
<script type="text/javascript">
$(function(){
  	//账单收起，展开	
	$('.bill-business li h4 .spread').click(function(){
			$(this).toggleClass("curr").closest('h4').next('table').slideToggle(10).find('.commentWarp').css("display","none").end().find(".Comments").removeClass("Commentsed");
		});		
		$('.bill-business li .Comments').click(function(){
			$(this).toggleClass('Commentsed').closest('tr').next().slideToggle(10);	
		});
})
</script>
	<c:if test="${data != null && fn:length(data) > 0 }">
		<ul class="bill-business">
   			<li style="border-top:1px solid #e7e7e7;">
				<table width="100%" border="0" cellpadding="0" cellspacing="1" class="bill-table" style="display:table;*+display:block;" isLoad="N">
                  <tr>
                    <th width="30%">商品名称</th>
                    <th width="10%">金额</th>
                    <th width="10%">数量</th>
                    <th width="10%">节省金额</th>
                    <th width="10%">涨价/降价</th>
                    <th width="30%">其他操作</th>
                  </tr>
                  <c:forEach items="${data}" var="blist">
                  <input type="hidden" id="shopId_${blist.billDetailId}" name="shopId" value="${blist.shopId}" class="shopId"/>
	                  <tr>
	                    <td>
	                     <p>${blist.goodsName}</p>
	                    <span class="bill-tableImg"><a href="${blist.picUrl}" target="_blank"><img src="${blist.goodsImg.smallImgUrl}" width="58" height="58px" /></a></span>
	                    </td>
	                    <td><strong>￥${blist.payPrice}</strong></td>
	                    <td><strong>${blist.goodsNum}</strong></td>
	                    <td><strong>￥${blist.save}</strong></td>
	                    <td>${blist.priceChangeName}<br /><strong>
	                    	<c:choose>
		                   		<c:when test="${blist.priceChange eq null || blist.priceChange eq ''}">
		                   		</c:when>
		                   		<c:otherwise>
		                   			￥${blist.priceChange}
		                   		</c:otherwise>
		                   	</c:choose>
	                    	</strong>
	                    </td>
	                    <td class="control-td">
		                    <a href="javascript:addFavorit('${blist.goodsId}')" class="collect"><span><b>收藏</b></span></a>
		                    <a href="javascript:addShopList('${blist.goodsId}','','${blist.shopId}')" class="addCart"><span><b>加入购物清单</b></span></a>
		                    <c:choose>
					       		<c:when test="${blist.commentId eq ''|| blist.commentId eq null}">
						       		<a href="javascript:void(0)" class="Comments"><span><b id="c_${blist.billDetailId}">评论</b></span></a>
					       		</c:when>
					       		<c:otherwise>
						       		<a href="javascript:void(0)" class="Comments"><span><b>已评论</b></span></a>
					       		</c:otherwise>
		       				</c:choose>
	                    </td>
	                  </tr>
                  
                  <tr class="commentWarp" id="comm_${blist.billDetailId}" style="display:none">
				     <c:choose>
				       	<c:when test="${blist.commentId eq ''|| blist.commentId eq null}">
					      <td colspan="8" class="comment-td">
					        <div class="hide-comment">
					        <input type="hidden" id="start_${blist.billDetailId}" name="start" class="start" value="0"/>
					        <input type="hidden" id="commentId_${blist.billDetailId}" name="commentId" value="${blist.commentId}" class="commentId"/>
					        <input type="hidden" id="goodsId_${blist.billDetailId}" name="goodsId" class="goodsId" value="${blist.goodsId}"/>
					        <h5>评论：<span class="commentStar">
					          <a href="javascript:startValue('${blist.billDetailId}',1)">1</a>
					          <a href="javascript:startValue('${blist.billDetailId}',2)">2</a>
					          <a href="javascript:startValue('${blist.billDetailId}',3)">3</a>
					          <a href="javascript:startValue('${blist.billDetailId}',4)">4</a>
					          <a href="javascript:startValue('${blist.billDetailId}',5)">5</a>
					        </span><span class="grade" ></span></h5>
					        <textarea class="comment-textarea" maxlength="150" id="commcontent_${blist.billDetailId}"></textarea>
					        <div class="commit" id="t_${blist.billDetailId}">
					        <a href="javascript:comment('${blist.billDetailId}')" class="del">确 认</a>
					        <a href="javascript:clearComment('${blist.billDetailId}')" class="del">清 空</a>
					        </div>
					        </div>
					      </td>
				       	</c:when>
				       	<c:otherwise>
					      <td colspan="8" class="comment-td">
					        <div class="hide-comment">
						        <h5>评论：<span class="commentStar star${blist.commentLevel}">
						        </span><span class="grade"></span></h5>
						        <div class="comment-textarea">${blist.content}</div>
					        </div>
					      </td>
				       	</c:otherwise>
				       </c:choose>
	     			</tr>
	     			</c:forEach>
                </table>
              </li>         
           </ul>
          </c:if>
          <c:if test="${data == null || fn:length(data) <= 0 }">
			<div>
				<div class="sorryPrompt" align="center">
				     <samp>${message}</samp>
				</div>
			</div>
		</c:if>