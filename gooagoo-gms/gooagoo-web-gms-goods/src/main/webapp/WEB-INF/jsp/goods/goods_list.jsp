<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<table class="goodsList_table" cellpadding="0" cellspacing="1" border="0">
	<tr>
	    <th width="5%">${shopVo.wordNames['gmsd018']}</th>
		<th width="215">${shopVo.wordNames['gmse004']}</th>
		<th width="100">${shopVo.wordNames['gmse005']}</th>
		<th width="100">${shopVo.wordNames['gmse006']}</th>
		<th width="100">${shopVo.wordNames['gmse007']}</th>
		<th width="120">所属实体店</th>
		<th width="60">状态</th>	
		<th width="150">${shopVo.wordNames['gmse041']}</th>
	</tr>
	<c:forEach items="${pm.result}" var="goods" varStatus="xh">
		<tr>
		 <td>${xh.count+(page_cur-1)*pm.pageSize}</td>
		<td>
		   <img width="73" height="65" style="display:inline-block;" src="${goods.goodsImg }" /><span>
			<c:if test="${not empty goods.webVisitUrl}"><a href="javascript:previewGoods('${goods.webVisitUrl}');" title="详情">${goods.goodsName }</a></c:if>
			<c:if test="${empty goods.webVisitUrl}">${goods.goodsName }</c:if>
			</span></td>
		<td>${goods.categoryLeafName }</td>
		<td>${goods.brandName }</td>
		<td>${goods.price }</td>
		<td>${goods.entityName }</td>
		<td>${goods.status=="W" ? "-待审核-" : (goods.status=="A" ? "-已审核-" : (goods.status=="B" ? "-未通过-" :(goods.status=="P" ? "已发布" : "未知状态")))}</td>
		<td>
		<c:if test="${goods.status == 'W' or goods.status == 'B'  or goods.status == 'P' }">
		<check:hasAuthority authorityID="15010201">
		<a title="${shopVo.wordNames['gmse008']}" href="${basePath }/goods.do?method=updateGoods&goodsId=${goods.goodsId}" class="handle pencil"></a>
		</check:hasAuthority>
		</c:if>
		<c:if test="${goods.status != 'P'  }">
		<c:if test="${goods.status != 'A' and goods.status != 'D' }">
		<check:hasAuthority authorityID="15010203">
		<a title="审核" href="javascript:check('${goods.goodsId }')" class="handle book"></a>
		</check:hasAuthority>
		</c:if>
		<check:hasAuthority authorityID="15010204">
		<c:if test="${goods.status == 'A'}">
		<a title="发布" href="javascript:void(0)" onclick="goods_publish('${goods.goodsId}');" class="handle issue"></a>
		</c:if>
		</check:hasAuthority>
		</c:if>
		<a title="商品详情" href="javascript:detail('${goods.goodsId }')" class="detailMark"></a>
		<check:hasAuthority authorityID="15010202">
		<a title="${shopVo.wordNames['gmse009']}" href="javascript:void(0)"  onclick="goods_delete('${goods.goodsId}');" class="handle del"></a>
		</check:hasAuthority>
		</td>	
	</tr>
	</c:forEach>
	<tr>
	<td colspan="8">
	<%@include file="/WEB-INF/jsp/common/page.jsp"%>
	</td>
	</tr>
</table>