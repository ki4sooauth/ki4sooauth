<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<div class="topControl">
	<a href="${basePath }/shoppingList.do?method=addGoodsByQuery&shoppingListId=${shoppingListId }" class="addBtn fancybox2">添加商品</a>
    <a href="${basePath }/shoppingList.do?method=addGoodsByHand&shoppingListId=${shoppingListId }" class="addBtnHM fancybox">手动添加</a>
    <div class="titName">
    	<span id="shoppinglistName"></span><b></b><span id="shoppinglistTime" class="dateNum"></span>
    </div>
</div>
<c:choose>
<c:when test="${isSuccess && !empty data}">
<div class="shopingTable">
	<table cellspacing="0" cellpadding="0" width="100%">
    	<tr>
            <th width="28%">名称</th>
            <th width="20%">所属类别</th>
            <th width="32%">商家名称</th>
            <th width="20%">操作</th>
        </tr>
        <c:forEach  items="${data }"  var="list" >
        <tr id="${list.shoppingGoodsId}">
        	<c:set var="currentDate" value="${fn:substring(currentTime, 0, 10) }"></c:set>
        	<fmt:formatDate var="createDate" value='${list.createTime }'  pattern='yyyy-MM-dd' type='date' dateStyle='long'></fmt:formatDate>
			<td class="nameP"><span><c:if test="${currentDate eq createDate }"><samp></samp></c:if> ${list.goodsName}</span></td>
         	<td>${list.goodsTypeName}</td>
         	<td>${list.shopName}</td>
         	<td><a href="javascript:void(0)" class="deleteBtn" onclick="javascript: delShoppingListGoods('${list.shoppingGoodsId }');" title="删 除"></a></td>
        </tr>
        </c:forEach>
    </table>
</div>
</c:when>
<c:otherwise>
<div class="sorryPrompt">
	<samp>${message }</samp>
</div>
</c:otherwise>
</c:choose>