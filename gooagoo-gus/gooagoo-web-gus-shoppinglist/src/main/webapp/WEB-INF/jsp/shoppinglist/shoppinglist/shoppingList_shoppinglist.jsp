<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${!empty data }">
	<c:forEach items="${data }" var="list" varStatus="s">
		<fmt:formatDate var="time" value='${list.preShoppingTime }'  pattern='yyyy-MM-dd' type='date' dateStyle='long'></fmt:formatDate>
		<li id="${list.shoppingListId }" onclick="javascript: getGoods('${list.shoppingListId }', '${list.title }', '${time }');">
        	<div class="pd">
            	<p class="name">${list.title }</p>
            	<a href="javascript: void(0);" onclick="javascript: delShoppingList('${list.shoppingListId}')">删除</a><a href="${basePath}/shoppingList.do?method=updateShppingList&shoppingListId=${list.shoppingListId}" class="fancybox">编辑</a>
        		<span class="dateNum">${time }</span>
        	</div>
        </li>
	</c:forEach>
</c:if>