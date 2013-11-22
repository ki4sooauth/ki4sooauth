<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:choose>
<c:when test="${goods != null && fn:length(goods) > 0 }">
	<table width="100%" border="0" id="purchased" cellpadding="0" cellspacing="0" class="MycTable shoppingEDtable">
		<tr>
			<th width="30%">商品名称</th>
            <th width="30%">来自商家</th>
            <th width="15%">购买日期</th>
            <th width="15%">价格</th>
            <th width="10%">操作</th>
		</tr>
		<%@ include file="/WEB-INF/jsp/shoppinglist/purchased/purchased_table2.jsp"%>
	</table>
</c:when>
<c:otherwise>
	<div>
		<div class="sorryPrompt" align="center">
		     <samp>${message }</samp>
		</div>
	</div>
</c:otherwise>
</c:choose>





