<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath}/gus/bill/js/bill.js"></script>
<script type="text/javascript" src="${imgPath}/gus/bill/js/star.js"></script>
<script type="text/javascript" src="${imgPath}/gus/bill/js/billFunction.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/billgeren.js"></script>
<script type="text/javascript">
 //账单收起，展开	
$(function(){
  	//账单收起，展开	
	$('.bill-business li h4 .spread').click(function(){
			var values = $(this).find(".spread");
			if(values == '.spread'){
				$(this).toggleClass("curr").closest('h4').next('table').slideToggle(10).find('.commentWarp').css("display","none").end().find(".Comments").removeClass("Commentsed");
			}else{
				loadGoodsDetail($(this),$(this).closest('h4').next('table'));
				$(this).toggleClass("curr").closest('h4').next('table').slideToggle(10).find('.commentWarp').css("display","none").end().find(".Comments").removeClass("Commentsed");
			} 
		});		
		$('.bill-business li .Comments').live("click",function(){
			$(this).toggleClass('Commentsed').closest('tr').next().slideToggle(10);	
		});
	initFancybox();
})

function initFancybox(){
	$(".certificate").fancybox({
// 		'width'				: '90%',
// 		'height'			: '95%',
		'padding'			: 0,
		'autoScale'			: true,
		'autoDimensions'    : true,
		'transitionIn'		: 'yes',
		'transitionOut'		: 'yes',
		'href'				: $(this).attr('href'),
// 		'type'				:'inline',
		'hideOnOverlayClick': false,
	});
}
</script>
<c:if test="${data != null && fn:length(data) > 0 }">
		<c:forEach var="d" items="${data}" varStatus="status">
			<li id="eli_${d.orderId}">
				<form id="f_${d.orderId}">
				  <h4>
					  <input type="hidden" name="billId" value="${d.orderId}"/>
					  <label>商家名称：</label>
					  <u><img src="${d.logo1.smallImgUrl}" width="17" height="17"/></u>
					  <label>${d.shopName}</label><label class="time">消费时间：<samp>${d.requestTime}</samp></label>
					  <label>总金额：<samp>￥${d.payPrice}</samp></label>
					  <a href="javascript:deleteEBill('${d.orderId}')" class="del"><b>删除</b></a>
					  <a href="javascript:void(0)" class="spread"></a>
					  <c:if test="${d.picUrl != null}">
					  	<a href="${d.picUrl}" class="certificate paddcer">原始票据</a>
					  </c:if>
					  <c:if test="${d.couponImgList != null && fn:length(d.couponImgList) > 0 }">
					  		<c:forEach items="${d.couponImgList }" var="img">
					  			<input type="hidden" name="couImg" value="${img.bigImgUrl }"/>
						  	</c:forEach>
						  	<a id="showCoupon${status.index }" href="${basePath}/electricBill.do?method=showCouponPic&id=showCoupon${status.index }" class="certificate">优惠使用</a>
					  </c:if>
				  </h4>
				  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="bill-table" id="tb_${d.orderId}" isLoad="N"></table>
				</form>
			</li>
		</c:forEach>
	<%@include file="/WEB-INF/jsp/common/ElectricPage.jsp" %>
</c:if>
<c:if test="${data == null || fn:length(data) <= 0 }">
	<div>
		<div class="sorryPrompt" align="center">
		     <samp>${message}</samp>
		</div>
	</div>
</c:if>