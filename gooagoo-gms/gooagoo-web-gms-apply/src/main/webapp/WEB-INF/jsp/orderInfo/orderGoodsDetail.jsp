<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript">
	behaviorSelect();
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<td colspan="4" class="hideTab">
			<u><img src="<c:if test='${empty orderDetailPic}'>${imgPath}/gms/shopinfo/images/qs.jpg</c:if><c:if test='${not empty orderDetailPic}'>${orderDetailPic}</c:if>" width="135"/></u>
			<table border="0" cellspacing="1" cellpadding="0" class="moneyTab">
				<tr>
	                <th width="20%"><input type="hidden" id="orderid" value="${orderid}">商品名称</th>
	                <th width="20%">商品序列号</th>
	                <th width="20%">商品数量</th>
	                <th width="40%">实际支付总价</th>
         		</tr>
                <c:forEach items="${pageModel.result}" var="obj">
		        	<tr>
		            	<td>${obj.detailInfo.goodsName}</td>
		                <td>${obj.detailInfo.goodsSerial}</td>
		                <td>${obj.detailInfo.goodsNum}</td>
		                <td>${obj.detailInfo.totalPrice}</td>
		         	</tr>
         		</c:forEach>
	         	<c:if test="${fn:length(pageModel.result)<=0}">
		  			<tr>
		 				<td colspan="8">${shopVo.wordNames['gmsg272']}</td>
		 			</tr>
              	</c:if>
              	<c:if test="${fn:length(pageModel.result) >0}">
	              	<tr>
		                <td colspan="8">
		                    <%@include file="/WEB-INF/jsp/common/page.jsp" %>
		                </td>
	               	</tr>
               	</c:if>
      		</table>
   		</td>
	</tr>
</table>
