<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${goods != null && fn:length(goods) > 0 }">
<c:forEach  items="${goods}"  var="list">
<tr>
	<td>
	    <u><a href="${list.goodsUrl}" target="_blank"><img src="${list.goodsImg.smallImgUrl}" width="66" height="66"></a></u>
	    <p style="margin-top:20px">${list.goodsName} x ${list.goodsNum} </p>
    </td>
  	<td align="center">${list.shopName}</td>
  	<td align="center">${list.time}</td>
  	<td align="center"><strong>￥${list.payPice}</strong></td>
  	<td class="add_btn"><a style="text-decoration:none" href="javascript:void(0)"  onclick="addGoods('${list.goodsId}','${list.goodsName}')" id="href${list.goodsId}" title="加入购物清单"></a></td>
</tr>
</c:forEach>
</c:if>





