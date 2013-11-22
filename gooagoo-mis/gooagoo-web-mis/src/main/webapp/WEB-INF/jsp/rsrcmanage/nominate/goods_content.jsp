<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity2",770,580,true);
});

// 推荐
function enter(){
	if("" == ids || ids == null){
		alert("请选择要推荐的商品！");
		return;
	}
	if(checkOnly()){
// 		var url = "nominateG.do?method=checkNominateGoods";
// 		var data = "ids=" + ids;
// 		var result = ajaxJsonMessageByData(url,data);
// 		if(result.success == false){
// 	    	alert(result.message);
// 		}else{
			var url = "nominateG.do?method=nominateGoodsPage&id=" + ids;
			$("#sysuserFancybox2").attr("href",url).click();
// 		}
	}
}

//选择一条数据进行操作 
function checkOnly(){
	var arrayMemberId = null;
	if(ids != null){
		arrayMemberId = ids.split(",");
		if((arrayMemberId.length - 1) > 1){
			alert("只能选择一条数据进行操作！");
			page(1);
			return false;
		} 
		return true;
	} 
	return false;
}

// 查询推荐页面
function cancelPage(){
	var url = "nominateG.do?method=cancelNominateGoodsPageIndex";
	$("#sysuserFancybox2").attr("href",url).click();
}
</script>

<div style="display:none;">
	<a href="#" id="sysuserFancybox2" class="fancybox_activity2" ></a>
</div>
<div class="div_but">
	<input type="button" value="推荐" onclick="enter()" />
</div>
<div class="list_box_search" style="padding:0 0 0 1px;overflow-x:auto;width:100%;white-space:nowrap">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th width="2%"><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"/>序号</th>
			<th width="10%">商品名称</th>
			<th width="10%">实体店名称</th>
			<th width="10%">商家名称</th>
			<th width="6%">商品序列号</th>
			<th width="6%">自定义序列号</th>
			<th width="4%">商品价格</th>
			<th width="2%">是否推荐</th>
			<th width="4%">更新时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.goodsId }" />&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.goodsName }</td>
				<td>${item.shopEntityName }</td>
				<td>${item.shopName }</td>
				<td>${item.goodsSerial }</td>
				<td>${item.itemSerial }</td>
				<td>${item.price }</td>
				<td>
					<c:choose>
						<c:when test="${item.isNominate eq 'Y' }">是</c:when>
						<c:when test="${item.isNominate eq 'N' }">否</c:when>
					</c:choose>
				</td>
				<td><fmt:formatDate value="${item.goodsBaseInfoCTimeStamp}" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="9"><strong>暂无信息</strong></td>
			</tr>
		</c:otherwise>
		</c:choose>
	</table>
</div>
<!--分页-->
<c:if test="${!empty pm.result }">
<div class="lasl" id="Pagination" style="border:0;">
	<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
</div>
</c:if>