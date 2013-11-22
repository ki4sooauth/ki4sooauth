<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';
$(document).ready(function(){
	initFancyBox("fancybox_window1",610,150,true);
	initFancyBox("fancybox_window2",800,420,true);
	initFancyBox("fancybox_window3",590,300,true);
});
//关闭弹出层
function closeFancyBoxWindow(){
	closeFancyBox();
}
//商家接口编辑页
function formEditOpen(id){
	var url = "interfshop.do?method=formEdit&id="+id;
	$("#shopInterfEdit").attr("href",url).click();
}
</script>
<div style="display:none;">
	<a href="#" id="shopInterfAllot" class="fancybox_window1" ></a>
	<a href="#" id="shopInterfList" class="fancybox_window2" ></a>
	<a href="#" id="shopInterfEdit" class="fancybox_window3" ></a>
</div>
<div class="div_but">
	<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
		<c:if test="${item.pId eq parentId2 and item.name eq '分配接口'}">
			<input type="button" value="分配接口" onclick="allotShopInterf()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '查询商家接口'}">
			<input type="button" value="查询商家接口" onclick="queryShopInterfList()" style="width: 70px;" />
		</c:if>
	</c:forEach>
</div>
<div class="list_box_search">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"/>序号</th>
			<th>商家名称</th>
			<th>电子邮箱</th>
			<th>商家状态</th>
			<th>是否连锁</th>
			<th>部署模式</th>
			<th>更新时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.shopId }" sStyleVal="${item.serviceStyle}"/>&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.shopName }</td>
				<td>${item.email }</td>
				<td>
					<c:choose>
						<c:when test="${item.shopStatus == 'L'}">锁定</c:when>
						<c:when test="${item.shopStatus == 'P'}">待营业</c:when>
						<c:when test="${item.shopStatus == 'U'}">正常营业</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${item.isChain == 'Y'}">连锁</c:when>
						<c:when test="${item.isChain == 'N'}">非连锁</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${item.serviceStyle == 'A'}">gooagoo代理</c:when>
						<c:when test="${item.serviceStyle == 'S'}">商家独享</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td><fmt:formatDate value="${item.cTimeStamp}" type="both" pattern="yyyy-MM-dd" /></td>
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
<!--分页-->
<c:if test="${!empty pm.result }">
<div class="lasl" id="Pagination" style="border:0;">
	<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
</div>
</c:if>
<script type="text/javascript">
//分配商家接口
function allotShopInterf(){
	if(checkOnly()){
		var url = "interfshop.do?method=allotShopInterfForm&shopId="+ids.substr(0,ids.length-1);
		$("#shopInterfAllot").attr("href",url).click();
	}
}

//查看商家详细接口列表
function queryShopInterfList(){
	if(checkOnly()){
		searchShopInterfList(ids.substr(0,ids.length-1));
	}
}

function searchShopInterfList(id){
	var url = "interfshop.do?method=shopInterfListIndex&shopId="+id;
	$("#shopInterfList").attr("href",url).click();
};

//选择一条数据进行操作 
function checkOnly(){
	var arrayMemberId = null;
	if("" == ids || ids == null){
		alert("请选择一个商家！");
		return false;
	}else{
		arrayMemberId = ids.split(",");
		if((arrayMemberId.length - 1) > 1){
			alert("只能选择一个商家进行操作！");
			page(1);
			return false;
		}
	}
	
	if($("input[name='single']:checkbox:checked").attr("sStyleVal") != 'S'){
		alert("非[部署模式:商家独享]无法进行此操作");
		return false;	
	}
	return true;
}
</script>