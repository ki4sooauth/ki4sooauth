<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity2",970,780,true);
	$("#fancybox-close").bind("click",function(){
		page(1);
	});
});

// 取消推荐
function cancel(){
	if("" == ids || ids == null){
		alert("请选择要取消推荐的商品！");
		return;
	}
	if(confirm("是否取消推荐此商品？")){
		var data = "pageIndex=1&id=" + ids;
		ajaxJsonTipByData("nominateG.do?method=cancelNominateGoods",data,true);
		page(1);
	}
}

// 修改推荐
function update(){
	if("" == ids || ids == null){
		alert("请选择要修改的推荐商品！");
		return;
	}
	if(checkOnly()){
		var url = "nominateG.do?method=updateGoodsPage&id=" + ids;
		$("#sysuserFancybox2").attr("href",url).click();
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

//新增推荐
function add(){
	var url = "nominateG.do?method=quertConditionPage";
	$("#sysuserFancybox2").attr("href",url).click();
}
</script>
<div style="display:none;">
	<a href="#" id="sysuserFancybox2" class="fancybox_activity2" ></a>
</div>
<div class="big_box" id="resultlist">
<div class="div_but">
	<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
		<c:if test="${item.pId eq parentId2 and item.name eq '新增推荐'}">
			<input type="button" value="新增推荐" onclick="add()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '修改推荐'}">
			<input type="button" value="修改推荐" onclick="update()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '取消推荐'}">
			<input type="button" value="取消推荐" onclick="cancel()" />
		</c:if>
	</c:forEach>
</div>
<div class="list_box_search">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th width="5%"><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"/>序号</th>
			<th width="15%">商品名称</th>
			<th width="15%">实体店名称</th>
			<th width="20%">商家名称</th>
			<th width="12%">起始时间</th>
			<th width="12%">结束时间</th>
			<th width="12%">更新时间</th>
		</tr>
		<c:choose>
			<c:when test="${!empty pm.result}">
				<c:forEach var="item" items="${pm.result }" varStatus="im" >
					<tr>
						<td><input type="checkbox" name="single" value="${item.id }" />&nbsp;${im.count + ((page_cur-1) * 10)}</td>
						<td>${item.goodsName }</td>
						<td>${item.shopEntityName }</td>
						<td>${item.shopName }</td>
						<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${item.nominateGoodsCTimeStamp}" pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="7"><strong>暂无信息</strong></td>
			</tr>
		</c:otherwise>
		</c:choose>
	</table>
</div>
</div>
<!--分页-->
<c:if test="${!empty pm.result }">
<div class="lasl" id="Pagination" style="border:0;">
	<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
</div>
</c:if>